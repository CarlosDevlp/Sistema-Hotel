/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ctrBuscarHabitacion.activo;
import modelo.mdlRegistrarCliente;
import vista.frmRegistrarCliente;
import vista.FrmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ctrRegistarCliente {

    //vistas
    private FrmMain principal;
    private frmRegistrarCliente vistaRegistrarCliente;

    //variable
    public static boolean activo = false;

    //modelo
    private mdlRegistrarCliente unmdlRegistrarCliente;

    //controladores
    private ctrBuscarCliente unctrBuscarCliente;
    private ctrRegistarCliente unctrRegistrarCliente;

    public ctrRegistarCliente() {
    }

    public ctrRegistarCliente(FrmMain principal) {
        this.principal = principal;
    }

    public void mantenerGUIregistrar() {
        activo = true;

        if (vistaRegistrarCliente == null) {
            vistaRegistrarCliente = new frmRegistrarCliente();
        }
        if (unmdlRegistrarCliente == null) {
            unmdlRegistrarCliente = new mdlRegistrarCliente();
        }
        vistaRegistrarCliente.setAlwaysOnTop(true);
        vistaRegistrarCliente.setDefaultCloseOperation(0);

        vistaRegistrarCliente.addALbtnCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activo = false;
                //Oculto y destruyo el panel
                vistaRegistrarCliente.setVisible(false);
                vistaRegistrarCliente = null;
            }
        });
        vistaRegistrarCliente.addALbtnRegistrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (unmdlRegistrarCliente.NuevoCliente(
                                        vistaRegistrarCliente.txtNombre.getText(),
                                        vistaRegistrarCliente.txtDocumento.getText(),
                                        vistaRegistrarCliente.cmbSexo.getSelectedItem().toString(),
                                        vistaRegistrarCliente.txtDireccion.getText(),
                                        vistaRegistrarCliente.txtTelefono.getText(),
                                        vistaRegistrarCliente.txtCorreo.getText()
                    )) {
                        JOptionPane.showMessageDialog(vistaRegistrarCliente, "Exito: Nuevo registro agregado.");
                        vistaRegistrarCliente.txtNombre.setText("");
                        vistaRegistrarCliente.txtNombre.setText("");
                        vistaRegistrarCliente.txtDocumento.setText("");
                        vistaRegistrarCliente.cmbSexo.setSelectedIndex(0);
                        vistaRegistrarCliente.txtDireccion.setText("");
                        vistaRegistrarCliente.txtTelefono.setText("");
                        vistaRegistrarCliente.txtCorreo.setText("");
                    } else //ocurrio un error
                    {
                        JOptionPane.showMessageDialog(vistaRegistrarCliente, "Error: Los datos son incorrectos.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ctrRegistrarHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //mostrar formulario interno
        vistaRegistrarCliente.setVisible(true);

        //mostar el formulario princial
        principal.setVisible(true);
    }

}
