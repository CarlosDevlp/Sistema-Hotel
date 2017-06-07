/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ctrBuscarHabitacion.activo;
import modelo.mdlBuscarCliente;
import modelo.mdlGenerarReserva;
import vista.frmBuscarCliente;
import vista.frmGenerarReserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.FrmMain;

public class ctrBuscarCliente {

    //vistas
    private FrmMain principal;
    private frmBuscarCliente vistaBuscarCliente;
    private frmGenerarReserva vistaGenerarReserva;

    //variable
    public static boolean activo = false;

    //modelo
    private mdlBuscarCliente unmdlBuscarCliente;
    //private Persona persona;
    //controladores
    private ctrBuscarCliente unctrBuscarCliente;
    private ctrRegistarCliente unctrRegistrarCliente;
    private ctrGenerarReserva unctrGenerarReserva;

    public ctrBuscarCliente() {
    }

    public ctrBuscarCliente(FrmMain principal) {
        this.principal = principal;
    }

    public void mantenerGUIbuscar() {
        activo = true;
        if (vistaBuscarCliente == null) {
            vistaBuscarCliente = new frmBuscarCliente();
        }
        if (unmdlBuscarCliente == null) {
            unmdlBuscarCliente = new mdlBuscarCliente();
        }
        vistaBuscarCliente.setAlwaysOnTop(true);
        vistaBuscarCliente.setDefaultCloseOperation(0);
        try {
            vistaBuscarCliente.tblCliente.setModel(unmdlBuscarCliente.getTablaCliente2());
        } catch (Exception ex) {
            Logger.getLogger(ctrBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        vistaBuscarCliente.addALbtnCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activo = false;
                //Oculto y destruyo el panel
                vistaBuscarCliente.setVisible(false);
                vistaBuscarCliente = null;
            }
        });
        vistaBuscarCliente.addALbtnBuscar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!vistaBuscarCliente.txtDocumento.getText().equals("")) {
                        vistaBuscarCliente.tblCliente.setModel(unmdlBuscarCliente.getTablaCliente(vistaBuscarCliente.txtDocumento.getText()));
                    } else {
                        JOptionPane.showMessageDialog(vistaBuscarCliente, "Error: Campos vacios.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ctrBuscarHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        vistaBuscarCliente.addLbtnAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = vistaBuscarCliente.tblCliente.getSelectedRow();
                if (fila > -1) {

                    String cod = (String) vistaBuscarCliente.tblCliente.getValueAt(fila, 0);
                    String nom = (String) vistaBuscarCliente.tblCliente.getValueAt(fila, 1);
                    String doc = (String) vistaBuscarCliente.tblCliente.getValueAt(fila, 2);
                    String dir = (String) vistaBuscarCliente.tblCliente.getValueAt(fila, 3);
                    String tel = (String) vistaBuscarCliente.tblCliente.getValueAt(fila, 4);

                    vistaGenerarReserva.txtCodCliente.setText(cod);
                    vistaGenerarReserva.txtNomCliente.setText(nom);
                    vistaGenerarReserva.txtDocCliente.setText(doc);

                    //JOptionPane.showMessageDialog(null, "Se capturaron los datos correctamente");
                    activo = false;
                    vistaBuscarCliente.setVisible(false);
                    vistaBuscarCliente = null;

                } else {
                    JOptionPane.showMessageDialog(null, "Busque y seleccione un cliente");
                }
            }
        });
        //mostrar formulario interno
        vistaBuscarCliente.setVisible(true);

        //mostar el formulario princial
        principal.setVisible(true);

    }
}
