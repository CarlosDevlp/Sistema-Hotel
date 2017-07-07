/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 * GRUPO ALOJAMIENTO
 *
 * @author VAIO
 */
import assets.values.Constant;
import dao.BasicDao;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import vista.frmBuscarReserva;
import vista.frmAlojamiento;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Empleado;
import modelo.Usuario;
import vista.FrmReporteAlojamiento;

public class CtrAlojamiento {

    private DefaultTableModel modelo_detalle_reserva;
    private DefaultTableModel modelo_detalle_huesped;
    private DefaultTableModel modelo_detalle_alojamiento;

    public void Registrar_alojamiento() {

        Empleado empleadoActual=Usuario.getInstance().getEmpleado();
     
        String idEmpleado= empleadoActual.getIdPersona();
 
        String CodEmpleado = Usuario.getInstance().getCurrentSesion().getIdSesion();
     
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
        BasicDao.call("InsertarAlojamientoLog", new String[]{frmAlojamiento.txtidAlojamiento.getText(), "'"+Date_Format.format(frmAlojamiento.txtFechaLLegada.getDate())+"'",
                    "'"+Date_Format.format(frmAlojamiento.txtfechaSalida.getDate())+"'", frmAlojamiento.txtidReserva.getText(),idEmpleado,"'insert'","'Alojamiento'",CodEmpleado});
        
         BasicDao.call("ActualizarHabitacion", new String[]{frmAlojamiento.txtidReserva.getText(),"'insert'","'Alojamiento'",CodEmpleado});
         
         BasicDao.call("ActualizarReserva", new String[]{frmAlojamiento.txtidReserva.getText(),"'update'","'Alojamiento'",CodEmpleado});
              

        JOptionPane.showMessageDialog(null, "El registro se realizo satisfactoriamente");
        
        limpiar();
        Limpiar_Tabla_huesped_alojamiento();

    }

    public void Conusltar_Reserva() throws ParseException {

        ArrayList<Map<String, String>> CallReserva = BasicDao.call("ConsultarReserva", new String[]{frmAlojamiento.txtidReserva.getText()});

        Map<String, String> row1 = CallReserva.get(0);

        frmAlojamiento.txtTitular.setText(row1.get("FullNamePer"));
        id_Alojamiento();

        Calendar FInicio = Calendar.getInstance();
        SimpleDateFormat sdfv1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FInicio.setTime(sdfv1.parse(row1.get("FechaInicioRes")));

        Calendar FSalidaA = Calendar.getInstance();
        SimpleDateFormat sdfv2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FSalidaA.setTime(sdfv2.parse(row1.get("FechaFinalRes")));

        frmAlojamiento.txtFechaLLegada.setCalendar(FInicio);
        frmAlojamiento.txtfechaSalida.setCalendar(FSalidaA);

        int dias = frmAlojamiento.txtfechaSalida.getCalendar().get(Calendar.DAY_OF_MONTH)
                - frmAlojamiento.txtFechaLLegada.getCalendar().get(Calendar.DAY_OF_MONTH);

        frmAlojamiento.txtCantDias.setText(String.valueOf(dias));

        ArrayList<Map<String, String>> CallHuesped = BasicDao.call("ConsultarHuesped", new String[]{frmAlojamiento.txtidReserva.getText()});

        for (int s = 0; s < CallHuesped.size(); s++) {

            Map<String, String> row2 = CallHuesped.get(s);
            modelo_detalle_huesped.insertRow(s, new Object[]{});
            modelo_detalle_huesped.setValueAt(row2.get("idHSP"), s, 0);
            modelo_detalle_huesped.setValueAt(row2.get("NombreHue"), s, 1);
            modelo_detalle_huesped.setValueAt(row2.get("DNIHue"), s, 2);

        }

        habilitar();

    }

    private void id_Alojamiento() {

        if (BasicDao.isTableEmpty("Alojamiento")) {

            frmAlojamiento.txtidAlojamiento.setText("1");
        } else {

            Map<String, String> lastRowIdReserva = BasicDao.selectLastRow("Alojamiento", new String[]{"*"}, "idAlojamiento");

            int dato = Integer.parseInt(lastRowIdReserva.get("idAlojamiento"));
            frmAlojamiento.txtidAlojamiento.setText(String.valueOf(dato + 1));
        }
    }

