
package com.Proyecto.SAM.service;

import com.Proyecto.SAM.model.animal;
import com.Proyecto.SAM.repository.repositoryAnimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("animalIMP")
public class animalServiceIMP implements IanimalService {
    
     @Autowired
    private repositoryAnimal animalRepository;

    @Override
    public List<animal> buscarTodas() {
       return animalRepository.findAll();
    }
    
}
