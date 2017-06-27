/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import modelo.Callback;
import vista.FrmFacturacion;
import vista.frmBuscarCliente;

/**
 *
 * @author Han
 */
public class CtrFacturacion implements ActionListener {
    
    private FrmFacturacion VistaFacturacion;
    private frmBuscarCliente VistaBuscarCliente;
    private ctrBuscarCliente controlBuscarCliente;
    
     public CtrFacturacion(){                
        this(new FrmFacturacion());
    }

    public CtrFacturacion(FrmFacturacion VistaFacturacion) {
        this.VistaFacturacion = VistaFacturacion;
        this.VistaFacturacion.btnBuscarCliente.addActionListener(this);
        
        this.controlBuscarCliente = new ctrBuscarCliente();
        
    }

     
     
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        switch(obj.getName()){
            case "btnBuscarCliente":
                controlBuscarCliente.showFrmBuscarCliente();
                controlBuscarCliente.loadData();
                //aca le mando el código que quiero que se ejecute en mi contexto
                //cuando se termine de hacer la búsqueda
                controlBuscarCliente.setOnCompletedSearch(new Callback<String>(){
                    @Override
                    public void execute(String[] cliente) {
                        
                        VistaFacturacion.txtCodigo.setText(cliente[0]);
                        VistaFacturacion.txtNombreRS.setText(cliente[1]);
                        VistaFacturacion.txtDNIRUC.setText(cliente[2]);
                        VistaFacturacion.setEnabled(true);
                    }
                });
                
                this.VistaFacturacion.setEnabled(false);
//                if(VistaBuscarCliente ==  null){
//                    VistaBuscarCliente = new frmBuscarCliente();
//                    VistaBuscarCliente.setVisible(true);
//                    VistaBuscarCliente.setAlwaysOnTop(true);
//                }
                break;
        }
    }
      
    
    
}
