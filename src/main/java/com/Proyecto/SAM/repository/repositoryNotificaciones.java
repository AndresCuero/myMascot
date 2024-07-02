
package com.Proyecto.SAM.repository;
/* @author Andres cuero*/


import com.Proyecto.SAM.model.notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;


public interface repositoryNotificaciones extends JpaRepository<notificaciones, Integer> {
    
}
