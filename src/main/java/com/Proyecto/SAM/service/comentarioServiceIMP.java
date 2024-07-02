
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.comentarios;
import com.Proyecto.SAM.repository.repositoryComentario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/* @author Andres cuero*/

@Service("comentarioIMP")
public class comentarioServiceIMP implements IcomentarioService {
    
    @Autowired
    private repositoryComentario repoComentario;

    @Override
    public void guardar(comentarios comentario) {
        repoComentario.save(comentario);
    }

    @Override
    public List<comentarios> comentarios(Integer ID_mascota) {
       return repoComentario.findByMascota(ID_mascota);
    }
    
}
