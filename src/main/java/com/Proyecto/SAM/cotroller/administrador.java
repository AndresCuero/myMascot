
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IusuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("administrador")
public class administrador {
   
    @Autowired
    private ImascotaService mascotaService;
    
    @Autowired
    private IusuarioService usuarioService;
    
    @GetMapping("mascota")
    public String mascotasEliminadas (Model model){
    model.addAttribute("mascota", mascotaService.buscarMascotasEliminada("eliminada"));
    return "administrador/mascotaEliminado";
    
    }
    
    @GetMapping("/macotasR")
      public String mascotasAprobada(Model model){
    model.addAttribute("mascota", mascotaService.buscarMascotasEliminada("aprobada"));
    return "administrador/mascotaRegistrada";
    
    }
      
   @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") Integer ID_mascota){
     mascota mascota = mascotaService.buscarPorId(ID_mascota);
      mascota.setEstatus("eliminada");
      mascotaService.guardar(mascota);
     return"redirect:/administrador/macotasR";
    }
    
     //funciones del usuario
    
    
    @GetMapping("usuario")
    public String usuarioEliminadas (Model model){
    model.addAttribute("usuario", usuarioService.usuarioEliminado(0));
    return "administrador/usuarioEliminado";
    
    }
    
    @GetMapping("/usuarioR")
      public String usuarioAprobada(Model model){
    model.addAttribute("usuario", usuarioService.usuarioEliminado(1));
    return "administrador/UsuariosRegistrados";
    
    }
      
   /*@GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer ID_usuario){
     usuario usuario = usuarioService.buscarPorId(ID_usuario);
      usuario.setEstatus(0);
      usuarioService.guardar(usuario);
     return"redirect:/administrador/usuarioR";
    }
    */
   
    
     
            @ModelAttribute
    public usuario recuperarInformacionDeUsuario(Authentication auth, HttpSession session) {
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
            InicioCotroller.idUsuario = usuario.getID_usuario();
            return usuario;
            
        }
        
        return null;    
    }
          @ModelAttribute
    public void setGenericos(Model model, usuario usuario) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);
    }
    
}
