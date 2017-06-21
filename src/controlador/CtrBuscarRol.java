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
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import modelo.Rol;
import vista.FrmBuscarRol;

/**
 * GRUPO: Facturación y seguridad
 * @author Carlos Chavez Laguna
 */
public class CtrBuscarRol implements ActionListener{
    private FrmBuscarRol mFrmBuscarRol;
    private ArrayList<Rol> mFoundRolList;
    private final String  []ROL_TABLE_COLUMN_NAMES={"Id","Nombre","Pestañas habilitadas"};
    private DefaultTableModel mRolTableModel;
    private Callback mOnCompletedSearch;

    
   
   //constructor
    public CtrBuscarRol() {
        this(new FrmBuscarRol());
    }

    public CtrBuscarRol(FrmBuscarRol mFrmBuscarRol) {
        this.mFrmBuscarRol = mFrmBuscarRol;
        this.mFrmBuscarRol.btnSearch.addActionListener(this);
        this.mFrmBuscarRol.btnAccept.addActionListener(this);
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
                searchRoles();
            break;            
            case "btnAccept":            
                chooseRolAndGoBack();
            break;
        }
    } 

    
    public Callback getOnCompletedSearch() {
        return mOnCompletedSearch;
    }

    public void setOnCompletedSearch(Callback callback) {
        this.mOnCompletedSearch = callback;
    }
    //--------------------------------------------------------------------
    
    
    
    /**
     * Pre-cargar data en el formulario.
     */
    public void loadData(){        
        this.mFrmBuscarRol.cmbSeachParameters.setModel(new DefaultComboBoxModel(Constant.ARRAY_ROLE_COLUMNS_AND_ALIAS[1]));
        clearTable();
    }
    
    /**
     * vaciar la tabla
     **/
    private void clearTable(){        
        mRolTableModel = new DefaultTableModel(null,ROL_TABLE_COLUMN_NAMES);
        this.mFrmBuscarRol.tbPestana.setModel(mRolTableModel);
    }
    
    /**
     * Mostrar el formulario buscar rol
     */
    public void showFrmBuscarRol(){
        this.mFrmBuscarRol.setVisible(true);
    }
    
    /**
     * Esconder el formulario buscar rol
     */
    public void hideFrmBuscarRol(){
        this.mFrmBuscarRol.setVisible(false);
    }
    
    /**
     * Buscar roles por los parámetros de búsqueda
     */    
    public void searchRoles(){
        //BasicDao.DEBUG=true;
        
        String value=this.mFrmBuscarRol.txtValue.getText();
        int index=this.mFrmBuscarRol.cmbSeachParameters.getSelectedIndex();
        
        //si ha ingresado solo campos vacíos...        
        /*if("".equals(value.trim())) {
            this.mFrmBuscarRol.messageBoxAlert(Constant.APP_NAME, "No se aceptan campos vacíos!");
            return;
        }*/
        
        //limpiar si la tabla tiene contenido
        if(mRolTableModel.getRowCount()>0) clearTable();
        
        //obtener la lista de roles dependiendo de los  parámetros de búsqueda
        if(!"".equals(value.trim())){
            mFoundRolList=Rol.getRolList(
                        Constant.ARRAY_ROLE_COLUMNS_AND_ALIAS[0][index]+"="+((index>0)?"'"+value+"'":value)
                        );
        }else mFoundRolList=Rol.getRolList();
        //ocultar o mostrar el label de tabla vacía
        this.mFrmBuscarRol.lblEmptyTable.setVisible(mFoundRolList.isEmpty());  
        //mostrar un mensaje que no se encontró lo que se buscaba
        if(mFoundRolList.isEmpty()) this.mFrmBuscarRol.messageBox(Constant.APP_NAME, "No se encontraron valores con "+value);
        /*
        //mostrar los valores en la tabla
        for(Rol rol:mFoundRolList)
            mRolTableModel.addRow(new String[]{rol.getIdRoles(),rol.getNombreRol(),String.join(",", rol.getPestanasHabilitadas())});
        */
    }

    /**
     * Selecciona un rol y vuelve al formulario anterior
     */
    public void chooseRolAndGoBack(){
        int index=this.mFrmBuscarRol.tbPestana.getSelectedRow();
        
        if(index!=-1){
            if(this.mOnCompletedSearch!=null){
                this.mOnCompletedSearch.execute(new Object[]{this.mFoundRolList.get(index)});
                hideFrmBuscarRol();
            } 
        }else
            this.mFrmBuscarRol.messageBoxAlert(Constant.APP_NAME, "Debe seleccionar un rol");
    }
    
}
