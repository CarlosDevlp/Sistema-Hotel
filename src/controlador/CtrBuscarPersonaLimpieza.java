/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import controlador.CtrlMantenerRDLH;
import modelo.DAOEmpleado;
import vista.FrmBuscarPersonalLimpieza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author rsoporte
 */
public class CtrBuscarPersonaLimpieza implements ActionListener,MouseListener{
    
    CtrlMantenerRDLH padre;
    FrmBuscarPersonalLimpieza Bpersonal;
    DAOEmpleado daoPersonal;
    
    String codigo,dni,nombre,telefono,turno;
    
    public CtrBuscarPersonaLimpieza(CtrlMantenerRDLH padre) {
        this.padre = padre;
        daoPersonal=new DAOEmpleado();
         if(Bpersonal==null)
        {
            Bpersonal=new FrmBuscarPersonalLimpieza();
        }
        Bpersonal.BtnBuscar.addActionListener(this);
        Bpersonal.BtnAceptar.addActionListener(this);
        Bpersonal.btnCancelarP.addActionListener(this);
        Bpersonal.setVisible(true);
        Bpersonal.txtdni.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        switch(e.getActionCommand())
        {
            case "BUSCAR":
                
                TableModel dtm=Bpersonal.tbPersonal.getModel();
                this.codigo=daoPersonal.obtenerEmpleado(Integer.parseInt(Bpersonal.txtdni.getText())).getCodigo();
                this.dni=daoPersonal.obtenerEmpleado(Integer.parseInt(Bpersonal.txtdni.getText())).getDni();
                this.nombre=daoPersonal.obtenerEmpleado(Integer.parseInt(Bpersonal.txtdni.getText())).getNombre();
                this.telefono=daoPersonal.obtenerEmpleado(Integer.parseInt(Bpersonal.txtdni.getText())).getTelefono();
                this.turno=daoPersonal.obtenerEmpleado(Integer.parseInt(Bpersonal.txtdni.getText())).getHorariolaboral();
                
                dtm.setValueAt(this.codigo,0,0);
                dtm.setValueAt(this.dni,0,1);
                dtm.setValueAt(this.nombre,0,2);
                dtm.setValueAt(this.telefono,0,3);
                Bpersonal.tbPersonal.setModel(dtm);                
                break;
                
            case "ACEPTAR":
                 ArrayList<String> datos=new ArrayList<String>();
                datos.add(this.codigo);
                datos.add(this.dni);
                datos.add(this.nombre);
                datos.add(this.turno);
                
                padre.recibir_datosBuscarE(datos);
                Bpersonal.dispose();
                break;
            case "CANCELAR":
                Bpersonal.setVisible(false);
                Bpersonal=null;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
