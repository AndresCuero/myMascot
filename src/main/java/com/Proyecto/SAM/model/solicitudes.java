
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="solicitudes")
public class solicitudes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_solicitudes;
    private Date fecha;
    private String estado;
    private String comentarios;
    
    @ManyToOne
    @JoinColumn(name="ID_mascota")
    private mascota mascota;
    
    @ManyToOne
    @JoinColumn(name="ID_usuario")
    private usuario usuario;

    public solicitudes() {
    }

    public solicitudes(Integer ID_solicitudes, Date fecha, String estado, String comentarios, mascota mascota, usuario usuario) {
        this.ID_solicitudes = ID_solicitudes;
        this.fecha = fecha;
        this.estado = estado;
        this.comentarios = comentarios;
        this.mascota = mascota;
        this.usuario = usuario;
    }

    public Integer getID_solicitudes() {
        return ID_solicitudes;
    }

    public void setID_solicitudes(Integer ID_solicitudes) {
        this.ID_solicitudes = ID_solicitudes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public mascota getMascota() {
        return mascota;
    }

    public void setMascota(mascota mascota) {
        this.mascota = mascota;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "solicitudes{" + "ID_solicitudes=" + ID_solicitudes + ", fecha=" + fecha + ", estado=" + estado + ", comentarios=" + comentarios + ", mascota=" + mascota + ", usuario=" + usuario + '}';
    }

    
    
    
    
    
    
}
