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
import modelo.Empleado;
import vista.FrmMantenerEmpleado;

/**
 *
 * Grupo: Facturación/ Seguridad
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerEmpleado implements ActionListener{
   private FrmMantenerEmpleado mFrmMantenerEmpleado;
   private Empleado mEmpleado;
   
   //constructor
    public CtrMantenerEmpleado() {
        this(new FrmMantenerEmpleado());
    }

    public CtrMantenerEmpleado(FrmMantenerEmpleado mFrmMantenerEmpleado) {
        this.mFrmMantenerEmpleado = mFrmMantenerEmpleado;
        this.mFrmMantenerEmpleado.btnSearchEmployee.addActionListener(this);
        this.mFrmMantenerEmpleado.btnSave.addActionListener(this);
        this.mFrmMantenerEmpleado.btnUpdate.addActionListener(this);
        this.mFrmMantenerEmpleado.btnDelete.addActionListener(this);
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
            //botón buscar al empleado
            case "btnSearchEmployee":
                CtrIncluido.getInstance().showForm(Constant.FORM_BUSCAR_EMPLEADO, OnCompleteSearch());
                break;
            //botón guardar al empleado y
            //botón actualizar al empleado
            case "btnSave":
            case "btnUpdate":
                saveEmpleado();
                break;
            //botón eliminar al empleado
            case "btnDelete":
                removeUser();
                break;
            //botón limpiar los campos
            case "btnClean":
                clear();
                break;
        }
    }
    
    //setters and getters
    
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
                               mEmpleado=(Empleado)args[0];
                               
                               //botones
                               mFrmMantenerEmpleado.btnSave.setEnabled(false);
                               mFrmMantenerEmpleado.btnUpdate.setEnabled(true);
                               mFrmMantenerEmpleado.btnDelete.setEnabled(true);
                               
                               //persona
                               mFrmMantenerEmpleado.txtName.setText(mEmpleado.getFullNamePer());
                               mFrmMantenerEmpleado.txtDniRuc.setText(mEmpleado.getRucDNI());
                               mFrmMantenerEmpleado.txtPhone.setText(mEmpleado.getTelefono());
                               mFrmMantenerEmpleado.spnEdad.setValue(mEmpleado.getEdad());
                               mFrmMantenerEmpleado.txtEmail.setText(mEmpleado.getCorreo());
                               mFrmMantenerEmpleado.txtAddress.setText(mEmpleado.getDireccion());
                               //empleado
                               mFrmMantenerEmpleado.spnPayment.setValue(mEmpleado.getSueldo());
                               mFrmMantenerEmpleado.txtHorarioLaboral.setText(mEmpleado.getHorarioLaboralEmp());
                               
                               //setear en el combo el rol escogido
                               /*Rol userRol=mEmpleado.getRolUser();
                               for(int i=0;i<mRolList.size();i++)
                                   if(mRolList.get(i).getIdRoles().equals(userRol.getIdRoles())){
                                        mFrmMantenerEmpleado.cmbRol.setSelectedIndex(i);
                                        break;
                                   }
                                 */       
                          }
                       }
           };
    }
    
    /**
     * Agregar empleado a la base de datos y a la tabla.
     */
    public void saveEmpleado(){
                
        
        
        //empleado nuevo
        boolean isUpdate=true;
        if(mEmpleado==null){
            //impedir que se cree el empleado
            /*if(BasicDao.rowExists(Constant.DB_TABLE_USUARIO, "UsuarioUse='"+username+"'")){
                this.mFrmMantenerEmpleado.messageBoxAlert(Constant.APP_NAME, "El nombre de empleado ya está en uso");
                return;
            }*/
            
            isUpdate=false;            
            mEmpleado= new Empleado();
            
        }
        mEmpleado.setRucDNI(mFrmMantenerEmpleado.txtDniRuc.getText());
        mEmpleado.setFullNamePer(mFrmMantenerEmpleado.txtName.getText());
        mEmpleado.setEdad((int)mFrmMantenerEmpleado.spnEdad.getValue());
        mEmpleado.setTelefono(mFrmMantenerEmpleado.txtPhone.getText());
        mEmpleado.setCorreo(mFrmMantenerEmpleado.txtEmail.getText());
        mEmpleado.setDireccion(mFrmMantenerEmpleado.txtAddress.getText());
        mEmpleado.setSueldo((float)mFrmMantenerEmpleado.spnPayment.getValue());
        mEmpleado.setHorarioLaboralEmp(mFrmMantenerEmpleado.txtHorarioLaboral.getText());
        
        //guardar o actualizar
        mEmpleado.save();
        
        this.mFrmMantenerEmpleado.messageBox(Constant.APP_NAME, (isUpdate?"Se ha actualizado el empleado":"Se ha agregado un nuevo empleado al sistema") );
        clear();
    }
    
    public void removeUser(){
        //preguntar al empleado si realmente eliminar o no al objeto empleado
        this.mFrmMantenerEmpleado.messageBox(Constant.APP_NAME, "<html>"
                                                             + "¿Deseas remover el empleado del sistema?<br> "
                                                             + "<b>OJO: EL USUARIO SERÁ ELIMINADO PERMANENTEMENTE.</b> "
                                                             + "</html>",
                                              new Callback<Boolean>(){
                                                    @Override
                                                    public void execute(Boolean[] answer) {
                                                        //si la respuesta fue YES=true, remover al empleado y limpiar el formulario
                                                        if(answer[0]){
                                                            mEmpleado.remove();
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
        
        
                               
    }
    
    
    /**
     * limpiar o resetear todos los campos
     */
    private void clear(){
        mEmpleado=null;
        mFrmMantenerEmpleado.btnSave.setEnabled(true);
        mFrmMantenerEmpleado.btnUpdate.setEnabled(false);
        mFrmMantenerEmpleado.btnDelete.setEnabled(false);
        
        //persona
        mFrmMantenerEmpleado.txtName.setText("");
        mFrmMantenerEmpleado.txtDniRuc.setText("");
        mFrmMantenerEmpleado.txtPhone.setText("");
        mFrmMantenerEmpleado.spnEdad.setValue("");
        mFrmMantenerEmpleado.txtEmail.setText("");
        mFrmMantenerEmpleado.txtAddress.setText("");
        //empleado
        mFrmMantenerEmpleado.spnPayment.setValue("");
        mFrmMantenerEmpleado.txtHorarioLaboral.setText("");
                               
    }
    
    /**
     * Mostrar el formulario mantener empleado
     */
    public void showFrmMantenerUsuario(){
        this.mFrmMantenerEmpleado.setVisible(true);
    }
    
    /**
     * Esconder el formulario mantener empleado
     */
    public void hideFrmMantenerUsuario(){
        this.mFrmMantenerEmpleado.setVisible(false);
    }    
    
}
