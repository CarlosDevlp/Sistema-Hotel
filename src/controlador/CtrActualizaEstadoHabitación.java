/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import controlador.CtrlMantenerRDLH;
import dto.dtoHabitacion;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAOHabitacion;
import vista.FrmActualizarEstadoDeHabitación;

/**
 *
 * @author windows
 */
public class CtrActualizaEstadoHabitación implements ActionListener,MouseListener{
    
    CtrlMantenerRDLH padre;
    FrmActualizarEstadoDeHabitación ActualizarEstadoHabitación;
    DAOHabitacion habitacionPendiente;
    
    
    public CtrActualizaEstadoHabitación(CtrlMantenerRDLH padre){
        this.padre = padre;
        if(ActualizarEstadoHabitación==null)
        {
          ActualizarEstadoHabitación = new FrmActualizarEstadoDeHabitación();
         // habitacionPendiente=new DAOHabitacion();
         
        }
        habitacionPendiente=new DAOHabitacion();
        ActualizarEstadoHabitación.Tablaestado.getSelectionModel().addListSelectionListener(padre);
        ActualizarEstadoHabitación.setVisible(true);
        cargardatosHabitacionesparacambiarEstado();
    
    }
     public void cargardatosHabitacionesparacambiarEstado()
    {
         LimpiarTabla(ActualizarEstadoHabitación.Tablaestado);
         DefaultTableModel dtm4=(DefaultTableModel)ActualizarEstadoHabitación.Tablaestado.getModel();
        //String id=Integer.toString(hp.get(e).getIdhabitacion());TableModel dtm=MantenerRDLH.tablaHab.getModel();
        ArrayList<dtoHabitacion> hp=habitacionPendiente.obtenerHabitacionPendientes("MANTENIMIENTO");
           
        for(int e=0;e<hp.size();e++)
        {
            String id=Integer.toString(hp.get(e).getIdhabitacion());
            String numero=Integer.toString(hp.get(e).getNumero());
            String descripcion=hp.get(e).getDescripcion();
            String estado=hp.get(e).getEstado();
            dtm4.addRow(new Object[]{id,numero,descripcion,estado});
        }
        ActualizarEstadoHabitación.Tablaestado.setModel(dtm4);
    }
     
      public void LimpiarTabla(JTable tabla)
    {
        DefaultTableModel modelo;
        modelo=(DefaultTableModel)tabla.getModel();
        
        try 
        {
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) 
            {
                modelo.removeRow(0);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
