/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.accenture.intento2.dao;

/**
 *
 * @author CrateX
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cl.accenture.intento2.conexion.Conexion;
import cl.accenture.intento2.exception.RolExisteException;
import cl.accenture.intento2.model.Rol;


public class RolDAO {

    private PreparedStatement ps;
    private Statement s;
    private Conexion con;

    public RolDAO(){
        this.con = new Conexion();
    }

    public ArrayList<Rol> getRol() throws SQLException {

       ArrayList<Rol> roles = new ArrayList<>();

        ps = Conexion.getConect().prepareStatement("SELECT * FROM Rol");
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Rol rol = new Rol();

            rol.setId(rs.getInt(1));
            rol.setNombre(rs.getString(2));
            rol.setDescripcion(rs.getString(3));

            roles.add(rol);
        }
        return roles;
    }

    public void eliminarRol(Rol rol) throws SQLException, RolExisteException {

        ps = Conexion.getConect().prepareStatement("SELECT id FROM usuarios WHERE id"
                + " = ?");
        ps.setInt(1, rol.getId());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            throw new RolExisteException("Rol actualmente en uso");
        } else {
            ps = Conexion.getConect().prepareStatement("DELETE FROM role WHERE id = ?");
            ps.setInt(1, rol.getId());
            ps.executeUpdate();
            System.out.println("Datos eliminados correctamente.");
        }
}
}
