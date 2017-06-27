/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

import modelo.Callback;
import modelo.Empleado;
import modelo.TipoEmpleado;
import vista.FrmMantenerEmpleado;

/**
 *
 * Grupo: Facturación/ Seguridad
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerEmpleado implements ActionListener{
   private FrmMantenerEmpleado mFrmMantenerEmpleado;
   private Empleado mEmpleado;
   private ArrayList<TipoEmpleado> mTipoEmpleadoList;
   
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
                removeEmpleado();
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
                               mFrmMantenerEmpleado.txtEstate.setText(mEmpleado.getEstadoEmp());
                               
                               //setear en el combo el tipo de empleado escogido
                               TipoEmpleado tipoEmpleado=mEmpleado.getTipoEmpleado();
                               
                               for(int i=0;i<mTipoEmpleadoList.size();i++)
                                   if(mTipoEmpleadoList.get(i).getIdTem().equals(tipoEmpleado.getIdTem())){
                                        mFrmMantenerEmpleado.cmbEmployeeType.setSelectedIndex(i);
                                        break;
                                   }
                                 
                          }
                       }
           };
    }
    
    
    /**
     * Validar si los campos no tienen algo inválido o
     * vacío
     * @return retorna si los campos son o no válidos
     */
    private boolean camposValidos(){
        //boolean valid=true;
        
        //si uno de estos campos están vacíos
        return !
                (
                "".equals(mFrmMantenerEmpleado.txtName.getText()) ||
                "".equals(mFrmMantenerEmpleado.txtDniRuc.getText()) ||
                "".equals(mFrmMantenerEmpleado.txtPhone.getText()) ||
                "".equals(mFrmMantenerEmpleado.txtEmail.getText()) ||
                "".equals(mFrmMantenerEmpleado.txtEstate.getText()) ||
                "".equals(mFrmMantenerEmpleado.txtHorarioLaboral.getText()) 
                );
    }
    
    
    /**
     * Agregar empleado a la base de datos y a la tabla.
     */
    public void saveEmpleado(){
                    
        //validor los campos antes de generar algún cambio
        if(!camposValidos()) {
            mFrmMantenerEmpleado.messageBoxAlert(Constant.APP_NAME, "los campos no deben estar vacíos");
            return;
        }
        
        //empleado nuevo
        boolean isUpdate=true;
        if(mEmpleado==null){                        
            isUpdate=false;            
            mEmpleado= new Empleado();            
        }
        
        
        mEmpleado.setFullNamePer(mFrmMantenerEmpleado.txtName.getText());//persona
        mEmpleado.setRucDNI(mFrmMantenerEmpleado.txtDniRuc.getText());//persona        
        mEmpleado.setEdad((int)mFrmMantenerEmpleado.spnEdad.getValue());//persona
        mEmpleado.setTelefono(mFrmMantenerEmpleado.txtPhone.getText());//persona
        mEmpleado.setCorreo(mFrmMantenerEmpleado.txtEmail.getText());//persona
        mEmpleado.setDireccion(mFrmMantenerEmpleado.txtAddress.getText());//persona
        mEmpleado.setTipoEmpleado(mTipoEmpleadoList.get(mFrmMantenerEmpleado.cmbEmployeeType.getSelectedIndex()));//empleado
        mEmpleado.setSueldo((float)mFrmMantenerEmpleado.spnPayment.getValue());//empleado
        mEmpleado.setHorarioLaboralEmp(mFrmMantenerEmpleado.txtHorarioLaboral.getText());//empleado
        mEmpleado.setEstadoEmp(mFrmMantenerEmpleado.txtEstate.getText());//empleado
        
        
        
        //guardar o actualizar
        mEmpleado.save();
        
        this.mFrmMantenerEmpleado.messageBox(Constant.APP_NAME, (isUpdate?"Se ha actualizado el empleado":"Se ha agregado un nuevo empleado al sistema") );
        clear();
    }
    
    /**
     * remover empleado de la base de datos
     */
    public void removeEmpleado(){
        //preguntar al empleado si realmente eliminar o no al objeto empleado
        this.mFrmMantenerEmpleado.messageBox(Constant.APP_NAME, "<html>"
                                                             + "¿Deseas remover el empleado del sistema?<br> "
                                                             + "<b>OJO: EL EMPLEADO SERÁ ELIMINADO PERMANENTEMENTE.</b> "
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
        mTipoEmpleadoList=TipoEmpleado.getTipoEmpleadoList();
        ArrayList<String> tipoEmpleadoName=new ArrayList();
        for(TipoEmpleado tipoEmpleado: mTipoEmpleadoList)
            tipoEmpleadoName.add(tipoEmpleado.getDescripcion());        
        mFrmMantenerEmpleado.cmbEmployeeType.setModel(new DefaultComboBoxModel(tipoEmpleadoName.toArray()));
                
        
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
        mFrmMantenerEmpleado.spnEdad.setValue(0);
        mFrmMantenerEmpleado.txtEmail.setText("");
        mFrmMantenerEmpleado.txtAddress.setText("");
        //empleado
        mFrmMantenerEmpleado.cmbEmployeeType.setSelectedIndex(0);
        mFrmMantenerEmpleado.spnPayment.setValue(0.0f);
        mFrmMantenerEmpleado.txtHorarioLaboral.setText("");
        mFrmMantenerEmpleado.txtEstate.setText("");
                               
    }
    
    /**
     * Mostrar el formulario mantener empleado
     */
    public void showFrmMantenerEmpleado(){
        this.mFrmMantenerEmpleado.setVisible(true);
    }
    
    /**
     * Esconder el formulario mantener empleado
     */
    public void hideFrmMantenerEmpleado(){
        this.mFrmMantenerEmpleado.setVisible(false);
    }    
    
}
