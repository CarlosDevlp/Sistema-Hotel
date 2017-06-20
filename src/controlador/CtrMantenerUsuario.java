/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
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
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.DatatypeConverter;
import modelo.Rol;
import modelo.Usuario;
import vista.FrmMantenerUsuario;

/**
 * Controlador Mantener Usuario
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerUsuario implements ActionListener, KeyListener,CaretListener{
    private FrmMantenerUsuario mFrmMantenerUsuario;
    
    //ROL
    private ArrayList<Rol> mRolList;
    private ArrayList<String> mRolNameList;
    
    //USER TABLE
    private ArrayList<Usuario> mUserList;
    private DefaultTableModel mUserTableModel;
    private final String []USER_TABLE_COLUMN_NAMES={"Nombres y apellidos","Nombre de usuario","Rol"};
    
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
        this.mFrmMantenerUsuario.btnGuardar.addActionListener(this);
        this.mFrmMantenerUsuario.txtPassword.addCaretListener(this);
        this.mFrmMantenerUsuario.txtPasswordRepeat.addCaretListener(this);
        this.mFrmMantenerUsuario.lblPasswordValidation.setVisible(false);
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
            case "btnGuardar":
                addUser();
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
     * Agregar usuario a la base de datos y a la tabla.
     */
    public void addUser(){
        String username=this.mFrmMantenerUsuario.txtUsername.getText();        
        String encryptedPassword=DatatypeConverter.printHexBinary(Hashing.hash(this.mFrmMantenerUsuario.txtPassword.getText(), Hashing.HASH_ALG.SHA256));

        Usuario newUser= new Usuario(username,encryptedPassword);
        newUser.setRolUser(mRolList.get(this.mFrmMantenerUsuario.cmbRol.getSelectedIndex()));
        
        newUser.save();
        
        mUserTableModel.addRow(new String[]{"",newUser.getUsuario(),newUser.getRolUser().getNombreRol()});        
        
        this.mFrmMantenerUsuario.messageBox(Constant.APP_NAME, "Se ha agregado un nuevo usuario al sistema");
        
    }
    
    /**
     * Pre-cargar data en el formulario.
     */
    public void loadData(){

        
        //cargar lista de roles en cmbRol
        mRolList= Rol.getRolList();
        mRolNameList=new ArrayList();
        
        for(Rol rol:mRolList)
            mRolNameList.add(rol.getNombreRol());
        
        this.mFrmMantenerUsuario.cmbRol.setModel(new DefaultComboBoxModel(mRolNameList.toArray()));

        
        //cargar usuarios en la tabla tbUser
        clearTable();
        mUserList= Usuario.getUsuarioList();
        
        this.mFrmMantenerUsuario.lblEmptyTable.setVisible(mUserList.isEmpty());
        for(Usuario usuario:mUserList)        
            mUserTableModel.addRow(new String[]{"",usuario.getUsuario(),usuario.getRolUser().getNombreRol()});        
        this.mFrmMantenerUsuario.tbUser.setModel(mUserTableModel);
        
        //ocultar el preloader
        this.mFrmMantenerUsuario.pbFormPreloader.setVisible(false);                        
        
                
    }
    
    /**
     * 
     */
    public void checkPasswords(){
        String password=String.valueOf(this.mFrmMantenerUsuario.txtPassword.getPassword());
        String passwordRepeated=String.valueOf(this.mFrmMantenerUsuario.txtPasswordRepeat.getPassword());
       
        
        this.mFrmMantenerUsuario.lblPasswordValidation.setVisible(!password.isEmpty());
        //contraseña correctamente ingresada
        if(passwordRepeated.equals(password)){
            this.mFrmMantenerUsuario.lblPasswordValidation.setIcon(ICON_GOOD);
            this.mFrmMantenerUsuario.lblPasswordValidation.setForeground(Constant.COLOR_GREEN);
            this.mFrmMantenerUsuario.lblPasswordValidation.setText("Contraseñas iguales");
        }
        else{
            this.mFrmMantenerUsuario.lblPasswordValidation.setIcon(ICON_BAD);
            this.mFrmMantenerUsuario.lblPasswordValidation.setForeground(Constant.COLOR_RED);
            this.mFrmMantenerUsuario.lblPasswordValidation.setText("Contraseñas no iguales");
        }
        
    }
    
    /**
     * 
     */
    private void clearData(){
        
    }
    
    /**
     * vaciar la tabla
     **/
    private void clearTable(){        
        mUserTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_NAMES);
        this.mFrmMantenerUsuario.tbUser.setModel(mUserTableModel);
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
