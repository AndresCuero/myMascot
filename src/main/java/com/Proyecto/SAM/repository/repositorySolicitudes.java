
package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.model.solicitudes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface repositorySolicitudes extends JpaRepository<solicitudes, Integer> {
    
    @Query("SELECT s FROM solicitudes s WHERE s.usuario.ID_usuario = :ID_usuario")
    List<solicitudes> findByUsuario(@Param("ID_usuario") Integer ID_usuario);
  
   
    
}
