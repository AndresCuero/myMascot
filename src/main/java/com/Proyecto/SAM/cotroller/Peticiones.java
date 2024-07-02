
package com.Proyecto.SAM.cotroller;


import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IsolicitudesService;
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

/**
 *
 * @author cuero
 */
@Controller
@RequestMapping("/peticion")
public class Peticiones {
    
    @Autowired
    private IsolicitudesService solicitudesService;
    
    @Autowired
    private IusuarioService usuarioService;
    
    @Autowired
    private ImascotaService mascotaService;
    

    
    @GetMapping("index")
    public String verPeticiones(Model model){
      
        Integer verificarMascota = mascotaService.buscarPorUsuarioParaSaberSiTieneMascota(InicioCotroller.idUsuario);   
        
        model.addAttribute("solicitud", solicitudesService.listaDePeticion(InicioCotroller.idUsuario) );
        model.addAttribute("verificarMascota", verificarMascota);
        return "HistorialPeticiones ";
      
    
    }
    
    @GetMapping("perfil/{id}")
    public String verPerfiDelApdotante(@PathVariable("id") Integer Imascota, Model model){
      mascota mascota = mascotaService.buscarPorId(Imascota);
      usuario usuarios = usuarioService.buscarPorId(mascota.getUsuario().getID_usuario());
      model.addAttribute("usuario", usuarios);
        return "PerfilUsuarioContato";
    }
    
    
    
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
    public void setGenericos(Model model) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);          
    }
    
}
