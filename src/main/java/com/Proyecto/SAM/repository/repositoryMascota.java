package com.Proyecto.SAM.repository;

/* @author Andres cuero*/

import com.Proyecto.SAM.model.mascota;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface repositoryMascota extends JpaRepository<mascota, Integer> {

     @Query("SELECT m FROM mascota m WHERE m.estatus = 'aprobada' ORDER BY m.calificacion DESC")
     Page<mascota> findByEstatusOrderByCalificacionDesc(Pageable page);
     
     @Query("SELECT m FROM mascota m WHERE m.estatus = 'aprobada' ORDER BY m.calificacion DESC")
     List<mascota> findByEstatusOrderByCalificacionDesc();

     @Query("SELECT m FROM mascota m WHERE m.estatus = 'aprobada'")
     List<mascota> findByEstatus();
     
     List<mascota> findByEstatus( String estatus);

    @Query("SELECT m FROM mascota m WHERE m.animal.especie = :especie AND m.estatus = 'aprobada'")
    List<mascota> findByEspecie(@Param("especie") String especie);

    //metodo para mis publicaciones 
    @Query("SELECT m FROM mascota m WHERE m.usuario.ID_usuario = :id AND m.estatus = 'aprobada'")
    List<mascota> findByUsuarioAndEstatus(@Param("id") Integer ID_usuario);
    
    @Query("SELECT m FROM mascota m WHERE m.usuario.ID_usuario = :id ")
     Optional<mascota> findByUsuario(@Param("id") Integer ID_usuario);



}