    public void Enviar_Datos_Alojamiento() throws ParseException {

        String Id = String.valueOf(modelo_detalle_reserva.getValueAt(frmBuscarReserva.TB_Buscar_Reserva.getSelectedRow(), 0));
        String Nombre = String.valueOf(modelo_detalle_reserva.getValueAt(frmBuscarReserva.TB_Buscar_Reserva.getSelectedRow(), 1));
        String F_Reserva = String.valueOf(modelo_detalle_reserva.getValueAt(frmBuscarReserva.TB_Buscar_Reserva.getSelectedRow(), 5));
        String F_Salida = String.valueOf(modelo_detalle_reserva.getValueAt(frmBuscarReserva.TB_Buscar_Reserva.getSelectedRow(), 6));

        Calendar FReserva = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FReserva.setTime(sdf.parse(F_Reserva));

        Calendar FSalida = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FSalida.setTime(sdf1.parse(F_Salida));

        frmAlojamiento.txtidReserva.setText(Id);
        frmAlojamiento.txtTitular.setText(Nombre);
        frmAlojamiento.txtFechaLLegada.setCalendar(FReserva);
        frmAlojamiento.txtfechaSalida.setCalendar(FSalida);

        int dia = frmAlojamiento.txtfechaSalida.getCalendar().get(Calendar.DAY_OF_MONTH)
                - frmAlojamiento.txtFechaLLegada.getCalendar().get(Calendar.DAY_OF_MONTH);

        frmAlojamiento.txtCantDias.setText(String.valueOf(dia));

        id_Alojamiento();

    }

    public void Llenar_detalle_huesped_alojamiento() {

        String IdAReserva = String.valueOf(modelo_detalle_reserva.getValueAt(frmBuscarReserva.TB_Buscar_Reserva.getSelectedRow(), 0));
        
        ArrayList<Map<String, String>> CallHuesped = BasicDao.call("ConsultarHuesped", new String[]{IdAReserva});
  
        for (int e = 0; e < CallHuesped.size(); e++) {

            Map<String, String> row3 = CallHuesped.get(e);
            modelo_detalle_huesped.insertRow(e, new Object[]{});

            modelo_detalle_huesped.setValueAt(row3.get("idHSP"), e, 0);
            modelo_detalle_huesped.setValueAt(row3.get("NombreHue"), e, 1);
            modelo_detalle_huesped.setValueAt(row3.get("DNIHue"), e, 2);

        }

    }

    public void Buscar_Reserva_id() {

        ArrayList<Map<String, String>> CallReservaId = BasicDao.call("ConsultarReservaId", new String[]{frmBuscarReserva.txtDatosReserva.getText()});

        for (int i = 0; i < CallReservaId.size(); i++) {

            Map<String, String> row4 = CallReservaId.get(i);
            modelo_detalle_reserva.insertRow(i, new Object[]{});

            modelo_detalle_reserva.setValueAt(row4.get("idReserva"), i, 0);
            modelo_detalle_reserva.setValueAt(row4.get("FullNamePer"), i, 1);
            modelo_detalle_reserva.setValueAt(row4.get("RucDNIRSo"), i, 2);
            modelo_detalle_reserva.setValueAt(row4.get("TelefonoPer"), i, 3);
            modelo_detalle_reserva.setValueAt(row4.get("EstadoRes"), i, 4);
            modelo_detalle_reserva.setValueAt(row4.get("FechaInicioRes"), i, 5);
            modelo_detalle_reserva.setValueAt(row4.get("FechaFinalRes"), i, 6);

        }

    }

