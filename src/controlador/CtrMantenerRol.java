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
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import modelo.Pestana;
import modelo.Rol;
import vista.FrmMantenerRol;

/**
 *
 * GRUPO: Seguridad y facturación
 * @author Carlos Chavez Laguna
 */
public class CtrMantenerRol implements ActionListener{
    private FrmMantenerRol mFrmMantenerRol;
    private String[] USER_TABLE_COLUMN_NAMES={"Nombre de pestaña","Asociar"};
    private Rol mRol;
    private DefaultTableModel mPestanaTableModel;
    private final String LOG_TAG="CtrMantenerRol";
    //constructor
    public CtrMantenerRol() {
        this(new FrmMantenerRol());
    }

    public CtrMantenerRol(FrmMantenerRol mFrmMantenerRol) {
        this.mFrmMantenerRol = mFrmMantenerRol;
        this.mFrmMantenerRol.btnSearchRole.addActionListener(this);
        this.mFrmMantenerRol.btnSelect.addActionListener(this);
        this.mFrmMantenerRol.btnUnselect.addActionListener(this);
        this.mFrmMantenerRol.btnClean.addActionListener(this);
        this.mFrmMantenerRol.btnSave.addActionListener(this);
        this.mFrmMantenerRol.btnUpdate.addActionListener(this);
        this.mFrmMantenerRol.btnDelete.addActionListener(this);        
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
            case "btnSearchRole":
                CtrIncluido.getInstance()
                        .showForm(Constant.FORM_BUSCAR_ROL,OnCompleteSearch());
                
            break;
            case "btnSelect":
                changeAllRolesAssignments(true);
                break;
            case "btnUnselect":
                changeAllRolesAssignments(false);
                break;
            case "btnClean":
                clear();
               break;
               
            //actualizar o guardar
            case "btnSave":
            case "btnUpdate":
                saveRole();
               break;
            case "btnDelete":
                deleteRol();
               break;
            
            
            
        }
    }
    
    
    /**
     * Pre-cargar data en el formulario.
     */
    public void loadData(){
         mPestanaTableModel =(DefaultTableModel) this.mFrmMantenerRol.tbPestana.getModel();
        if(mPestanaTableModel.getRowCount()==0)
            for(Pestana pestana:Constant.ARRAY_MENU_PESTANA){
                mPestanaTableModel.addRow(new Object[]{pestana.getNombre(),false});
            }        
    }
    
    /**
     * mostrar formulario Mantener Rol 
     */
    public void showFrmMantenerRol(){
        this.mFrmMantenerRol.setVisible(true);
    }
    
    /**
     * 
     * esconder formulario Mantener Rol 
     */
    public void hideFrmMantenerRol(){
        this.mFrmMantenerRol.setVisible(false);
    }
    
    
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
                                            mRol=(Rol)args[0];
                                            mFrmMantenerRol.btnSave.setEnabled(false);
                                            mFrmMantenerRol.btnUpdate.setEnabled(true);
                                            mFrmMantenerRol.btnDelete.setEnabled(true);
                                            mFrmMantenerRol.txtName.setText(mRol.getNombreRol());
                                                                                        
                                            //tamaño de la tabla de pestañas en la vista 
                                            int tableRowSize=mPestanaTableModel.getRowCount();

                                            //obtener todas las pestañas del objeto rol obtenido en el buscar
                                            String[] pestanasList=mRol.getPestanasHabilitadas();
                                            
                                            //identificar las pestañas y volverlas objeto

                                            //si tiene la pestaña all
                                            if(pestanasList[0].equals("all")) {                      
                                                for(int i=0;i<tableRowSize;i++) 
                                                     mPestanaTableModel.setValueAt(true,i, 1);
                                                return;
                                            }

                                            //crear listas de objetos pestañas
                                            ArrayList<Pestana> pestanasObjList=new ArrayList();
                                            for(String pestana:pestanasList)
                                                for(Pestana pestanaObj: Constant.ARRAY_MENU_PESTANA)
                                                    if(pestana.equals(pestanaObj.getAlias())) {
                                                        pestanasObjList.add(pestanaObj);
                                                        break;
                                                    }                                                    


                                            //asginar las pestañas en la tabla
                                            for(int i=0;i<tableRowSize;i++){
                                                mPestanaTableModel.setValueAt(false,i, 1);
                                                for(Pestana pestana:pestanasObjList){
                                                    if(mPestanaTableModel.getValueAt(i, 0).equals(pestana.getNombre())){
                                                        mPestanaTableModel.setValueAt(true,i, 1);
                                                        break;
                                                    }
                                                }
                                            }
                                            
                                            
                                        }
                                    }
                        };
    }
            
    /**
     * 
     * Clear, método que permite limpiar todos los 
     * campos del formulario
     */
    private void clear(){
        this.mFrmMantenerRol.txtName.setText("");
        this.changeAllRolesAssignments(true);
        mFrmMantenerRol.btnSave.setEnabled(true);
        mFrmMantenerRol.btnUpdate.setEnabled(false);
        mFrmMantenerRol.btnDelete.setEnabled(false);
        
        //quitar el check de toda la tabla
        //tamaño de la tabla de pestañas en la vista 
        int tableRowSize=mPestanaTableModel.getRowCount();
        for(int i=0;i<tableRowSize;i++) mPestanaTableModel.setValueAt(false,i, 1);
        
        
        mRol=null;
    }
            
    
    /**
     * vaciar la tabla
     */
    private void clearTable(){               
        this.mFrmMantenerRol.tbPestana.setModel(mPestanaTableModel);
    }
    
    /**
     * seleccionar o deseleccionar todos los roles
     * 
     * @param select verdadero o  falso para realizar selección o 
     * deselección en todas las filas
     */
    private void changeAllRolesAssignments(boolean select){
        for(int i=0;i<mPestanaTableModel.getRowCount();i++)
            mPestanaTableModel.setValueAt(select, i, 1);
            
    }
    
    /**
     * 
     *guardar o modificar el rol
     */
    private void saveRole(){
        int tableRowSize=mPestanaTableModel.getRowCount();
        int tabCount=0;        
        boolean tabSelected;
        String tabsString="";
        
        for(int i=0;i<tableRowSize;i++){
            
            //obtener la seleción del usuario
            tabSelected=(boolean) mPestanaTableModel.getValueAt(i, 1);
            if(tabSelected) {
                tabCount++;
                
                if(tabCount>1) tabsString+=Rol.DELIMETER;
                    
                //agregar el alias como pestañas asignadas 
                tabsString+=Constant.ARRAY_MENU_PESTANA[i].getAlias();
            }
            
        }
        
        //si se han seleccionado todos los tabs
        if(tabCount==tableRowSize){
            tabsString="all";
        }else if(tabCount==0){ //si no se ha seleccionado ningún tab - inválido -
            this.mFrmMantenerRol.messageBoxAlert(Constant.APP_NAME, "necesitar asignar al menos una pestaña");
            return;
        }
        
        
                
        
        String name=this.mFrmMantenerRol.txtName.getText();
        
        //si está lleno de campos vacíos
        if("".equals(name.trim())){
            this.mFrmMantenerRol.messageBoxAlert(Constant.APP_NAME, "el nombre no debe tener campos vacíos");
            return;
        }
        //System.out.println(LOG_TAG+": "+tabsString);
        
        //proceder a registrar el rol            
        boolean isUpdate=false;
        if(mRol==null) //crear nuevo formulario
            mRol=new Rol("0",name,tabsString);
        else{
            isUpdate=true;
            mRol.setNombreRol(name);
            mRol.setPestanasHabilitadas(tabsString);
        }
        
        mRol.save();
        this.mFrmMantenerRol.messageBox(Constant.APP_NAME,(isUpdate)? "se ha actualizado el rol":"Se ha registrado el rol ");
    }
    
    
    /**
     * 
     * eliminar el rol
     */
    private void deleteRol(){
        mRol.remove();
        this.mFrmMantenerRol.messageBox(Constant.APP_NAME,"el rol ha sido eliminado satisfactoriamente");
        clear();
    }
}
