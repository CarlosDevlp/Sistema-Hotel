/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrFacturacion;
import dao.BasicDao;

/**
 *
 * @author Han
 */
public class FrmFacturacion extends StandardForm {
    private CtrFacturacion mCtrFacturacion;
    /**
     * Creates new form FrmFacturacion
     */
    public FrmFacturacion() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MDP = new javax.swing.ButtonGroup();
        btnBuscarCliente = new javax.swing.JButton();
        lblDatosC = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDNIRUC = new javax.swing.JLabel();
        txtDNIRUC = new javax.swing.JTextField();
        lblNombreRS = new javax.swing.JLabel();
        txtNombreRS = new javax.swing.JTextField();
        lblApellidoD = new javax.swing.JLabel();
        txtApellidoD = new javax.swing.JTextField();
        Scroll = new javax.swing.JScrollPane();
        tbLSE = new javax.swing.JTable();
        lblTC = new javax.swing.JLabel();
        cmbTC = new javax.swing.JComboBox<>();
        lblSubtotal = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        lblIGV = new javax.swing.JLabel();
        txtIGV = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        Scroll1 = new javax.swing.JScrollPane();
        tbLSH = new javax.swing.JTable();
        Scroll2 = new javax.swing.JScrollPane();
        tbLHO = new javax.swing.JTable();
        lblLSE = new javax.swing.JLabel();
        lblLSH = new javax.swing.JLabel();
        lblLAO = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        lblDNIRUC1 = new javax.swing.JLabel();
        rdbtnEfectivo = new javax.swing.JRadioButton();
        rdbtnTarjeta = new javax.swing.JRadioButton();
        lblNombreRS1 = new javax.swing.JLabel();
        txtCA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.setName("BuscarCliente"); // NOI18N

        lblDatosC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatosC.setText("Datos del Cliente:");

        lblCodigo.setText("Codigo:");

        txtCodigo.setEditable(false);

        lblDNIRUC.setText("DNI/RUC:");

        txtDNIRUC.setEditable(false);

        lblNombreRS.setText("Nombres/Razon Social:");

        txtNombreRS.setEditable(false);

        lblApellidoD.setText("Apellidos/Direccion:");

        txtApellidoD.setEditable(false);

        tbLSE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbLSE.setEnabled(false);
        Scroll.setViewportView(tbLSE);

        lblTC.setText("Tipo de Comprobante:");

        cmbTC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura" }));
        cmbTC.setSelectedIndex(-1);

        lblSubtotal.setText("Subtotal S/.");

        lblIGV.setText("IGV");

        lblTotal.setText("Total S/.");

        btnNuevo.setText("Nuevo");
        btnNuevo.setName("Nuevo"); // NOI18N

        btnRegistrar.setText("Registrar");
        btnRegistrar.setName("Registrar"); // NOI18N

        btnCancelar.setText("Cancelar");
        btnCancelar.setName("Cancelar"); // NOI18N

        tbLSH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbLSH.setEnabled(false);
        Scroll1.setViewportView(tbLSH);

        tbLHO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbLHO.setEnabled(false);
        Scroll2.setViewportView(tbLHO);

        lblLSE.setText("Lista de Servicios Extra:");

        lblLSH.setText("Lista de Servicios a la Habitacion:");

        lblLAO.setText("Lista de Habitaciones Ocupadas:");

        btnImprimir.setText("Imprimir");
        btnImprimir.setName("Imprimir"); // NOI18N

        lblDNIRUC1.setText("Modo de Pago:");

        MDP.add(rdbtnEfectivo);
        rdbtnEfectivo.setText("Efectivo");
        rdbtnEfectivo.setName("Efectivo"); // NOI18N

        MDP.add(rdbtnTarjeta);
        rdbtnTarjeta.setText("Tarjeta");
        rdbtnTarjeta.setName("Tarjeta"); // NOI18N

        lblNombreRS1.setText("Codigo de Alojamiento:");

        txtCA.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLSE)
                    .addComponent(lblDatosC)
                    .addComponent(lblLAO)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblDNIRUC)
                                    .addGap(184, 184, 184))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDNIRUC)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCodigo)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(25, 25, 25)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCA)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombreRS1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombreRS, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                            .addComponent(lblNombreRS)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(Scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidoD)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDNIRUC1)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdbtnEfectivo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rdbtnTarjeta))
                                .addComponent(lblLSH))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Scroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellidoD, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbTC, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTC))
                            .addGap(87, 87, 87)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblSubtotal)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblTotal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblIGV)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo)
                            .addGap(36, 36, 36)
                            .addComponent(btnRegistrar)
                            .addGap(37, 37, 37)
                            .addComponent(btnImprimir)
                            .addGap(32, 32, 32)
                            .addComponent(btnCancelar)
                            .addGap(14, 14, 14))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDatosC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(lblApellidoD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombreRS1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblDNIRUC1)
                                            .addComponent(rdbtnEfectivo)
                                            .addComponent(rdbtnTarjeta)
                                            .addComponent(btnBuscarCliente)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDNIRUC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDNIRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLSH)
                                    .addComponent(lblLSE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombreRS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLAO))
                    .addComponent(Scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSubtotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIGV))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotal))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnRegistrar)
                            .addComponent(btnCancelar)
                            .addComponent(btnImprimir))))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //No se ejecutara cuando se llame desde el ctrMain
                BasicDao.init();
                FrmFacturacion frmFacturacion=new FrmFacturacion();
                frmFacturacion.createController();                
                frmFacturacion.setVisible(true);
                frmFacturacion.setResizable(false);
                frmFacturacion.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup MDP;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JScrollPane Scroll1;
    public javax.swing.JScrollPane Scroll2;
    public javax.swing.JButton btnBuscarCliente;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cmbTC;
    private javax.swing.JLabel lblApellidoD;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDNIRUC;
    private javax.swing.JLabel lblDNIRUC1;
    private javax.swing.JLabel lblDatosC;
    private javax.swing.JLabel lblIGV;
    private javax.swing.JLabel lblLAO;
    private javax.swing.JLabel lblLSE;
    private javax.swing.JLabel lblLSH;
    private javax.swing.JLabel lblNombreRS;
    private javax.swing.JLabel lblNombreRS1;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTC;
    private javax.swing.JLabel lblTotal;
    public javax.swing.JRadioButton rdbtnEfectivo;
    public javax.swing.JRadioButton rdbtnTarjeta;
    public javax.swing.JTable tbLHO;
    public javax.swing.JTable tbLSE;
    public javax.swing.JTable tbLSH;
    public javax.swing.JTextField txtApellidoD;
    public javax.swing.JTextField txtCA;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDNIRUC;
    public javax.swing.JTextField txtIGV;
    public javax.swing.JTextField txtNombreRS;
    public javax.swing.JTextField txtSubtotal;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    @Override
    public void createController(){
        mCtrFacturacion=new CtrFacturacion(this);
    }
    @Override
    public Object getViewController() {
       
        return mCtrFacturacion;
    }
}
