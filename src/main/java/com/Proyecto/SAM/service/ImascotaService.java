
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.mascota;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/* @author Andres cuero*/
public interface ImascotaService {
    
    //este metodo tambien es para actualizar pasandole un id 
    void guardar(mascota mascota);
    
    void eliminar(Integer id);
    
    List<mascota> buscartodas ();
    
    mascota buscarPorId (Integer id);
    
    Page<mascota> buscarTodasOrdenadaPorCalificacionYaprobadas(Pageable page);
    
     List<mascota> buscarTodasOrdenadaPorCalificacionYaprobadas();
    
    
    List<mascota> buscarPerroOgato(String especie);
    
    // este metodo es para buscar
    List<mascota> buscarPorExamble(Example<mascota> example);
   
    //este metodo es para paginar las vistas
    Page<mascota> buscarTodas(Pageable page);
    
    //ejemplo
    Page<mascota> buscartodas (Pageable page);
    
    List<mascota> misPublicaciones(Integer ID_mascota);
    
    Integer buscarPorUsuarioParaSaberSiTieneMascota(Integer ID_mascota);
    
    
    
    
    
    
    
    
    
    
}
