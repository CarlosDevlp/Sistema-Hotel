package vista;
import conexion.Conexion;
import dao.BasicDao;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class frmServicioExtra extends javax.swing.JFrame {

    
    //conexion
   /* Conexion cn = new Conexion();
   Connection con = cn.conexion(); */
    
    public frmServicioExtra() {
        initComponents();
        fecha2.setText(FechaActual());
        tablilla();
        bloquear();
    }
    
    void bloquear(){
      txtnombresapellidosServicio.setEnabled(false);
      txtHabitacionServicio.setEnabled(false);
      panelservicio.setEnabled(false);
      txaDetalleServicio.setEnabled(false);
      txtpagoServicios.setEnabled(false);
      btnAgregarServicio.setEnabled(false);
      btnquitarServicio.setEnabled(false);
      btnguardarServicios.setEnabled(false);
      checkbuffet.setEnabled(false);
      checkpiscina.setEnabled(false);
      checkdiscoteca.setEnabled(false);
    }
    void desbloquear(){
      txtnombresapellidosServicio.setEnabled(true);
      txtHabitacionServicio.setEnabled(true);
      panelservicio.setEnabled(true);
      txaDetalleServicio.setEnabled(true);
      txtpagoServicios.setEnabled(true);
      btnAgregarServicio.setEnabled(true);
      btnquitarServicio.setEnabled(true);
      btnguardarServicios.setEnabled(true);
      checkbuffet.setEnabled(true);
      checkpiscina.setEnabled(true);
      checkdiscoteca.setEnabled(true);
    }
    void tablilla(){
       /* DefaultTableModel tableta =new DefaultTableModel();
        tableta.addColumn("DNI");
        tableta.addColumn("Nombres y Apellidos");
        tableta.addColumn("N°Habitación");
        tableta.addColumn("Fecha");
        tableta.addColumn("Tipo Servicio");
        tableta.addColumn("Total");
        txttabla2.setModel(tableta);
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
        txtnombresapellidosServicio = new javax.swing.JTextField();
        txtHabitacionServicio = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDetalleServicio = new javax.swing.JTable();
        txtdniServicio = new javax.swing.JTextField();
        btnconsultarDNIservicio = new javax.swing.JButton();
        btnAgregarServicio = new javax.swing.JButton();
        btnquitarServicio = new javax.swing.JButton();
        btnguardarServicios = new javax.swing.JButton();
        btnsalirServicios = new javax.swing.JButton();
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
        txtpagoServicios = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("DNI");

        jLabel3.setText("Nombres y Apellidos");

        jLabel6.setText("N° Habitación");

        txaDetalleServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(txaDetalleServicio);

        btnconsultarDNIservicio.setText("Consultar");
        btnconsultarDNIservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarDNIservicioActionPerformed(evt);
            }
        });

        btnAgregarServicio.setText("Agregar");

        btnquitarServicio.setText("Quitar");

        btnguardarServicios.setText("Guardar");
        btnguardarServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarServiciosActionPerformed(evt);
            }
        });

        btnsalirServicios.setText("Salir");
        btnsalirServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirServiciosActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(205, 205, 205)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtdniServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnconsultarDNIservicio))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHabitacionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnombresapellidosServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAgregarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(btnquitarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(33, 33, 33)
                                        .addComponent(panelservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnguardarServicios)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpagoServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalirServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fecha2)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtdniServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultarDNIservicio))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnombresapellidosServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHabitacionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarServicio)
                            .addComponent(btnquitarServicio)))
                    .addComponent(panelservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpagoServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalirServicios)
                    .addComponent(btnguardarServicios)))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarDNIservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarDNIservicioActionPerformed
        //CONSULTAR DATOS
        ArrayList<Map<String,String>> resultHuespedes=BasicDao.select("Huesped", new String[]{"*"}, "DNIHue="+this.txtdniServicio.getText());
        Map<String,String> huesped=resultHuespedes.get(0);//objeto huesped
        
        this.txtnombresapellidosServicio.setText(huesped.get("NombreHue")); 
        ArrayList<Map<String,String>> resultHabitaciones=BasicDao.select(new String[]{"Habitacion","DetalleReserva"}, new String[]{"*"}, new String[]{"Habitacion_idHab","idHab"},"Huesped_idHSP="+huesped.get("idHSP"));
        Map<String,String> habitacion=resultHabitaciones.get(0);
        this.txtHabitacionServicio.setText(habitacion.get("NumeroHab"));
    }//GEN-LAST:event_btnconsultarDNIservicioActionPerformed

    private void btnsalirServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirServiciosActionPerformed
       JOptionPane.showMessageDialog(null,"Salir de Servicios Extras");
       this.setVisible(false);
         
    }//GEN-LAST:event_btnsalirServiciosActionPerformed

    private void btnguardarServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarServiciosActionPerformed
       /* try {
            //validacion de mi panel
            panelservicio.add(checkpiscina);
            panelservicio.add(checkbuffet);
            panelservicio.add(checkdiscoteca);
            if(checkpiscina.){
                
              
            }
            // codigo del boton guardar
            PreparedStatement pps = cn.prepareStatement("INSERT INTO detalleserviciosextra(dniDSE,FullNombresDSE,NroHabitacionDSE,FechaDSE,TipoServicioDSE,totalDSe,totalnetoDSE) VALUES(?,?,?,?,?,?,?)");
            pps.setString(1,txtdni2.getText());
            pps.setString(2,txtnombresapellidos2.getText());
            pps.setString(3,txthabitacion2.getText());
            pps.setString(4,fecha2.getText());
            pps.setString(5,panelservicio.getText());
            pps.setString(6,txtdni2.getText());
            pps.setString(7,.getText());
            pps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(frmServicioExtra.class.getName()).log(Level.SEVERE, null, ex);
        } */
    }//GEN-LAST:event_btnguardarServiciosActionPerformed

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
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JButton btnconsultarDNIservicio;
    private javax.swing.JButton btnguardarServicios;
    private javax.swing.JButton btnquitarServicio;
    private javax.swing.JButton btnsalirServicios;
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
    private javax.swing.JTable txaDetalleServicio;
    private javax.swing.JTextField txtHabitacionServicio;
    private javax.swing.JTextField txtdniServicio;
    private javax.swing.JTextField txtnombresapellidosServicio;
    private javax.swing.JTextField txtpagoServicios;
    // End of variables declaration//GEN-END:variables

    public void addALbtnsalir2(ActionListener actionListener){
        btnsalirServicios.addActionListener(actionListener);
    }
    private void fclose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
