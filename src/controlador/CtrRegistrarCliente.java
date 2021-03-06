
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import modelo.Persona;
import vista.frmRegistrarCliente;


public class CtrRegistrarCliente implements ActionListener{
    private frmRegistrarCliente vistaRegistrarCliente;
    
    private ArrayList<Persona> mClienteList;
    private boolean repetido=false;
    
    
    public CtrRegistrarCliente(){
        this(new frmRegistrarCliente());
    }
    
    public CtrRegistrarCliente(frmRegistrarCliente mfrmRegistrarCliente) {
        this.vistaRegistrarCliente = mfrmRegistrarCliente;
        this.vistaRegistrarCliente.btnAceptar.addActionListener(this);
        this.vistaRegistrarCliente.btnCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        
        switch(obj.getName()){
            
            case "btnAceptar":
                
                registrarCliente();
               break;
            case "btnCancelar":
                
                hideFrmRegistrarCliente();
               break;
        }                
    }
    
    public void registrarCliente(){
        
        String nom=this.vistaRegistrarCliente.txtNombre.getText();
        String doc=this.vistaRegistrarCliente.txtDocumento.getText();
        String edad=this.vistaRegistrarCliente.txtEdad.getText();
        String dir=this.vistaRegistrarCliente.txtDireccion.getText();
        String tel=this.vistaRegistrarCliente.txtTelefono.getText();
        String email=this.vistaRegistrarCliente.txtCorreo.getText();
        
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
 
        if(nom.length()>0 && nom.matches("[a-zA-Z- ]*") && (doc.length()==11 || doc.length()==8) && doc.matches("[0-9]*") && edad.length()>0 && edad.matches("[0-9]*")&& dir.length()>0 && tel.length()>0 && tel.matches("[0-9]*") && email.length()>0 && mather.find()){
            
            Persona persona=new Persona() {};
            persona.setFullNamePer(nom);
            persona.setRucDNI(doc);
            persona.setEdad(Integer.parseInt(edad));
            persona.setDireccion(dir);
            persona.setTelefono(tel);
            persona.setCorreo(email);

            repetido=false;
            mClienteList= Persona.getClienteDni((String)vistaRegistrarCliente.txtDocumento.getText());
            for(Persona cliente:mClienteList){        
                if(cliente.getRucDNI().equals(doc)){
                    repetido=true;
                }  
            }
            
            if(repetido!=true){
                persona.nuevoPersona();
                JOptionPane.showMessageDialog(vistaRegistrarCliente,"Exito: Nuevo registro agregado.");
                this.vistaRegistrarCliente.txtNombre.setText("");
                this.vistaRegistrarCliente.txtDocumento.setText("");
                this.vistaRegistrarCliente.txtEdad.setText("");
                this.vistaRegistrarCliente.txtTelefono.setText("");
                this.vistaRegistrarCliente.txtDireccion.setText("");
                this.vistaRegistrarCliente.txtTelefono.setText("");
                this.vistaRegistrarCliente.txtCorreo.setText("");

            }else{
            JOptionPane.showMessageDialog(vistaRegistrarCliente,"Error: DNI ingresado ya existe.");
            }
        }else{
            JOptionPane.showMessageDialog(vistaRegistrarCliente,"Error: Los datos son incorrectos.");
        }
    }
    
    public void showFrmRegistrarCliente(){
        this.vistaRegistrarCliente.setVisible(true);
    }
    
    public void hideFrmRegistrarCliente(){
        this.vistaRegistrarCliente.setVisible(false);
        ctrRegistrarReserva.activo=false;
    }

    public void loadData() {
        System.out.println("frmRegistrarCliente");
    }
}
