/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.CtrlMantenerRDLH;
import dto.dtoEmpleado;
import modelo.DAOEmpleado;
import vista.FrmBuscarPersonalLimpieza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import vista.FrmMantenerRegistroDeLimpiezaDeHabitacion;

/**
 *
 * @author rsoporte
 */
public class CtrBuscarPersonaLimpieza implements ActionListener, MouseListener {

    CtrlMantenerRDLH padre;
    ValidaciondeDatos validacion;
    FrmBuscarPersonalLimpieza Bpersonal;
    FrmMantenerRegistroDeLimpiezaDeHabitacion mantenerRegistro;
    DAOEmpleado daoPersonal;

    String codigo, dni, nombre, telefono, turno;

    public CtrBuscarPersonaLimpieza(CtrlMantenerRDLH padre) {
        this.padre = padre;
        daoPersonal = new DAOEmpleado();
        if (Bpersonal == null) {
            Bpersonal = new FrmBuscarPersonalLimpieza();
        }

        Bpersonal.BtnBuscar.addActionListener(this);
        Bpersonal.BtnAceptar.addActionListener(this);
        Bpersonal.btnCancelarP.addActionListener(this);
        Bpersonal.setVisible(true);
        validacion = new ValidaciondeDatos();
                validacion.validarNumeros(Bpersonal.txtdnifiltro);
        validacion.validarLetras(Bpersonal.txtTurnofiltro);
        validacion.validarLetras(Bpersonal.txtNombrefiltro);
        validacion.LimitarCaracteres(Bpersonal.txtdnifiltro, 8);
        validacion.LimitarCaracteres(Bpersonal.txtNombrefiltro, 45);
        validacion.LimitarCaracteres(Bpersonal.txtTurnofiltro, 45);

        Bpersonal.txtdnifiltro.requestFocusInWindow();
        
}

    public void limpiarCajar() {
        Bpersonal.txtNombrefiltro.setText("");
        Bpersonal.txtdnifiltro.setText("");
        Bpersonal.txtTurnofiltro.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "BUSCAR":

                DAOEmpleado dao = new DAOEmpleado();
                ArrayList<dtoEmpleado> listita = dao.obtenerEmpleado();

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new Object[]{"N° DNI", "NOMBRE", "HORARIO", "TELEFONO"});
                Object[] row = new Object[4];
                
                for (int i = 0; i < listita.size(); i++) {
                    row[0] = listita.get(i).getDni();
                    row[1] = listita.get(i).getNombre();
                    row[2] = listita.get(i).getTelefono();
                    row[3] = listita.get(i).getHorariolaboral();
                    model.addRow(row);

                }

                Bpersonal.tbPersonal.setModel(model);
                
        
        
                break;

            case "ACEPTAR":

                int seleccion = Bpersonal.tbPersonal.getSelectedRow();

                String dni = String.valueOf(Bpersonal.tbPersonal.getValueAt(seleccion, 0));
                String nombre = String.valueOf(Bpersonal.tbPersonal.getValueAt(seleccion, 1));
                String horario = String.valueOf(Bpersonal.tbPersonal.getValueAt(seleccion, 2));

                ArrayList<String> datos = new ArrayList<String>();
                //datos.add(this.codigo);
                datos.add(dni);
                datos.add(nombre);
                datos.add(horario);

                padre.recibir_datosBuscarE(datos);

                Bpersonal.dispose();
                break;
            case "CANCELAR":
                Bpersonal.setVisible(false);
                Bpersonal = null;
                break;
            case "Limpiar":
                limpiarCajar();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
