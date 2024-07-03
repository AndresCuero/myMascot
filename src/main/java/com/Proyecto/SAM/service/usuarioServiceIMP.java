
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.repository.repositoryUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* @author Andres cuero*/
@Service
public class usuarioServiceIMP implements IusuarioService{
    
      @Autowired 
     private repositoryUsuario repoUsuario;

       @Override
    public usuario buscarPorUsername(String username){ 
        return repoUsuario.findByUsername(username);
    }

    @Override
    public void guardar(usuario usuario) {
        repoUsuario.save(usuario);
    }

    @Override
    public usuario buscarPorCorreo(String correo) {
      return  repoUsuario.findByCorreo(correo);
    }
    
   

    @Override
    public usuario buscarPorId(Integer iDusuario) {   
        Optional<usuario> optional = repoUsuario.findById(iDusuario);
           if(optional.isPresent()){
             return optional.get();         
         }            
        return null;
    }

    @Override
    public List<usuario> usuarioEliminado(int estatus) {
      return  repoUsuario.findByEstatus(estatus);
    }

   
    
}
