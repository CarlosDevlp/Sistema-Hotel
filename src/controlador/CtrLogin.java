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
import modelo.Usuario;
import vista.FrmLogin;

/**
 * 
 * @author Carlos Chavez Laguna
 */
public class CtrLogin implements ActionListener{
    private Usuario usuario;
    private FrmLogin mFrmLogin;

    public CtrLogin(FrmLogin frmLogin) {
        mFrmLogin = frmLogin;
        
        
        usuario= Usuario.getInstance();
        usuario.setUsuario("upene");
        usuario.setPassword("123");    
        
        
        //configurando la vista
        //botón
        mFrmLogin.BtnEnter.addActionListener(this);
        
        
    }
       
       
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
        System.out.println(obj.getName());
        
        switch(obj.getName()){
            case "btnEntrar":
                confirmUser();
               break;
            
        }
    }
    
    //---------------------------------------------------------------------
    
    /**
     * ConfirmUser, confirma si los datos ingresados 
     * por el usuario son los correctos.
     * Si son correctos, entonces se procede al formulario principal.
     * En otro caso muestra un mensaje de error y limpia los campos.          
     */    
    private void confirmUser(){
        
        String username=mFrmLogin.TxtUsername.getText();
        String password=mFrmLogin.TxtPassword.getText();
        
        if(!"".equals(username.trim()+password.trim())){
            
                if(usuario.getUsuario().equals(username) && 
                   usuario.getPassword().equals(password)){
                    mFrmLogin.messageBox(Constant.APP_NAME, "Bienvenido al sistema ctm!");
                }
                else{
                   mFrmLogin.messageBoxError(Constant.APP_NAME, "Sus credenciales son incorrectas");
                }
                
        }else mFrmLogin.messageBoxAlert(Constant.APP_NAME, "los campos no pueden estar vacíos");
                
    }
    
    /**
     * 
     * Clear, método que permite limpiar todos los 
     * campos del formulario
     */
    private void clear(){
        mFrmLogin.TxtUsername.setText("");
        mFrmLogin.TxtPassword.setText("");
    }
    
           
}