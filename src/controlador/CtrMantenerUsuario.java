/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.Rol;
import vista.FrmMantenerUsuario;

/**
 * Controlador Mantener Usuario
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerUsuario {
    private FrmMantenerUsuario mFrmMantenerUsuario;
    
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
    
    
    public void loadRoles(){
        ArrayList<Rol> rolList= Rol.getRolList();
        ArrayList<String> rolNameList=new ArrayList();
        
        for(Rol rol:rolList)
            rolNameList.add(rol.getNombreRol());
        
        this.mFrmMantenerUsuario.cmbRol.setModel(new DefaultComboBoxModel(rolNameList.toArray()));
    }
}
