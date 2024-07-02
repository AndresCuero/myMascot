
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.imagen;
import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.service.ImascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class PerfilMascota {
    
    @Autowired
    private ImascotaService mascotaService;
    
    @GetMapping("/mascota/{id}")
    public String perfilMascota(@PathVariable("id") Integer ID_mascota, Model model, imagen imajen){
        mascota mascota = mascotaService.buscarPorId(ID_mascota);
        model.addAttribute("mascota", mascota);
        return "PerfilMasc";
    }
    
    
     @ModelAttribute
    public void setGenericos(Model model) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);          
    }
}
