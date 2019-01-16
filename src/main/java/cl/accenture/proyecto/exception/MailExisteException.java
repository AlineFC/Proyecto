package cl.accenture.intento2.exception;

import cl.accenture.intento2.conexion.Conexion;

import java.sql.Connection;

public class MailExisteException extends Exception {
    Connection con = Conexion.getConect();
    public MailExisteException(String e){

        super(e);
    }
    public MailExisteException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
