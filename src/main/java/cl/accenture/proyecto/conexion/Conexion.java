/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.accenture.intento2.conexion;

/**
 *
 * @author CrateX
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static Connection con;

    public static Connection getConect(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println("El driver no cargo correctamente... ");
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql//localhost:3306/Proyecto","root","1345");
        }
        catch(Exception e){
            System.out.println("No se pudo crear una conexion con la Base de Datos, revise el error.");
        }

        return con;
    }

    public Connection getConexion(){

        return con;

    }        //Metodo que desconecta de la DB

    public void desconectar() {

        con = null;

        if (con == null) {

            System.out.println("Desconectado.");

        }
    }
}
