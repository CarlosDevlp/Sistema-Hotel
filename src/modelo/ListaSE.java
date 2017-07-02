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
public class ListaSE {
    private String cod,nombre,fechaserv,cant,PU,PT;

    public ListaSE(String cod, String nombre, String fechaserv, String cant, String PU, String PT) {
        this.cod = cod;
        this.nombre = nombre;
        this.fechaserv = fechaserv;
        this.cant = cant;
        this.PU = PU;
        this.PT = PT;
    }

    public ListaSE(Map<String, String> args) {
         this.cod = args.get("Codigo Serv.");
        this.nombre = args.get("Nombre");
        this.fechaserv = args.get("Fecha Serv.");
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

    public String getFechaserv() {
        return fechaserv;
    }

    public void setFechaserv(String fechaserv) {
        this.fechaserv = fechaserv;
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
