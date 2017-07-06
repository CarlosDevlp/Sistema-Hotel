/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.toedter.calendar.JTextFieldDateEditor;
import modelo.Reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import modelo.DetalleReserva;
import modelo.Habitacion;
import vista.frmGenerarReserva;
import vista.*;
/**
 *
 * @author Propietario
 */
public class ctrGenerarReserva implements ActionListener{
    
    private frmGenerarReserva vistaGenerarReserva;
    private frmBuscarHabitacion vistaBuscarHabitacion;
    
    private ctrBuscarHuesped mCtrBuscarHuesped;
    private ctrBuscarHabitacion mCtrBuscarHabitacion;
    private ctrBuscarCliente mCtrBuscarCliente;
    private CtrRegistrarCliente mCtrRegistrarCliente;
    private ctrRegistrarHuesped mCtrRegistrarHuesped;
    
    public DefaultTableModel modelo; 
    public static boolean activo=false;
    int row=0;
    int cont=0;
    double coti=0.00;
    String lleg="";
    String sal="";
    String cd="";
    
    public ctrGenerarReserva() {
        this(new frmGenerarReserva());
    }
    public ctrGenerarReserva(frmGenerarReserva mfrmGenerarReserva) {
        this.vistaGenerarReserva = mfrmGenerarReserva;
        this.vistaGenerarReserva.btnGrabarReserva.addActionListener(this);
        this.vistaGenerarReserva.btnBuscarHuesped.addActionListener(this);
        this.vistaGenerarReserva.btnBuscarCliente.addActionListener(this);
        this.vistaGenerarReserva.btnBuscarHabitacion.addActionListener(this);
        this.vistaGenerarReserva.btnNuevoHuesped.addActionListener(this);
        this.vistaGenerarReserva.btnNuevoCliente.addActionListener(this);
        this.vistaGenerarReserva.btnCancelar.addActionListener(this);
    }
     public void loadData() {
        
        Reserva reserva=new Reserva(); 
        this.vistaGenerarReserva.txtCantHabit.setText("0");
        this.vistaGenerarReserva.txtCotizacion.setText("0");
        this.vistaGenerarReserva.jdcLlegada.setDate(new Date());
        this.vistaGenerarReserva.jdcSalida.setDate(setMinSal());

        this.vistaGenerarReserva.jdcLlegada.setMinSelectableDate(new Date());
        this.vistaGenerarReserva.jdcSalida.setMinSelectableDate(setMinSal());
        this.vistaGenerarReserva.jdcSalida.setMaxSelectableDate(setMaxDate());
        this.vistaGenerarReserva.txtCantDias.setText(contarDias());
        this.vistaGenerarReserva.txtFechaReserva.setText("  " +fechaActual2(new Date()));
        this.vistaGenerarReserva.txtCodEmpleado.setText(reserva.getIdPersonaEmpleado());

        final JTextFieldDateEditor llegada = (JTextFieldDateEditor) this.vistaGenerarReserva.jdcLlegada.getDateEditor();
        final JTextFieldDateEditor salida  = (JTextFieldDateEditor) this.vistaGenerarReserva.jdcSalida.getDateEditor();
        llegada.setEditable(false);
        salida.setEditable(false);
        
        modelo = (DefaultTableModel) vistaGenerarReserva.tblDetalleReserva.getModel();
        
        vistaGenerarReserva.addPropertyChangeLlegada(new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                vistaGenerarReserva.jdcSalida.setDate(setMinSal());
                vistaGenerarReserva.jdcSalida.setMinSelectableDate(setMinSal());
                vistaGenerarReserva.txtCantDias.setText(contarDias());
            }
        });
        vistaGenerarReserva.addPropertyChangeSalida(new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                vistaGenerarReserva.txtCantDias.setText(contarDias());
            }
        });
        
        vistaGenerarReserva.addALbtnAgregar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            
            Object [] fila=new Object[7]; 
            
            String nomcli = vistaGenerarReserva.txtNomCliente.getText();
            String codhab = vistaGenerarReserva.txtCodHab.getText();
            String codhue = vistaGenerarReserva.txtCodHuesped.getText(); 
            String coshab = vistaGenerarReserva.txtCostoHab.getText();
            String cantdi = vistaGenerarReserva.txtCantDias.getText();
            String fllega = fechaActual2(vistaGenerarReserva.jdcLlegada.getDate());
            String fsalid = fechaActual2(vistaGenerarReserva.jdcSalida.getDate());

            fila[0]=nomcli;
            fila[1]=codhab;
            fila[2]=codhue; 
            fila[3]=coshab;
            fila[4]=cantdi;
            fila[5]=fllega;
            fila[6]=fsalid;
   
            if(!nomcli.equals("") && !codhab.equals("") && !codhue.equals("") && !coshab.equals("") && !coshab.equals("") && !cantdi.equals("") && !fllega.equals("") && !fsalid.equals("")){
                
                modelo.addRow(fila); 
                row = modelo.getRowCount();
                double multi = 0.00;
                for(int i=0;i<row;i++){
                    multi=Double.parseDouble(String.valueOf(modelo.getValueAt(i,3)))*Double.parseDouble(String.valueOf(modelo.getValueAt(i,4)));
                }
                
                coti+=multi;
                vistaGenerarReserva.tblDetalleReserva.setModel(modelo); 
                Habitacion habitacion=new Habitacion();
                habitacion.updateEstadoHabitacion(codhab,"EN LISTA");
             
                if((Integer)vistaGenerarReserva.jspCantHuesped.getValue()==1){
                    
                    vistaGenerarReserva.txtCodHab.setText(""); 
                    vistaGenerarReserva.txtTipoHab.setText(""); 
                    vistaGenerarReserva.txtCostoHab.setText("");
                }
                else{
                    vistaGenerarReserva.txtCodHab.setEnabled(false);
                    vistaGenerarReserva.btnBuscarHabitacion.setEnabled(false);
                    vistaGenerarReserva.txtTipoHab.setEnabled(false);
                    vistaGenerarReserva.txtCostoHab.setEnabled(false);
                    vistaGenerarReserva.jspCantHuesped.setEnabled(false);
                    cont++;
                }
                if(cont%2==0){
                    vistaGenerarReserva.txtCodHab.setEnabled(true);
                    vistaGenerarReserva.btnBuscarHabitacion.setEnabled(true);
                    vistaGenerarReserva.txtTipoHab.setEnabled(true);
                    vistaGenerarReserva.txtCostoHab.setEnabled(true);
                    vistaGenerarReserva.jspCantHuesped.setEnabled(true);
                    
                    vistaGenerarReserva.txtCodHab.setText(""); 
                    vistaGenerarReserva.txtTipoHab.setText(""); 
                    vistaGenerarReserva.txtCostoHab.setText("");
                    vistaGenerarReserva.jspCantHuesped.setValue((Integer)1);
                }
                
                vistaGenerarReserva.txtCodHuesped.setText("");
                vistaGenerarReserva.txtNomHuesped.setText("");
                vistaGenerarReserva.txtDniHuesped.setText("");
                
                vistaGenerarReserva.btnBuscarCliente.setEnabled(false);
                vistaGenerarReserva.btnNuevoCliente.setEnabled(false);
                vistaGenerarReserva.txtCodCliente.setEnabled(false);
                vistaGenerarReserva.txtNomCliente.setEnabled(false);
                vistaGenerarReserva.txtDocCliente.setEnabled(false);
                vistaGenerarReserva.txtCantDias.setEnabled(false);
                vistaGenerarReserva.btnNuevoCliente.setEnabled(false);
                vistaGenerarReserva.jdcLlegada.setEnabled(false);
                vistaGenerarReserva.jdcSalida.setEnabled(false);
                    
                vistaGenerarReserva.txtCantHabit.setText(String.valueOf(row));
                vistaGenerarReserva.txtCotizacion.setText(String.valueOf(coti));
                
                cd=String.valueOf(modelo.getValueAt(0,4));
                sal=String.valueOf(modelo.getValueAt(0,6));
                lleg=String.valueOf(modelo.getValueAt(0,5));

                llegada.setText(lleg);
                salida.setText(sal);
                vistaGenerarReserva.txtCantDias.setText(cd);
                
                ctrBuscarHuesped.rowhues = modelo.getRowCount();
                for(int i=0;i<ctrBuscarHuesped.rowhues;i++){
                    ctrBuscarHuesped.idhues[i]=String.valueOf(modelo.getValueAt(i,2));
                }
                
                }else{
                    JOptionPane.showMessageDialog(vistaGenerarReserva,"Debe llenar todos los campos");
                }
            }
        });
        
        vistaGenerarReserva.addALbtnQuitar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                int a = vistaGenerarReserva.tblDetalleReserva.getSelectedRow(); 

                if (a<0){ 
                    
                    JOptionPane.showMessageDialog(vistaGenerarReserva,"Debe seleccionar una fila de la tabla" ); 
                    
                }else {
                    
                    int confirmar=JOptionPane.showConfirmDialog(vistaGenerarReserva,"Esta seguro que desea Eliminar el registro? "); 

                    if(JOptionPane.OK_OPTION==confirmar){
                        
                        Habitacion habitacion=new Habitacion();
                        habitacion.updateEstadoHabitacion(String.valueOf(modelo.getValueAt(a,1)),"DISPONIBLE");
                        
                        row = modelo.getRowCount();
                        double multi = 0.00;
                        for(int i=0;i<row;i++){
                            if(a==i){
                                multi=Double.parseDouble(String.valueOf(modelo.getValueAt(a,3)))*Double.parseDouble(String.valueOf(modelo.getValueAt(a,4)));break;
                            }
                            else continue;
                        }

                        JOptionPane.showMessageDialog(vistaGenerarReserva,"Registro Eliminado" );

                        modelo.removeRow(a);
                        row = modelo.getRowCount();
                        
                        if(row==0){
                            vistaGenerarReserva.btnBuscarCliente.setEnabled(true);
                            vistaGenerarReserva.btnNuevoCliente.setEnabled(true);
                            vistaGenerarReserva.txtCodCliente.setEnabled(true);
                            vistaGenerarReserva.txtNomCliente.setEnabled(true);
                            vistaGenerarReserva.txtDocCliente.setEnabled(true);
                            vistaGenerarReserva.txtCantDias.setEnabled(true);
                            vistaGenerarReserva.btnNuevoCliente.setEnabled(true);
                            vistaGenerarReserva.jdcLlegada.setEnabled(true);
                            vistaGenerarReserva.jdcSalida.setEnabled(true);
                            vistaGenerarReserva.txtCodHab.setEnabled(true);
                            vistaGenerarReserva.txtTipoHab.setEnabled(true);
                            vistaGenerarReserva.txtCostoHab.setEnabled(true);
                            vistaGenerarReserva.jspCantHuesped.setEnabled(true);
                            vistaGenerarReserva.btnBuscarHabitacion.setEnabled(true);
                            
                            vistaGenerarReserva.txtCodHab.setText("");
                            vistaGenerarReserva.txtTipoHab.setText("");
                            vistaGenerarReserva.txtCostoHab.setText("");
                            vistaGenerarReserva.txtCodHuesped.setText("");
                            vistaGenerarReserva.txtNomHuesped.setText("");
                            vistaGenerarReserva.txtDniHuesped.setText("");
                            vistaGenerarReserva.jspCantHuesped.setValue((Integer)1);
                            
                            cont=0;
                            salida.setText(sal);
                            vistaGenerarReserva.txtCantDias.setText(cd);
                        }
                        coti-=multi;

                        vistaGenerarReserva.txtCantHabit.setText(String.valueOf(row));
                        String cotis=String.valueOf(coti);
                        vistaGenerarReserva.txtCotizacion.setText(cotis);
                        
                        ctrBuscarHuesped.rowhues = modelo.getRowCount();
                        for(int i=0;i<ctrBuscarHuesped.rowhues;i++){
                            ctrBuscarHuesped.idhues[i]=String.valueOf(modelo.getValueAt(i,2));
                        }
                        
                    }
                }
            }    
        });
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JComponent obj=(JComponent) e.getSource();
        
        switch(obj.getName()){
            
            case "btnBuscarCliente":
                if(activo==false){
                    mCtrBuscarCliente = new ctrBuscarCliente();
                    mCtrBuscarCliente.showFrmBuscarCliente();
                    mCtrBuscarCliente.loadData();
                    //mandar una interfaz que el caso de uso incluído (buscar cliente)
                    //ejecutará cuando se complete la búsqueda de un cliente
                    
                        mCtrBuscarCliente.setOnCompletedSearch(new Callback<String>(){
                            /*
                             *el parámetro "string[] cliente " devuelve los datos que el 
                             *caso de uso buscar cliente quiere enviarme cuando termine de realizar su tarea.
                             */
                            @Override
                            public void execute(String[] cliente) {
                                if(cliente!=null){    
                                    //códgo a ejecutar
                                    vistaGenerarReserva.txtCodCliente.setText(cliente[0]);
                                    vistaGenerarReserva.txtNomCliente.setText(cliente[1]);
                                    vistaGenerarReserva.txtDocCliente.setText(cliente[2]);
                                }
                            }
                        });
                    activo=true;
                }else{
                    System.out.println("btnBuscarCliente");
                }
            break;
            
            case "btnBuscarHabitacion":
                
                if(activo==false){
                    mCtrBuscarHabitacion = new ctrBuscarHabitacion();
                    mCtrBuscarHabitacion.showFrmBuscarHabitacion();
                    vistaBuscarHabitacion.txtFechaLlegada.setText("  "+fechaActual2(vistaGenerarReserva.jdcLlegada.getDate()));
                    vistaBuscarHabitacion.txtFechaSalida.setText("  "+fechaActual2(vistaGenerarReserva.jdcSalida.getDate()));
                    mCtrBuscarHabitacion.loadData();
                    activo=true;
                }else{
                    System.out.println("btnBuscarHabitacion...");
                }
            break;
            
            case "btnBuscarHuesped":
                
                if(activo==false){
                    mCtrBuscarHuesped = new ctrBuscarHuesped();
                    mCtrBuscarHuesped.showFrmBuscarHuesped();
                    mCtrBuscarHuesped.loadData();
                    activo=true;
                }else{
                    System.out.println("btnBuscarHuesped...");
                }
            break;
            
            case "btnNuevoCliente":
                
                if(activo==false){
                    mCtrRegistrarCliente = new CtrRegistrarCliente();
                    mCtrRegistrarCliente.showFrmRegistrarCliente();
                    activo=true;
                }else{
                    System.out.println("btnNuevoCliente...");
                }
            break;
               
            case "btnNuevoHuesped":
                
                if(activo==false){
                    mCtrRegistrarHuesped = new ctrRegistrarHuesped();
                    mCtrRegistrarHuesped.showFrmRegistrarHuesped();
                    activo=true;
                }else{
                    System.out.println("btnNuevoHuesped...");
                }
            break;
            
            case "btnGrabarReserva":
                
                modelo = (DefaultTableModel) vistaGenerarReserva.tblDetalleReserva.getModel(); 
                row = modelo.getRowCount();
                
                if(row>0){
                    if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(vistaGenerarReserva,"Esta seguro que desea grabar la RESERVA? ")){
                        
                        String feclle = fechaActual3(vistaGenerarReserva.jdcLlegada.getDate());
                        String fecsal = fechaActual3(vistaGenerarReserva.jdcSalida.getDate());
                        String canhab = vistaGenerarReserva.txtCantHabit.getText();
                        String estado = "RESERVADO";
                        String codcli = vistaGenerarReserva.txtCodCliente.getText();
                        String fecres = fechaActual3(new Date());
                        String cotiza = vistaGenerarReserva.txtCotizacion.getText();
                        String emplea = vistaGenerarReserva.txtCodEmpleado.getText();

                        Reserva reserva=new Reserva();

                        reserva.setFechaInicioRes(feclle);
                        reserva.setFechaFinalRes(fecsal);
                        reserva.setCantidadRes(canhab);
                        reserva.setEstadoRes(estado);
                        reserva.setCliente_Persona_idPersona(codcli);
                        reserva.setFechaRes(fecres);
                        reserva.setCotizacionRes(cotiza);
                        reserva.setEmpleado_Persona_idPersona(emplea);

                        reserva.grabarReserva();

                        for(int i=0;i<row;i++){
                            String codhab=String.valueOf(modelo.getValueAt(i,1));
                            String codhue=String.valueOf(modelo.getValueAt(i,2));

                            DetalleReserva detalleReserva=new DetalleReserva();
                            detalleReserva.grabarDetalleReserva(codhab,codhue);

                            Habitacion habitacion=new Habitacion();
                            habitacion.updateEstadoHabitacion(String.valueOf(modelo.getValueAt(i,1)),"RESERVADO");

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
                        coti=0;
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

                        for(int i=0;i<row;i++){
                            modelo.removeRow(0);
                        }

                        JOptionPane.showMessageDialog(vistaGenerarReserva,"Codigo Reserva Generado: "+(reserva.getCodigoReserva()));
                       
                    } 
                }else{
                    JOptionPane.showMessageDialog(vistaGenerarReserva,"Error: Campos vacios");          
                }
            break;
            
            case "btnCancelar":
                
                int confirmar=JOptionPane.showConfirmDialog(vistaGenerarReserva,"Esta seguro que desea salir del registro? "); 

                if(JOptionPane.OK_OPTION==confirmar) {
                    
                    modelo=(DefaultTableModel) vistaGenerarReserva.tblDetalleReserva.getModel();
                    row=modelo.getRowCount();
                    for(int i=0;i<row;i++){
                        Habitacion habitacion=new Habitacion();
                        habitacion.updateEstadoHabitacion(String.valueOf(modelo.getValueAt(i,1)),"DISPONIBLE");
                    }
                    hideFrmGenerarReserva();
                }
            break;
        }
    }
   
    public static String fechaActual1(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String fec="";
        fec=dateFormat.format(date);
        return fec;
    }
    public static String fechaActual2(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fec="";
        fec=dateFormat.format(date);
        return fec;
    }
    public static String fechaActual3(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fec="";
        fec=dateFormat.format(date);
        return fec;
    }
    public  Date setMaxDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar maximo = new GregorianCalendar();
        maximo.setTime(this.vistaGenerarReserva.jdcLlegada.getDate());
        int año = maximo.get(Calendar.YEAR);
        String dateInString = "31/12/"+año;
        Date date= null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return date;
    }
    public  Date setMinSal(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar minimo = new GregorianCalendar();
        minimo.setTime(this.vistaGenerarReserva.jdcLlegada.getDate());
        
        int año = minimo.get(Calendar.YEAR);
        int mes = minimo.get(Calendar.MONTH)+1;
        int dia = minimo.get(Calendar.DAY_OF_MONTH)+1;
        
        String dateInString = (dia)+"/"+mes+"/"+año;
        Date date= null;
            
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return date;
    }
    public  Date setMaxLleg(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar maximo = new GregorianCalendar();
        maximo.setTime(this.vistaGenerarReserva.jdcSalida.getDate());
        
        int año = maximo.get(Calendar.YEAR);
        int mes = maximo.get(Calendar.MONTH)+1;
        int dia = maximo.get(Calendar.DAY_OF_MONTH)-1;
        
        String dateInString = (dia)+"/"+mes+"/"+año;
        Date date= null;
           
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(ctrGenerarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public String contarDias(){
        int cant=0;
        Calendar llegada = new GregorianCalendar();
        llegada.setTime(this.vistaGenerarReserva.jdcLlegada.getDate());

        Calendar salida = new GregorianCalendar();
        salida.setTime(this.vistaGenerarReserva.jdcSalida.getDate());
                
        int llegada_dias = llegada.get(Calendar.DAY_OF_YEAR);
        int salida_dias  = salida.get(Calendar.DAY_OF_YEAR);
        cant=salida_dias-llegada_dias;        
        return String.valueOf(cant);
    }
    
    public void showFrmGenerarReserva(){
        this.vistaGenerarReserva.setVisible(true);
    }
     
    public void hideFrmGenerarReserva(){
        this.vistaGenerarReserva.setVisible(false);
        CtrNReserva.activo=false;
    }
 
}