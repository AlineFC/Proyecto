package cl.accenture.intento2.exception;

import cl.accenture.intento2.conexion.Conexion;

import java.sql.Connection;

public class CampoEnBlancoException extends Exception {
    Connection con = Conexion.getConect();

    public CampoEnBlancoException(String e){
        super(e);
    }

    public CampoEnBlancoException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
