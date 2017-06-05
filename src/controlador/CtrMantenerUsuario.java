/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.Rol;
import modelo.Usuario;
import vista.FrmMantenerUsuario;

/**
 * Controlador Mantener Usuario
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerUsuario {
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
    }

    public void showFrmMantenerUsuario(){
        this.mFrmMantenerUsuario.setVisible(true);
    }
      
    public void hideFrmMantenerUsuario(){
        this.mFrmMantenerUsuario.setVisible(false);
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
    
    
    //vaciar la tabla
    private void clearTable(){        
        mUserTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_NAMES);
         this.mFrmMantenerUsuario.tbUser.setModel(mUserTableModel);
    }
}
