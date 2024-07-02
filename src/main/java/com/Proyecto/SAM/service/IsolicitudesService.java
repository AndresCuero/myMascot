
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.solicitudes;
import java.util.List;


public interface IsolicitudesService {
    
    void guardarSolicitud(solicitudes solicitud);
    
    List<solicitudes> listaDePeticion(Integer ID_usuario);
    
    List<solicitudes> todasLasSolicitudes();
    
    solicitudes buscarPorId(Integer ID_solicitudes);
  
    
}
