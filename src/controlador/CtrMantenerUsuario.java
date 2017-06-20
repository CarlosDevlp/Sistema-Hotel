/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
import dao.BasicDao;
import helpers.Hashing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.xml.bind.DatatypeConverter;
import modelo.Callback;
import modelo.Rol;
import modelo.Usuario;
import vista.FrmMantenerUsuario;

/**
 * Controlador Mantener Usuario
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerUsuario implements ActionListener, KeyListener,CaretListener{
    private FrmMantenerUsuario mFrmMantenerUsuario;
    private boolean mValidPassword;
    private ArrayList<Rol> mRolList;
    private ArrayList<String> mUserNameList;        
    private Usuario mUser;
    
    
    //ICONS
    private final ImageIcon ICON_GOOD=new javax.swing.ImageIcon(getClass().getResource("/assets/images/good.png"));
    private final ImageIcon ICON_BAD=new javax.swing.ImageIcon(getClass().getResource("/assets/images/bad.png"));
    //constructores
    public CtrMantenerUsuario() {
        //creación implícita de vista
        this(new FrmMantenerUsuario());
    }
    
    
    public CtrMantenerUsuario(FrmMantenerUsuario frmMantenerUsuario) {
        this.mFrmMantenerUsuario = frmMantenerUsuario;
        this.mFrmMantenerUsuario.btnSearchUser.addActionListener(this);
        this.mFrmMantenerUsuario.btnSave.addActionListener(this);
        this.mFrmMantenerUsuario.btnUpdate.addActionListener(this);
        this.mFrmMantenerUsuario.btnDelete.addActionListener(this);
        this.mFrmMantenerUsuario.btnClean.addActionListener(this);
        this.mFrmMantenerUsuario.txtPassword.addCaretListener(this);
        this.mFrmMantenerUsuario.txtPasswordRepeat.addCaretListener(this);        
        this.mFrmMantenerUsuario.lblPasswordValidation.setVisible(false);
        mValidPassword=false;
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
                saveUser();
                break;
            //botón eliminar al usuario
            case "btnDelete":
                removeUser();
                break;
            //botón limpiar los campos
            case "btnClean":
                clear();
                break;
        }                
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JComponent obj=(JComponent) e.getSource();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
            
    
    @Override
    public void caretUpdate(CaretEvent e) {
        JComponent obj=(JComponent) e.getSource();
        
        switch(obj.getName()){
            case "txtPassword":
            case "txtPasswordRepeat":
                this.checkPasswords();
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
                           if(args!=null) {
                               mUser=(Usuario)args[0];
                               
                               mFrmMantenerUsuario.btnSave.setEnabled(false);
                               mFrmMantenerUsuario.btnUpdate.setEnabled(true);
                               mFrmMantenerUsuario.btnDelete.setEnabled(true);
                               mFrmMantenerUsuario.txtUsername.setText(mUser.getUsuario());                                                              
                               mFrmMantenerUsuario.txtPassword.setText("");
                               mFrmMantenerUsuario.txtPasswordRepeat.setText("");
                               
                               //setear en el combo el rol escogido
                               Rol userRol=mUser.getRolUser();
                               for(int i=0;i<mRolList.size();i++)
                                   if(mRolList.get(i).getIdRoles().equals(userRol.getIdRoles())){
                                        mFrmMantenerUsuario.cmbRol.setSelectedIndex(i);
                                        break;
                                   }
                                        
                          }
                       }
           };
    }
    
    /**
     * Agregar usuario a la base de datos y a la tabla.
     */
    public void saveUser(){
        
        String username=this.mFrmMantenerUsuario.txtUsername.getText();        
        String password=this.mFrmMantenerUsuario.txtPassword.getText();
        //si está lleno de campos vacíos
        if("".equals(password.trim())){
            this.mFrmMantenerUsuario.messageBoxAlert(Constant.APP_NAME, "la contraseña no debe tener campos vacíos");
            return;
        }
        
        if("".equals(username.trim())){
            this.mFrmMantenerUsuario.messageBoxAlert(Constant.APP_NAME, "el nombre de usuario no debe tener campos vacíos");
            return;
        }
            
        String encryptedPassword=DatatypeConverter.printHexBinary(Hashing.hash(password, Hashing.HASH_ALG.SHA256));

        
        
        
        //usuario nuevo
        boolean isUpdate=false;
        if(mUser==null){
            //impedir que se cree el usuario
            if(BasicDao.rowExists(Constant.DB_TABLE_USUARIO, "UsuarioUse='"+username+"'")){
                this.mFrmMantenerUsuario.messageBoxAlert(Constant.APP_NAME, "El nombre de usuario ya está en uso");
                return;
            }
            
            
            mUser= new Usuario(username,encryptedPassword);
        }else{ //usuario ya creado, pero actualizando
            isUpdate=true;
            mUser.setUsuario(username);
            mUser.setPassword(encryptedPassword);
        }
        mUser.setRolUser(mRolList.get(this.mFrmMantenerUsuario.cmbRol.getSelectedIndex()));
        mUser.save();
        
        this.mFrmMantenerUsuario.messageBox(Constant.APP_NAME, (isUpdate?"Se ha actualizado el usuario":"Se ha agregado un nuevo usuario al sistema") );
        clear();
    }
    
    public void removeUser(){
        //preguntar al usuario si realmente eliminar o no al objeto usuario
        this.mFrmMantenerUsuario.messageBox(Constant.APP_NAME, "<html>"
                                                             + "¿Deseas remover el usuario del sistema?<br> "
                                                             + "<b>OJO: EL USUARIO SERÁ ELIMINADO PERMANENTEMENTE.</b> "
                                                             + "</html>",
                                              new Callback<Boolean>(){
                                                    @Override
                                                    public void execute(Boolean[] answer) {
                                                        //si la respuesta fue YES=true, remover al usuario y limpiar el formulario
                                                        if(answer[0]){
                                                            mUser.remove();
                                                            clear();
                                                        }
                                                        //si la respuesta es NO=false, no hacer nada
                                                    }
                                              }
                                            );
        
    }
    /**
     * Pre-cargar data en el formulario.
     */
    public void loadData(){
        
        //cargar lista de roles en cmbRol
        mRolList= Rol.getRolList();
        mUserNameList=new ArrayList();
        
        for(Rol rol:mRolList)
            mUserNameList.add(rol.getNombreRol());
        
        this.mFrmMantenerUsuario.cmbRol.setModel(new DefaultComboBoxModel(mUserNameList.toArray()));
        
                               
    }
    
    /**
     * 
     */
    public void checkPasswords(){
        
        
        String password=String.valueOf(this.mFrmMantenerUsuario.txtPassword.getPassword());
        String passwordRepeated=String.valueOf(this.mFrmMantenerUsuario.txtPasswordRepeat.getPassword());
       
        
        this.mFrmMantenerUsuario.lblPasswordValidation.setVisible(!password.isEmpty());
        //contraseña correctamente ingresada
        mValidPassword=passwordRepeated.equals(password);
        if(mValidPassword){
            this.mFrmMantenerUsuario.lblPasswordValidation.setIcon(ICON_GOOD);
            this.mFrmMantenerUsuario.lblPasswordValidation.setForeground(Constant.COLOR_GREEN);
            this.mFrmMantenerUsuario.lblPasswordValidation.setText("Contraseñas iguales");                        
        }
        else{
            this.mFrmMantenerUsuario.lblPasswordValidation.setIcon(ICON_BAD);
            this.mFrmMantenerUsuario.lblPasswordValidation.setForeground(Constant.COLOR_RED);
            this.mFrmMantenerUsuario.lblPasswordValidation.setText("Contraseñas no iguales");
        }
        
        (mUser==null?this.mFrmMantenerUsuario.btnSave
                    :this.mFrmMantenerUsuario.btnUpdate).setEnabled(mValidPassword);
        
    }
    
    /**
     * limpiar o resetear todos los campos
     */
    private void clear(){
        mUser=null;
        mFrmMantenerUsuario.btnSave.setEnabled(true);
        mFrmMantenerUsuario.btnUpdate.setEnabled(false);
        mFrmMantenerUsuario.btnDelete.setEnabled(false);
        mFrmMantenerUsuario.txtUsername.setText("");
        mFrmMantenerUsuario.txtPassword.setText("");
        mFrmMantenerUsuario.txtPasswordRepeat.setText("");
        mFrmMantenerUsuario.cmbRol.setSelectedIndex(0);                
    }
    
    /**
     * Mostrar el formulario mantener usuario
     */
    public void showFrmMantenerUsuario(){
        this.mFrmMantenerUsuario.setVisible(true);
    }
    
    /**
     * Esconder el formulario mantener usuario
     */
    public void hideFrmMantenerUsuario(){
        this.mFrmMantenerUsuario.setVisible(false);
    }


}