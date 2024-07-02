/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.model.raza;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author cuero
 */
public interface repositoryRaza extends JpaRepository<raza, Integer> {
      
   List<raza> findBySelectEspecie(String selectEspecie);
  
 
}
