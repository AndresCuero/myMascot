
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.solicitudes;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IsolicitudesService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author cuero
 */
@Controller
@RequestMapping("/solicitudes")
public class Solicitudes {
    
     @Autowired
     private IusuarioService usuarioService;
     
     @Autowired
     private IsolicitudesService solicitudesService;
     
      @Autowired
     private ImascotaService mascotaService;
     
    public static Integer idMascota = 0;
    
    @GetMapping("/create/{id}")
    public String create(@PathVariable("id") Integer id){        
        idMascota=id;  
    return "formularioAdopcion";
    }
    
    //guardamo la solicitu formulario y actulizamos varioos datos del usuario
    @PostMapping("/save")
    public String guardarMascota(Model model,
                                 @RequestParam("comentarios") String comentarios,
                                 @RequestParam("direccion") String direccion,                             
                                 @RequestParam("documento") int documento,
                                 @RequestParam("tipo_documento") String tipo_documento ){
       
        model.addAttribute("usuario", usuarioService.buscarPorId(InicioCotroller.idUsuario));
      usuario usuarios = usuarioService.buscarPorId(InicioCotroller.idUsuario);
      usuarios.setDireccion(direccion);
      usuarios.setDocumento(documento);
      usuarios.setTipo_documento(tipo_documento);
      usuarioService.guardar(usuarios);
      
       
      solicitudes solicitudes = new solicitudes();
      solicitudes.setFecha(new Date());
      solicitudes.setEstado("Revisión");
      solicitudes.setComentarios(comentarios);
      solicitudes.setMascota(mascotaService.buscarPorId(idMascota));
      solicitudes.setUsuario(usuarioService.buscarPorId(InicioCotroller.idUsuario));
      solicitudesService.guardarSolicitud(solicitudes);
      return "redirect:/peticion/index"; 
    
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

