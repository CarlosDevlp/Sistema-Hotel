
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Huesped;
import vista.frmBuscarHuesped;
import vista.frmGenerarReserva;


public class ctrBuscarHuesped implements ActionListener{
    
    private frmBuscarHuesped vistaBuscarHuesped;
    private frmGenerarReserva vistaGenerarReserva;
    
    private ArrayList<Huesped> mHuespedList;
    private DefaultTableModel mHuespedTableModel;
    private final String []USER_TABLE_COLUMN_NAMES={"Codigo","Nombres","DNI"};
    private final int []anchos={100, 150, 135};
    
    public ctrBuscarHuesped(){
        this(new frmBuscarHuesped());
    }
    
    public ctrBuscarHuesped(frmBuscarHuesped mfrmBuscarHuesped) {
        this.vistaBuscarHuesped = mfrmBuscarHuesped;
        this.vistaBuscarHuesped.btnAceptar.addActionListener(this);
        this.vistaBuscarHuesped.btnBuscar.addActionListener(this);
        this.vistaBuscarHuesped.btnCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        
        switch(obj.getName()){
            case "btnBuscar":
                buscarHuespedDni();
               break;
            case "btnAceptar":
                transferirDatos();
               break;
            case "btnCancelar":
                hideFrmBuscarHuesped();
               break;
        }                
    }
    
    public void buscarHuespedDni(){
        String dni=vistaBuscarHuesped.txtDni.getText();
        if(dni.length()>0){
            clearTable();
            mHuespedList= Huesped.getHuespedDni((String) vistaBuscarHuesped.txtDni.getText());

            for(Huesped huesped:mHuespedList)        
                mHuespedTableModel.addRow(new String[]{huesped.getIdHuesped(),huesped.getNombre(),huesped.getDni()});        
            this.vistaBuscarHuesped.tblHuesped.setModel(mHuespedTableModel);
        }else{
            JOptionPane.showMessageDialog(vistaBuscarHuesped, "Error: Ingrese DNI");
        }
    }
    
    public void transferirDatos(){
        int fila=vistaBuscarHuesped.tblHuesped.getSelectedRow();
                if(fila>-1){
                    
                    String codhuesped=(String)vistaBuscarHuesped.tblHuesped.getValueAt(fila, 0);
                    String nomhuesped=(String)vistaBuscarHuesped.tblHuesped.getValueAt(fila, 1);
                    String dochuesped=(String)vistaBuscarHuesped.tblHuesped.getValueAt(fila, 2);
                    
                    vistaGenerarReserva.txtCodHuesped.setText(codhuesped);
                    vistaGenerarReserva.txtNomHuesped.setText(nomhuesped);
                    vistaGenerarReserva.txtDniHuesped.setText(dochuesped);
                    
                    hideFrmBuscarHuesped();
                    
                }else{
                    JOptionPane.showMessageDialog(vistaBuscarHuesped, "Seleccione un Huesped");
                }
    }
    
    public void loadData() {
        clearTable();
        mHuespedList= Huesped.getHuespedList();
        
        for(Huesped huesped:mHuespedList)        
            mHuespedTableModel.addRow(new String[]{huesped.getIdHuesped(),huesped.getNombre(),huesped.getDni()});        
        this.vistaBuscarHuesped.tblHuesped.setModel(mHuespedTableModel);
    }
    
    private void clearTable(){        
        mHuespedTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_NAMES);
        this.vistaBuscarHuesped.tblHuesped.setModel(mHuespedTableModel);
    }
    
    public void showFrmBuscarHuesped(){
        this.vistaBuscarHuesped.setVisible(true);
    }
    
    public void hideFrmBuscarHuesped(){
        this.vistaBuscarHuesped.setVisible(false);
        ctrGenerarReserva.activo=false;
    }
    
}
