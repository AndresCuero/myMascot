/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.SAM.cotroller;

import static com.Proyecto.SAM.cotroller.MisPublicaciones.ID_mascotaPerfil;
import com.Proyecto.SAM.model.comentarios;
import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.IcomentarioService;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IusuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentario")
public class Comentario {
    
     @Autowired
    private ImascotaService mascotaService;
    
    @Autowired
    private IcomentarioService comentarioService;
     
     
     @Autowired
    private IusuarioService usuarioService;

    
    
    //ESTE METODO ES PARA COMENTAR LA PUBLICACION
 @GetMapping("/save")
public String guardarComentario() {  
    return "redirect:/publicacion/perfil";
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
    public void setGenericos(Model model, usuario usuario) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);
    }
    
}
