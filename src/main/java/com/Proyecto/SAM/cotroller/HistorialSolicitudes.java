/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.solicitudes;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IsolicitudesService;
import com.Proyecto.SAM.service.IusuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solicitudes")
public class HistorialSolicitudes {
    
    @Autowired
    private IsolicitudesService solicitudesService;
    
     @Autowired
    private IusuarioService usuarioService;
     
      @Autowired
    private ImascotaService mascotaService;
      
      public static boolean activar = false;
    
   /* @GetMapping("index")
    public String misSolicitudesDeMisMascota (Model model){
     List<solicitudes> solicitudes =solicitudesService.todasLasSolicitudes();
     model.addAttribute("solicitud",solicitudes );
     model.addAttribute("mascota", mascotaService.misPublicaciones(InicioCotroller.idUsuario));
     
    return "HistorialSolicitudes";
    }
   */ 
    @GetMapping("/eliminar/{id}")
    public String eliminarSolicitu(@PathVariable("id") Integer ID_solicitu, Model model){
     solicitudes solicitudes = solicitudesService.buscarPorId(ID_solicitu);     
     solicitudes.setEstado("Rechazada");     
     solicitudesService.guardarSolicitud(solicitudes);
     return"redirect:/solicitudes/index";
    }
    
    @GetMapping("/aceptada/{id}")
    public String solicitudAceptada(@PathVariable("id") Integer ID_solicitu, Model model){
     solicitudes solicitudes = solicitudesService.buscarPorId(ID_solicitu);     
     solicitudes.setEstado("Aceptado");     
     solicitudesService.guardarSolicitud(solicitudes);
     model.addAttribute("usuario", mascotaService.buscarPorId(InicioCotroller.idUsuario));
     return"formularioAceptar";
    }
    
    @PostMapping("/guardar")
    public String guardarDastosDelUsuario(Model model, usuario usuario){
        
      return"redirect:/solicitudes/index";   
    }
    
    @GetMapping("/perfil/{id}")
    public String verPerfilDelSolicitante(@PathVariable("id") Integer ID_solicitudes, Model model){
      solicitudes solicitudes = solicitudesService.buscarPorId(ID_solicitudes);
      usuario usuario =usuarioService.buscarPorId(solicitudes.getUsuario().getID_usuario());
     model.addAttribute("usuario", usuario);
     return "PerfilUsuarioContato";
    }
    
    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable("id") Integer ID_mascota){
     mascota mascota = mascotaService.buscarPorId(ID_mascota);
      mascota.setEstatus("eliminada");
      mascotaService.guardar(mascota);
     return"redirect:/solicitudes/index";
    }
    
    
          @ModelAttribute
    public void setGenericos(Model model, usuario usuario) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);
    }
    
    
}
