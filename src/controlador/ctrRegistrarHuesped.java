
package controlador;


//import static controlador.ctrBuscarHabitacion.activo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import modelo.Huesped;
import vista.frmRegistrarHuesped;


public class ctrRegistrarHuesped implements ActionListener{
    private frmRegistrarHuesped vistaRegistrarHuesped;
    private ArrayList<Huesped> mHuespedList;
    private boolean repetido=false;
    
    public ctrRegistrarHuesped(){
        this(new frmRegistrarHuesped());
    }
    
    public ctrRegistrarHuesped(frmRegistrarHuesped mfrmRegistrarHuesped) {
        this.vistaRegistrarHuesped = mfrmRegistrarHuesped;
        this.vistaRegistrarHuesped.btnAceptar.addActionListener(this);
        this.vistaRegistrarHuesped.btnCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        
        switch(obj.getName()){
            case "btnAceptar":
                registrarHuesped();
               break;
            case "btnCancelar":
                hideFrmRegistrarHuesped();
               break;
        }                
    }
    
    public void registrarHuesped(){
        String nom=this.vistaRegistrarHuesped.txtNombre.getText();
        String dni=this.vistaRegistrarHuesped.txtDni.getText();
        if(nom.length()>0 && nom.matches("[a-zA-Z- ]*") && dni.length()==8 && dni.matches("[0-9]*")){
            repetido=false;
            mHuespedList= Huesped.getHuespedList();
        
            for(Huesped huesped:mHuespedList)
                if(huesped.getDni().equals(dni))
                    repetido=true;
            
            if(repetido!=true){
                Huesped huesped=new Huesped();
                huesped.setNombre(nom);
                huesped.setDni(dni);
                huesped.nuevoHuesped();
                JOptionPane.showMessageDialog(vistaRegistrarHuesped,"Exito: Nuevo registro agregado.");
                this.vistaRegistrarHuesped.txtNombre.setText("");
                this.vistaRegistrarHuesped.txtDni.setText("");
            }else
                JOptionPane.showMessageDialog(vistaRegistrarHuesped,"Error: DNI ingresado ya existe.");
            System.out.println("Exito Ingresado");
        }else
            JOptionPane.showMessageDialog(vistaRegistrarHuesped,"Error: Los datos son incorrectos.");
    }
    
    public void showFrmRegistrarHuesped(){
        this.vistaRegistrarHuesped.setVisible(true);
    }
    
    public void hideFrmRegistrarHuesped(){
        this.vistaRegistrarHuesped.setVisible(false);
        ctrRegistrarReserva.activo=false;
    }

    public void loadData() {
        System.out.println("frmbuscarhuesped");
    }
}
