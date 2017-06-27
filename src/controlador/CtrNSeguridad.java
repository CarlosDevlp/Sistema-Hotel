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
    private CtrVerPerfil mCtrVerPerfil;
    private CtrMantenerUsuario mCtrMantenerUsuario;    
    private CtrMantenerRol mCtrMantenerRol;
    private CtrReportarSesiones mCtrReportarSesiones;
    private CtrMantenerEmpleado mCtrMantenerEmpleado;//verificar
    
    private Callback mInvokeCallback;
    //constructor    
    public CtrNSeguridad() {
        //creación implicita de controladores
        mCtrLogin=new CtrLogin();
        mCtrVerPerfil=new CtrVerPerfil();
        mCtrMantenerUsuario=new CtrMantenerUsuario();        
        mCtrMantenerRol=new CtrMantenerRol();
        mCtrReportarSesiones=new CtrReportarSesiones();
        mCtrMantenerEmpleado=new CtrMantenerEmpleado();
        mCtrMantenerEmpleado=new CtrMantenerEmpleado();
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

    public CtrVerPerfil getmCtrVerPerfil() {
        return mCtrVerPerfil;
    }

    public void setmCtrVerPerfil(CtrVerPerfil mCtrVerPerfil) {
        this.mCtrVerPerfil = mCtrVerPerfil;
    }

    public CtrReportarSesiones getCtrReportarSesiones() {
        return mCtrReportarSesiones;
    }

    public void setCtrReportarSesiones(CtrReportarSesiones ctrReportarSesiones) {
        this.mCtrReportarSesiones = ctrReportarSesiones;
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
     * mostrar el fomrulario mantener usuario
     */            
    public void showFrmMantenerUsuario(){
        mCtrMantenerUsuario.showFrmMantenerUsuario();
    }
    
    /**
     * mostrar el formulario mantener usuario
     */            
    public void showFrmVerPerfil(){
       mCtrVerPerfil.showFrmVerPerfil();
       mCtrVerPerfil.loadData();
    }
    
    /**
     * mostrar el formulario mantener rol
     */
    public void showFrmMantenerRol(){
      mCtrMantenerRol.showFrmMantenerRol();
    }
    
    /**
     * mostrar el formulario mantener rol
     */
    public void showFrmReportarSesiones(){
      mCtrReportarSesiones.showFrmReporteSesiones();
    }

    /**
     * mostrar el fomrulario mantener empleado
     */            
    public void showFrmMantenerEmpleado(){
        mCtrMantenerEmpleado.showFrmMantenerEmpleado();
    }
    
    
    /**
     * cargar los datos de los formularios
     */
    public void loadData(){
        mCtrMantenerUsuario.loadData();
        mCtrMantenerRol.loadData();
        mCtrReportarSesiones.loadData();
        mCtrMantenerEmpleado.loadData();
    }

    /**
     * pasar el callback para invocar casos
     * de uso incluidos
     * 
     * @param invokeCallback objeto callback
     */
    public void setInvokeCallback(Callback invokeCallback) {
        this.mInvokeCallback = invokeCallback;        
    }
    
    
    
}
