/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.BasicDao;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * Clase Usuario, representa los datos del usuario actual
 *
 * @author Carlos Chavez Laguna
 *
 */
public class Usuario {

    private String idUser;
    private String usuarioUser;
    private String passUser;
    private Rol rolUser;
    /**
     * Singleton que mantiene sesión por un solo usuario a nivel global.
     */
    
    private static Usuario mCurrentUser;
    
    /**
     * @return retorna el usuario global que representa al usuario 
     * actualmente logeado
     */        
    public static Usuario getInstance(){
        if(mCurrentUser==null)
            mCurrentUser=new Usuario();
        return mCurrentUser;
    }
    
    
    
    
    //constructores
    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.usuarioUser = username;
        this.passUser = password;
    }
    
    /**
     * Constructor especial que acepta mapas para convertirlo en el objeto User
     *  @param args ,el mapa que contiene los valores del objeto
     */
    public Usuario(Map<String,String> args) {
        this.usuarioUser = args.get("UsuarioUser");
        this.passUser = args.get("PassUser");
    }
    
    //setters and getters
    public String getPassword() {
        return passUser;
    }

    public void setPassword(String password) {
        this.passUser = password;
    }

    public String getUsuario() {
        return usuarioUser;
    }

    public void setUsuario(String usuario) {
        this.usuarioUser = usuario;
    }

    public Rol getRolUser() {
        return rolUser;
    }

    public void setRolUser(Rol rolUser) {
        this.rolUser = rolUser;
    }
   
    
    
    /**
     * verifica la existencia del usuario,
     * de forma implícita crea al objeto usuario
     * que se va a conectar al sistema.
     * 
     * @param username ,nombre de usuario
     * @param password ,contraseña de usuario
     * 
     * @return retorna verdadero o falso según la existencia 
     * del usuario en la base de datos
     */
    public static boolean userExists(String username,String password){        
        ArrayList<Map<String,String>> result=BasicDao.select("user",new String[]{"*"},"UsuarioUser='"+username+"' AND PassUser='"+password+"'");
        boolean exists= result.size()>0;
        //si existe el usuario, de forma implícita, crear al usuario   
        if(exists){
            Map<String,String> row=result.get(0);
            mCurrentUser= new Usuario(row);
            mCurrentUser.setRolUser(Rol.getRol(row.get("Roles_idRoles")));
        }
        return exists;
    }
    
    /**
     * Save <br>
     * Guardar datos en la base de datos
     */
    public void save(){
        BasicDao.update("user", new String []{"UsuarioUser","PassUser"}, new String []{this.usuarioUser,this.passUser}, "idUser="+this.idUser);
    }
   
}
