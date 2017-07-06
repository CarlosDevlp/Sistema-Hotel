/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BasicDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import modelo.ListaHO;
import modelo.ListaSE;
import modelo.ListaSH;
import vista.FrmFacturacion;

/**
 *
 * @author Han
 */
public class CtrFacturacion implements ActionListener {
    
    private FrmFacturacion VistaFacturacion;
    private ctrBuscarCliente controlBuscarCliente;
    private DefaultTableModel mLSETableModel,mLSHTableModel,mLHOTableModel;
    private final String[] USER_TABLE_COLUMN_LSE = {"Codigo Serv.","Nombre","Fecha Serv.","Cantidad","Precio U.","Precio Total"};
    private final String[] USER_TABLE_COLUMN_LSH = {"Codigo Pro.","Nombre Pro.","Fecha","Cantidad","Precio U.","Precio Total"};
    private final String[] USER_TABLE_COLUMN_LHO = {"Codigo Hab.","Numero Hab.","Tipo Hab.","Fecha Ingreso","Precio x Dia","Dias Alojado","Costo x Habitacion"};
    private double subtotal;
    private double igv;
    private double total;
    private int idformaPago;
    
     public CtrFacturacion(){                
        this(new FrmFacturacion());
    }

    public CtrFacturacion(FrmFacturacion VistaFacturacion) {
        this.VistaFacturacion = VistaFacturacion;
        this.VistaFacturacion.btnBuscarCliente.addActionListener(this);
        this.VistaFacturacion.btnCancelar.addActionListener(this);
        this.VistaFacturacion.btnImprimir.addActionListener(this);
        this.VistaFacturacion.btnNuevo.addActionListener(this);
        this.VistaFacturacion.btnRegistrar.addActionListener(this);
        this.VistaFacturacion.rdbtnEfectivo.addActionListener(this);
        this.VistaFacturacion.rdbtnTarjeta.addActionListener(this);
        this.controlBuscarCliente = new ctrBuscarCliente(); 
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        switch(obj.getName()){
            case "BuscarCliente":
                controlBuscarCliente.showFrmBuscarCliente();
                controlBuscarCliente.loadData();
                this.VistaFacturacion.setEnabled(false); 
                //aca le mando el código que quiero que se ejecute en mi contexto
                //cuando se termine de hacer la búsqueda
                
                controlBuscarCliente.setOnCompletedSearch(new Callback<String>(){
                    @Override
                    public void execute(String[] cliente) {
                        if(cliente!= null){
                            subtotal = 0;
                            VistaFacturacion.txtCodigo.setText(cliente[0]);
                            VistaFacturacion.txtNombreRS.setText(cliente[1]);
                            VistaFacturacion.txtDNIRUC.setText(cliente[2]);
                            VistaFacturacion.txtApellidoD.setText(cliente[3]);
                            String codAloj = getCodAlojamiento(cliente[0]);
                            VistaFacturacion.txtCA.setText(codAloj);
                            //Llenando tablas
                            loadLSE(codAloj);
                            loadLSH(codAloj);
                            loadLHO(codAloj);
                            //Generando Subtotal, IGV y Total
                            igv = subtotal * 0.18;
                            subtotal -= igv;
                            total = subtotal + igv;
                            //LLenando Subtotal, IGV y Total
                            VistaFacturacion.txtSubtotal.setText(""+subtotal);
                            VistaFacturacion.txtIGV.setText(""+igv);
                            VistaFacturacion.txtTotal.setText(""+total);
                            VistaFacturacion.btnImprimir.setEnabled(true);
                            VistaFacturacion.btnRegistrar.setEnabled(true);
                        }
                        VistaFacturacion.setEnabled(true);
                    }
                });
                break;
            case "Efectivo":
                idformaPago = 1;
               break;
            case "Tarjeta":
                idformaPago = 2;
               break;
            case "Registrar":
                  if(idformaPago <= 0){
                       JOptionPane.showMessageDialog(null,"Seleccione la forma de Pago");
                  }else if(VistaFacturacion.cmbTC.getSelectedIndex() == -1){
                       JOptionPane.showMessageDialog(null,"Seleccione el tipo de Comprobante");
                  }else{
                       String obs = null;
                       String Total = ""+this.total;
                       String IdformaPago = ""+this.idformaPago;
                       String IdtipoPago = ""+0;
                       switch(VistaFacturacion.cmbTC.getSelectedIndex()){
                           case 0:
                               IdtipoPago = ""+2;//Boleta
                               break;
                           case 1:
                               IdtipoPago = ""+1;//Factura
                               break;
                       }
                       
                       String[] factura = { obs, Total, IdformaPago, IdtipoPago, "Cancelado" };
                       insertFacturacion(factura);
                       
                       limpiarCampos();
                       JOptionPane.showMessageDialog(null, "Pago Realizado.");
                       
                       VistaFacturacion.btnImprimir.setEnabled(false);
                       VistaFacturacion.btnRegistrar.setEnabled(false);
                  }
                  
                break;
            case "Nuevo":
                limpiarCampos();
                VistaFacturacion.btnImprimir.setEnabled(true);
                VistaFacturacion.btnRegistrar.setEnabled(true);
                
                break;
            case "Cancelar":
                closeFrmFacturacion();
                break;
        }
    }
      
