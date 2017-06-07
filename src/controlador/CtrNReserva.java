/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Italo
 */
public class CtrNReserva {
    private ctrGenerarReserva mctrGenerarReserva;

    
    
    //constructores

    public CtrNReserva() {
    }
    
    
    //setters and getters
    
    public ctrGenerarReserva getCtrGenerarReserva() {
        return mctrGenerarReserva;
    }

    public void setCtrGenerarReserva(ctrGenerarReserva mctrGenerarReserva) {
        this.mctrGenerarReserva = mctrGenerarReserva;
    }
    
    
    
    //otros métodos
    
    public void showGenerarReserva(){
        this.mctrGenerarReserva.showGenerarReserva();
        if (!this.mctrGenerarReserva.activo) {
                    this.mctrGenerarReserva.mantenerGUIreserva();
        }
    }
    
}
