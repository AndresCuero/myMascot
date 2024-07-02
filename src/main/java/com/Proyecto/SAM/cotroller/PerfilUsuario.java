
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.IusuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


// @author cuero



@Controller
@RequestMapping("/perfil")
public class PerfilUsuario {
    
   @Autowired
   private IusuarioService usuarioService;
    
    @GetMapping("/usuario")
    public String verPerfil(Model model){
        return "PerfilUsuario";
    }
    
    
    @GetMapping("editar/{id}")
    public String editarPerfil(@PathVariable("id") Integer ID_usuario, Model model){       
        usuario usuario = usuarioService.buscarPorId(ID_usuario);
        String contraseña = usuario.getPassword();
        usuario.setPassword(contraseña.substring(6, contraseña.length()));
        model.addAttribute("usuario", usuario);              
        InicioCotroller.actualizarPerfil = true;       
        return "ActualizarDatos";
        
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") Integer ID_mascota){
     usuario usuario = usuarioService.buscarPorId(ID_mascota);
     usuario.setPassword("123");
     usuarioService.guardar(usuario);
     return"redirect:/logout";
    }
    
    @ModelAttribute
    public void setGenericos(Model model) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);          
    }
    
}
