
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="imagen")
public class imagen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_imagen;
    private String foto1;
    private String foto2;
    private String foto3;
    
  
    
     //constructores 

    public imagen() {
    }

    public imagen(Integer ID_imagen, String foto1, String foto2, String foto3) {
        this.ID_imagen = ID_imagen;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
    }

    public Integer getID_imagen() {
        return ID_imagen;
    }

    public void setID_imagen(Integer ID_imagen) {
        this.ID_imagen = ID_imagen;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    @Override
    public String toString() {
        return "imagen{" + "ID_imagen=" + ID_imagen + ", foto1=" + foto1 + ", foto2=" + foto2 + ", foto3=" + foto3 + '}';
    }

   

}
