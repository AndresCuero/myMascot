
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="calificacion")
public class calificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_calificacion;
    
    
    private boolean megusta;
    
    private Integer ID_usuario;
    
    public calificacion() {
    }

    public calificacion(Integer ID_calificacion, boolean megusta, Integer ID_usuario) {
        this.ID_calificacion = ID_calificacion;
        this.megusta = megusta;
        this.ID_usuario = ID_usuario;
    }

    public Integer getID_calificacion() {
        return ID_calificacion;
    }

    public void setID_calificacion(Integer ID_calificacion) {
        this.ID_calificacion = ID_calificacion;
    }

    public boolean isMegusta() {
        return megusta;
    }

    public void setMegusta(boolean megusta) {
        this.megusta = megusta;
    }

    public Integer getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(Integer ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    @Override
    public String toString() {
        return "calificacion{" + "ID_calificacion=" + ID_calificacion + ", megusta=" + megusta + ", ID_usuario=" + ID_usuario + '}';
    }
    
    

  

  
    
    
    
    
}
