package vista;

import conexion.Conexion;
import dao.BasicDao;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class frmServicioExtra extends javax.swing.JFrame {

    
    //conexion
   /* Conexion cn = new Conexion();
   Connection con = cn.conexion(); */
    DefaultTableModel tableta;
    int precioAcumulado = 0;
    int idAlojamiento = 0;
    int idHuesped = 0;
    
    public frmServicioExtra() {
        initComponents();
        fecha2.setText(FechaActual());
        tablilla();
        bloquear();
        txtpago2.setText(""+precioAcumulado);
    }
    
    void bloquear(){
      txtnombresapellidos2.setEnabled(false);
      txthabitacion2.setEnabled(false);
      panelservicio.setEnabled(false);
      tblServiciosExtras.setEnabled(false);
      txtpago2.setEnabled(false);
      btnagregar2.setEnabled(false);
      btnquitar2.setEnabled(false);
      btnguardar2.setEnabled(false);
      checkbuffet.setEnabled(false);
      checkpiscina.setEnabled(false);
      checkdiscoteca.setEnabled(false);
    }
    void desbloquear(){
      txtnombresapellidos2.setEnabled(true);
      txthabitacion2.setEnabled(true);
      panelservicio.setEnabled(true);
      tblServiciosExtras.setEnabled(true);
      txtpago2.setEnabled(true);
      btnagregar2.setEnabled(true);
      btnquitar2.setEnabled(true);
      btnguardar2.setEnabled(true);
      checkbuffet.setEnabled(true);
      checkpiscina.setEnabled(true);
      checkdiscoteca.setEnabled(true);
    }
    void tablilla(){
        tableta = new DefaultTableModel();
        tableta.addColumn("DNI");
        tableta.addColumn("Nombres y Apellidos");
        tableta.addColumn("N°Habitación");
        tableta.addColumn("Fecha");
        tableta.addColumn("Tipo Servicio");
        tableta.addColumn("Total");
        tblServiciosExtras.setModel(tableta);/*
        String sql= "SELECT * FROM ";
        String datos[]=new String[6];
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(0);
                datos[1]=rs.getString(1);
                datos[2]=rs.getString(2);
                datos[3]=rs.getString(3);
                datos[4]=rs.getString(4);
                datos[5]=rs.getString(5);
                tableta.addRow(datos);
            }
            txttabla2.setModel(tableta);
        } catch (SQLException ex) {
            Logger.getLogger(frmServicioExtra.class.getName()).log(Level.SEVERE, null, ex);
        } */
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnombresapellidos2 = new javax.swing.JTextField();
        txthabitacion2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblServiciosExtras = new javax.swing.JTable();
        txtdni2 = new javax.swing.JTextField();
        btnconsultar2 = new javax.swing.JButton();
        btnagregar2 = new javax.swing.JButton();
        btnquitar2 = new javax.swing.JButton();
        btnguardar2 = new javax.swing.JButton();
        btnsalir2 = new javax.swing.JButton();
        panelservicio = new javax.swing.JPanel();
        checkpiscina = new javax.swing.JCheckBox();
        checkbuffet = new javax.swing.JCheckBox();
        checkdiscoteca = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        fecha2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpago2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("DNI");

        jLabel3.setText("Nombres y Apellidos");

        jLabel6.setText("N° Habitación");

        tblServiciosExtras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblServiciosExtras);

        btnconsultar2.setText("Consultar");
        btnconsultar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultar2ActionPerformed(evt);
            }
        });

        btnagregar2.setText("Agregar");
        btnagregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar2ActionPerformed(evt);
            }
        });

        btnquitar2.setText("Quitar");
        btnquitar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitar2ActionPerformed(evt);
            }
        });

        btnguardar2.setText("Guardar");
        btnguardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar2ActionPerformed(evt);
            }
        });

        btnsalir2.setText("Salir");
        btnsalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir2ActionPerformed(evt);
            }
        });

        panelservicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicios"));
        panelservicio.setForeground(java.awt.Color.darkGray);

        checkpiscina.setText("Piscina");

        checkbuffet.setText("Buffet");

        checkdiscoteca.setText("Discoteca");

        javax.swing.GroupLayout panelservicioLayout = new javax.swing.GroupLayout(panelservicio);
        panelservicio.setLayout(panelservicioLayout);
        panelservicioLayout.setHorizontalGroup(
            panelservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelservicioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkpiscina)
                    .addComponent(checkbuffet)
                    .addComponent(checkdiscoteca))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelservicioLayout.setVerticalGroup(
            panelservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelservicioLayout.createSequentialGroup()
                .addComponent(checkpiscina, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkbuffet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkdiscoteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Servicios Extras");

        jLabel8.setText("Fecha:");

        fecha2.setText("dia/Mes/Año");

        jLabel2.setText("Neto a Pagar");

        txtpago2.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdni2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnconsultar2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombresapellidos2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txthabitacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnagregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnquitar2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btnguardar2)
                        .addGap(50, 50, 50)
                        .addComponent(btnsalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpago2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fecha2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtdni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultar2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnombresapellidos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txthabitacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnagregar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnquitar2))
                    .addComponent(panelservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpago2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar2)
                    .addComponent(btnsalir2))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultar2ActionPerformed
        //CONSULTAR DATOS
       Map<String,String> huespedes=null;
       //Consultar Huesped
        if(txtdni2.getText().length()>0 && txtdni2.getText().length()==8){
            try{
           
                ArrayList<Map<String,String>> resultaHuespedes=BasicDao.select("Huesped", new String[]{"*"}, "DNIHue="+this.txtdni2.getText());
                huespedes=resultaHuespedes.get(0);//objeto huesped
                this.txtnombresapellidos2.setText(huespedes.get("NombreHue"));
                idHuesped = Integer.parseInt(huespedes.get("idHSP"));
                
                desbloquear();
                } catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Huesped no se encuentra alojado en estos momentos");
                   bloquear();
                   txtnombresapellidos2.setText("");
                   txthabitacion2.setText("");
               }


                ArrayList<Map<String,String>> resultaHabitaciones=BasicDao.select(new String[]{"Habitacion","DetalleReserva"}, new String[]{"*"}, new String[]{"Habitacion_idHab","idHab"},"Huesped_idHSP="+huespedes.get("idHSP"));
                Map<String,String> habitaciones=resultaHabitaciones.get(0);
                txthabitacion2.setText(habitaciones.get("NumeroHab"));
                ArrayList<Map<String,String>> resultAlojamiento = BasicDao.select("Alojamiento", new String[]{"*"},"Reserva_idReserva="+habitaciones.get("Reserva_idReserva").toString());
                idAlojamiento = Integer.parseInt(resultAlojamiento.get(0).get("idAlojamiento"));
                
        }else{
            JOptionPane.showMessageDialog(null,"Ingrese un DNI correcto");
                   bloquear();
                   txtnombresapellidos2.setText("");
                   txthabitacion2.setText("");
        }
    }//GEN-LAST:event_btnconsultar2ActionPerformed

    private void btnsalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir2ActionPerformed
       JOptionPane.showMessageDialog(null,"Salir de Servicios Extras");
       this.setVisible(false);
         
    }//GEN-LAST:event_btnsalir2ActionPerformed

    private void btnguardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar2ActionPerformed
        try{
           if(tableta.getRowCount() > 0){
                for(int i = 0 ; i < tableta.getRowCount(); i++)
                {
                     tableta.getValueAt(i, 0);
                     String []items = new String[5];
                     String []values = new String[5];
                     items[0] = "FechaDSe";
                     items[1] = "CantidadDSe";
                     items[2] = "Huesped_idHSP";
                     items[3] = "ServicioExtra_idSEx";
                     items[4] = "Alojamiento_idAlojamiento";
                     String fecha = fecha2.getText();
                     String fechaCambiada = fecha.replace("/","-");
                     SimpleDateFormat formatFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                     Date fechaFormateada = formatFecha.parse(fechaCambiada);
                     SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                     values[0] = ""+formatoFecha2.format(fechaFormateada);
                     values[1] = "1";
                     values[2] = ""+idHuesped;
                     ArrayList<Map<String,String>> resultadoProductos = BasicDao.select("ServiciosExtra", new String[]{"*"}, "NombreSEx = '"+tableta.getValueAt(i, 4).toString()+"'");
                     //System.out.println(tableta.getValueAt(i, 4).toString());
                     //System.out.println(resultadoProductos.get(0));
                     values[3] = ""+resultadoProductos.get(0).get("idSEx");
                     values[4] = ""+idAlojamiento;
                     BasicDao.insert("DetalleServicios", items, values);
                 }

                 checkbuffet.setSelected(false);
                 checkdiscoteca.setSelected(false);
                 checkpiscina.setSelected(false);
                 DefaultTableModel modelo = (DefaultTableModel) tblServiciosExtras.getModel();
                 while(modelo.getRowCount()>0)modelo.removeRow(0);
                 precioAcumulado = 0;
                 txtpago2.setText(""+precioAcumulado);
                 JOptionPane.showMessageDialog(null,"Registro sastifactorio");
           }else{
               JOptionPane.showMessageDialog(null, "No puede guardar si no selecciona algún servicio extra.");
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_btnguardar2ActionPerformed

    private void btnagregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar2ActionPerformed
        
        if(checkpiscina.isSelected()){
            String data[] = new String[6];
            data[0] = txtdni2.getText().toString();
            data[1] = txtnombresapellidos2.getText().toString();
            data[2] = txthabitacion2.getText().toString();
            data[3] = fecha2.getText().toString();
            data[4] = checkpiscina.getText().toString();
            ArrayList<Map<String,String>> resultadoProductos = BasicDao.select("ServiciosExtra", new String[]{"*"}, "NombreSEx like '%"+this.checkpiscina.getText().toString()+"%'");
            data[5] = resultadoProductos.get(0).get("costoSEx");
            tableta.addRow(data);
            precioAcumulado += Integer.parseInt(resultadoProductos.get(0).get("costoSEx"));
            txtpago2.setText(""+precioAcumulado);
            checkpiscina.setSelected(false);
        }
        
        if(checkbuffet.isSelected()){
            String data[] = new String[6];
            data[0] = txtdni2.getText().toString();
            data[1] = txtnombresapellidos2.getText().toString();
            data[2] = txthabitacion2.getText().toString();
            data[3] = fecha2.getText().toString();
            data[4] = checkbuffet.getText().toString();
            ArrayList<Map<String,String>> resultadoProductos = BasicDao.select("ServiciosExtra", new String[]{"*"}, "NombreSEx like '%"+this.checkbuffet.getText().toString()+"%'");
            data[5] = resultadoProductos.get(0).get("costoSEx");
            tableta.addRow(data);
            precioAcumulado += Integer.parseInt(resultadoProductos.get(0).get("costoSEx"));
            txtpago2.setText(""+precioAcumulado);
            checkbuffet.setSelected(false);
        }
        
        if(checkdiscoteca.isSelected()){
            String data[] = new String[6];
            data[0] = txtdni2.getText().toString();
            data[1] = txtnombresapellidos2.getText().toString();
            data[2] = txthabitacion2.getText().toString();
            data[3] = fecha2.getText().toString();
            data[4] = checkdiscoteca.getText().toString();
            ArrayList<Map<String,String>> resultadoProductos = BasicDao.select("ServiciosExtra", new String[]{"*"}, "NombreSEx like '%"+this.checkdiscoteca.getText().toString()+"%'");
            data[5] = resultadoProductos.get(0).get("costoSEx");
            tableta.addRow(data);
            precioAcumulado += Integer.parseInt(resultadoProductos.get(0).get("costoSEx"));
            txtpago2.setText(""+precioAcumulado);
            checkdiscoteca.setSelected(false);
        }
        
    }//GEN-LAST:event_btnagregar2ActionPerformed

    private void btnquitar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitar2ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblServiciosExtras.getModel();
        
        precioAcumulado -= Integer.parseInt(modelo.getValueAt(tblServiciosExtras.getSelectedRow(), 5).toString());
        txtpago2.setText(""+precioAcumulado);
        modelo.removeRow(tblServiciosExtras.getSelectedRow());
    }//GEN-LAST:event_btnquitar2ActionPerformed

    public static String FechaActual(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss a");
        return formatoFecha.format(fecha);
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmServicioExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmServicioExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmServicioExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmServicioExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmServicioExtra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar2;
    private javax.swing.JButton btnconsultar2;
    private javax.swing.JButton btnguardar2;
    private javax.swing.JButton btnquitar2;
    private javax.swing.JButton btnsalir2;
    private javax.swing.JCheckBox checkbuffet;
    private javax.swing.JCheckBox checkdiscoteca;
    private javax.swing.JCheckBox checkpiscina;
    private javax.swing.JLabel fecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelservicio;
    private javax.swing.JTable tblServiciosExtras;
    private javax.swing.JTextField txtdni2;
    private javax.swing.JTextField txthabitacion2;
    private javax.swing.JTextField txtnombresapellidos2;
    private javax.swing.JTextField txtpago2;
    // End of variables declaration//GEN-END:variables

    public void addALbtnsalir2(ActionListener actionListener){
        btnsalir2.addActionListener(actionListener);
    }
}
