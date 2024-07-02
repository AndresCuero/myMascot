
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.solicitudes;
import com.Proyecto.SAM.repository.repositorySolicitudes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class solicitudesServiceIMP implements IsolicitudesService {
    
    @Autowired 
    private repositorySolicitudes repoSolicitudes;

    @Override
    public void guardarSolicitud(solicitudes solicitud) {
            repoSolicitudes.save(solicitud);
    }

    @Override
    public List<solicitudes> listaDePeticion(Integer ID_usuario) {
       return repoSolicitudes.findByUsuario(ID_usuario);
    }

    @Override
    public List<solicitudes> todasLasSolicitudes() {
      return  repoSolicitudes.findAll();
    }

    @Override
    public solicitudes buscarPorId(Integer ID_solicitudes) {
        Optional<solicitudes> optional = repoSolicitudes.findById(ID_solicitudes);
        if(optional.isPresent()){
        return optional.get();
        }
        
        return null;
    }

  
    
}
