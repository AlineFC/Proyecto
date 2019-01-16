package cl.accenture.intento2.dao;

import cl.accenture.intento2.Email;
import cl.accenture.intento2.conexion.Conexion;
import cl.accenture.intento2.exception.CorreoExisteException;
import cl.accenture.intento2.exception.SinConexionException;
import cl.accenture.intento2.exception.UsuarioExisteException;
import cl.accenture.intento2.model.Registro;
import cl.accenture.intento2.model.Usuario;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Conexion conexion;
    private PreparedStatement ps;
    private Statement statement;

    public UsuarioDAO() {
        this.conexion = conexion;
        this.statement = statement;
        this.ps=ps;
    }

    public PreparedStatement getPs() {
        return ps;
    }
    public void setPs(PreparedStatement ps) {
        ps = ps;
    }
    public Statement getStatement() {
        return statement;
    }
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    public Conexion getConexion() {
        return conexion;
    }
    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public String Encriptar(String encr) throws NoSuchAlgorithmException {

        //Encriptacion MD5

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(encr.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public boolean VerificarExistenciaUsuario( Usuario usuario ) throws SQLException, SinConexionException {
        ps = Conexion.getConect().prepareStatement("SELECT nombre_usuario FROM usuarios WHERE nombre_usuario=?");
        ps.setString(1, usuario.getNombreUs());
        ps = Conexion.getConect().prepareStatement("SELECT * FROM usuarios WHERE email=?");
        ps.setString(1, usuario.getEmail());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public boolean Login(Usuario usuario)throws SinConexionException {

        try{
            final String SQL = "select * from usuarios where " +
                    "nombre=? and password=?";
            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ps.setString(1, usuario.getNombreUs() );
            ps.setString(2, usuario.getContrasena() );
            ResultSet rs = ps.executeQuery();
            if(rs.next() ){
                System.out.println( "Iniciando sesion, espere un momento... ");
            }else{
                System.out.println( "Nombre o Contraseña incorrectos.");
            }
            return rs.next();
        }catch (SQLException e){
            return false;
        }
    }

    public String agregarUser(Registro r) throws SinConexionException{

        String id  = r.getId() ;
        String rut = r.getRut();
        String nombre = r.getNombre();
        String psword= r.getPword();
        String cargo = r.getCargo();
        String habilidad = r.getHabilidad();
        String email=r.getEmail();
        String myhash = r.getMyhash();
        Connection con = Conexion.getConect();

        try{
            String sqlQuery = "insert into usertable(id,rut, nombre,cargo,habilidad,email,proyecto, myhash) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setString(1, id);
            pst.setString(2, rut);
            pst.setString(3, nombre);
            pst.setString(4, cargo);
            pst.setString(5, habilidad);
            pst.setString(6, email);
            pst.setString(7, myhash);
            int i = pst.executeUpdate();
            if(i!= 0){

                Email e = new Email(email,myhash);
                return "Agregado con exito.";
            }
        }
        catch(Exception e){
            System.out.println("RegistroDAO" +e);
        }
        return "Error al agregar el usuario";
    }


    public void guardarUsuario(Usuario u) throws CorreoExisteException, UsuarioExisteException, SQLException, SinConexionException {
        try {

            if (VerificarExistenciaUsuario(u)) {
                throw new UsuarioExisteException("Usuario ya existe");
            } else if (VerificarExistenciaUsuario(u)) {
                throw new CorreoExisteException("Email ya utilizado");
            } else {

                final String SQL = "INSERT INTO usuarios(nombre_usuario,email,password,,id_rol) VALUES (?,?,?,?,?)";
                ps = Conexion.getConect().prepareStatement(SQL);

                ps.setString(1, u.getNombreUs());
                ps.setString(2, u.getEmail());
                ps.setString(3, (u.getContrasena()));   //Se ingresa contraseña encriptada
                ps.setInt(4, u.getRol().getId());
                ps.executeUpdate();
                System.out.println("Usuario ingresado correctamente");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Usuario> buscarUsuario(String nombre) throws SinConexionException {
                    List<Usuario> usuarios = new ArrayList<Usuario>();
                    try {
                        final String SQL = "SELECT * from cancion where nombre = ?";
                        PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
                        ps.setString(1,nombre);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            Usuario usuario = new Usuario();
                            usuario.setId(rs.getInt(1));
                            usuario.setNombreUs(rs.getString(2));
                            usuario.setContrasena(rs.getString(3));
                            usuario.setEmail(rs.getString(4));
                            //usuario.setRol(rs.get(5));
                            usuarios.add(usuario);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    return usuarios;
                }


    public List<Usuario> buscarUsEmail(String email) throws SinConexionException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            final String SQL = "SELECT * from usuario where email = ?";
            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombreUs(rs.getString(2));
                usuario.setContrasena(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                //usuario.setRol(rs.getInt(5));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    public ArrayList<Usuario> obtenerUsuarios() throws SQLException, SinConexionException{

        ArrayList<Usuario> usuarios = new ArrayList<>();

        ps = Conexion.getConect().prepareStatement("SELECT * FROM usuarios");
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Usuario usuario = new Usuario();

            usuario.setId(rs.getInt(1));
            usuario.setNombreUs(rs.getString(2));
            usuario.setEmail(rs.getString(3));
            usuario.setContrasena(rs.getString(4));
            //usuario.setRol( new RolDAO(rs.getInt(5)) );
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public void EditarUsuario(Usuario usuario) {

        try {
            String sqledit = "UPDATE Usuarios";
            sqledit += " set nombre = '" + usuario.getNombreUs() + "',";
            sqledit += " set Contrasena = '" + usuario.setContrasena + "',";
            sqledit += " codigo_programa = '" + usuario.setId() + "'";
            sqledit += " WHERE codigo = '" + usuario.setRol() + "'";

            Connection con = Conexion.getConect();
            Statement s = con.createStatement();
            System.out.println("SQL: " + sqledit);
            s.executeUpdate(sqledit);
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
    }

    public void eliminarUser(Usuario usuario) {
        try {
            String sqldel = "DELETE FROM Usuarios";
            sqldel += " WHERE idUser = '" + usuario.getId() + "'";

            Connection con = Conexion.getConect();
            Statement s = con.createStatement();
            System.out.println("SQL: " + sqldel);
            s.executeUpdate(sqldel);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
    }


    }


