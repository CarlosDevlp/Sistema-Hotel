/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.mdlBuscarHabitacion;
import vista.frmBuscarHabitacion;
import vista.frmGenerarReserva;
import vista.FrmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ctrBuscarHabitacion {

    //vistas
    private FrmMain principal;
    private frmBuscarHabitacion vistaBuscarHabitacion;
    private frmGenerarReserva vistaGenerarReserva;

    //variable
    public static boolean activo = false;

    //modelo
    private mdlBuscarHabitacion unmdlBuscarHabitacion;

    //controladores
    public ctrBuscarHabitacion() {
    }

    public ctrBuscarHabitacion(FrmMain principal) {
        this.principal = principal;
    }

    public void mantenerGUIbuscarHabitacion() {
        activo = true;
        if (vistaBuscarHabitacion == null) {
            vistaBuscarHabitacion = new frmBuscarHabitacion();
        }
        if (unmdlBuscarHabitacion == null) {
            unmdlBuscarHabitacion = new mdlBuscarHabitacion();
        }

        vistaBuscarHabitacion.setAlwaysOnTop(true);
        vistaBuscarHabitacion.setDefaultCloseOperation(0);

        try {
            vistaBuscarHabitacion.tblHabitacion.setModel(unmdlBuscarHabitacion.getTablaHabitacion2());
        } catch (Exception ex) {
            Logger.getLogger(ctrBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        vistaBuscarHabitacion.addALbtnBuscar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!vistaBuscarHabitacion.cmbTipoHabitacion.getSelectedItem().equals("")) {
                        vistaBuscarHabitacion.tblHabitacion.setModel(unmdlBuscarHabitacion.getTablaHabitacion(String.valueOf(vistaBuscarHabitacion.cmbTipoHabitacion.getSelectedItem())));
                    } else {
                        JOptionPane.showMessageDialog(vistaBuscarHabitacion, "Error: Campos vacios.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ctrBuscarHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        vistaBuscarHabitacion.addALbtnCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activo = false;
                //Oculto y destruyo el panel
                vistaBuscarHabitacion.setVisible(false);
                vistaBuscarHabitacion = null;
            }
        });

        vistaBuscarHabitacion.addLbtnAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = vistaBuscarHabitacion.tblHabitacion.getSelectedRow();
                if (fila > -1) {

                    String cod = (String) vistaBuscarHabitacion.tblHabitacion.getValueAt(fila, 0);
                    String tip = (String) vistaBuscarHabitacion.tblHabitacion.getValueAt(fila, 2);
                    String cos = (String) vistaBuscarHabitacion.tblHabitacion.getValueAt(fila, 3);

                    vistaGenerarReserva.txtCodHab.setText(cod);
                    vistaGenerarReserva.txtTipoHab.setText(tip);
                    vistaGenerarReserva.txtCostoHab.setText(cos);

                    //JOptionPane.showMessageDialog(null, "Se capturaron los datos correctamente");
                    activo = false;
                    vistaBuscarHabitacion.setVisible(false);
                    vistaBuscarHabitacion = null;

                } else {
                    JOptionPane.showMessageDialog(null, "Busque y seleccione un cliente");
                }
            }
        });

        //mostrar formulario interno
        vistaBuscarHabitacion.setVisible(true);

        //mostar el formulario princial
        principal.setVisible(true);
    }

}
