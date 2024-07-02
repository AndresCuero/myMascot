/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.SAM.repository;

import com.Proyecto.SAM.model.historial_usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cuero
 */
public interface repositoryHistorial_usuario extends JpaRepository<historial_usuario, Integer> {
    
}
