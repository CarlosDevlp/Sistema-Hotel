/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ctrBuscarHabitacion.activo;
import modelo.mdlRegistrarHuesped;
import vista.frmRegistrarHuesped;
import vista.FrmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ctrRegistrarHuesped {

    //vistas
    private FrmMain principal;
    private frmRegistrarHuesped vistaRegistrarHuesped;

    //variable
    public static boolean activo = false;

    //modelo
    private mdlRegistrarHuesped unmdlRegistrarHuesped;

    //controladores
    public ctrRegistrarHuesped() {
    }

    public ctrRegistrarHuesped(FrmMain principal) {
        this.principal = principal;
    }

    public void mantenerGUIbuscarHuesped() {
        activo = true;
        if (vistaRegistrarHuesped == null) {
            vistaRegistrarHuesped = new frmRegistrarHuesped();
        }
        if (unmdlRegistrarHuesped == null) {
            unmdlRegistrarHuesped = new mdlRegistrarHuesped();
        }
        vistaRegistrarHuesped.setAlwaysOnTop(true);
        vistaRegistrarHuesped.setDefaultCloseOperation(0);

        vistaRegistrarHuesped.addALbtnCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activo = false;
                //Oculto y destruyo el panel
                vistaRegistrarHuesped.setVisible(false);
                vistaRegistrarHuesped = null;
            }
        });
        vistaRegistrarHuesped.addALbtnRegistrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (unmdlRegistrarHuesped.NuevoHuesped(
                                        vistaRegistrarHuesped.txtNombre.getText(),
                                        vistaRegistrarHuesped.txtDni.getText())) {
                        JOptionPane.showMessageDialog(vistaRegistrarHuesped, "Exito: Nuevo registro agregado.");
                        vistaRegistrarHuesped.txtNombre.setText("");
                        vistaRegistrarHuesped.txtDni.setText("");
                    } else //ocurrio un error
                    {
                        JOptionPane.showMessageDialog(vistaRegistrarHuesped, "Error: Los datos son incorrectos.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ctrRegistrarHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //mostrar formulario interno
        vistaRegistrarHuesped.setVisible(true);

        //mostar el formulario princial
        principal.setVisible(true);
    }

}
