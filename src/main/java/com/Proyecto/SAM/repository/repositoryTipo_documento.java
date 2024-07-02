
package com.Proyecto.SAM.repository;
/* @author Andres cuero*/


import com.Proyecto.SAM.model.tipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface repositoryTipo_documento extends JpaRepository<tipoDocumento, Integer>{
    
}
