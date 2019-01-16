package cl.accenture.intento2.model;

import cl.accenture.intento2.exception.SinConexionException;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String id;
    private String name;
    ArrayList<Persona> empleados;
    ArrayList<Proyecto> proyectos;
    ArrayList<Usuario> usuarios;

    public Empresa(){

    }

    public Empresa(String id, String name, Persona persona, Usuario usuario, Proyecto proyecto ){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Persona> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Persona> empleados) {
        this.empleados = empleados;
    }


    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public List<Usuario> buscarUserEmail(String email) throws SinConexionException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        return  null;
    }
}
