
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "animal")
public class animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_animal;
    private String especie;
    
   

    public animal() {
    }
 
    
    public animal(Integer ID_animal, String especie) {
        this.ID_animal = ID_animal;
        this.especie = especie;
    }
    
       //get set

    public Integer getID_animal() {
        return ID_animal;
    }

    public void setID_animal(Integer ID_animal) {
        this.ID_animal = ID_animal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "animal{" + "ID_animal=" + ID_animal + ", especie=" + especie + '}';
    }
    
    
    
}
