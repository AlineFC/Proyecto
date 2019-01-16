package cl.accenture.intento2.model;

import cl.accenture.intento2.model.Proyecto;

public class Persona {

    private String idPersona;
    private String rut;
    private String nombre;
    private String cargo;
    private String habilidad;
    private Proyecto proyecto;

    public Persona() {

    }

    public Persona(String idPersona,String rut,String nombre,String cargo,String habilidad, Proyecto proyecto) {
        this.idPersona = idPersona;
        this.rut = rut;
        this.nombre = nombre;
        this.cargo=cargo;
        this.habilidad=habilidad;
        this.proyecto = proyecto;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}