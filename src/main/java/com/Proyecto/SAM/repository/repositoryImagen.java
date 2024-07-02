/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.model.imagen;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cuero
 */
public interface repositoryImagen extends JpaRepository<imagen, Integer>{
    
}
