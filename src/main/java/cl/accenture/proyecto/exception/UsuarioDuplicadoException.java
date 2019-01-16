package cl.accenture.intento2.exception;

import cl.accenture.intento2.conexion.Conexion;

import java.sql.Connection;

public class UsuarioDuplicadoException extends Exception {
    Connection con = Conexion.getConect();

    public UsuarioDuplicadoException(String e){
        super(e);

    }
    public UsuarioDuplicadoException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