    public String getCodAlojamiento(String cod){
        String codigoAlojamiento = null;
        try {
            ArrayList<Map<String,String>>  alojamientoLista = BasicDao.call("ObtenerAlojamientoCliente",new String[]{cod});
           
            Map<String,String> alojamiento=alojamientoLista.get(0);
            
            codigoAlojamiento = alojamiento.get("idAlojamiento");
            //System.out.println(codigoAlojamiento);
        } catch (Exception e) {
            e.toString();
        }
        
        return codigoAlojamiento;
    } 
    
    public ArrayList<ListaSE> getLSE(String codaloj){
        ArrayList<ListaSE> lista = new ArrayList();
        try {
            ArrayList<Map<String,String>> result = BasicDao.call("ObtenerServiciosAlojamiento", new String[]{codaloj});
            for(Map<String,String> row:result) 
                lista.add(new ListaSE(row));
        } catch (Exception e) {
            e.toString();
        }
       
        return  lista;
    }
    
    public ArrayList<ListaSH> getLSH(String codaloj){
        ArrayList<ListaSH> lista = new ArrayList();
        try {
            ArrayList<Map<String,String>> result = BasicDao.call("ObtenerServicioHabitacion", new String[]{codaloj});
            for(Map<String,String> row:result) 
                lista.add(new ListaSH(row));
        } catch (Exception e) {
            e.toString();
        }
        
        return  lista;
    }
    
    public ArrayList<ListaHO> getLHO(String codaloj){
        ArrayList<ListaHO> lista = new ArrayList();
        try {
            ArrayList<Map<String,String>> result = BasicDao.call("ObtenerHabitacionesHospedadas", new String[]{codaloj});
            for(Map<String,String> row:result) 
                lista.add(new ListaHO(row));
        } catch (Exception e) {
            e.toString();
        }
        
        //System.out.println(lista.size());
        
        return  lista;
    }
    
    public void loadLSE(String codaloj){
        clearTableLSE();
        ArrayList<ListaSE> listaSE = null;
        listaSE = getLSE(codaloj);
        if(!listaSE.isEmpty()){
            for(ListaSE LSE: listaSE){
                mLSETableModel.addRow(new String[]{LSE.getCod(),LSE.getNombre(),LSE.getFechaserv(),LSE.getCant(),LSE.getPU(),LSE.getPT()});
                subtotal += Double.parseDouble(LSE.getPT());
            }
        }
        VistaFacturacion.tbLSE.setModel(mLSETableModel);
    }
    
    public void loadLSH(String codaloj){
        clearTableLSH();
        ArrayList<ListaSH> listaSH = null;
        listaSH = getLSH(codaloj);
        if(!listaSH.isEmpty()){
            for(ListaSH LSH: listaSH){
                mLSHTableModel.addRow(new String[]{LSH.getCod(),LSH.getNombre(),LSH.getFecha(),LSH.getCant(),LSH.getPU(),LSH.getPT()});
                subtotal += Double.parseDouble(LSH.getPT());
            }
        }
        VistaFacturacion.tbLSH.setModel(mLSHTableModel);
    }
    
    public void loadLHO(String codaloj){
        clearTableLHO();
        ArrayList<ListaHO> listaHO = null;
        listaHO = getLHO(codaloj);
        if(!listaHO.isEmpty()){
            for(ListaHO LHO: listaHO){
                //System.out.println(LHO.toString());
                mLHOTableModel.addRow(new String[]{LHO.getCod(),LHO.getNumhab(),LHO.getTipohab(),LHO.getFechaing(),LHO.getPxD(),LHO.getDiasaloj(),LHO.getCostoxH()});
                subtotal += Double.parseDouble(LHO.getCostoxH());
            }
        }
        VistaFacturacion.tbLHO.setModel(mLHOTableModel);
    }
    
    
    public void clearTableLSE(){        
        mLSETableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_LSE);
        VistaFacturacion.tbLSE.setModel(mLSETableModel);
    }
     
    public void clearTableLSH(){        
        mLSHTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_LSH);
        VistaFacturacion.tbLSH.setModel(mLSHTableModel);
    }
    
    public void clearTableLHO(){        
        mLHOTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_LHO);
        VistaFacturacion.tbLHO.setModel(mLHOTableModel);
    }
    
    public void showFrmFacturacion(){
        VistaFacturacion.setVisible(true);
        VistaFacturacion.setResizable(false);
        VistaFacturacion.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        VistaFacturacion.btnImprimir.setEnabled(false);
        VistaFacturacion.btnRegistrar.setEnabled(false);
    }
    
    public void closeFrmFacturacion(){
        VistaFacturacion.setVisible(false);
    }
    
    public void insertFacturacion(String[] factura){
        BasicDao.call("InsertFactura", factura);
    }
    
    public void limpiarCampos(){
        VistaFacturacion.txtCodigo.setText("");
        VistaFacturacion.txtNombreRS.setText("");
        VistaFacturacion.txtApellidoD.setText("");
        VistaFacturacion.txtDNIRUC.setText("");
        VistaFacturacion.txtCA.setText("");
        clearTableLSE();
        clearTableLSH();
        clearTableLHO();
        VistaFacturacion.rdbtnEfectivo.setSelected(false);
        VistaFacturacion.rdbtnTarjeta.setSelected(false);
        VistaFacturacion.cmbTC.setSelectedIndex(-1);
        VistaFacturacion.txtSubtotal.setText("");
        VistaFacturacion.txtIGV.setText("");
        VistaFacturacion.txtTotal.setText("");
    }
}
