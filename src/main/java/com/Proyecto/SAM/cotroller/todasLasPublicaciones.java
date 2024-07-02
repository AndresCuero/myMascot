/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IrazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publicaciones")
public class todasLasPublicaciones {
    
    @Autowired
    private ImascotaService mascotaService;
    
    @Autowired
    private IrazaService razaService;
    
    @GetMapping("/todas")
    public String mostrarTodasLasPublicaciones(Model model, Pageable page){
    model.addAttribute("mascota", mascotaService.buscarTodasOrdenadaPorCalificacionYaprobadas(page) );
    return"todasLasPublicaciones";
    }
    
     @ModelAttribute
    public void setGenericos(Model model,Pageable page){  
        mascota mascotaBuscar = new mascota();
        model.addAttribute("mascota", mascotaService.buscarTodasOrdenadaPorCalificacionYaprobadas(page) );
        model.addAttribute("raza", razaService.buscarTodas());
        model.addAttribute("buscar", mascotaBuscar);
        
    }
    
}
