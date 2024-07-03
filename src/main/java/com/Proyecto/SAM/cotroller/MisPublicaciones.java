package com.Proyecto.SAM.cotroller;


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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publicacion")
public class MisPublicaciones {

    @Autowired
    private ImascotaService mascotaService;
    
    @Autowired
    private IcomentarioService comentarioService;
     
     
     @Autowired
    private IusuarioService usuarioService;

    public static boolean ActualizarPublicacion = false;
    
       public static Integer ID_mascotaPerfil;

    @GetMapping("/index")
    public String verMisPublicaciones(Model model) {
        
        model.addAttribute("mascota", mascotaService.misPublicaciones(InicioCotroller.idUsuario));
        return "misPublicaciones";
    }

    @GetMapping("/perfil/{id}")
    public String perfilMascota(@PathVariable("id") Integer ID_mascota, Model model, comentarios comentario) {
        ID_mascotaPerfil = ID_mascota;
        model.addAttribute("ID_mascota", ID_mascota);
        mascota mascota = mascotaService.buscarPorId(ID_mascota);
        model.addAttribute("mascota", mascota);
        model.addAttribute("losComentario", comentarioService.comentarios(ID_mascota));
        return "PerfilMasc";
    }

    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable("id") Integer ID_mascota, Model model) {
        mascota mascota = mascotaService.buscarPorId(ID_mascota);
        model.addAttribute("mascota", mascota);
        ActualizarPublicacion = true;
        return "actualizarMascota";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") Integer ID_mascota){
     mascota mascota = mascotaService.buscarPorId(ID_mascota);
      mascota.setEstatus("eliminada");
      mascotaService.guardar(mascota);
     return"redirect:/publicacion/index";
    }
    
 @PostMapping("/save")
public String guardarComentario(@ModelAttribute("comentario") comentarios comentarios) {
    comentarios.setFecha_creacion(new Date());
    usuario usuario = usuarioService.buscarPorId(InicioCotroller.idUsuario);
    comentarios.setImagenPerfil(usuario.getImagen_perfil());
    comentarios.setNombre(usuario.getNombre_completo());
    comentarios.setUsuario(usuario);
    mascota mascota = mascotaService.buscarPorId(ID_mascotaPerfil);
    comentarios.setMascota(mascota);   
    comentarioService.guardar(comentarios);
    return "redirect:/publicacion/perfil/"+ID_mascotaPerfil;
}

    @ModelAttribute
    public void setGenericos(Model model) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);
    }
}
