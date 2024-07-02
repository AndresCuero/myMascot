
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.calificacion;


public interface IcalificacionService {
    
   void  guardar(calificacion calificacion);
   
   calificacion buscarPorId(Integer ID_calificacion);
    
}
