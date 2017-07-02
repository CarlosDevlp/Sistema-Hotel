/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.dtoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.DAOEmpleado;
import modelo.DAOHabitacion;
import vista.FrmGenerarListaLimpiezaHabitaciónPorPiso;

/**
 *
 * @author windows
 */
public class CtrGenerarLHPISO implements ActionListener,MouseListener,ItemListener{
    FrmGenerarListaLimpiezaHabitaciónPorPiso GenerarLLHP;
    DAOHabitacion habitacionPendiente;
    DAOEmpleado daoPersonal;
    
     String codigo,dni,nombre,telefono,turno;
    public CtrGenerarLHPISO(){
    GenerarLLHP= new FrmGenerarListaLimpiezaHabitaciónPorPiso();
    habitacionPendiente=new DAOHabitacion();
    daoPersonal=new DAOEmpleado();
    GenerarLLHP.cboPiso.addItemListener(this);
    GenerarLLHP.btnGuardarlh.addActionListener(this);
    GenerarLLHP.btnCancelarLH.addActionListener(this);
    
    }
    
    public void showFrmGenerarlistaLHP(){
       GenerarLLHP.setVisible(true);
       cargarDatosHabitacionesporLimpiar2();
        
    }
     public void cargarDatosHabitacionesporLimpiar2()
    {
        
        // cargar los datos 
        LimpiarTabla(GenerarLLHP.TablalistaLH);
         DefaultTableModel dtm3=(DefaultTableModel)GenerarLLHP.TablalistaLH.getModel();
          ArrayList<dtoHabitacion> hp=habitacionPendiente.obtenerHabitacionPendientes("MANTENIMIENTO");
           
        for(int e=0;e<hp.size();e++)
        {
            String id=Integer.toString(hp.get(e).getIdhabitacion());
            String numero=Integer.toString(hp.get(e).getNumero());
            String descripcion=hp.get(e).getDescripcion();
            String estado=hp.get(e).getEstado();
            dtm3.addRow(new Object[]{id,numero,descripcion,estado});
        }
        GenerarLLHP.TablalistaLH.setModel(dtm3);
                
                        
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
        switch(e.getActionCommand())
        {
            case "seleccionar":
                // cargar el piso 
        // GenerarLLHP.getCbmPiso().removeAllItems();
         GenerarLLHP.cboPiso.getSelectedItem().equals(codigo);
         GenerarLLHP.getCbmPiso().addItem("Seleccione un Piso");
       // this.codigo.addItemListener(new ItemChangeListener);
        //this.nombre.addItemListener(new ItemChangeListener);
        //this.telefono.addItemListener(new ItemChangeListener);
         cargarDatosHabitacionesporLimpiar2();
         GenerarLLHP.getCbmPiso().addItem(1);
         GenerarLLHP.getCbmPiso().addItem(2);
         GenerarLLHP.getCbmPiso().addItem(3);
         GenerarLLHP.getCbmPiso().addItem(4);
         
        // DAOEmpleado lista1= daoPersonal.obtenerEmpleado();
        GenerarLLHP.txtcodSupe.setText(null);
        GenerarLLHP.txtNombreSuper.setText(null);
                
                break;
            case "CANCELAR":
               //cancelar
                GenerarLLHP.setVisible(false);
                GenerarLLHP =null;
                
                break;
        }
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        JOptionPane.showMessageDialog(null,e.getItem().toString());
        DefaultTableModel model= (DefaultTableModel)GenerarLLHP.TablalistaLH.getModel();
    }
    
}
