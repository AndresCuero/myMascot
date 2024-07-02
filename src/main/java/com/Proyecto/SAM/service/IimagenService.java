
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.imagen;


public interface IimagenService {
    
    void guardarImagen (imagen imagen);
    
    imagen buscarPorId(Integer id);
    
}
