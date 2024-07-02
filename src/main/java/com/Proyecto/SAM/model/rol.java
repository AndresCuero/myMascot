
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


 @Entity
 @Table(name="rol")
public class rol {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_rol;

  
    private String roles;
    
     //constructores 

    public rol() {
    }

    public rol(Integer ID_rol, String roles) {
        this.ID_rol = ID_rol;
        this.roles = roles;
    }

    public Integer getID_rol() {
        return ID_rol;
    }

    public void setID_rol(Integer ID_rol) {
        this.ID_rol = ID_rol;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "rol{" + "ID_rol=" + ID_rol + ", roles=" + roles + '}';
    }

    
    
    

    
}
