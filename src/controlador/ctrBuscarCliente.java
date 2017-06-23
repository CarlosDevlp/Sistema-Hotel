package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import modelo.Persona;
import vista.frmBuscarCliente;
import vista.frmGenerarReserva;

public class ctrBuscarCliente implements ActionListener{
    private frmBuscarCliente vistaBuscarCliente;
    private frmGenerarReserva vistaGenerarReserva;
    private Callback onCompletedSearch;
    
    private ArrayList<Persona> mClienteList;
    private DefaultTableModel mClienteTableModel;
    private final String []USER_TABLE_COLUMN_NAMES={"Codigo","Nombre","Documento","Direccion","Telefono"};
    
    public ctrBuscarCliente(){
        this(new frmBuscarCliente());
    }
    
    public ctrBuscarCliente(frmBuscarCliente mfrmBuscarCliente) {
        this.vistaBuscarCliente = mfrmBuscarCliente;
        this.vistaBuscarCliente.btnAceptar.addActionListener(this);
        this.vistaBuscarCliente.btnBuscar.addActionListener(this);
        this.vistaBuscarCliente.btnCancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        
        switch(obj.getName()){
            case "btnBuscar":
                buscarClienteDni();
               break;
            case "btnAceptar":
                transferirDatos();
               break;
            case "btnCancelar":
                hideFrmBuscarCliente();
                System.out.println("btnCancelar");
               break;
        }                
    }
    
    
    public Callback getOnCompletedSearch() {
        return onCompletedSearch;
    }

    /**
     * pasar método que se ejecutará cuando se complete la búsqueda
     * @params onCompletedSearch callback
     */
    public void setOnCompletedSearch(Callback onCompletedSearch) {
        this.onCompletedSearch = onCompletedSearch;
    }
    
    
    
    public void buscarClienteDni(){
        clearTable();
        mClienteList= Persona.getClienteDni((String)vistaBuscarCliente.txtDocumento.getText());
        
        for(Persona cliente:mClienteList)        
            mClienteTableModel.addRow(new String[]{cliente.getIdPersona(),cliente.getNombre(),cliente.getRucDNI(),cliente.getDireccion(),cliente.getTelefono()});        
        this.vistaBuscarCliente.tblCliente.setModel(mClienteTableModel); 
    }
    
    public void transferirDatos(){
        int fila=vistaBuscarCliente.tblCliente.getSelectedRow();
        if(fila>-1){
            
            String cod=(String)vistaBuscarCliente.tblCliente.getValueAt(fila, 0);
            String nom=(String)vistaBuscarCliente.tblCliente.getValueAt(fila, 1);
            String doc=(String)vistaBuscarCliente.tblCliente.getValueAt(fila, 2);
            String dir=(String)vistaBuscarCliente.tblCliente.getValueAt(fila, 3);
            String tel=(String)vistaBuscarCliente.tblCliente.getValueAt(fila, 4);

            vistaGenerarReserva.txtCodCliente.setText(cod);
            vistaGenerarReserva.txtNomCliente.setText(nom);
            vistaGenerarReserva.txtDocCliente.setText(doc);

            
            onCompletedSearch.execute(new String[]{cod,nom,doc,dir,tel});
            
            hideFrmBuscarCliente();
            
        }else{
            JOptionPane.showMessageDialog(vistaBuscarCliente, "Seleccione un Cliente");
        }
    }
    
    public void loadData() {
        clearTable();
        mClienteList= Persona.getClienteList();
        
        for(Persona cliente:mClienteList)        
            mClienteTableModel.addRow(new String[]{cliente.getIdPersona(),cliente.getNombre(),cliente.getRucDNI(),cliente.getDireccion(),cliente.getTelefono()});        
        this.vistaBuscarCliente.tblCliente.setModel(mClienteTableModel); 
    }
   
    private void clearTable(){        
        mClienteTableModel = new DefaultTableModel(null,USER_TABLE_COLUMN_NAMES);
        this.vistaBuscarCliente.tblCliente.setModel(mClienteTableModel);
    }
    
    public void showFrmBuscarCliente(){
        this.vistaBuscarCliente.setVisible(true);
    }
    
    public void hideFrmBuscarCliente(){
        this.vistaBuscarCliente.setVisible(false);
        ctrGenerarReserva.activo=false;
        
    }

    
}
