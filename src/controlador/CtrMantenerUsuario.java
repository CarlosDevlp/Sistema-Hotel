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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.DatatypeConverter;
import modelo.Rol;
import modelo.Usuario;
import vista.FrmMantenerUsuario;

/**
 * Controlador Mantener Usuario
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerUsuario implements ActionListener{
    private FrmMantenerUsuario mFrmMantenerUsuario;
    
    //ROL
    private ArrayList<Rol> mRolList;
    private ArrayList<String> mRolNameList;
    
    //USER TABLE
    private ArrayList<Usuario> mUserList;
    private DefaultTableModel mUserTableModel;
    private final String []USER_TABLE_COLUMN_NAMES={"Nombres y apellidos","Nombre de usuario","Rol"};
    //constructores
    public CtrMantenerUsuario(FrmMantenerUsuario frmMantenerUsuario) {
        this.mFrmMantenerUsuario = frmMantenerUsuario;
        this.mFrmMantenerUsuario.btnGuardar.addActionListener(this);
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
        for(Usuario usuario:mUserList)        
            mUserTableModel.addRow(new String[]{"",usuario.getUsuario(),usuario.getRolUser().getNombreRol()});        
        this.mFrmMantenerUsuario.tbUser.setModel(mUserTableModel);
        
        
                
    }
    
    
    
    /**
     * 
     */
    private void clearData(){
        
    }
    
    //vaciar la tabla
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
