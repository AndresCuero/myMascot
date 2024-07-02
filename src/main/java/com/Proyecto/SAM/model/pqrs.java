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
@Table(name="pqrs")
public class pqrs {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_pqrs;
    private String titulo;
    private String descripcion;
    private String correo;
    private Date fecha_pqrs;

    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private usuario usuario;
    
     //constructores 

    public pqrs() {
    }

    public pqrs(Integer ID_pqrs, String titulo, String descripcion, String correo, Date fecha_pqrs, usuario usuario) {
        this.ID_pqrs = ID_pqrs;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.correo = correo;
        this.fecha_pqrs = fecha_pqrs;
        this.usuario = usuario;
    }


     //constructores //get set

    public Integer getID_pqrs() {
        return ID_pqrs;
    }

    public void setID_pqrs(Integer ID_pqrs) {
        this.ID_pqrs = ID_pqrs;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_pqrs() {
        return fecha_pqrs;
    }

    public void setFecha_pqrs(Date fecha_pqrs) {
        this.fecha_pqrs = fecha_pqrs;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "pqrs{" + "ID_pqrs=" + ID_pqrs + ", titulo=" + titulo + ", descripcion=" + descripcion + ", correo=" + correo + ", fecha_pqrs=" + fecha_pqrs + ", usuario=" + usuario + '}';
    }
    
    

}
