/* @author Andres cuero*/
package com.Proyecto.SAM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name ="usuario")
public class usuario {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_usuario;

    
    private int documento;

    
    private String nombre_completo;

 
    private String correo;

  
    private String telefono;

  
    private String direccion;

   
    private String password;
    
    private String username;
    
    

    @ManyToOne
    @JoinColumn(name = "ID_documento")
    private tipoDocumento tipoDocumento;

   

    @ManyToOne
    @JoinColumn(name = "ID_historial")
    private historial_usuario historial;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="usuario_rol",
            joinColumns= @JoinColumn(name="ID_usuario"),
            inverseJoinColumns = @ JoinColumn(name="ID_rol")
    
    
    )
    
    private List<rol> roles;
    
    private int estatus;
    
    private String Imagen_perfil="sinFotoDePerfil.png";
    
    private String apellidos;
    
    private String tipo_documento;
    
    
    // metodo
     public void agregar(rol addRol){
       if(roles == null){
         roles = new LinkedList<rol>();
       }
       roles.add(addRol);
    }


    
    //constructores 

    public usuario() {
    }

    public usuario(Integer ID_usuario, int documento, String nombre_completo, String correo, String telefono, String direccion, String password, String username, tipoDocumento tipoDocumento, historial_usuario historial, List<rol> roles, int estatus, String apellidos, String tipo_documento) {
        this.ID_usuario = ID_usuario;
        this.documento = documento;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.password = password;
        this.username = username;
        this.tipoDocumento = tipoDocumento;
        this.historial = historial;
        this.roles = roles;
        this.estatus = estatus;
        this.apellidos = apellidos;
        this.tipo_documento = tipo_documento;
    }

    public Integer getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(Integer ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public tipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(tipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public historial_usuario getHistorial() {
        return historial;
    }

    public void setHistorial(historial_usuario historial) {
        this.historial = historial;
    }

    public List<rol> getRoles() {
        return roles;
    }

    public void setRoles(List<rol> roles) {
        this.roles = roles;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getImagen_perfil() {
        return Imagen_perfil;
    }

    public void setImagen_perfil(String Imagen_perfil) {
        this.Imagen_perfil = Imagen_perfil;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    @Override
    public String toString() {
        return "usuario{" + "ID_usuario=" + ID_usuario + ", documento=" + documento + ", nombre_completo=" + nombre_completo + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", password=" + password + ", username=" + username + ", tipoDocumento=" + tipoDocumento + ", historial=" + historial + ", roles=" + roles + ", estatus=" + estatus + ", Imagen_perfil=" + Imagen_perfil + ", apellidos=" + apellidos + ", tipo_documento=" + tipo_documento + '}';
    }



   
    
}
