package com.Proyecto.SAM.cotroller;

import static com.Proyecto.SAM.cotroller.MisPublicaciones.ID_mascotaPerfil;
import com.Proyecto.SAM.model.calificacion;
import com.Proyecto.SAM.model.comentarios;
import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.rol;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.IcalificacionService;
import com.Proyecto.SAM.service.IcomentarioService;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IusuarioService;
import com.Proyecto.SAM.utileria.utileria;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InicioCotroller {

    @Autowired
    private ImascotaService mascotaService;
    

    @Autowired
    private IcalificacionService calificacionService;

    @Autowired
    private IusuarioService usuarioService;

    /*@Autowired
    private PasswordEncoder passwordEncoder;*/
    public static boolean actualizarPerfil = false;

    public static int idUsuario = 0;

    public boolean calificarDeNuevo = false;

    @Value("${trabajoapp.ruta.imagen}")
    private String ruta;

    //la url principal 
    @GetMapping("/")
    public String index(Model model, Pageable page) {
        Page<mascota> lista = mascotaService.buscarTodasOrdenadaPorCalificacionYaprobadas(page);
        model.addAttribute("mascota", lista);
        return "PagInicio";
    }

    // desde aqui trabajamos el usuario
    @GetMapping("/index")
    public String mostrarIndex(Authentication auth, HttpSession session) {
        String correo = auth.getName();
        System.out.println("Nombre del usuario: " + correo);
        for (GrantedAuthority rol : auth.getAuthorities()) {
            System.out.println("ROL: " + rol.getAuthority());
        }

        if (session.getAttribute("usuario") == null) {
            usuario usuario = usuarioService.buscarPorCorreo(correo);
            usuario.setPassword(null);
            System.out.println("usuario " + usuario);
            session.setAttribute("usuario", usuario);
            idUsuario = usuario.getID_usuario();
        }

        if (RegistroMascota.activarUrlDonantes) {
            RegistroMascota.activarUrlDonantes = false;
            return "redirect:/mascota/registro";
        }
        return "redirect:/";
    }
   
    public usuario metodoIniciarSecion(Authentication auth, HttpSession session) {
        String correo = auth.getName();
        System.out.println("Nombre del usuario: " + correo);
        usuario usuarios = usuarioService.buscarPorCorreo(correo);
        idUsuario = usuarios.getID_usuario(); 
        return usuarios;
    }
    
    @GetMapping("/registro")
    public String inicioSeccion(usuario usuario) {
        return "formLogin";
    }

    @PostMapping("/save")
    public String guardarRegistro(@RequestParam("archivoImagenPerfil") MultipartFile multiPartPerfil, usuario usuario, RedirectAttributes mensajeAlGurdar, HttpSession session) {

        String password = usuario.getPassword();
        if (!password.startsWith("{noop}")) {
            String claveTextoPlano = "{noop}" + password;
            usuario.setPassword(claveTextoPlano);
        }

        if (!multiPartPerfil.isEmpty()) {
            String nombreImagen = utileria.guardarArchivo(multiPartPerfil, ruta);
            if (nombreImagen != null) {
                usuario.setImagen_perfil(nombreImagen);
            }
        }

        usuario.setEstatus(1);

        // Asignar rol por defecto al usuario
        rol roles = new rol();
        roles.setID_rol(1);
        usuario.agregar(roles);

        usuarioService.guardar(usuario);

        if (actualizarPerfil) {
            session.setAttribute("usuario", usuarioService.buscarPorId(usuario.getID_usuario()));
            actualizarPerfil = false;
            return "redirect:/perfil/usuario";
        } else {
            return "redirect:/registro";
        }
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "formLogin";
    }

    //cerramos sesion
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        SecurityContextLogoutHandler logoutHandler
                = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return "redirect:/";
    }

  /*  @GetMapping("/saver/{id}")
    public String calificarMascota(@PathVariable("id") Integer idMascota, Model model, usuario usuario, @RequestHeader(value = "Referer", required = false) String referer) {
        mascota mascota = mascotaService.buscarPorId(idMascota);
        if (mascota == null) {
            return "redirect:/error";
        }

        calificacion calificacion = mascota.getCalificacion();
        if (calificacion == null) {
            calificacion = crearNuevaCalificacion();
        } else {
            calificacion = calificacionService.buscarPorId(calificacion.getID_calificacion());
            if (calificacion == null) {
                return "redirect:/error";
            }
        }

        manejarCalificacionExistente(mascota, calificacion);

        mascotaService.guardar(mascota);
        return "redirect:/";
    }

    private calificacion crearNuevaCalificacion() {
        calificacion calificacion = new calificacion();
        calificacion.setID_usuario(InicioCotroller.idUsuario);
        calificacion.setMegusta(true);
        calificacionService.guardar(calificacion);
        return calificacion;
    }

    private void actualizarMascota(mascota mascota, calificacion calificacion) {
        mascota.setCalificacion(calificacion);
    }

    private void manejarCalificacionExistente(mascota mascota, calificacion calificacion) {
        boolean esUsuarioActual = calificacion.getID_usuario() == InicioCotroller.idUsuario;

        if (esUsuarioActual && calificacion.isMegusta()) {
            calificacion.setMegusta(false);
        } else {
            calificacion.setMegusta(true);
            calificacion.setID_usuario(InicioCotroller.idUsuario);
        }

        actualizarMascota(mascota, calificacion);
        calificacionService.guardar(calificacion);
    }
    
    */
    
    
    @ModelAttribute
    public void setGenericos(Model model, Pageable page) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);

    }

}
