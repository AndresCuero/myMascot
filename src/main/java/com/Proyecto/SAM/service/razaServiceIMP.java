
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.raza;
import com.Proyecto.SAM.repository.repositoryRaza;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("razaIMP")
public class razaServiceIMP implements IrazaService {
    
    @Autowired
    private repositoryRaza razaRepository;


    @Override
    public List<raza> buscarTodas() {
        return razaRepository.findAll();
        
    }

   @Override
    public List<raza> mostrarRazasPorTipoAnimal(String especie) {
        return razaRepository.findBySelectEspecie(especie);
    }

    @Override
    public raza buscarPorId(Integer idRaza) {
       Optional<raza> optional = razaRepository.findById(idRaza);
       if(optional.isPresent()){
           return optional.get();
       }
       
       return null;
    }

    @Override
    public void guardar(raza raza) {
        razaRepository.save(raza);
    }

   
}
