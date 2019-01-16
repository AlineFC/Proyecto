package cl.accenture.intento2.controller;
import cl.accenture.intento2.dao.UsuarioDAO;
import cl.accenture.intento2.model.Usuario;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {



    @RequestMapping(method = RequestMethod.POST )
    public void agregarUs(@RequestBody Usuario usuario){

        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET )
    public ArrayList<Usuario> obtenerUs( ){
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.obtenerUsuarios();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    @RequestMapping(method = RequestMethod.POST ,
            value="/login")
    public void login( @RequestBody Usuario usuario ){
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.Login(usuario);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
