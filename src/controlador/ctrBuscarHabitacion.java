/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Habitacion;
import vista.frmBuscarHabitacion;
import vista.frmGenerarReserva;

/**
 *
 * @author Propietario
 */
public class ctrBuscarHabitacion implements ActionListener{
    private frmBuscarHabitacion vistaBuscarHabitacion;
    private frmGenerarReserva vistaGenerarReserva;
    private ArrayList<Habitacion> mHabitacionList;
    private DefaultTableModel mHabitacionTableModel;
    private final String []USER_TABLE_COLUMN_NAMES={"Codigo","Numero","Tipo","Costo","Estado"};
    
    public ctrBuscarHabitacion(){
        this(new frmBuscarHabitacion());
    }
    
    public ctrBuscarHabitacion(frmBuscarHabitacion mfrmBuscarHabitacion) {
        this.vistaBuscarHabitacion = mfrmBuscarHabitacion;
        this.vistaBuscarHabitacion.btnAceptar.addActionListener(this);
        this.vistaBuscarHabitacion.btnBuscar.addActionListener(this);
        this.vistaBuscarHabitacion.btnCancelar.addActionListener(this);
    }
    
     public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        
        switch(obj.getName()){
            case "btnBuscar":
                buscarHabitacionTipo();
               break;
            case "btnAceptar":
                transferirDatos();
               break;
            case "btnCancelar":
                hideFrmBuscarHabitacion();
               break;
        }                
    }
     
    public void buscarHabitacionTipo() {
        if(vistaBuscarHabitacion.cmbTipoHabitacion.getSelectedItem().equals("Todas")){
            loadData();
        }else{
            clearTable();
            mHabitacionList= Habitacion.getHabitacionTipo((String)vistaBuscarHabitacion.cmbTipoHabitacion.getSelectedItem());

            for(Habitacion habitacion:mHabitacionList)        
                mHabitacionTableModel.addRow(new String[]{habitacion.getIdHab(),habitacion.getNumeroHab(),habitacion.getDescripcionTHA(),habitacion.getCostoHab(),habitacion.getEstadoHab()});        
            this.vistaBuscarHabitacion.tblHabitacion.setModel(mHabitacionTableModel);
        }
    }
     
    public void loadData() {
        clearTable();
        mHabitacionList= Habitacion.getHabitacionList();
        
        for(Habitacion habitacion:mHabitacionList)        
            mHabitacionTableModel.addRow(new String[]{habitacion.getIdHab(),habitacion.getNumeroHab(),habitacion.getDescripcionTHA(),habitacion.getCostoHab(),habitacion.getEstadoHab()});        
        this.vistaBuscarHabitacion.tblHabitacion.setModel(mHabitacionTableModel);
    }
    
    public void transferirDatos(){
        int fila=vistaBuscarHabitacion.tblHabitacion.getSelectedRow();
            if(fila>-1){

            String cod=(String)vistaBuscarHabitacion.tblHabitacion.getValueAt(fila, 0);
            String tip=(String)vistaBuscarHabitacion.tblHabitacion.getValueAt(fila, 2);
            String cos=(String)vistaBuscarHabitacion.tblHabitacion.getValueAt(fila, 3);

            vistaGenerarReserva.txtCodHab.setText(cod);
            vistaGenerarReserva.txtTipoHab.setText(tip);
            vistaGenerarReserva.txtCostoHab.setText(cos);

            hideFrmBuscarHabitacion();
            }else{
                JOptionPane.showMessageDialog(vistaBuscarHabitacion, "Seleccione una Habitacion");
            }
    }
    
    private void clearTable(){        
        mHabitacionTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_NAMES);
        this.vistaBuscarHabitacion.tblHabitacion.setModel(mHabitacionTableModel);
    }
    
    public void showFrmBuscarHabitacion(){
        this.vistaBuscarHabitacion.setVisible(true);
    }
    
    public void hideFrmBuscarHabitacion(){
        this.vistaBuscarHabitacion.setVisible(false);
        ctrGenerarReserva.activo=false;
    }
    
}
