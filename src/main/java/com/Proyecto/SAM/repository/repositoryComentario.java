
package com.Proyecto.SAM.repository;
/* @author Andres cuero*/

import com.Proyecto.SAM.model.comentarios;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface repositoryComentario extends JpaRepository<comentarios, Integer> {
    
       @Query("SELECT c FROM comentarios c WHERE c.mascota.ID_Mascota = :ID_Mascota")
List<comentarios> findByMascota(@Param("ID_Mascota") Integer ID_Mascota);
    
}
