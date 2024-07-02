
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.comentarios;
import java.util.List;

/* @author Andres cuero*/

public interface IcomentarioService {
    
    void guardar(comentarios comentario);
    
    List<comentarios> comentarios(Integer ID_mascota);
    
}
