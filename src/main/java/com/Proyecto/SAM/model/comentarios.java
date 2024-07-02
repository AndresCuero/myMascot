/* @author Andres cuero*/
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
@Table(name="comentarios")
public class comentarios {
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Comentario;

    
    private String mensaje;

 
    private Date fecha_creacion;
    
     @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_mascota")
    private mascota mascota;
    
    private String imagenPerfil;
    
    private String nombre;
    
     //constructores 

    public comentarios() {
    }

    public comentarios(Integer ID_Comentario, String mensaje, Date fecha_creacion, usuario usuario, mascota mascota, String imagenPerfil, String nombre) {
        this.ID_Comentario = ID_Comentario;
        this.mensaje = mensaje;
        this.fecha_creacion = fecha_creacion;
        this.usuario = usuario;
        this.mascota = mascota;
        this.imagenPerfil = imagenPerfil;
        this.nombre = nombre;
    }

    public Integer getID_Comentario() {
        return ID_Comentario;
    }

    public void setID_Comentario(Integer ID_Comentario) {
        this.ID_Comentario = ID_Comentario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public mascota getMascota() {
        return mascota;
    }

    public void setMascota(mascota mascota) {
        this.mascota = mascota;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "comentarios{" + "ID_Comentario=" + ID_Comentario + ", mensaje=" + mensaje + ", fecha_creacion=" + fecha_creacion + ", usuario=" + usuario + ", mascota=" + mascota + ", imagenPerfil=" + imagenPerfil + ", nombre=" + nombre + '}';
    }   
    
}
