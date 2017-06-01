/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;

/**
 * Standard Form, clase de formulario genérico que permite
 * el uso de diferen
 * @author Carlos Chavez Laguna
 */
abstract public class StandardForm extends javax.swing.JFrame{

    
    public void messageBox(String title,String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }    
    
    public void messageBoxAlert(String title,String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }    
    
    public void messageBoxError(String title,String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
}
