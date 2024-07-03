
package com.Proyecto.SAM.repository;
/* @author Andres cuero*/

import com.Proyecto.SAM.model.usuario;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryUsuario extends JpaRepository<usuario, Integer>{
    
    // esta consulta es para iniciar con username
     usuario findByUsername(String username);
     
     
      // esta consulta es para iniciar con username
     usuario findByCorreo(String correo);
     
     List<usuario> findByEstatus(int estatus);
    
}
