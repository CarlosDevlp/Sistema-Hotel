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
public class Reserva {
    private String idReserva;
    private String FechaInicioRes;
    private String FechaFinalRes;
    private String CantidadRes;
    private String EstadoRes;
    private String Cliente_Persona_idPersona;
    private String FechaRes;
    private String CotizacionRes;
    private String Empleado_Persona_idPersona;
    
    public Reserva(){
        
    }
    
    public Reserva(String idReserva, String FechaInicioRes, String FechaFinalRes, String CantidadRes, String EstadoRes, String Cliente_Persona_idPersona, String FechaRes, String CotizacionRes, String Empleado_Persona_idPersona) {
        this.idReserva = idReserva;
        this.FechaInicioRes = FechaInicioRes;
        this.FechaFinalRes = FechaFinalRes;
        this.CantidadRes = CantidadRes;
        this.EstadoRes = EstadoRes;
        this.Cliente_Persona_idPersona = Cliente_Persona_idPersona;
        this.FechaRes = FechaRes;
        this.CotizacionRes = CotizacionRes;
        this.Empleado_Persona_idPersona = Empleado_Persona_idPersona;
    }
    
    public Reserva(Map<String, String> args) {
        this.idReserva = args.get("idReserva");
        this.FechaInicioRes = args.get("FechaInicioRes");
        this.FechaFinalRes = args.get("FechaFinalRes");
        this.CantidadRes = args.get("CantidadRes");
        this.EstadoRes = args.get("EstadoRes");
        this.Cliente_Persona_idPersona = args.get("Cliente_Persona_idPersona");
        this.FechaRes = args.get("FechaRes");
        this.CotizacionRes = args.get("CotizacionRes");
        this.Empleado_Persona_idPersona = args.get("Empleado_Persona_idPersona");
    }
    
    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaInicioRes() {
        return FechaInicioRes;
    }

    public void setFechaInicioRes(String FechaInicioRes) {
        this.FechaInicioRes = FechaInicioRes;
    }

    public String getFechaFinalRes() {
        return FechaFinalRes;
    }

    public void setFechaFinalRes(String FechaFinalRes) {
        this.FechaFinalRes = FechaFinalRes;
    }

    public String getCantidadRes() {
        return CantidadRes;
    }

    public void setCantidadRes(String CantidadRes) {
        this.CantidadRes = CantidadRes;
    }

    public String getEstadoRes() {
        return EstadoRes;
    }

    public void setEstadoRes(String EstadoRes) {
        this.EstadoRes = EstadoRes;
    }

    public String getCliente_Persona_idPersona() {
        return Cliente_Persona_idPersona;
    }

    public void setCliente_Persona_idPersona(String Cliente_Persona_idPersona) {
        this.Cliente_Persona_idPersona = Cliente_Persona_idPersona;
    }

    public String getFechaRes() {
        return FechaRes;
    }

    public void setFechaRes(String FechaRes) {
        this.FechaRes = FechaRes;
    }

    public String getCotizacionRes() {
        return CotizacionRes;
    }

    public void setCotizacionRes(String CotizacionRes) {
        this.CotizacionRes = CotizacionRes;
    }

    public String getEmpleado_Persona_idPersona() {
        return Empleado_Persona_idPersona;
    }

    public void setEmpleado_Persona_idPersona(String Empleado_Persona_idPersona) {
        this.Empleado_Persona_idPersona = Empleado_Persona_idPersona;
    }
    
    public void grabarReserva(){
        BasicDao.insert("Reserva", new String []{"FechaInicioRes", "FechaFinalRes", "CantidadRes", "EstadoRes", "Cliente_Persona_idPersona", "FechaRes", "CotizacionRes", "Empleado_Persona_idPersona"}, new String []{this.FechaInicioRes,this.FechaFinalRes,this.CantidadRes,this.EstadoRes,this.Cliente_Persona_idPersona,this.FechaRes,this.CotizacionRes,this.Empleado_Persona_idPersona});
    }
    
    public String getCodigoReserva(){
        Map<String,String> result;
            result= BasicDao.selectLastRow("Reserva",new String []{"idReserva"},"idReserva");
            return result.get("idReserva");
    }
    
}
