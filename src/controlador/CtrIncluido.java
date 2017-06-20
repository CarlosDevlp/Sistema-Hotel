/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
import modelo.Callback;

/**
 *
 * Controladora que administra todos los casos de uso (formulario)
 * incluidos o que se utilizan más de 1 vez por otros formularios.
 * 
 * Patrón referido: Factory, Singleton
 *  
 * @author Carlos Chavez Laguna
 */
public class CtrIncluido {
    //paquete de seguridad
    private CtrBuscarRol mCtrBuscarRol;
    private CtrBuscarUsuario mCtrBuscarUsuario;
    private static CtrIncluido mCtrIncluido;
    
    
    //constructor
    private CtrIncluido() {
        mCtrBuscarRol=new CtrBuscarRol();
        mCtrBuscarUsuario=new CtrBuscarUsuario();
        mCtrBuscarRol.loadData();
        mCtrBuscarUsuario.loadData();
    }      
    
    public static CtrIncluido getInstance(){
        if(mCtrIncluido==null)
            mCtrIncluido=new CtrIncluido();
        return mCtrIncluido;
    }
    
    /**
     * Muestra un formulario en específico
     * @param nombreFormulario nombre del formulario, use Constant.FORM_X
     */
    public void showForm(String nombreFormulario){
        switch(nombreFormulario){
            case Constant.FORM_BUSCAR_ROL:
                mCtrBuscarRol.showFrmBuscarRol();                
            break;
            case Constant.FORM_BUSCAR_USUARIO:
                mCtrBuscarUsuario.showFrmBuscarRol();
            break;
        }
    }

    /**
     * Muestra un formulario en específico y envía un callback
     * @param nombreFormulario nombre del formulario, use Constant.FORM_X
     * @param callback agregar un callback que podría realizar el caso de uso incluído
     */
    public void showForm(String nombreFormulario,Callback callback){
        switch(nombreFormulario){
            case Constant.FORM_BUSCAR_ROL:
                mCtrBuscarRol.showFrmBuscarRol();
                mCtrBuscarRol.setOnCompletedSearch(callback);
            break;
            case Constant.FORM_BUSCAR_USUARIO:
                mCtrBuscarUsuario.showFrmBuscarRol();
                mCtrBuscarUsuario.setOnCompletedSearch(callback);
                
            break;
        }
    }
    
       
}