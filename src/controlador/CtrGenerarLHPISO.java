/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dto.dtoHabitacion;
import dto.dtpEmpleadoDNI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAOEmpleado;
import modelo.DAOHabitacion;
import modelo.ListaDatosHabtacionPorPiso;
import modelo.Piso;
import vista.FrmGenerarListaLimpiezaHabitaciónPorPiso;

/**
 *
 * @author windows
 */
public class CtrGenerarLHPISO implements ActionListener, MouseListener, ItemListener {

    FrmGenerarListaLimpiezaHabitaciónPorPiso GenerarLLHP;
    DAOHabitacion habitacionPendiente;
    DAOEmpleado daoPersonal;
    ValidaciondeDatos validardatos;
    String codigo, dni, nombre, telefono, turno;

    public CtrGenerarLHPISO() {
        GenerarLLHP = new FrmGenerarListaLimpiezaHabitaciónPorPiso();
        habitacionPendiente = new DAOHabitacion();

        daoPersonal = new DAOEmpleado();

        GenerarLLHP.cboPiso.addItemListener(this);
        GenerarLLHP.btnGuardarlh.addActionListener(this);
        GenerarLLHP.btnCancelarLH.addActionListener(this);
        GenerarLLHP.btnConsultarEmpleado.addActionListener(this);

        validardatos = new ValidaciondeDatos();
    }

    public void showFrmGenerarlistaLHP() {
        GenerarLLHP.setVisible(true);
        CargarCombo();
        validardatos.validarNumeros(GenerarLLHP.txtcodSupe);
        GenerarLLHP.txtNombreSuper.setEnabled(false);
        GenerarLLHP.txtCodigo.setVisible(false);
    }

    public void CargarCombo() {
        DAOHabitacion daohabc = new DAOHabitacion();
        System.out.println("ENTRO AL METODO");
        ArrayList<Piso> lista = daohabc.consultarPiso();

        lista = daohabc.consultarPiso();

        for (int i = 0; i < lista.size(); i++) {
            GenerarLLHP.cboPiso.addItem(lista.get(i));

        }

    }

    public void consultarEmpleado() {
        System.out.println("Ingreso al metodo");
        DAOHabitacion daohab = new DAOHabitacion();
        //daohab.obtenerPersona(GenerarLLHP.txtcodSupe);
        dtpEmpleadoDNI pdt = daohab.consultarPorCodigo(GenerarLLHP.txtcodSupe.getText());

        String nombre = pdt.toString();

        //System.out.println("Empleado: "+ nombre);
        GenerarLLHP.txtNombreSuper.setText(nombre);

    }

    public void cargarDatosHabitacionesporLimpiar2() {

        // cargar los datos 
        LimpiarTabla(GenerarLLHP.TablalistaLH);
        DefaultTableModel dtm3 = (DefaultTableModel) GenerarLLHP.TablalistaLH.getModel();
        ArrayList<dtoHabitacion> hp = habitacionPendiente.obtenerHabitacionPendientes("MANTENIMIENTO");

        for (int e = 0; e < hp.size(); e++) {
            String id = Integer.toString(hp.get(e).getIdhabitacion());
            String numero = Integer.toString(hp.get(e).getNumero());
            String descripcion = hp.get(e).getDescripcion();
            String estado = hp.get(e).getEstado();
            dtm3.addRow(new Object[]{id, numero, descripcion, estado});
        }
        GenerarLLHP.TablalistaLH.setModel(dtm3);

    }

    public void LimpiarTabla(JTable tabla) {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tabla.getModel();

        try {
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "seleccionar":

                GenerarLLHP.cboPiso.getSelectedItem().equals(codigo);
                GenerarLLHP.getCbmPiso().addItem("Seleccione un Piso");
                cargarDatosHabitacionesporLimpiar2();
                GenerarLLHP.getCbmPiso().addItem(1);
                GenerarLLHP.getCbmPiso().addItem(2);
                GenerarLLHP.getCbmPiso().addItem(3);
                GenerarLLHP.getCbmPiso().addItem(4);

                GenerarLLHP.txtcodSupe.setText(null);
                GenerarLLHP.txtNombreSuper.setText(null);

                break;
            case "CANCELAR":
                //cancelar
                GenerarLLHP.setVisible(false);
                GenerarLLHP = null;

                break;
            case "CONSULTAR":
                GenerarLLHP.txtNombreSuper.setText("");
                System.out.println("TOCANDO BOTON");
                consultarEmpleado();
                break;
            case "GUARDAR":
                Conexion con = new Conexion();

                int seleccion = GenerarLLHP.TablalistaLH.getSelectedRow();
                if (seleccion >= 0) {
                    GenerarLLHP.txtCodigo.setText(GenerarLLHP.TablalistaLH.getValueAt(seleccion, 0).toString());
                }

                 {
                    try {
                        PreparedStatement pst = con.getCon().prepareStatement("UPDATE Habitacion SET Habitacion.EstadoHab='PENDIENTE POR ASIGNAR' where idHab='" + GenerarLLHP.txtCodigo.getText() + "'");
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS EXITOSAMENTE");
                        //String idHab = String.valueOf(GenerarLLHP.TablalistaLH.getValueAt(seleccion, 0));
                    } catch (SQLException ex) {
                        Logger.getLogger(CtrGenerarLHPISO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Object item = e.getItem();
            //JOptionPane.showMessageDialog(null, item);
            DAOHabitacion habi = new DAOHabitacion();
            ArrayList<ListaDatosHabtacionPorPiso> list = habi.obtenerTabla(item);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"ID Hab", "N° Habitación", "Tipo Habitación", "Estado Habitación"});
            Object[] row = new Object[4];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getIdHab();
                row[1] = list.get(i).getNumeroHabitacion();
                row[2] = list.get(i).getTipoHabitacon();
                row[3] = list.get(i).getEstadoHabitacion();
                model.addRow(row);
            }
            GenerarLLHP.TablalistaLH.setModel(model);
            System.out.println("Dato: " + item);
        }

        // JOptionPane.showMessageDialog(null,e.getItem().toString());
        //DefaultTableModel model= (DefaultTableModel)GenerarLLHP.TablalistaLH.getModel();
    }
}
