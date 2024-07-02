
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name="tipo_documento")
public class tipoDocumento {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_documento;

  
    private String nombre;
    
     //constructores 

    public tipoDocumento() {
    }

    public tipoDocumento(Integer ID_documento, String nombre) {
        this.ID_documento = ID_documento;
        this.nombre = nombre;
    }
    
      //get set

    public Integer getID_documento() {
        return ID_documento;
    }

    public void setID_documento(Integer ID_documento) {
        this.ID_documento = ID_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "tipoDocumento{" + "ID_documento=" + ID_documento + ", nombre=" + nombre + '}';
    }
    
    
    
}
