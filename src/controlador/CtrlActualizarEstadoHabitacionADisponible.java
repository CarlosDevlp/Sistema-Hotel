package controlador;

import conexion.Conexion;
import dto.dtoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DAOHabitacion;
import modelo.ListaDatosHabtacionPorPiso;
import vista.FrmActualizarEstadoDeHabitación;

public class CtrlActualizarEstadoHabitacionADisponible implements ActionListener {

    FrmActualizarEstadoDeHabitación formulario;
    DAOHabitacion habitacionPendiente;

    public CtrlActualizarEstadoHabitacionADisponible() {
        formulario = new FrmActualizarEstadoDeHabitación();
        habitacionPendiente = new DAOHabitacion();
        formulario.cboEstadohab.addActionListener(this);
        formulario.btnActualizar.addActionListener(this);
        formulario.btnCancelar.addActionListener(this);
    }

    public void showFrmActualizarEstadoHabitacionADisponile() {
        formulario.setVisible(true);
        //cargarDatosHabitacionesporLimpiar2();
        cargarDatosHabitacionesporLimpiar2();

    }

    public void cargarDatosHabitacionesporLimpiar2() {

        // cargar los datos 
        //LimpiarTabla(formulario.Tablaestado);
        DAOHabitacion habi = new DAOHabitacion();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"IdHab", "N° Habitación", "Tipo Hab", "Estado Hab"});
        Object[] row = new Object[4];
        ArrayList<ListaDatosHabtacionPorPiso> list = habi.obtenerTablaLista();
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getIdHab();
            row[1] = list.get(i).getNumeroHabitacion();
            row[2] = list.get(i).getTipoHabitacon();
            row[3] = list.get(i).getEstadoHabitacion();
            model.addRow(row);

        }
        formulario.Tablaestado.setModel(model);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ACTUALIZAR":
                System.out.println(" INGRESO Datos");;
                String combo = (String) formulario.cboEstadohab.getSelectedItem();
                System.out.println(combo);
                /*Conexion con = new Conexion();

                
                int seleccion = formulario.Tablaestado.getSelectedRow();
                if (seleccion >= 0) {
                    formulario.txtCodigoHab.setText(formulario.Tablaestado.getValueAt(seleccion, 0).toString());
                }

            /*  try {
                PreparedStatement pst = con.getCon().prepareStatement("UPDATE Habitacion SET Habitacion.EstadoHab='Disponible' where idHab='"+formulario.txtCodigoHab.getText()+"'");
                pst.executeUpdate();
                JOptionPane.showConfirmDialog(null, "DATOS GUARDADOS EXITOSAMENTE");
                //String idHab = String.valueOf(GenerarLLHP.TablalistaLH.getValueAt(seleccion, 0));
            } catch (SQLException ex) {
                Logger.getLogger(CtrGenerarLHPISO.class.getName()).log(Level.SEVERE, null, ex);
            }
             */
        }

        JOptionPane.showMessageDialog(null, "Habitación actualizada", "ACTUALIZAR A PENDIENTE POR ASIGNAR", JOptionPane.OK_OPTION);
    }
}
