/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

 import modelo.DAOHabitacion;
import modelo.DaoHabitacionMantenimiento;
import vista.FrmMantenerRegistroDeLimpiezaDeHabitacion;
import dto.dtoHabitacionMantenimiento;
import dto.dtoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrador
 */
public class CtrlMantenerRDLH implements ActionListener,MouseListener,ListSelectionListener{
    
    FrmMantenerRegistroDeLimpiezaDeHabitacion MantenerRDLH;
    DaoHabitacionMantenimiento habitacionMantenimiento;
    DAOHabitacion habitacionPendiente;
    CtrBuscarPersonaLimpieza ctrBucarP;
    CtrActualizaEstadoHabitación ctrActualizaEHab;

    public CtrlMantenerRDLH() {
        MantenerRDLH=new FrmMantenerRegistroDeLimpiezaDeHabitacion();
        habitacionMantenimiento=new DaoHabitacionMantenimiento();
        //MantenerRDLH.BtnBuscarH.addActionListener(this);
        habitacionPendiente=new DAOHabitacion();
        MantenerRDLH.btnBuscarP.addActionListener(this);
        MantenerRDLH.btnRegistrar.addActionListener(this);
        MantenerRDLH.btnModificar.addActionListener(this);
        MantenerRDLH.btnCancelar.addActionListener(this);
        MantenerRDLH.btnActualizar.addActionListener(this);
        MantenerRDLH.tbporhacer.getSelectionModel().addListSelectionListener(this);
        MantenerRDLH.tablaHab.getSelectionModel().addListSelectionListener(this);
        //asignando fecha actual
        MantenerRDLH.getTxtFechaActual().setText(getFechaFormateada(new java.util.Date()));
    }
    
    public void showFrmMantenerRegistro(){
        MantenerRDLH.setVisible(true);
        LoadHabitacionesMantenimiento();
        cargarDatosHabitacionesporLimpiar();
    }
    
    public void LoadHabitacionesMantenimiento()
    {
        LimpiarTabla(MantenerRDLH.tbporhacer);
        
        DefaultTableModel dtm2=(DefaultTableModel)MantenerRDLH.tbporhacer.getModel();
        ArrayList<dtoHabitacionMantenimiento> hp=habitacionMantenimiento.ObtenerHabitacionesMantenimiento();
           
        for(int e=0;e<hp.size();e++)
        {
            String id=Integer.toString(hp.get(e).getCodMantenimiento());
            String numero=Integer.toString(hp.get(e).getNumHab());
            String descripcion=hp.get(e).getTipoHab();
            String empleado=hp.get(e).getPersonal();
            dtm2.addRow(new Object[]{id,numero,descripcion,empleado});
        }
        MantenerRDLH.tbporhacer.setModel(dtm2);
    }
    

    public void cargarDatosHabitacionesporLimpiar()
    {
         LimpiarTabla(MantenerRDLH.tablaHab);
         DefaultTableModel dtm1=(DefaultTableModel)MantenerRDLH.tablaHab.getModel();
        //String id=Integer.toString(hp.get(e).getIdhabitacion());TableModel dtm=MantenerRDLH.tablaHab.getModel();
        ArrayList<dtoHabitacion> hp=habitacionPendiente.obtenerHabitacionPendientes("POR LIMPIAR");
           
        for(int e=0;e<hp.size();e++)
        {
            String id=Integer.toString(hp.get(e).getIdhabitacion());
            String numero=Integer.toString(hp.get(e).getNumero());
            String descripcion=hp.get(e).getDescripcion();
            String estado=hp.get(e).getEstado();
            dtm1.addRow(new Object[]{id,numero,descripcion,estado});
        }
        MantenerRDLH.tablaHab.setModel(dtm1);
    }
     
            
    
    public void recibir_datosBuscarE(ArrayList<String> datosp)
    {
        MantenerRDLH.txtCodigoEmpleado.setText(datosp.get(0));
        MantenerRDLH.txtTurno.setText(datosp.get(3));
        MantenerRDLH.txtNombreEmpleado.setText(datosp.get(2));
    }
    
    public String getfecha()
    {
        Calendar calendario=GregorianCalendar.getInstance();
        Date fecha = calendario.getTime();
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStr=formatoDeFecha.format(fecha);
        return fechaStr;
    }
    
