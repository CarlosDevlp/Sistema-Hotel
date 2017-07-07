
package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CRISTIAN
 */
public class ValidaciondeDatos {
    
    Icon i= new ImageIcon(getClass().getResource("/imagenes/notificacion.png"));
    
    public void validarLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if (Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se aceptan letras", "Advertencia", JOptionPane.INFORMATION_MESSAGE, i);
                }
            }
        });
    }
    
     public void validarNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if (!Character.isDigit(c)) {
                    e.consume();
                JOptionPane.showMessageDialog(null, "Solo se aceptan números", "Advertencia", JOptionPane.INFORMATION_MESSAGE, i);
                }
            }
        });
    }
     
     
     public void LimitarCaracteres(final JTextField campo, final int cantidad){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int tamano = campo.getText().length();
                if (tamano>=cantidad) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se aceptan "+  cantidad +" caracteres", "Advertencia", JOptionPane.INFORMATION_MESSAGE, i);
                }
            }
        });
    }
     
     
     TableRowSorter trs = null;
   public void KeyTyped(final JTextField campo,final int numFiltro, final JTable tabla){
       
       campo.addKeyListener(new KeyAdapter() {
           @Override
           public void keyReleased(final KeyEvent evt){
               trs.setRowFilter(RowFilter.regexFilter(campo.getText(), numFiltro));
           }
       });
       
      // DefaultTableModel dtm = new DefaultTableModel();
      // trs= new TableRowSorter(dtm);
       tabla.setRowSorter(trs);
   }
}
