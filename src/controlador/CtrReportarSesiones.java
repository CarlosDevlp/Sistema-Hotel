/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import modelo.Callback;
import modelo.Usuario;
import vista.FrmReporteSesiones;

/**
 *
 * GRUPO: Facturación/Seguridad 
 * @author Carlos Chavez Laguna
 */
public class CtrReportarSesiones implements ActionListener{
    private Usuario mUser;
    private FrmReporteSesiones mFrmReporteSesiones;
    
    //constructor

    public CtrReportarSesiones() {
        this(new FrmReporteSesiones());
    }

    public CtrReportarSesiones(FrmReporteSesiones mFrmReporteSesiones) {
        this.mFrmReporteSesiones = mFrmReporteSesiones;
        this.mFrmReporteSesiones.btnSearchUser.addActionListener(this);
    }
    
    
    //____________________________________________________________________________________________
    /**
     * 
     * ActionPerformed, recibe todos los eventos de UI
     * por componente, lo identificas y ejecutas la acción
     * dependiendo del nombre de este último.
     * PD: refierase al componente como: TextField, Button, etc.
     * 
     * @param e el ui llama pasa este parámetro por componente
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        //System.out.println(obj.getName());
        
        switch(obj.getName()){
            //botón buscar al usuario
            case "btnSearchUser":
                CtrIncluido.getInstance().showForm(Constant.FORM_BUSCAR_USUARIO, OnCompleteSearch());
                break;
            //botón guardar al usuario y
            //botón actualizar al usuario
            case "btnSave":
            case "btnUpdate":
                
                break;
            //botón eliminar al usuario
            case "btnDelete":
                
                break;
            //botón limpiar los campos
            case "btnClean":
                clear();
                break;
        }                
    }
    //____________________________________________________________________________________________    
    
        //otros métodos
    /**
     * 
     * cuando se complete la búsqueda
     */
    private Callback OnCompleteSearch(){
        return //callback que se ejecutará cuando se logre completar la búsqueda
            new Callback(){
                       @Override
                       public void execute(Object[] args) {
                            mUser=(Usuario) args[0];
                            mFrmReporteSesiones.txtName.setText(mUser.getUsuario());
                       }
           };
    }
    
    /**
     * limpiar o resetear todos los campos
     */
    private void clear(){
        mUser=null;        
        mFrmReporteSesiones.txtName.setText("");
        mFrmReporteSesiones.cmbActivity.setSelectedIndex(0);                
    }


    /**
     * Mostrar el formulario mantener usuario
     */
    public void showFrmReporteSesiones(){
        this.mFrmReporteSesiones.setVisible(true);
    }
    
    /**
     * Esconder el formulario mantener usuario
     */
    public void hideFrmReporteSesiones(){
        this.mFrmReporteSesiones.setVisible(false);
    }    
    
    
}
