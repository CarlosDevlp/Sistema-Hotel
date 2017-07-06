
package controlador;

import dto.dtoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DAOHabitacion;
import modelo.ListaDatosHabtacionPorPiso;
import vista.FrmActualizarEstadoDeHabitación;


public class CtrlActualizarEstadoHabitacionADisponible implements ActionListener{

     FrmActualizarEstadoDeHabitación formulario;
     DAOHabitacion habitacionPendiente;

    public CtrlActualizarEstadoHabitacionADisponible() {
        formulario = new FrmActualizarEstadoDeHabitación();
         habitacionPendiente=new DAOHabitacion();
         formulario.cboEstadohab.addActionListener(this);
         
    }
    
    
     public void showFrmActualizarEstadoHabitacionADisponile(){
       formulario.setVisible(true);
       //cargarDatosHabitacionesporLimpiar2();
       cargarDatosHabitacionesporLimpiar2();
        
    }
    
    
        public void cargarDatosHabitacionesporLimpiar2()
    {
        
        // cargar los datos 
        //LimpiarTabla(formulario.Tablaestado);
        DAOHabitacion habi = new DAOHabitacion();
         DefaultTableModel model = new DefaultTableModel();
         model.setColumnIdentifiers(new Object[]{"N° Habitación", "Tipo Hab", "Estado Hab"});
             Object[] row = new Object[3];
          ArrayList<ListaDatosHabtacionPorPiso> list=habi.obtenerTablaLista();
        for(int i=0;i<list.size();i++)
        {
            row [0] = list.get(i).getNumeroHabitacion();
            row [1] = list.get(i).getTipoHabitacon();
            row [2] = list.get(i).getEstadoHabitacion();
            model.addRow(row);
           
        }
        formulario.Tablaestado.setModel(model);
                
       
                        
    }
 
     
    
     
     
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
