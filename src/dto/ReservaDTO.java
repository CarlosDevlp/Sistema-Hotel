/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Luis Fernando
 */

import java.util.Date;
public class ReservaDTO {
    
    String idReserva;
    Date FechaInicioReserva;
    Date FechaFinalReserva;
    int CantidadReserva;
    String EstadoReserva;
    Date FechaReserva;
    double CotizacionReserva;
    String IdPersonaReserva;

    public ReservaDTO(String idReserva) {
        this.idReserva = idReserva;
    }

    public ReservaDTO() {
    }

    public ReservaDTO(String idReserva, Date FechaInicioReserva, Date FechaFinalReserva, int CantidadReserva, 
            String EstadoReserva, Date FechaReserva, double CotizacionReserva, String IdPersonaReserva) {
        this.idReserva = idReserva;
        this.FechaInicioReserva = FechaInicioReserva;
        this.FechaFinalReserva = FechaFinalReserva;
        this.CantidadReserva = CantidadReserva;
        this.EstadoReserva = EstadoReserva;
        this.FechaReserva = FechaReserva;
        this.CotizacionReserva = CotizacionReserva;
        this.IdPersonaReserva = IdPersonaReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicioReserva() {
        return FechaInicioReserva;
    }

    public void setFechaInicioReserva(Date FechaInicioReserva) {
        this.FechaInicioReserva = FechaInicioReserva;
    }

    public Date getFechaFinalReserva() {
        return FechaFinalReserva;
    }

    public void setFechaFinalReserva(Date FechaFinalReserva) {
        this.FechaFinalReserva = FechaFinalReserva;
    }

    public int getCantidadReserva() {
        return CantidadReserva;
    }

    public void setCantidadReserva(int CantidadReserva) {
        this.CantidadReserva = CantidadReserva;
    }

    public String getEstadoReserva() {
        return EstadoReserva;
    }

    public void setEstadoReserva(String EstadoReserva) {
        this.EstadoReserva = EstadoReserva;
    }

    public Date getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(Date FechaReserva) {
        this.FechaReserva = FechaReserva;
    }

    public double getCotizacionReserva() {
        return CotizacionReserva;
    }

    public void setCotizacionReserva(double CotizacionReserva) {
        this.CotizacionReserva = CotizacionReserva;
    }

    public String getIdPersonaReserva() {
        return IdPersonaReserva;
    }

    public void setIdPersonaReserva(String IdPersonaReserva) {
        this.IdPersonaReserva = IdPersonaReserva;
    }

  
    
}
