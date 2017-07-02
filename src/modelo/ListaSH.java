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
public class ListaSH {
    String cod, nombre, fecha, cant, PU, PT;

    public ListaSH(String cod, String nom, String fecha, String cant, String PU, String PT) {
        this.cod = cod;
        this.nombre = nom;
        this.fecha = fecha;
        this.cant = cant;
        this.PU = PU;
        this.PT = PT;
    }
    
    public ListaSH(Map<String, String> args){
    this.cod = args.get("Codigo Pro.");
    this.nombre = args.get("Nombre Pro.");
    this.fecha = args.get("Fecha");
    this.cant = args.get("Cantidad");
    this.PU = args.get("Precio U.");
    this.PT = args.get("Precio Total");
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getPU() {
        return PU;
    }

    public void setPU(String PU) {
        this.PU = PU;
    }

    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }
    
}
