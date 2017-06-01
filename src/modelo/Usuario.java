/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * Clase Usuario, representa los datos del usuario actual
 *
 * @author Carlos Chavez Laguna
 *
 */
public class Usuario {

    private String usuarioUser;
    private String passUser;
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
    
   
}
