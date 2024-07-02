/* @author Andres cuero*/
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name="notificacion")
public class notificaciones {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_notificacion;
    private String mensaje;
    private Date fecha_notificacion;
    private boolean leida;

    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private usuario usuario;
    
     //constructores 

    public notificaciones() {
    }

    public notificaciones(Integer ID_notificacion, String mensaje, Date fecha_notificacion, boolean leida, usuario usuario) {
        this.ID_notificacion = ID_notificacion;
        this.mensaje = mensaje;
        this.fecha_notificacion = fecha_notificacion;
        this.leida = leida;
        this.usuario = usuario;
    }

    
     //get set

    public Integer getID_notificacion() {
        return ID_notificacion;
    }

    public void setID_notificacion(Integer ID_notificacion) {
        this.ID_notificacion = ID_notificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha_notificacion() {
        return fecha_notificacion;
    }

    public void setFecha_notificacion(Date fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "notificaciones{" + "ID_notificacion=" + ID_notificacion + ", mensaje=" + mensaje + ", fecha_notificacion=" + fecha_notificacion + ", leida=" + leida + ", usuario=" + usuario + '}';
    }

    
    

    
    
    
    
    
}
