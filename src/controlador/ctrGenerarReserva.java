/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ctrBuscarCliente.activo;
import modelo.mdlBuscarCliente;
import modelo.mdlGenerarReserva;
import vista.frmBuscarCliente;
import vista.frmBuscarHabitacion;
import vista.frmBuscarHuesped;
import vista.frmGenerarReserva;
import vista.FrmMain;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrGenerarReserva {

    //vistas
    private FrmMain principal;
    private frmGenerarReserva vistaGenerarReserva;
    
    private frmBuscarCliente vistaBuscarCliente;
    private frmBuscarHabitacion vistaBuscarHabitacion;
    //variable
    public static boolean activo = false;
    public static boolean estado = false;

    //modelo
    private mdlGenerarReserva unmdlGenerarReserva;
    private mdlBuscarCliente unmdlBuscarCliente;
    // private Persona persona;

    //controladores
    private ctrBuscarCliente unctrBuscarCliente;
    private ctrRegistarCliente unctrRegistrarCliente;
    private ctrBuscarHabitacion unctrBuscarHabitacion;
    private ctrBuscarHuesped unctrBuscarHuesped;
    private ctrRegistrarHuesped unctrRegistarHuesped;

    //variable global
    double coti = 0.00;
    String lleg = "";
    String sal = "";
    String cd = "";

    public ctrGenerarReserva(FrmMain principal) {
        this.principal = principal;
        //mostra datos del formulario buscar cliente
    }

    public void mantenerGUIreserva() {
        activo = true;

        if (vistaGenerarReserva == null) {
            vistaGenerarReserva = new frmGenerarReserva();

        }
        if (unmdlGenerarReserva == null) {
            unmdlGenerarReserva = new mdlGenerarReserva();
        }
        vistaGenerarReserva.setDefaultCloseOperation(0);
        //vistaGenerarReserva.setUndecorated(true);
        //vistaGenerarReserva.getRootPane().setWindowDecorationStyle(0);

        vistaGenerarReserva.setLocationRelativeTo(principal);
        vistaGenerarReserva.setAlwaysOnTop(true);
        vistaGenerarReserva.txtCantHabit.setText("0");
        vistaGenerarReserva.txtCotizacion.setText("0");
        vistaGenerarReserva.jdcLlegada.setDate(new Date());
        vistaGenerarReserva.jdcSalida.setDate(vistaGenerarReserva.setMinSal());

        vistaGenerarReserva.jdcLlegada.setMinSelectableDate(new Date());
        vistaGenerarReserva.jdcSalida.setMinSelectableDate(vistaGenerarReserva.setMinSal());
        vistaGenerarReserva.jdcSalida.setMaxSelectableDate(vistaGenerarReserva.setMaxDate());
        vistaGenerarReserva.contarDias();
        vistaGenerarReserva.txtFechaReserva.setText("  " + vistaGenerarReserva.fechaActual2(new Date()));
        vistaGenerarReserva.txtCodEmpleado.setText("1");

        final JTextFieldDateEditor llegada = (JTextFieldDateEditor) vistaGenerarReserva.jdcLlegada.getDateEditor();
        final JTextFieldDateEditor salida = (JTextFieldDateEditor) vistaGenerarReserva.jdcSalida.getDateEditor();
        llegada.setEditable(false);
        salida.setEditable(false);

        //boton Buscar Cliente
        vistaGenerarReserva.addBuscarCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unctrBuscarCliente == null) {
                    unctrBuscarCliente = new ctrBuscarCliente(principal);
                }
                if (unctrBuscarCliente.activo == false) {
                    unctrBuscarCliente.mantenerGUIbuscar();
                }
            }
        });

        //boton nuevo cliente
        vistaGenerarReserva.addNuevoCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unctrRegistrarCliente == null) {
                    unctrRegistrarCliente = new ctrRegistarCliente(principal);

                }
                if (unctrRegistrarCliente.activo == false) {
                    unctrRegistrarCliente.mantenerGUIregistrar();
                }
            }
        });
        // boton buscar Habitacion
        vistaGenerarReserva.addBuscarHabitacion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unctrBuscarHabitacion == null) {
                    unctrBuscarHabitacion = new ctrBuscarHabitacion(principal);
                }
                if (unctrBuscarHabitacion.activo == false) {
                    unctrBuscarHabitacion.mantenerGUIbuscarHabitacion();
                }
                vistaBuscarHabitacion.txtFechaLlegada.setText("  " + vistaGenerarReserva.fechaActual2(vistaGenerarReserva.jdcLlegada.getDate()));
                vistaBuscarHabitacion.txtFechaSalida.setText("  " + vistaGenerarReserva.fechaActual2(vistaGenerarReserva.jdcSalida.getDate()));
            }
        });
        //boton buscar Huesped
        vistaGenerarReserva.addBuscarHuesped(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unctrBuscarHuesped == null) {
                    unctrBuscarHuesped = new ctrBuscarHuesped(principal);

                }
                if (unctrBuscarHuesped.activo == false) {
                    unctrBuscarHuesped.mantenerGUIbuscarHuesped();
                }
            }
        });
        //boton nuevo Huesped
        vistaGenerarReserva.addRegistrarHuesped(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unctrRegistarHuesped == null) {
                    unctrRegistarHuesped = new ctrRegistrarHuesped(principal);
                }
                if (unctrRegistarHuesped.activo == false) {
                    unctrRegistarHuesped.mantenerGUIbuscarHuesped();
                }
            }
        });

        vistaGenerarReserva.addPropertyChangeLlegada(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                vistaGenerarReserva.contarDias();
                vistaGenerarReserva.jdcSalida.setDate(vistaGenerarReserva.setMinSal());
                vistaGenerarReserva.jdcSalida.setMinSelectableDate(vistaGenerarReserva.setMinSal());
            }

        });
        vistaGenerarReserva.addPropertyChangeSalida(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                vistaGenerarReserva.contarDias();
            }

        });

        vistaGenerarReserva.addALbtnAgregar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sección 1
                DefaultTableModel modelo = (DefaultTableModel) vistaGenerarReserva.tblDetalleReserva.getModel();

                //Sección 2
                Object[] fila = new Object[7];

                //Sección 3
                String nomcli = vistaGenerarReserva.txtNomCliente.getText();
                String codhab = vistaGenerarReserva.txtCodHab.getText();
                String codhue = vistaGenerarReserva.txtCodHuesped.getText();
                String coshab = vistaGenerarReserva.txtCostoHab.getText();
                String cantdi = vistaGenerarReserva.txtCantDias.getText();
                String fllega = vistaGenerarReserva.fechaActual2(vistaGenerarReserva.jdcLlegada.getDate());
                String fsalid = vistaGenerarReserva.fechaActual2(vistaGenerarReserva.jdcSalida.getDate());

                fila[0] = nomcli;
                fila[1] = codhab;
                fila[2] = codhue;
                fila[3] = coshab;
                fila[4] = cantdi;
                fila[5] = fllega;
                fila[6] = fsalid;

                if (!nomcli.equals("") && !codhab.equals("") && !codhue.equals("") && !coshab.equals("") && !coshab.equals("") && !cantdi.equals("") && !fllega.equals("") && !fsalid.equals("")) {
                    //Sección 4
                    modelo.addRow(fila);
                    int row = modelo.getRowCount();
                    double multi = 0.00;
                    for (int i = 0; i < row; i++) {
                        multi = Double.parseDouble(String.valueOf(modelo.getValueAt(i, 3))) * Double.parseDouble(String.valueOf(modelo.getValueAt(i, 4)));

                    }
                    coti += multi;
                    //Sección 5
                    vistaGenerarReserva.tblDetalleReserva.setModel(modelo);
                    try {
                        unmdlGenerarReserva.ActualizarEstadoReserva_EnLista(codhab);
                    } catch (Exception ex) {
                        Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Sección 6
                    vistaGenerarReserva.txtCodHab.setText("");
                    vistaGenerarReserva.txtTipoHab.setText("");
                    vistaGenerarReserva.txtCostoHab.setText("");
                    vistaGenerarReserva.txtCodHuesped.setText("");
                    vistaGenerarReserva.txtNomHuesped.setText("");
                    vistaGenerarReserva.txtDniHuesped.setText("");
                    vistaGenerarReserva.txtCantHabit.setText(String.valueOf(row));

                    String cotis = String.valueOf(coti);
                    vistaGenerarReserva.txtCotizacion.setText(cotis);
                    vistaGenerarReserva.btnBuscarCliente.setEnabled(false);
                    vistaGenerarReserva.btnNuevoCliente.setEnabled(false);
                    vistaGenerarReserva.txtCodCliente.setEnabled(false);
                    vistaGenerarReserva.txtNomCliente.setEnabled(false);
                    vistaGenerarReserva.txtDocCliente.setEnabled(false);
                    vistaGenerarReserva.txtCantDias.setEnabled(false);
                    vistaGenerarReserva.btnNuevoCliente.setEnabled(false);

                    vistaGenerarReserva.jdcLlegada.setEnabled(false);
                    vistaGenerarReserva.jdcSalida.setEnabled(false);

                    cd = String.valueOf(modelo.getValueAt(0, 4));
                    sal = String.valueOf(modelo.getValueAt(0, 6));
                    lleg = String.valueOf(modelo.getValueAt(0, 5));

                    llegada.setText(lleg);
                    salida.setText(sal);
                    vistaGenerarReserva.txtCantDias.setText(cd);

                } else {
                    JOptionPane.showMessageDialog(vistaGenerarReserva, "Debe llenar todos los campos");
                }
            }
        });

        vistaGenerarReserva.addALbtnQuitar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sección 1
                DefaultTableModel modelo = (DefaultTableModel) vistaGenerarReserva.tblDetalleReserva.getModel();

                //Sección 2
                int a = vistaGenerarReserva.tblDetalleReserva.getSelectedRow();

                //Sección 3
                if (a < 0) {

                    JOptionPane.showMessageDialog(vistaGenerarReserva,
                                        "Debe seleccionar una fila de la tabla");

                } else {
                    //Sección 4
                    int confirmar = JOptionPane.showConfirmDialog(vistaGenerarReserva,
                                        "Esta seguro que desea Eliminar el registro? ");

                    //Sección 5
                    if (JOptionPane.OK_OPTION == confirmar) {
                        try {
                            unmdlGenerarReserva.ActualizarEstadoReserva_Libre(String.valueOf(modelo.getValueAt(a, 1)));
                        } catch (Exception ex) {
                            Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        int row = modelo.getRowCount();
                        double multi = 0.00;
                        for (int i = 0; i < row; i++) {
                            if (a == i) {

                                multi = Double.parseDouble(String.valueOf(modelo.getValueAt(a, 3))) * Double.parseDouble(String.valueOf(modelo.getValueAt(a, 4)));
                                break;
                            } else {
                                continue;
                            }
                        }

                        JOptionPane.showMessageDialog(vistaGenerarReserva, "Registro Eliminado");

                        modelo.removeRow(a);

                        int row2 = modelo.getRowCount();
                        if (row2 == 0) {
                            vistaGenerarReserva.btnBuscarCliente.setEnabled(true);
                            vistaGenerarReserva.btnNuevoCliente.setEnabled(true);
                            vistaGenerarReserva.txtCodCliente.setEnabled(true);
                            vistaGenerarReserva.txtNomCliente.setEnabled(true);
                            vistaGenerarReserva.txtDocCliente.setEnabled(true);
                            vistaGenerarReserva.txtCantDias.setEnabled(true);
                            vistaGenerarReserva.btnNuevoCliente.setEnabled(true);
                            vistaGenerarReserva.jdcLlegada.setEnabled(true);
                            vistaGenerarReserva.jdcSalida.setEnabled(true);
                            salida.setText(sal);
                            vistaGenerarReserva.txtCantDias.setText(cd);
                        }
                        coti -= multi;

                        vistaGenerarReserva.txtCantHabit.setText(String.valueOf(row2));
                        String cotis = String.valueOf(coti);
                        vistaGenerarReserva.txtCotizacion.setText(cotis);
                    }
                }
            }
        });

        vistaGenerarReserva.addALbtnCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmar = JOptionPane.showConfirmDialog(vistaGenerarReserva, "Esta seguro que desea salir del registro? ");

                if (JOptionPane.OK_OPTION == confirmar) {
                    DefaultTableModel modelo = (DefaultTableModel) vistaGenerarReserva.tblDetalleReserva.getModel();
                    int row = modelo.getRowCount();
                    for (int i = 0; i < row; i++) {
                        try {
                            unmdlGenerarReserva.ActualizarEstadoReserva_Libre(String.valueOf(modelo.getValueAt(i, 1)));
                        } catch (Exception ex) {
                            Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    activo = false;
                    //Oculto y destruyo el panel
                    vistaGenerarReserva.setVisible(false);
                    vistaGenerarReserva = null;

                }

            }
        });

        vistaGenerarReserva.addALbtnGrabarReserva(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel modelo = (DefaultTableModel) vistaGenerarReserva.tblDetalleReserva.getModel();
                int row = modelo.getRowCount();

                if (row > 0) {
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(vistaGenerarReserva, "Esta seguro que desea grabar la RESERVA? ")) {
                        try {
                            String feclle = vistaGenerarReserva.fechaActual3(vistaGenerarReserva.jdcLlegada.getDate());
                            String fecsal = vistaGenerarReserva.fechaActual3(vistaGenerarReserva.jdcSalida.getDate());
                            String canhab = vistaGenerarReserva.txtCantHabit.getText();
                            String estado = "RESERVADO";
                            String codcli = vistaGenerarReserva.txtCodCliente.getText();
                            String fecres = vistaGenerarReserva.fechaActual3(new Date());
                            String cotiza = vistaGenerarReserva.txtCotizacion.getText();
                            String emplea = vistaGenerarReserva.txtCodEmpleado.getText();

                            //unmdlGenerarReserva.InsertarDatosReserva(feclle, fecsal, canhab, estado, codcli, fecres, cotiza, emplea);
                            try {
                                if (unmdlGenerarReserva.InsertarDatosReserva(feclle, fecsal, canhab, estado, codcli, fecres, cotiza, emplea)) {
                                    for (int i = 0; i < row; i++) {
                                        String codhab = String.valueOf(modelo.getValueAt(i, 1));
                                        String codhue = String.valueOf(modelo.getValueAt(i, 2));
                                        unmdlGenerarReserva.InsertarDatosDetalleReserva(codhab, codhue);
                                        unmdlGenerarReserva.ActualizarEstadoReserva_Reservado(codhab);

                                    }
                                }
                                vistaGenerarReserva.btnBuscarCliente.setEnabled(true);
                                vistaGenerarReserva.btnNuevoCliente.setEnabled(true);
                                vistaGenerarReserva.txtCodCliente.setEnabled(true);
                                vistaGenerarReserva.txtNomCliente.setEnabled(true);
                                vistaGenerarReserva.txtDocCliente.setEnabled(true);
                                vistaGenerarReserva.txtCantDias.setEnabled(true);
                                vistaGenerarReserva.btnNuevoCliente.setEnabled(true);
                                vistaGenerarReserva.jdcLlegada.setEnabled(true);
                                vistaGenerarReserva.jdcSalida.setEnabled(true);
                                coti = 0;
                                vistaGenerarReserva.txtCodCliente.setText("");
                                vistaGenerarReserva.txtNomCliente.setText("");
                                vistaGenerarReserva.txtDocCliente.setText("");
                                vistaGenerarReserva.txtCodHab.setText("");
                                vistaGenerarReserva.txtTipoHab.setText("");
                                vistaGenerarReserva.txtCostoHab.setText("");
                                vistaGenerarReserva.txtCodHuesped.setText("");
                                vistaGenerarReserva.txtDniHuesped.setText("");
                                vistaGenerarReserva.txtCotizacion.setText("0");
                                vistaGenerarReserva.txtCantHabit.setText("0");
                                vistaBuscarHabitacion.txtFechaLlegada.setText("  " + vistaGenerarReserva.fechaActual2(vistaGenerarReserva.jdcLlegada.getDate()));

                                for (int i = 0; i < row; i++) {
                                    modelo.removeRow(0);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(vistaGenerarReserva, "Codigo Reserva Generado: " + (unmdlGenerarReserva.BuscarCodigoReserva()));
                        } catch (Exception ex) {
                            Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaGenerarReserva, "Error: Campos vacios");
                }
            }
        });

        //mostrar formulario interno
        vistaGenerarReserva.setVisible(true);

        //mostar el formulario princial
        principal.setVisible(true);

    }

    public void showGenerarReserva(){
        vistaGenerarReserva.setVisible(true);
    }
    
    
    public frmGenerarReserva getVistaGenerarReserva() {
        return vistaGenerarReserva;
    }

    public void setVistaGenerarReserva(frmGenerarReserva vistaGenerarReserva) {
        this.vistaGenerarReserva = vistaGenerarReserva;        
    }
}
