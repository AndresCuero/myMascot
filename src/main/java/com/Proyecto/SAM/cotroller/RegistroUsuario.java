
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.rol;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.IusuarioService;
import com.Proyecto.SAM.utileria.utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class RegistroUsuario {
    
    @Autowired
    private IusuarioService serviceUsuario;
   
    
   // @Autowired
  //  private PasswordEncoder contraseñaEncoder;
    
    @Value("${trabajoapp.ruta.imagen}")
    private String ruta;

    boolean activar = false;
/*
    @GetMapping("/inicioseccion")
    public String inicioSeccion(usuario usuario, Model model) {
        
        model.addAttribute("buscar", new mascota());
        return "formLogin";
    }

    @PostMapping("/save")
    public String guardarRegistro(@RequestParam("archivoImagenPerfil") MultipartFile multiPartPerfil, usuario usuario,  RedirectAttributes mensajeAlGurdar) {

        if (!multiPartPerfil.isEmpty()) {
            String nombreImagen = utileria.guardarArchivo(multiPartPerfil, ruta);
            if (nombreImagen != null) {
                usuario.setImagen_perfil(nombreImagen);
            }
        }

     usuario.setEstatus(1);
     
     
     // inscriptacion de contraseña
     String contraseñaUsuario = usuario.getContraseña();
     String contraseñaUsuarioencriptada = contraseñaEncoder.encode(contraseñaUsuario);
     usuario.setContraseña(contraseñaUsuarioencriptada);
     
     // le damos un rol al usuario por defeto 
     rol roles = new rol();
     roles.setID_rol(1);
     
     usuario.agregar(roles);

       
     serviceUsuario.guardar(usuario);
        
     mensajeAlGurdar.addFlashAttribute("mensaje", "¡Hola " + usuario.getNombre_completo() + " Ya puedes iniciar sesión.");


        return "redirect:/usuario/inicioseccion";
    }
*/
    @GetMapping("/registro")
    public String registroDeUsuario(usuario usuario) {
        return "gestionusuario";
    }

    @ModelAttribute
    public void setGenericos(Model model) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);

    }

}
