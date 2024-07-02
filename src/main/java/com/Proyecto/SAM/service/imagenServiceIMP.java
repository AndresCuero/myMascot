
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.imagen;
import com.Proyecto.SAM.repository.repositoryImagen;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("imagenIMP")
public class imagenServiceIMP implements IimagenService {
    
    @Autowired
    private repositoryImagen repoImagen;

    @Override
    public void guardarImagen(imagen imagen) {
       repoImagen.save(imagen);
    }

    @Override
    public imagen buscarPorId(Integer id) {
        Optional<imagen> optional = repoImagen.findById(id);
        if(optional.isEmpty()){
          return optional.get();   
        }     
        return null;
    }
    
}
