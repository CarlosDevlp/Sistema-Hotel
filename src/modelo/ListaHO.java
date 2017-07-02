/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Map;

/**
 *
 * @author Han
 */
public class ListaHO {
    private String cod, numhab, tipohab, fechaing, PxD, diasaloj, costoxH;

    public ListaHO(String cod, String numhab, String tipohab, String fechaing, String PxD, String diasaloj, String costoxH) {
        this.cod = cod;
        this.numhab = numhab;
        this.tipohab = tipohab;
        this.fechaing = fechaing;
        this.PxD = PxD;
        this.diasaloj = diasaloj;
        this.costoxH = costoxH;
    }
    
    public ListaHO(Map<String, String> args){
        this.cod = args.get("Codigo Hab.");
        this.numhab = args.get("Numero Hab.");
        this.tipohab = args.get("Tipo Hab.");
        this.fechaing = args.get("Fecha Ingreso");
        this.PxD = args.get("Precio x Dia");
        this.diasaloj = args.get("Dias Alojado");
        this.costoxH = args.get("Costo x Habitacion");
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNumhab() {
        return numhab;
    }

    public void setNumhab(String numhab) {
        this.numhab = numhab;
    }

    public String getTipohab() {
        return tipohab;
    }

    public void setTipohab(String tipohab) {
        this.tipohab = tipohab;
    }

    public String getFechaing() {
        return fechaing;
    }

    public void setFechaing(String fechaing) {
        this.fechaing = fechaing;
    }

    public String getPxD() {
        return PxD;
    }

    public void setPxD(String PxD) {
        this.PxD = PxD;
    }

    public String getDiasaloj() {
        return diasaloj;
    }

    public void setDiasaloj(String diasaloj) {
        this.diasaloj = diasaloj;
    }

    public String getCostoxH() {
        return costoxH;
    }

    public void setCostoxH(String costoxH) {
        this.costoxH = costoxH;
    }
    
    
}
