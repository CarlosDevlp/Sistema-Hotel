/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ctrBuscarCliente.activo;
import modelo.mdlBuscarHuesped;
import vista.frmBuscarHuesped;
import vista.FrmMain;
import vista.frmGenerarReserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ctrBuscarHuesped {

    private FrmMain principal;
    private frmBuscarHuesped vistaBuscarHuesped;
    private frmGenerarReserva vistaGenerarReserva;
    //variable
    public static boolean activo = false;

    //modelo
    private mdlBuscarHuesped unmdlBuscarHuesped;
    //controladores

    public ctrBuscarHuesped() {
    }

    public ctrBuscarHuesped(FrmMain principal) {
        this.principal = principal;
    }

    public void mantenerGUIbuscarHuesped() {
        activo = true;

        if (vistaBuscarHuesped == null) {
            vistaBuscarHuesped = new frmBuscarHuesped();
        }
        if (unmdlBuscarHuesped == null) {
            unmdlBuscarHuesped = new mdlBuscarHuesped();
        }
        vistaBuscarHuesped.setAlwaysOnTop(true);
        vistaBuscarHuesped.setDefaultCloseOperation(0);
        try {
            vistaBuscarHuesped.tblHuesped.setModel(unmdlBuscarHuesped.getTablaHuesped2());
        } catch (Exception ex) {
            Logger.getLogger(ctrBuscarHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }

        vistaBuscarHuesped.addALbtnCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activo = false;
                //Oculto y destruyo el panel
                vistaBuscarHuesped.setVisible(false);
                vistaBuscarHuesped = null;
            }
        });
        vistaBuscarHuesped.addALbtnBuscar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!vistaBuscarHuesped.txtDni.getText().equals("")) {
                        vistaBuscarHuesped.tblHuesped.setModel(unmdlBuscarHuesped.getTablaHuesped(vistaBuscarHuesped.txtDni.getText()));
                    } else {
                        JOptionPane.showMessageDialog(vistaBuscarHuesped, "Error: Campos vacios.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ctrBuscarHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        vistaBuscarHuesped.addALbtnAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = vistaBuscarHuesped.tblHuesped.getSelectedRow();
                if (fila > -1) {
                    String codhuesped = (String) vistaBuscarHuesped.tblHuesped.getValueAt(fila, 0);
                    String nomhuesped = (String) vistaBuscarHuesped.tblHuesped.getValueAt(fila, 1);
                    String dochuesped = (String) vistaBuscarHuesped.tblHuesped.getValueAt(fila, 2);

                    vistaGenerarReserva.txtCodHuesped.setText(codhuesped);
                    vistaGenerarReserva.txtNomHuesped.setText(nomhuesped);
                    vistaGenerarReserva.txtDniHuesped.setText(dochuesped);

                    //JOptionPane.showMessageDialog(null, "Se capturaron los datos correctamente");
                    activo = false;
                    vistaBuscarHuesped.setVisible(false);
                    vistaBuscarHuesped = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Busque y seleccione un Huesped");
                }

            }
        });

        //mostrar formulario interno
        vistaBuscarHuesped.setVisible(true);

        //mostar el formulario princial
        principal.setVisible(true);
    }

}
