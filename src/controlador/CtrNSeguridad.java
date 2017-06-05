/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Callback;

/**
 * Controlador de negocio Seguridad
 * @author Carlos Chavez Laguna
 */
public class CtrNSeguridad {

    
    private CtrLogin mCtrLogin;
    private CtrMantenerUsuario mCtrMantenerUsuario;
    
    //constructor
    public CtrNSeguridad() {
    }
    
    public CtrNSeguridad(CtrLogin ctrLogin) {
        mCtrLogin=ctrLogin;
    }
    
    //setters and getters
    public CtrLogin getCtrLogin() {
        return mCtrLogin;
    }

    public void setCtrLogin(CtrLogin ctrLogin) {
        this.mCtrLogin = ctrLogin;
    }

    public CtrMantenerUsuario getCtrMantenerUsuario() {
        return mCtrMantenerUsuario;
    }

    public void setCtrMantenerUsuario(CtrMantenerUsuario ctrMantenerUsuario) {
        this.mCtrMantenerUsuario = ctrMantenerUsuario;
    }
    
    /**
     * Agrega un callback(listener) para cuando
     * el login haya verificado la validez del 
     * usuario.
     * 
     * @param onUserLogged callback(listener)
     */
    public void setOnUserLogged(Callback onUserLogged) {
        mCtrLogin.setOnUserLogged(onUserLogged);
    }
    
    
    /**
     * showFrmLogin <br>
     * Permite mostrar el login
     *      
     */
    public void showFrmLogin(){
        mCtrLogin.showFrmLogin();
    }
    
    /**
     * 
     */            
    public void showFrmMantenerUsuario(){
        mCtrMantenerUsuario.showFrmMantenerUsuario();
    }
    
    public void loadData(){
        mCtrMantenerUsuario.loadData();
    }
}
