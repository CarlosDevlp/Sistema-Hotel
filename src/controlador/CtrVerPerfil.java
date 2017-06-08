/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
import dao.BasicDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import modelo.Usuario;
import vista.FrmVerPerfil;

/**
 *
 * @author Carlos Chavez Laguna
 */
public class CtrVerPerfil implements ActionListener{
    private FrmVerPerfil mFrmVerPerfil;
    private Usuario mUsuario;
    //constructores    
    public CtrVerPerfil() {
        this.mFrmVerPerfil = new FrmVerPerfil();        
    }

    public CtrVerPerfil(FrmVerPerfil mFrmVerPerfil) {
        this.mFrmVerPerfil = mFrmVerPerfil;
        this.mFrmVerPerfil.btnCancel.addActionListener(this);
        this.mFrmVerPerfil.btnSave.addActionListener(this);
        this.mFrmVerPerfil.tbtnEdit.addActionListener(this);        
        setIfEnableAll(false);
        
        this.selfInit();
        mUsuario=Usuario.getInstance();        
        
        clearForm();
        loadData();
    }
    
    /**
     * inicializar así mismo para crear lo necesario para que 
     * el formulario funcione
     * @deprecated NO usar en producción 
     */
    private void selfInit(){
        Usuario.userExists("carlosplusplus", "20F3765880A5C269B747E1E906054A4B4A3A991259F1E16B5DDE4742CEC2319A");
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
            case "btnSave":
                saveData();
                setIfEnableAll(false);
                this.mFrmVerPerfil.tbtnEdit.setSelected(false);
               break;            
            case "btnCancel":
                clearForm();
                loadData();
                setIfEnableAll(false);
                this.mFrmVerPerfil.tbtnEdit.setSelected(false);
                break;
            case "tbtnEdit":
                JToggleButton toggleButtonEdit=(JToggleButton) obj;
                boolean enable=toggleButtonEdit.isSelected();
                setIfEnableAll(enable);
                break;
        }                
    }
    
    /**
     * Deshabilitar todos los componentes
     * caja de texto
     * 
     * @param enable permite decidir si bloquear o no 
     * las cajas de texto
     */
    private void setIfEnableAll(boolean enable){
        //datos personales        
        this.mFrmVerPerfil.txtName.setEnabled(enable);
        this.mFrmVerPerfil.txtDniRuc.setEnabled(enable);
        this.mFrmVerPerfil.txtPhone.setEnabled(enable);
        this.mFrmVerPerfil.spnEdad.setEnabled(enable);
        this.mFrmVerPerfil.txtEmail.setEnabled(enable);
        this.mFrmVerPerfil.txtAddress.setEnabled(enable);
        
        //datos de usuario
        this.mFrmVerPerfil.txtUsername.setEnabled(enable);
    }
    
    /**
     * Cargar toda la data de la bd al formulario
     */
    private void loadData(){
        //datos de usuario        
            //nombre de usuario        
            this.mFrmVerPerfil.txtUsername.setText(mUsuario.getUsuario());
            //rol de usuario
            this.mFrmVerPerfil.lblRolUsuario.setText(mUsuario.getRolUser().getNombreRol());
    }
    
    /**
     * eliminar todos los datos de la caja de texto
     */
    private void clearForm(){
        //datos personales        
        this.mFrmVerPerfil.txtName.setText("");
        this.mFrmVerPerfil.txtDniRuc.setText("");
        this.mFrmVerPerfil.txtPhone.setText("");
        this.mFrmVerPerfil.spnEdad.setValue(0);
        this.mFrmVerPerfil.txtEmail.setText("");
        this.mFrmVerPerfil.txtAddress.setText("");
        
        //datos de usuario
        this.mFrmVerPerfil.txtUsername.setText("");
    }
    
    /**
     * guardar datos del usuario a la base de datos
     */
    private void saveData(){
        String username=this.mFrmVerPerfil.txtUsername.getText();
        //datos del usuario
        
        //si el usuario no son espacios vacíos 
        if(!username.trim().equals("")) {
            boolean exists=BasicDao.rowExists(Constant.DB_TABLE_USUARIO, "UsuarioUser='"+username+"'");
            if(!exists) {//si el nombre de usuario no existe, actualizar y guardar los datos
                mUsuario.setUsuario(username);
                mUsuario.save(); 
                this.mFrmVerPerfil.messageBox(Constant.APP_NAME, "Se guardado tus datos satisfactoriamente");
            }else
                this.mFrmVerPerfil.messageBoxError(Constant.APP_NAME, "El nombre de usuario ya existe, intente otro.");        
        }else
            this.mFrmVerPerfil.messageBoxError(Constant.APP_NAME, "Campo vacíos");
    }
    
    
}
