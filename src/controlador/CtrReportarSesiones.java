/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import assets.values.Constant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import modelo.Sesion;
import modelo.Usuario;
import vista.FrmReporteSesiones;

/**
 *
 * GRUPO: Facturación/Seguridad 
 * @author Carlos Chavez Laguna
 */
public class CtrReportarSesiones implements ActionListener{
    private Usuario mUser;
    private ArrayList<Sesion> mSesionList;
    private FrmReporteSesiones mFrmReporteSesiones;
    private DefaultTableModel mSesionTableModel;
    private final String []SESION_TABLE_COLUMN_NAMES={"Id","Nombre de usuario","Fecha de ingreso","Fecha de salida","Actividad"};
    
    //constructor

    public CtrReportarSesiones() {
        this(new FrmReporteSesiones());
    }

    public CtrReportarSesiones(FrmReporteSesiones mFrmReporteSesiones) {
        this.mFrmReporteSesiones = mFrmReporteSesiones;
        this.mFrmReporteSesiones.btnSearchUser.addActionListener(this);
        this.mFrmReporteSesiones.btnFilter.addActionListener(this);
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
            //botón buscar al usuario
            case "btnSearchUser":
                CtrIncluido.getInstance().showForm(Constant.FORM_BUSCAR_USUARIO, OnCompleteSearch());
                break;
            //botón para buscar los logs y sesiones del usuarios
            case "btnFilter":
                searchLogs();
                break;
            //botón guardar al usuario y
            //botón actualizar al usuario
            case "btnSave":
            case "btnUpdate":
                
                break;
            //botón eliminar al usuario
            case "btnDelete":
                
                break;
            //botón limpiar los campos
            case "btnClean":
                clear();
                break;
        }                
    }
    //____________________________________________________________________________________________    
    
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
                            mUser=(Usuario) args[0];
                            mFrmReporteSesiones.txtName.setText(mUser.getUsuario());
                       }
           };
    }
    
    /**
     * Pre-cargar data en el formulario.
     */
    public void loadData(){        
        
        this.mFrmReporteSesiones.cmbActivity.setModel(new DefaultComboBoxModel(Constant.ARRAY_ACTIVITY_TYPE_AND_ALIAS[1]));
        clearTable();
    }
    
    /**
     * limpiar o resetear todos los campos
     */
    private void clear(){
        mUser=null;        
        mFrmReporteSesiones.txtName.setText("");
        mFrmReporteSesiones.cmbActivity.setSelectedIndex(0);                
    }


    /**
     * Mostrar el formulario mantener usuario
     */
    public void showFrmReporteSesiones(){
        this.mFrmReporteSesiones.setVisible(true);
    }
    
    /**
     * Esconder el formulario mantener usuario
     */
    public void hideFrmReporteSesiones(){
        this.mFrmReporteSesiones.setVisible(false);
    }    

    /**
     * vaciar la tabla
     **/
    private void clearTable(){
        mSesionTableModel = new DefaultTableModel(null,SESION_TABLE_COLUMN_NAMES);
        this.mFrmReporteSesiones.tbLog.setModel(mSesionTableModel);
    }    
    /**
     * buscar logs de un usuario filtrando por 
     * fecha y tipo de actividad realizado (insertar, eliminar, actualizar, etc)
     */
    private void searchLogs(){
        
        int condCounter=0;
        String condSesion="";
        
        if(mUser!=null) {
            condSesion+=" User_idUser="+mUser.getIdUser();
            condCounter++;
        }
                
        Date fromDate=this.mFrmReporteSesiones.dtpSessionDateFrom.getDate();
        if(fromDate!=null){                       
            fromDate.setHours(0);
            fromDate.setMinutes(0);
            fromDate.setSeconds(1);
            condSesion+=(condCounter>0?" AND ":" ")+" TimeInitSes > '"+formatDate(fromDate)+"'";
            condCounter++;
        }
        
        
        Date toDate=this.mFrmReporteSesiones.dtpSessionDateTo.getDate();
        if(toDate!=null){
            toDate.setHours(23);
            toDate.setMinutes(59);
            toDate.setSeconds(59);
            condSesion+=(condCounter>0?" AND ":" ")+" TimeInitSes < '"+formatDate(toDate)+"'";
            condCounter++;
        }
        
                        

        String condLog;
        condLog=Constant.ARRAY_ACTIVITY_TYPE_AND_ALIAS[0][this.mFrmReporteSesiones.cmbActivity.getSelectedIndex()];
        
        mSesionList=Sesion.getSesionList((condCounter==0? null:condSesion),(condLog.equals("all")? "":" AND DescripcionTHU='"+condLog+"'") );
        
        //--------------------------------------------
        
        //setear la vista
        
        if(mSesionTableModel.getRowCount()>0) clearTable();
        
        ArrayList<Sesion.Log> logList;
        for(Sesion sesion:mSesionList){
            
            //mostrar solo inicio de sesión 
            if(condLog.equals("all"))
                mSesionTableModel.addRow(new Object[]{sesion.getIdSesion(),sesion.getUserName(),sesion.getTimeInitSes(),sesion.getTimesFinishSes(),"inicio de sesión"});
            
            //mostrar los logs de la sesión
            logList=sesion.getLogList();
            if(logList!=null)            
                for(Sesion.Log log:logList)
                    mSesionTableModel.addRow(new Object[]{sesion.getIdSesion(),sesion.getUserName(),sesion.getTimeInitSes(),sesion.getTimesFinishSes(),log.getTipoActividad()+" - "+log.getTablaLUs()});
        }
        
        
        this.mFrmReporteSesiones.lblEmptyTable.setVisible(mSesionList.isEmpty());
        
    }
    
    /**
     * 
     * convertir el la fecha a un formato reconocido por el 
     * mysql
     * 
     * @param date fecha de clase date
     * 
     * @return string formateado listo para ser enviado a la bd.
     */
    private String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    } 
    
}
