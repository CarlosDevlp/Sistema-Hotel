/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import assets.values.Constant;
import controlador.CtrMain;
import controlador.CtrNAlojamiento;
import controlador.CtrNReserva;
import controlador.CtrNSeguridad;
import controlador.CtrNServicio;
import controlador.ctrGenerarReserva;
/**
 * 
 * @author Carlos Chavez Laguna
 */
public class FrmMain extends StandardForm {
    private CtrMain mCtrMain;    
    
    /**
     * Creates new form frmMain
     */
    public FrmMain() {
        initComponents();        
        mCtrMain =new CtrMain(this);
        
        
        //controladora de negocio seguridad
        mCtrMain.setCtrNSeguridad(new CtrNSeguridad());
        
        //controladora de negocio facturación
            //.....
       //controladora de negocio reserva
        CtrNReserva mCtrNReserva= new CtrNReserva();
                ctrGenerarReserva ctrGenerarReservax=new ctrGenerarReserva(this);                
                ctrGenerarReservax.setVistaGenerarReserva(new frmGenerarReserva());
                mCtrNReserva.setCtrGenerarReserva(ctrGenerarReservax);             
         mCtrMain.setCtrNReserva(mCtrNReserva);
                 
         
        //controladora de negocio de servicio
         mCtrMain.setCtrNServicio(new CtrNServicio());
        
        //controladora de negocio alojamiento
        mCtrMain.setCtrNAlojamiento(new CtrNAlojamiento());
        
        //inicializar sistema y su configuración
         mCtrMain.init();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnAdministrador = new javax.swing.JMenu();
        SmnMantenerUsuario = new javax.swing.JMenuItem();
        smMantenerRoles = new javax.swing.JMenuItem();
        SmnReporteSesiones = new javax.swing.JMenuItem();
        MnVerPerfil = new javax.swing.JMenuItem();
        MnSalir = new javax.swing.JMenuItem();
        MnFacturacion = new javax.swing.JMenu();
        smRegistrarCobro = new javax.swing.JMenuItem();
        smBuscarCliente = new javax.swing.JMenuItem();
        MnReserva = new javax.swing.JMenu();
        MnGenerarReserva = new javax.swing.JMenuItem();
        MnAlojamiento = new javax.swing.JMenu();
        smRegistrarAlojamiento = new javax.swing.JMenuItem();
        smReporteAlojamiento = new javax.swing.JMenuItem();
        MnServicio = new javax.swing.JMenu();
        smServicioHabitacion = new javax.swing.JMenuItem();
        smServicioExtra = new javax.swing.JMenuItem();
        MnMantenimiento = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Constant.APP_NAME);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/main_background.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("Usuario");

        MnAdministrador.setText("Administrador");
        MnAdministrador.setEnabled(false);
        MnAdministrador.setName("padministrador"); // NOI18N

        SmnMantenerUsuario.setText("Mantener Usuario");
        SmnMantenerUsuario.setName("pmantenerusuario"); // NOI18N
        MnAdministrador.add(SmnMantenerUsuario);

        smMantenerRoles.setText("Mantener Roles");
        MnAdministrador.add(smMantenerRoles);

        SmnReporteSesiones.setText("Reporte Sesiones");
        MnAdministrador.add(SmnReporteSesiones);

        jMenu1.add(MnAdministrador);

        MnVerPerfil.setText("Ver Perfil");
        MnVerPerfil.setName("pperfil"); // NOI18N
        jMenu1.add(MnVerPerfil);

        MnSalir.setText("Salir");
        MnSalir.setName("exit"); // NOI18N
        MnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnSalirActionPerformed(evt);
            }
        });
        jMenu1.add(MnSalir);

        jMenuBar1.add(jMenu1);

        MnFacturacion.setText("Facturación");
        MnFacturacion.setEnabled(false);
        MnFacturacion.setName("pfacturacion"); // NOI18N

        smRegistrarCobro.setText("Registrar Cobro");
        smRegistrarCobro.setName("smRegistrarCobro"); // NOI18N
        MnFacturacion.add(smRegistrarCobro);

        smBuscarCliente.setText("Buscar Cliente");
        smBuscarCliente.setName("smBuscarCliente"); // NOI18N
        MnFacturacion.add(smBuscarCliente);

        jMenuBar1.add(MnFacturacion);

        MnReserva.setText("Reserva");
        MnReserva.setEnabled(false);
        MnReserva.setName("preserva"); // NOI18N

        MnGenerarReserva.setText("GenerarReserva");
        MnGenerarReserva.setName("pGenerarReserva"); // NOI18N
        MnReserva.add(MnGenerarReserva);

        jMenuBar1.add(MnReserva);

        MnAlojamiento.setText("Alojamiento");
        MnAlojamiento.setEnabled(false);

        smRegistrarAlojamiento.setText("Registrar Alojamiento");
        smRegistrarAlojamiento.setName("pRegistrarAlojamiento"); // NOI18N
        MnAlojamiento.add(smRegistrarAlojamiento);

        smReporteAlojamiento.setText("Reporte Alojamiento");
        smReporteAlojamiento.setName("pRegistrarAlojamiento"); // NOI18N
        MnAlojamiento.add(smReporteAlojamiento);

        jMenuBar1.add(MnAlojamiento);

        MnServicio.setText("Servicio");
        MnServicio.setEnabled(false);

        smServicioHabitacion.setText("Servicio Habitación");
        smServicioHabitacion.setName("pServicioHabitacion"); // NOI18N
        MnServicio.add(smServicioHabitacion);

        smServicioExtra.setText("Servicio Extra");
        smServicioExtra.setName("pServicioExtra"); // NOI18N
        MnServicio.add(smServicioExtra);

        jMenuBar1.add(MnServicio);

        MnMantenimiento.setText("Mantenimiento");
        jMenuBar1.add(MnMantenimiento);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMain mFrmMain=new FrmMain();
                mFrmMain.setVisible(true);
                //mFrmMain.createController();
                System.out.println("FRM MAIN");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu MnAdministrador;
    public javax.swing.JMenu MnAlojamiento;
    public javax.swing.JMenu MnFacturacion;
    public javax.swing.JMenuItem MnGenerarReserva;
    public javax.swing.JMenu MnMantenimiento;
    public javax.swing.JMenu MnReserva;
    public javax.swing.JMenuItem MnSalir;
    public javax.swing.JMenu MnServicio;
    public javax.swing.JMenuItem MnVerPerfil;
    public javax.swing.JMenuItem SmnMantenerUsuario;
    private javax.swing.JMenuItem SmnReporteSesiones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JMenuItem smBuscarCliente;
    private javax.swing.JMenuItem smMantenerRoles;
    public javax.swing.JMenuItem smRegistrarAlojamiento;
    public javax.swing.JMenuItem smRegistrarCobro;
    public javax.swing.JMenuItem smReporteAlojamiento;
    public javax.swing.JMenuItem smServicioExtra;
    public javax.swing.JMenuItem smServicioHabitacion;
    // End of variables declaration//GEN-END:variables

    

    @Override
    public void createController() {
        mCtrMain=new CtrMain(this);
    }
    
    @Override
    public Object getViewController() {        
        return mCtrMain;
    }
}
