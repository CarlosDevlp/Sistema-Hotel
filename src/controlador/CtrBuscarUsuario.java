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
import modelo.Usuario;
import vista.FrmBuscarUsuario;

/**
 *
 * GRUPO: Facturación/ Seguridad
 * @author Carlos Chavez Laguna
 */
public class CtrBuscarUsuario implements ActionListener{
    private FrmBuscarUsuario mFrmBuscarUsuario;
    private ArrayList<Usuario> mFoundUserList;
    private DefaultTableModel mUserTableModel;
    private Callback mOnCompletedSearch;
    
    private final String []USER_TABLE_COLUMN_NAMES={"Id","Nombre de usuario","Rol"};
    //constructor    
    public CtrBuscarUsuario() {
        this(new FrmBuscarUsuario());
    }

    public CtrBuscarUsuario(FrmBuscarUsuario mFrmBuscarUsuario) {
        this.mFrmBuscarUsuario = mFrmBuscarUsuario;
        this.mFrmBuscarUsuario.btnSearch.addActionListener(this);
        this.mFrmBuscarUsuario.btnAccept.addActionListener(this);                
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
                searchUsers();
            break;            
            case "btnAccept":            
                chooseUserAndGoBack();
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
     * Pre-cargar data en el formulario.
     */
    public void loadData(){        
        this.mFrmBuscarUsuario.cmbSearchParameters.setModel(new DefaultComboBoxModel(Constant.ARRAY_USER_COLUMNS_AND_ALIAS[1]));
        clearTable();
    }
    
    
    /**
     * vaciar la tabla
     **/
    private void clearTable(){        
        mUserTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_NAMES);
        this.mFrmBuscarUsuario.tbUser.setModel(mUserTableModel);
    }
    
    /**
     * Mostrar el formulario buscar usuario
     */
    public void showFrmBuscarRol(){
        this.mFrmBuscarUsuario.setVisible(true);
    }
    
    /**
     * Esconder el formulario buscar usuario
     */
    public void hideFrmBuscarRol(){
        this.mFrmBuscarUsuario.setVisible(false);
    }


    /**
     * Buscar usuarios por los parámetros de búsqueda
     */    
    public void searchUsers(){
        BasicDao.DEBUG=true;
        
        String value=this.mFrmBuscarUsuario.txtValue.getText();
        int index=this.mFrmBuscarUsuario.cmbSearchParameters.getSelectedIndex();
                
        //limpiar si la tabla tiene contenido
        if(mUserTableModel.getRowCount()>0) clearTable();
        
        //obtener la lista de usuarios dependiendo de los  parámetros de búsqueda
        if(!"".equals(value.trim())){
            
            mFoundUserList=Usuario.getUsuarioList(
                        Constant.ARRAY_USER_COLUMNS_AND_ALIAS[0][index]+"="+((index>0)?"'"+value+"'":value)
                        );
            
        }else mFoundUserList=Usuario.getUsuarioList();
        //ocultar o mostrar el label de tabla vacía
        this.mFrmBuscarUsuario.lblEmptyTable.setVisible(mFoundUserList.isEmpty());  
        //mostrar un mensaje que no se encontró lo que se buscaba
        if(mFoundUserList.isEmpty()) this.mFrmBuscarUsuario.messageBox(Constant.APP_NAME, "No se encontraron valores con "+value);
        
        //mostrar los valores en la tabla
        for(Usuario usuario:mFoundUserList)
            mUserTableModel.addRow(new String[]{usuario.getIdUser(),usuario.getUsuario(),usuario.getRolUser().getNombreRol()});
        
    }


    
    

    /**
     * Selecciona un usuario y vuelve al formulario anterior
     */
    public void chooseUserAndGoBack(){
        int index=this.mFrmBuscarUsuario.tbUser.getSelectedRow();
        
        if(index!=-1){                
            if(this.mOnCompletedSearch!=null){
                this.mOnCompletedSearch.execute(new Object[]{this.mFoundUserList.get(index)});
                hideFrmBuscarRol();
            } 
        }else
            this.mFrmBuscarUsuario.messageBoxAlert(Constant.APP_NAME, "Debe seleccionar un usuario");
    }    
    
}
