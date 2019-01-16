package cl.accenture.intento2.exception;

public class SinConexionException extends Exception{


    public SinConexionException(String mensaje, Throwable e){
        super(mensaje, e);
    }


}