    public void Buscar_Reserva_Nombre_Cliente() {
        
        ArrayList<Map<String, String>> CallReservaNombre = BasicDao.call("ConsultarReservaNombre", new String[]{"'"+frmBuscarReserva.txtDatosReserva.getText().toString()+"'"});

        Map<String, String> row = CallReservaNombre.get(0);

        for (int i = 0; i < 1; i++) {

            modelo_detalle_reserva.insertRow(i, new Object[]{});

            modelo_detalle_reserva.setValueAt(row.get("idReserva"), i, 0);
            modelo_detalle_reserva.setValueAt(row.get("FullNamePer"), i, 1);
            modelo_detalle_reserva.setValueAt(row.get("RucDNIRSo"), i, 2);
            modelo_detalle_reserva.setValueAt(row.get("TelefonoPer"), i, 3);
            modelo_detalle_reserva.setValueAt(row.get("EstadoRes"), i, 4);
            modelo_detalle_reserva.setValueAt(row.get("FechaInicioRes"), i, 5);
            modelo_detalle_reserva.setValueAt(row.get("FechaFinalRes"), i, 6);

        }

    }

    /**
     * **************************************
     */
    public final void interfaz_busqueda_reserva() {

        String data[][] = {};
        String col[] = {"Codigo", "Nombre", "DNI", "Telefono", "Estado", "F.Reserva", "F.Salida"};
        modelo_detalle_reserva = new DefaultTableModel(data, col);
        frmBuscarReserva.TB_Buscar_Reserva.setModel(modelo_detalle_reserva);

    }

    public void tamaño_tabla_reserva() {

        frmBuscarReserva.TB_Buscar_Reserva.getColumnModel().getColumn(0).setPreferredWidth(30);
        frmBuscarReserva.TB_Buscar_Reserva.getColumnModel().getColumn(1).setPreferredWidth(30);
        frmBuscarReserva.TB_Buscar_Reserva.getColumnModel().getColumn(2).setPreferredWidth(200);
        frmBuscarReserva.TB_Buscar_Reserva.getColumnModel().getColumn(3).setPreferredWidth(80);
        frmBuscarReserva.TB_Buscar_Reserva.getColumnModel().getColumn(4).setPreferredWidth(50);
        frmBuscarReserva.TB_Buscar_Reserva.getColumnModel().getColumn(5).setPreferredWidth(50);
        frmBuscarReserva.TB_Buscar_Reserva.getColumnModel().getColumn(6).setPreferredWidth(50);

    }

    public void Limpiar_Tabla() {

        for (int i = 0; i < frmBuscarReserva.TB_Buscar_Reserva.getRowCount(); i++) {
            modelo_detalle_reserva.removeRow(i);
            i -= 1;
        }

    }


    
    /**
     * *********************************************************
     * @param idReserva
     * @return
     */
    /* public void idRExists(String idReserva){        
     ArrayList<Map<String,String>> result=BasicDao.select("reserva r",new String[]{"*"},"r.idReserva='"+idReserva+"'");
     boolean exists= result.size()>0;
     //si existe el usuario, de forma implícita, crear al usuario   
     if(!exists){
     JOptionPane.showMessageDialog(null, "No existe");
     }
     }
     */
    public void VCTextoIdR() {

        ArrayList<Map<String, String>> result = BasicDao.select("Reserva r", new String[]{"*"}, "r.idReserva='" + frmAlojamiento.txtidReserva.getText() + "'");
        
        boolean exists = result.size() > 0;

         if (exists) {
            frmAlojamiento.txtidReserva.setText("");
            frmAlojamiento.txtidReserva.requestFocus();
            JOptionPane.showMessageDialog(null, "No existe o ya esta ");
        }
    }
    


    public void VCTextoBIdR() {
        if (frmBuscarReserva.txtDatosReserva.getText().length() == 00) {
            JOptionPane.showMessageDialog(null, "Ingrese Nombre o Código");
            frmBuscarReserva.txtDatosReserva.requestFocus();
            return;
        }
    }

