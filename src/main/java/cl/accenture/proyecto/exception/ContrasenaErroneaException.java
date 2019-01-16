package cl.accenture.intento2.exception;

import cl.accenture.intento2.conexion.Conexion;

import java.sql.Connection;

public class ContrasenaErroneaException extends Exception {

    Connection con = Conexion.getConect();

    public ContrasenaErroneaException(String e){
        super(e);
    }

    public ContrasenaErroneaException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
