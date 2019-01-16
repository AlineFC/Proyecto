/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.accenture.intento2.model;

/**
 *
 * @author CrateX
 */
import javax.management.relation.Role;

public class Usuario {

    private int id;
    private String NombreUs;
    private String contrasena;
    private String email;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(Integer Id, String userName, String contrasenaa, String email,  Rol rol) {

        this.setNombreUs(userName);
        this.setContrasena(contrasenaa);
        this.setId(id);
        this.setEmail(email);
        this.setRol(rol);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUs() {
        return NombreUs;
    }

    public void setNombreUs(String nombreUs) {
        NombreUs = nombreUs;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

 {


    }

}