    //VERIFICAR ESTOS CODIGOS
    public void VSNumero(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void KeyType(KeyEvent evt) {
                char validar = evt.getKeyChar();
                if (!Character.isLetter(validar)) {
                } else {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Ingrese solo Números");
                }
            }
        });
    }

    public void inhabilitar() {
        frmAlojamiento.txtidAlojamiento.setEnabled(false);
        frmAlojamiento.txtCantDias.setEnabled(false);
        frmAlojamiento.txtCantDias.setEnabled(false);
        frmAlojamiento.txtFechaLLegada.setEnabled(false);
        frmAlojamiento.txtfechaSalida.setEnabled(false);
        frmAlojamiento.txtTitular.setEnabled(false);
        frmAlojamiento.idRegistrar_Alojamiento.setEnabled(false);
        frmAlojamiento.btnLimpiar.setEnabled(false);
    }

    public void habilitar() {
        frmAlojamiento.txtFechaLLegada.setEnabled(true);
        frmAlojamiento.txtfechaSalida.setEnabled(true);
        frmAlojamiento.btnLimpiar.setEnabled(true);
        frmAlojamiento.idRegistrar_Alojamiento.setEnabled(true);

    }

    public void limpiar() {
        frmAlojamiento.txtidReserva.setText("");
        frmAlojamiento.txtCantDias.setText("");
        frmAlojamiento.txtTitular.setText("");
        frmAlojamiento.txtidAlojamiento.setText("");
        frmAlojamiento.txtFechaLLegada.setCalendar(null);
        frmAlojamiento.txtfechaSalida.setCalendar(null);
    }

    public final void interfaz_detalle_huesped_alojamiento() {

        String data[][] = {};
        String col[] = {"Codigo", "Nombre", "DNI"};
        modelo_detalle_huesped = new DefaultTableModel(data, col);
        frmAlojamiento.TB_Detalle_Huesped.setModel(modelo_detalle_huesped);

    }

    public void tamaño_tabla_huesped_alojamiento() {

        frmAlojamiento.TB_Detalle_Huesped.getColumnModel().getColumn(0).setPreferredWidth(30);
        frmAlojamiento.TB_Detalle_Huesped.getColumnModel().getColumn(1).setPreferredWidth(200);
        frmAlojamiento.TB_Detalle_Huesped.getColumnModel().getColumn(2).setPreferredWidth(50);

    }

    public void Limpiar_Tabla_huesped_alojamiento() {

        for (int i = 0; i < frmAlojamiento.TB_Detalle_Huesped.getRowCount(); i++) {
            modelo_detalle_huesped.removeRow(i);
            i -= 1;
        }

    }

    public void Cambio_de_fecha_llegada() {

        frmAlojamiento.txtFechaLLegada.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if (frmAlojamiento.txtfechaSalida.getDate() != null && frmAlojamiento.txtFechaLLegada.getDate() != null) {

                    Calendar c = Calendar.getInstance();

                    c.setTimeInMillis(
                            frmAlojamiento.txtfechaSalida.getCalendar().getTime().getTime() - frmAlojamiento.txtFechaLLegada.getCalendar().getTime().getTime());
                    frmAlojamiento.txtCantDias.setText(String.valueOf(c.get(Calendar.DAY_OF_YEAR)));

                }

            }

        });

    }

    public void Cambio_de_fecha_salida() {

        frmAlojamiento.txtfechaSalida.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if (frmAlojamiento.txtfechaSalida.getDate() != null && frmAlojamiento.txtFechaLLegada.getDate() != null) {

                    Calendar c = Calendar.getInstance();

                    c.setTimeInMillis(
                            frmAlojamiento.txtfechaSalida.getCalendar().getTime().getTime() - frmAlojamiento.txtFechaLLegada.getCalendar().getTime().getTime());

                    frmAlojamiento.txtCantDias.setText(String.valueOf(c.get(Calendar.DAY_OF_YEAR)));

                }

            }

        });

    }

    /*------------REPORTE------------*/
    public void Reporte_Alojamiento() {

        FrmReporteAlojamiento.txtFecInicAloReport.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {

                for (int i = 0; i < FrmReporteAlojamiento.TB_Reporte_Alojamiento.getRowCount(); i++) {
                    modelo_detalle_alojamiento.removeRow(i);
                    i -= 1;
                }

                if (FrmReporteAlojamiento.txtFecInicAloReport.getDate() != null && FrmReporteAlojamiento.txtFecFinAloReport.getDate() != null) {

                    Calendar c = Calendar.getInstance();
                    c.setTime(FrmReporteAlojamiento.txtFecInicAloReport.getCalendar().getTime());
                    Calendar r = Calendar.getInstance();
                    r.setTime(FrmReporteAlojamiento.txtFecFinAloReport.getCalendar().getTime());

                    String fechainicio = (String.valueOf(c.get(Calendar.YEAR)) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE));
                    String fechafin = (String.valueOf(r.get(Calendar.YEAR)) + "-" + (r.get(Calendar.MONTH) + 1) + "-" + r.get(Calendar.DATE));

                    
                    ArrayList<Map<String, String>> CallReporte = BasicDao.call("ListarPorFecha", new String[]{"'"+fechainicio+"'","'"+fechafin+"'"});
 
                    for (int i = 0; i < CallReporte.size(); i++) {

                        Map<String, String> row = CallReporte.get(i);
                        modelo_detalle_alojamiento.insertRow(i, new Object[]{});

                        modelo_detalle_alojamiento.setValueAt(row.get("idAlojamiento"), i, 0);
                        modelo_detalle_alojamiento.setValueAt(row.get("FechaInicioAlo"), i, 1);
                        modelo_detalle_alojamiento.setValueAt(row.get("FechaFinalAlo"), i, 2);

                    }

                }

            }

        });

        FrmReporteAlojamiento.txtFecFinAloReport.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {

                for (int i = 0; i < FrmReporteAlojamiento.TB_Reporte_Alojamiento.getRowCount(); i++) {
                    modelo_detalle_alojamiento.removeRow(i);
                    i -= 1;
                }

                if (FrmReporteAlojamiento.txtFecInicAloReport.getDate() != null && FrmReporteAlojamiento.txtFecFinAloReport.getDate() != null) {

                    Calendar c = Calendar.getInstance();
                    c.setTime(FrmReporteAlojamiento.txtFecInicAloReport.getCalendar().getTime());
                    Calendar r = Calendar.getInstance();
                    r.setTime(FrmReporteAlojamiento.txtFecFinAloReport.getCalendar().getTime());

                    String fechainicio = (String.valueOf(c.get(Calendar.YEAR)) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE));
                    String fechafin = (String.valueOf(r.get(Calendar.YEAR)) + "-" + (r.get(Calendar.MONTH) + 1) + "-" + r.get(Calendar.DATE));

                    
                    ArrayList<Map<String, String>> CallReporte = BasicDao.call("ListarPorFecha", new String[]{"'"+fechainicio+"'","'"+fechafin+"'"});
                    
                    
                    for (int i = 0; i < CallReporte.size(); i++) {

                        Map<String, String> row = CallReporte.get(i);
                        modelo_detalle_alojamiento.insertRow(i, new Object[]{});

                        modelo_detalle_alojamiento.setValueAt(row.get("idAlojamiento"), i, 0);
                        modelo_detalle_alojamiento.setValueAt(row.get("FechaInicioAlo"), i, 1);
                        modelo_detalle_alojamiento.setValueAt(row.get("FechaFinalAlo"), i, 2);

                    }

                }

            }

        });

    }

    public final void interfaz_detalle_alojamiento() {

        String data[][] = {};
        String col[] = {"Codigo", "Fecha Inicio Alojamiento", "Fecha Final Alojamiento"};
        modelo_detalle_alojamiento = new DefaultTableModel(data, col);
        FrmReporteAlojamiento.TB_Reporte_Alojamiento.setModel(modelo_detalle_alojamiento);

    }

    public void tamaño_tabla_alojamiento() {

        FrmReporteAlojamiento.TB_Reporte_Alojamiento.getColumnModel().getColumn(0).setPreferredWidth(30);
        FrmReporteAlojamiento.TB_Reporte_Alojamiento.getColumnModel().getColumn(1).setPreferredWidth(200);
        FrmReporteAlojamiento.TB_Reporte_Alojamiento.getColumnModel().getColumn(2).setPreferredWidth(50);

    }


}
