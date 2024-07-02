
package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.model.animal;
import com.Proyecto.SAM.model.mascota;
import com.Proyecto.SAM.model.raza;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface repositoryAnimal extends JpaRepository<animal, Integer> {
   
   
}
