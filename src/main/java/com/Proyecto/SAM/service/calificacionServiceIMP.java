
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.calificacion;
import com.Proyecto.SAM.repository.repositoryCalificacion;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class calificacionServiceIMP implements IcalificacionService{
    
    @Autowired
    private repositoryCalificacion repoCalificacion;

    @Override
    public void guardar(calificacion calificacion) {
        repoCalificacion.save(calificacion);
    }

    @Override
    public calificacion buscarPorId(Integer ID_calificacion) {
        Optional<calificacion> optional = repoCalificacion.findById(ID_calificacion);
        
        if(optional.isPresent()){
           return optional.get();
        }
        
       return null; 
    }
    
}
