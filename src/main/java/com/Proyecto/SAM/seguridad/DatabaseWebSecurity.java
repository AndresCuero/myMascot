package com.Proyecto.SAM.seguridad;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

    @Bean
    public UserDetailsManager usersCustom(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        
        // Consulta para autenticar al usuario utilizando solo el correo
        users.setUsersByUsernameQuery("select correo, password, estatus from usuario where correo=?");
        
        // Consulta para obtener las autoridades (roles) del usuario utilizando solo el correo
        users.setAuthoritiesByUsernameQuery("select u.correo, r.roles from Usuario_rol ur "
                + "inner join usuario u on ur.ID_usuario = u.ID_usuario "
                + "inner join rol r on ur.ID_rol = r.ID_rol "
                + "where u.correo=?");

        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                // Los recursos estáticos no requieren autenticación
                .requestMatchers("/img-prin/**", "/js/**", "/styles/**", "logos/**").permitAll()
                // Las vistas públicas no requieren autenticación
                .requestMatchers("/", "/buscar", "/buscar/**", "/publicaciones/**", "/usuario/registro", "/save", "/registro","publicacion/perfil/**", "/saver/**").permitAll()
                // Asignar permisos a URLs por ROLES
                .requestMatchers("/mascota/**").hasAnyAuthority("USUARIO")
                // Todas las demás URLs de la Aplicación requieren autenticación
                .anyRequest().authenticated()
            )
            // El formulario de Login no requiere autenticacion
            .formLogin(login -> login.permitAll().loginPage("/login"))
            // Configurar el manejador de acceso denegado
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler(new AccessDeniedHandlerImpl())
            );

        return http.build();
    }
}
