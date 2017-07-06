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
import modelo.Empleado;
import modelo.Usuario;
import vista.FrmVerPerfil;

/**
 * 
 * Controlador de la vista del perfil
 * @author Carlos Chavez Laguna
 */
public class CtrVerPerfil implements ActionListener{
    private FrmVerPerfil mFrmVerPerfil;
    private Usuario mUsuario;
    private Empleado mEmpleado;
    //constructores    
    public CtrVerPerfil() {
        //creación de vista implícita
        this(new FrmVerPerfil());
    }

    public CtrVerPerfil(FrmVerPerfil mFrmVerPerfil) {
        this.mFrmVerPerfil = mFrmVerPerfil;
        this.mFrmVerPerfil.btnCancel.addActionListener(this);
        this.mFrmVerPerfil.btnSave.addActionListener(this);
        this.mFrmVerPerfil.tbtnEdit.addActionListener(this);                
    }
    
    /**
     * inicializar así mismo para crear lo necesario para que 
     * el formulario funcione
     * @deprecated NO usar en producción 
     */
    public void selfInit(){
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
                loadData();                
                this.mFrmVerPerfil.tbtnEdit.setSelected(false);
                break;
            case "tbtnEdit":
                JToggleButton toggleButtonEdit=(JToggleButton) obj;
                boolean enable=toggleButtonEdit.isSelected();
                setIfEnableAll(enable);
                break;
        }                
    }
    //---------------------------------------------------------------------------------------
    
    /**
     * Mostrar formulario ver perfil
     */
    public void showFrmVerPerfil(){
        this.mFrmVerPerfil.setVisible(true);        
    }
    
    /**
     * Esconder formulario ver perfil
     */
    public void hideFrmVerPerfil(){
        this.mFrmVerPerfil.setVisible(false);
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
     * 
     * Cargar toda la data de la bd al formulario,
     * también, deshabilita y limpia los campos del formulario.
     */
    public void loadData(){
        setIfEnableAll(false);
        clearForm();                     
        //datos de usuario actual
        mUsuario=Usuario.getInstance();
        
        //USUARIO
        //nombre de usuario        
        this.mFrmVerPerfil.txtUsername.setText(mUsuario.getUsuario());
        //rol de usuario
        this.mFrmVerPerfil.lblRolUsuario.setText(mUsuario.getRolUser().getNombreRol());
        
        //EMPLEADO
        mEmpleado=mUsuario.getEmpleado();
        if(mEmpleado!=null){
            //persona
            this.mFrmVerPerfil.txtName.setText(mEmpleado.getNombre());
            this.mFrmVerPerfil.txtDniRuc.setText(mEmpleado.getRucDNI());
            this.mFrmVerPerfil.txtPhone.setText(mEmpleado.getTelefono());
            this.mFrmVerPerfil.spnEdad.setValue(mEmpleado.getEdad());
            this.mFrmVerPerfil.txtEmail.setText(mEmpleado.getCorreo());
            this.mFrmVerPerfil.txtAddress.setText(mEmpleado.getDireccion());
            //empleado
            this.mFrmVerPerfil.lblTipoEmpleado.setText(mEmpleado.getTipoEmpleado().getDescripcion());
            this.mFrmVerPerfil.txtHorarioLaboral.setText(mEmpleado.getHorarioLaboralEmp());
            this.mFrmVerPerfil.lblSueldo.setText("S/."+mEmpleado.getSueldo());
        }
        
    }
    
    /**
     * eliminar todos los datos de la caja de texto
     */
    private void clearForm(){        
        //....
        this.mFrmVerPerfil.tbtnEdit.setVisible(false);
        this.mFrmVerPerfil.tbtnEdit.setEnabled(false);        
        this.mFrmVerPerfil.btnCancel.setEnabled(false);
        this.mFrmVerPerfil.btnCancel.setVisible(false);
        this.mFrmVerPerfil.btnSave.setEnabled(false);
        this.mFrmVerPerfil.btnSave.setVisible(false);
        
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
            boolean exists=BasicDao.rowExists(Constant.DB_TABLE_USUARIO, "UsuarioUse='"+username+"'");
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
