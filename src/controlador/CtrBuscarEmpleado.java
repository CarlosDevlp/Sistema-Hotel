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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import modelo.Empleado;
import vista.FrmBuscarEmpleado;

/**
 *
 * Grupo: facturación / seguridad
 * @author Carlos Chavez Laguna
 */
public class CtrBuscarEmpleado implements ActionListener{
    private FrmBuscarEmpleado mFrmBuscarEmpleado;
    private ArrayList<Empleado> mFoundEmployeeList;
    private DefaultTableModel mEmployeeTableModel;
    private Callback mOnCompletedSearch;
    private final String []EMPLOYEE_TABLE_COLUMN_NAMES={"Id","Nombre completo","DNI / RUC","Telefono","Correo","Edad"};
    //constructor
    public CtrBuscarEmpleado() {
        this(new FrmBuscarEmpleado());
    }

    public CtrBuscarEmpleado(FrmBuscarEmpleado mFrmBuscarEmpleado) {
        this.mFrmBuscarEmpleado = mFrmBuscarEmpleado;
        this.mFrmBuscarEmpleado.btnSearch.addActionListener(this);
        this.mFrmBuscarEmpleado.btnAccept.addActionListener(this);
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
        switch(obj.getName()){
            case "btnSearch":
                searchEmployee();
            break;            
            case "btnAccept":            
                chooseEmployeeAndGoBack();
            break;
        }
    } 
    
    
    //setters and getters
    public Callback getOnCompletedSearch() {
        return mOnCompletedSearch;
    }

    public void setOnCompletedSearch(Callback onCompletedSearch) {
        this.mOnCompletedSearch = onCompletedSearch;
    }    

    
    //otros métodos
    /**
     * Mostrar el formulario buscar usuario
     */
    public void showFrmBuscarEmpleado(){
        this.mFrmBuscarEmpleado.setVisible(true);
    }
    
    /**
     * Esconder el formulario buscar usuario
     */
    public void hideFrmBuscarEmpleado(){
        this.mFrmBuscarEmpleado.setVisible(false);
    }

    /**
     * Pre-cargar data en el formulario.
     */
    public void loadData(){        
        this.mFrmBuscarEmpleado.cmbSearchParameters.setModel(new DefaultComboBoxModel(Constant.ARRAY_EMPLOYEE_COLUMNS_AND_ALIAS[1]));
        clearTable();
    }
    
    
    /**
     * vaciar la tabla
     **/
    private void clearTable(){        
        mEmployeeTableModel = new DefaultTableModel(null,EMPLOYEE_TABLE_COLUMN_NAMES);
        this.mFrmBuscarEmpleado.tbEmployee.setModel(mEmployeeTableModel);
    }
    /**
     * Buscar usuarios por los parámetros de búsqueda
     */    
    public void searchEmployee(){
        BasicDao.DEBUG=true;
        
        String value=this.mFrmBuscarEmpleado.txtValue.getText();
        int index=this.mFrmBuscarEmpleado.cmbSearchParameters.getSelectedIndex();
                
        //limpiar si la tabla tiene contenido
        if(mEmployeeTableModel.getRowCount()>0) clearTable();
        
        //obtener la lista de usuarios dependiendo de los  parámetros de búsqueda
        if(!"".equals(value.trim())){
            
            String cond;
            switch(index){
                case 0://FullName
                    cond=" LIKE '%"+value+"%'";
                    break;
                case 1://Dni/Ruc
                    cond=" = "+value;
                    break;
                default://email
                    cond=" = '"+value+"'";
            }
            mFoundEmployeeList=Empleado.getEmpleadoList(Constant.ARRAY_EMPLOYEE_COLUMNS_AND_ALIAS[0][index]+cond);
            
        }else mFoundEmployeeList=Empleado.getEmpleadoList();
        
        //ocultar o mostrar el label de tabla vacía
        this.mFrmBuscarEmpleado.lblEmptyTable.setVisible(mFoundEmployeeList.isEmpty());  
        
        //mostrar un mensaje que NO se encontró lo que se buscaba
        if(mFoundEmployeeList.isEmpty()) this.mFrmBuscarEmpleado.messageBox(Constant.APP_NAME, "No se encontraron valores con "+value);
        
        
        //mostrar los valores en la tabla
        for(Empleado empleado:mFoundEmployeeList)
            mEmployeeTableModel.addRow(
             new String[]{empleado.getIdPersona(),empleado.getFullNamePer(),empleado.getRucDNI(),empleado.getTelefono(),empleado.getCorreo(),empleado.getEdad()+""}
            );
        
    }


    
    

    /**
     * Selecciona un usuario y vuelve al formulario anterior
     */
    public void chooseEmployeeAndGoBack(){
        int index=this.mFrmBuscarEmpleado.tbEmployee.getSelectedRow();
        
        if(index!=-1){                
            if(this.mOnCompletedSearch!=null){
                this.mOnCompletedSearch.execute(new Object[]{this.mFoundEmployeeList.get(index)});
                hideFrmBuscarEmpleado();
            } 
        }else
            this.mFrmBuscarEmpleado.messageBoxAlert(Constant.APP_NAME, "Debe seleccionar un usuario");
    }    
    
    
}
