
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="historial_usuario")
public class historial_usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_historial;
    private String accion;
    private Date fecha;

   
     //constructores 
    
    public historial_usuario() {
    }

    public historial_usuario(Integer ID_historial, String accion, Date fecha) {
        this.ID_historial = ID_historial;
        this.accion = accion;
        this.fecha = fecha;
    }

   
   
    
      //get set

    public Integer getID_historial() {
        return ID_historial;
    }

    public void setID_historial(Integer ID_historial) {
        this.ID_historial = ID_historial;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "historial_usuario{" + "ID_historial=" + ID_historial + ", accion=" + accion + ", fecha=" + fecha + '}';
    }

    

    
    
    
    
    
}
