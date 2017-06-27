/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.BasicDao;
import java.util.Map;

/**
 *
 * @author Propietario
 */
public class DetalleReserva {
    private String Habitacion_idHab;
    private String Reserva_idReserva;
    private String Huesped_idHSP;
    
    public DetalleReserva(){
        
    }
    public DetalleReserva(String Habitacion_idHab, String Reserva_idReserva, String Huesped_idHSP) {
        this.Habitacion_idHab = Habitacion_idHab;
        this.Reserva_idReserva = Reserva_idReserva;
        this.Huesped_idHSP = Huesped_idHSP;
    }

    public String getHabitacion_idHab() {
        return Habitacion_idHab;
    }

    public void setHabitacion_idHab(String Habitacion_idHab) {
        this.Habitacion_idHab = Habitacion_idHab;
    }

    public String getReserva_idReserva() {
        return Reserva_idReserva;
    }

    public void setReserva_idReserva(String Reserva_idReserva) {
        this.Reserva_idReserva = Reserva_idReserva;
    }

    public String getHuesped_idHSP() {
        return Huesped_idHSP;
    }

    public void setHuesped_idHSP(String Huesped_idHSP) {
        this.Huesped_idHSP = Huesped_idHSP;
    }
    
    public void grabarDetalleReserva(String idHab,String idHsp){
        Map<String,String> result;
            result= BasicDao.selectLastRow("Reserva",new String []{"idReserva"},"idReserva");
        BasicDao.insert("DetalleReserva", new String []{"Reserva_idReserva","Habitacion_idHab","Huesped_idHSP"}, new String []{result.get("idReserva"),idHab,idHsp});
    }
    
}
