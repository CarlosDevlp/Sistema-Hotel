/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
import helpers.Hashing;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.xml.bind.DatatypeConverter;
import modelo.Callback;
import modelo.Usuario;
import vista.FrmLogin;


/**
 * 
 * @author Carlos Chavez Laguna
 */
public class CtrLogin implements ActionListener, KeyListener{
    
    private FrmLogin mFrmLogin;    
    private Callback mOnUserLogged;
    
    private final String LOG_TAG="CtrLogin",LOG_TAG_ERROR="CtrLogin-error";

    //constructor

    public CtrLogin() {
        //creación de vista implícita
        this(new FrmLogin());
    }
    
    
    public CtrLogin(FrmLogin frmLogin) {
        mFrmLogin = frmLogin;        
                                      
        //configurando la vista
        //botón        
        mFrmLogin.TxtUsername.addKeyListener(this);
        mFrmLogin.TxtPassword.addKeyListener(this);
        mFrmLogin.BtnEnter.addActionListener(this);
        //traer el formulario al frente
        mFrmLogin.toFront();
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
        //System.out.println(obj.getName());
        
        switch(obj.getName()){
            case "btnEntrar":
                confirmUser();
               break;            
        }                
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JComponent obj=(JComponent) e.getSource();
        //System.out.println(obj.getName());
        
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            switch(obj.getName()){
                case "txtUsername":
                case "txtPassword":
                    confirmUser();           
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    //setters and getters
    public Callback getOnUserLogged() {
        return mOnUserLogged;
    }

    public void setOnUserLogged(Callback onUserLogged) {
        this.mOnUserLogged = onUserLogged;       
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
        
        //si los datos de acceso no solo son espacios
        if( !( "".equals(username.trim()) && "".equals(password.trim()) ) ){
            
                //si el usuario y contraseña son válidos
                String encryptedPassword=DatatypeConverter.printHexBinary(Hashing.hash(password, Hashing.HASH_ALG.SHA256));                
                if(Usuario.userExists(username, encryptedPassword)){
                    
                    mFrmLogin.messageBox(Constant.APP_NAME, "Bienvenido al sistema");
                    
                    //regresar al formulario principal habilitándolo
                    //la ventana principal y los menus por rol
                    this.mOnUserLogged.execute(null);
                    //esconder login
                    this.hideFrmLogin();
                }
                else{ //si uno de estos no son válidos
                   mFrmLogin.messageBoxError(Constant.APP_NAME, "Sus credenciales son incorrectas");
                }
                
        }// si solo son espacios
        else mFrmLogin.messageBoxAlert(Constant.APP_NAME, "los campos no pueden estar vacíos");
                
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
     
    
    /**
     * showFrmLogin <br>
     * Permite esconder el login
     *      
     */
    public void showFrmLogin(){        
        mFrmLogin.setVisible(true);
        mFrmLogin.windowAlignCenter();
    }
    
    /**
     * hideFrmLogin <br>
     * Permite esconder el login
     *      
     */
    public void hideFrmLogin(){
        mFrmLogin.setVisible(false);
    }       

 
    
}