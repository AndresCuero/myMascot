
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.raza;
import java.util.List;


public interface IrazaService {
   // List<raza> buscarPorRaza(int idAnimal);
    List<raza> buscarTodas();
    
    raza buscarPorId(Integer idRaza);
    
      List<raza> mostrarRazasPorTipoAnimal(String especie );
      
      void guardar(raza raza);
}
