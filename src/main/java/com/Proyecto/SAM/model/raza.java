
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "raza")
public class raza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_raza;
    private String nombre;
    private String selectEspecie;

   
     //constructores 

    public raza() {
    }

    public raza(Integer ID_raza, String nombre, String selectEspecie) {
        this.ID_raza = ID_raza;
        this.nombre = nombre;
        this.selectEspecie = selectEspecie;
    }

    public Integer getID_raza() {
        return ID_raza;
    }

    public void setID_raza(Integer ID_raza) {
        this.ID_raza = ID_raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSelectEspecie() {
        return selectEspecie;
    }

    public void setSelectEspecie(String selectEspecie) {
        this.selectEspecie = selectEspecie;
    }

    @Override
    public String toString() {
        return "raza{" + "ID_raza=" + ID_raza + ", nombre=" + nombre + ", selectEspecie=" + selectEspecie + '}';
    }

    
  
}