    public void LimpiarControles()
    {
        MantenerRDLH.txtcodigo.setText(null);
        MantenerRDLH.txtCodigoEmpleado.setText(null);
        MantenerRDLH.txtDescripcionHabitacion.setText(null);
        MantenerRDLH.txtNhabitacion.setText(null);
        MantenerRDLH.txtNombreEmpleado.setText(null);
        MantenerRDLH.txtTurno.setText(null);
        
    }
    
    public void LimpiarTabla(JTable tabla)
    {
        DefaultTableModel modelo;
        modelo=(DefaultTableModel)tabla.getModel();
        
        try 
        {
            while(modelo.getRowCount()>0)
            {
                modelo.removeRow(0);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String numeroHab;
        String codigoRLH;
      
        switch(e.getActionCommand())
        {
            case "BUSCARP":
                ctrBucarP=new CtrBuscarPersonaLimpieza(this);
                break;
            case "BUSCAR1":
                ctrActualizaEHab=new CtrActualizaEstadoHabitación(this);
                    break;
            case "REGISTRAR"://registra y actualiza la tabla
               numeroHab=MantenerRDLH.txtNhabitacion.getText();
               int codHab=Integer.parseInt(MantenerRDLH.txtcodigo.getText());
               int codPer=Integer.parseInt(MantenerRDLH.txtCodigoEmpleado.getText());
               String fecha=getfecha();
               habitacionMantenimiento.RegistrarMantenimiento(codPer,codHab,fecha,"ASIGNADA");
               habitacionPendiente.ActualizarEstadoHabitacion(numeroHab,"MANTENIMIENTO");
               LoadHabitacionesMantenimiento();
               cargarDatosHabitacionesporLimpiar();
               LimpiarControles();
               break;
               
            case "ELIMINAR":
                codigoRLH=MantenerRDLH.tbporhacer.getValueAt(MantenerRDLH.tbporhacer.getSelectedRow(),0).toString();
                numeroHab=MantenerRDLH.tbporhacer.getValueAt(MantenerRDLH.tbporhacer.getSelectedRow(),1).toString();
                JOptionPane.showMessageDialog(null,codigoRLH);
                
                habitacionMantenimiento.EliminarHabitacionesMantenimiento(codigoRLH);
                habitacionPendiente.ActualizarEstadoHabitacion(numeroHab,"EN LISTA");
                LoadHabitacionesMantenimiento();
                cargarDatosHabitacionesporLimpiar();
                break;
                
            case "ACTUALIZAR":
                numeroHab=MantenerRDLH.tbporhacer.getValueAt(MantenerRDLH.tbporhacer.getSelectedRow(),1).toString();
                codigoRLH=MantenerRDLH.tbporhacer.getValueAt(MantenerRDLH.tbporhacer.getSelectedRow(),0).toString();
                
                habitacionMantenimiento.ActualizarEstadoRHL(Integer.parseInt(codigoRLH));
                habitacionPendiente.ActualizarEstadoHabitacion(numeroHab,"DISPONIBLE");
                LoadHabitacionesMantenimiento();
                cargarDatosHabitacionesporLimpiar();
                break;
            case "CANCELAR":
                //cancelar
                MantenerRDLH.setVisible(false);
                MantenerRDLH =null;
             
                
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
    public void valueChanged(ListSelectionEvent e) {
        
        if(e.getSource()==MantenerRDLH.tbporhacer.getSelectionModel())        
        {
            
        }
        else 
        {   
            MantenerRDLH.txtcodigo.setText(MantenerRDLH.tablaHab.getValueAt(MantenerRDLH.tablaHab.getSelectedRow(),0).toString());
            MantenerRDLH.txtNhabitacion.setText(MantenerRDLH.tablaHab.getValueAt(MantenerRDLH.tablaHab.getSelectedRow(),1).toString());
            MantenerRDLH.txtDescripcionHabitacion.setText(MantenerRDLH.tablaHab.getValueAt(MantenerRDLH.tablaHab.getSelectedRow(),2).toString());
        }
    
   }
     //fecha actual del sistema: metodo 
       private String getFechaFormateada(java.util.Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");

        return (formateador.format(fecha.getTime()));
    }
      
    
}
