
package com.Proyecto.SAM.cotroller;

import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.service.ImascotaService;
import com.Proyecto.SAM.service.IrazaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buscar")
public class Busqueda {
    
    @Autowired
    private  ImascotaService  mascotaService;
    
    @Autowired
    private IrazaService razaService;
    
    // buscar por perro o gato 
    
      @GetMapping("/mascotaPerro")
    public String buscarPorPerro(Model model) {
        model.addAttribute("mascota", mascotaService.buscarPerroOgato("perro"));
        return "PagInformes";
    }

    @GetMapping("/mascotaGato")
    public String buscarPorGato(Model model) {
        model.addAttribute("mascota", mascotaService.buscarPerroOgato("gato"));
        return "PagInformes";
    }
    
    
    // buscar por escrito
    
    @GetMapping("/imput")
    public String buscarMascotas(@ModelAttribute("buscar") mascota mascota, Model model){
    
       //para hacer que no busque comparando el codigo 
        ExampleMatcher matcheer = ExampleMatcher.matching().
                // where descripcion like '%?%'
                withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
    
       //para hacacer busquedas
        Example<mascota> example = Example.of(mascota, matcheer);
        List<mascota> lista = mascotaService.buscarPorExamble(example);
        model.addAttribute("mascota", lista);
        return "mascotasBusquedas";
    
    }
    
    
     @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); 
    }
    
    
    @ModelAttribute
    public void setGenericos(Model model, Pageable page){  
        mascota mascotaBuscar = new mascota();
        model.addAttribute("mascota", mascotaService.buscarTodasOrdenadaPorCalificacionYaprobadas(page) );
        model.addAttribute("raza", razaService.buscarTodas());
        model.addAttribute("buscar", mascotaBuscar);
        
    }
    
}
