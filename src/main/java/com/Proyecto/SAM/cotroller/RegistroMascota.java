package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.animal;
import com.Proyecto.SAM.model.imagen;
import org.springframework.ui.Model;
import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.raza;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.IrazaService;
import com.Proyecto.SAM.utileria.utileria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.Proyecto.SAM.service.IanimalService;
import com.Proyecto.SAM.service.IimagenService;
import com.Proyecto.SAM.service.ImascotaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mascota")
public class RegistroMascota {

    boolean select = false;
    public static boolean activarUrlDonantes = false;
    int tipoEspecie = 0;

    @Autowired
    private IanimalService serviceAnimal;

    @Autowired
    private IrazaService serviceRaza;

    @Autowired
    private ImascotaService serviceMascota;
    
    @Autowired
    private IimagenService serviceImagen;
    

    @Value("${trabajoapp.ruta.imagen}")
    private String ruta;

    @GetMapping("/registro")
    public String urlAregistro(mascota mascota, Model model) {
        model.addAttribute("activar", select = false);
         model.addAttribute("nombreEspecie", "Seleccionar especie");
        return "gestionMascotas";
    }

    @GetMapping("/selectPerro")
    public String seleccionamosPerro(Model model, mascota mascota) {
        model.addAttribute("activar", select = true);
        List<raza> razasPerro = serviceRaza.mostrarRazasPorTipoAnimal("1"); 
        model.addAttribute("raza", razasPerro);
        tipoEspecie =1;
        model.addAttribute("nombreEspecie", "Perro");
 

        return "gestionMascotas";
    }

    @GetMapping("/selectGato")
    public String seleccionamosGatos(Model model, mascota mascota) {
        model.addAttribute("activar", select = true);
        List<raza> razasGato = serviceRaza.mostrarRazasPorTipoAnimal("2"); 
        model.addAttribute("raza", razasGato);
        tipoEspecie =2;
         model.addAttribute("nombreEspecie", "Gato");

        return "gestionMascotas";
    }

    @PostMapping("/save")
    public String guardarRegistro(mascota mascota,animal animal,  imagen imagen, raza raza, RedirectAttributes mensajeAlGurdar, HttpSession session,
            @RequestParam("archivoImagenPerfil") MultipartFile multiPartPerfil,
            @RequestParam("archivoImagenVacuna") MultipartFile multiPartVacuna,
            @RequestParam("archivoImagenFoto1")  MultipartFile multipartFoto1,
            @RequestParam("archivoImagenFoto2")  MultipartFile multipartFoto2,
            @RequestParam("archivoImagenFoto3")  MultipartFile multipartFoto3       
    ){
        
       
     
        animal.setID_animal(tipoEspecie);
        mascota.setAnimal(animal);
        
        
        usuario usuario = (usuario) session.getAttribute("usuario");
        mascota.setUsuario(usuario);
               
    
        // estamos guardado las imagenes en una caperta de la pc 
        // con la funcion de utileria nos traemos el nomber de la img para guardalo en base de datos
        if (!multiPartPerfil.isEmpty()) {
            String nombreImagen = utileria.guardarArchivo(multiPartPerfil, ruta);
            if (nombreImagen != null) {
                mascota.setImagen_perfil(nombreImagen);
            }
        }

        if (!multiPartVacuna.isEmpty()) {
            String nombreImagen = utileria.guardarArchivo(multiPartVacuna, ruta);
            if (nombreImagen != null) {
                mascota.setImg_vacuna(nombreImagen);
            }
        }
        
        if (!multipartFoto1.isEmpty()){
            String nombreFoto1 = utileria.guardarArchivo(multipartFoto1, ruta);
            if(nombreFoto1 != null ){
              imagen.setFoto1(nombreFoto1);
            }
        }
        
        
        if(!multipartFoto2.isEmpty()){
            String nombreFoto2 = utileria.guardarArchivo(multipartFoto2, ruta);           
            if(nombreFoto2 != null){
               imagen.setFoto2(nombreFoto2);
            }              
        }        
        
        if(!multipartFoto3.isEmpty()){
          String nombreFoto3 = utileria.guardarArchivo(multipartFoto3, ruta);
          if(nombreFoto3 != null)
              imagen.setFoto3(nombreFoto3);
        }
        
         // Guardamos la instancia de imagen primero
        serviceImagen.guardarImagen(imagen);
        mascota.setImagen(imagen);
        

        // Todas las publicaciones estaran aprobada al incio
        mascota.setEstatus("aprobada");

        // nos guardamos el objeto mascota en la base de datos
        serviceMascota.guardar(mascota);
 
        if(MisPublicaciones.ActualizarPublicacion){
            MisPublicaciones.ActualizarPublicacion=false;
           // mensajeAlGurdar.addFlashAttribute("mensaje", "️Tu Publicacion fue actualizada");
            return "redirect:/publicacion/index";
        }
        else {
         //    mensajeAlGurdar.addFlashAttribute("mensaje", "Los datos de la mascota "+mascota.getNombre()+" fueron publicados ✔️");
            return "redirect:/mascota/registro";
        }
    }
    
    
    @GetMapping("/index")
    public String inciarSessionPublicaciones() {
        activarUrlDonantes = true;
        return "redirect:/index";
    }

    @ModelAttribute
    public void setGenericos(Model model, usuario usuario) {
        mascota mascotaBuscar = new mascota();
        model.addAttribute("buscar", mascotaBuscar);
        model.addAttribute("raza",serviceRaza.buscarTodas());

    }

}
