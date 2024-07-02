/* @author Andres cuero*/
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascota")
public class mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Mascota;

   
    private String nombre;

  
    private String edad;

  
    private String estado;

   
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "ID_animal")
    private animal animal;

    @ManyToOne
    @JoinColumn(name = "ID_raza")
    private raza raza;

    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_imagen")
    private imagen imagen;

    
    private String imagen_perfil;
    
    private String img_vacuna;
    
    
    private String estatus;
    
    @ManyToOne
    @JoinColumn(name = "ID_calificacion")
    private calificacion calificacion;
    
    private int puntuacion;
    
    

       //constructores 

    public mascota() {
    }

    public mascota(Integer ID_Mascota, String nombre, String edad, String estado, String descripcion, animal animal, raza raza, usuario usuario, imagen imagen, String imagen_perfil, String img_vacuna, String estatus, calificacion calificacion, int puntuacion) {
        this.ID_Mascota = ID_Mascota;
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.descripcion = descripcion;
        this.animal = animal;
        this.raza = raza;
        this.usuario = usuario;
        this.imagen = imagen;
        this.imagen_perfil = imagen_perfil;
        this.img_vacuna = img_vacuna;
        this.estatus = estatus;
        this.calificacion = calificacion;
        this.puntuacion = puntuacion;
    }

    public Integer getID_Mascota() {
        return ID_Mascota;
    }

    public void setID_Mascota(Integer ID_Mascota) {
        this.ID_Mascota = ID_Mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public animal getAnimal() {
        return animal;
    }

    public void setAnimal(animal animal) {
        this.animal = animal;
    }

    public raza getRaza() {
        return raza;
    }

    public void setRaza(raza raza) {
        this.raza = raza;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public imagen getImagen() {
        return imagen;
    }

    public void setImagen(imagen imagen) {
        this.imagen = imagen;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }

    public String getImg_vacuna() {
        return img_vacuna;
    }

    public void setImg_vacuna(String img_vacuna) {
        this.img_vacuna = img_vacuna;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "mascota{" + "ID_Mascota=" + ID_Mascota + ", nombre=" + nombre + ", edad=" + edad + ", estado=" + estado + ", descripcion=" + descripcion + ", animal=" + animal + ", raza=" + raza + ", usuario=" + usuario + ", imagen=" + imagen + ", imagen_perfil=" + imagen_perfil + ", img_vacuna=" + img_vacuna + ", estatus=" + estatus + ", calificacion=" + calificacion + ", puntuacion=" + puntuacion + '}';
    }

    
   

   
  
   

 
 
    
}
    

