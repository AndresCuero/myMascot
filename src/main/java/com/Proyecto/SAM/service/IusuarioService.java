
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.usuario;
import com.Proyecto.SAM.repository.repositoryUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/* @author Andres cuero*/
public interface IusuarioService {
  
      usuario buscarPorId(Integer iDusuario);
       
      usuario buscarPorUsername(String username);
      
      usuario buscarPorCorreo(String correo);
    
      void guardar(usuario usuario);
      
      List<usuario> usuarioEliminado(int estatus);
    
}
