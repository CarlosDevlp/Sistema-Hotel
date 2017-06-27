/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.BasicDao;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Propietario
 */
public class Habitacion {
    private String idHab;
    private String NumeroHab;
    private String DescripcionTHA;
    private String CostoHab;
    private String EstadoHab;
    
    public Habitacion(){
        
    }
    
    public Habitacion(String idHab, String NumeroHab, String DescripcionTHA, String CostoHab, String EstadoHab) {
        this.idHab = idHab;
        this.NumeroHab = NumeroHab;
        this.DescripcionTHA = DescripcionTHA;
        this.CostoHab = CostoHab;
        this.EstadoHab = EstadoHab;
    }

    public Habitacion(Map<String, String> args){
        this.idHab = args.get("idHab");
        this.NumeroHab = args.get("NumeroHab");
        this.DescripcionTHA = args.get("DescripcionTHA");
        this.CostoHab = args.get("CostoHab");
        this.EstadoHab = args.get("EstadoHab");
    }
    public String getIdHab() {
        return idHab;
    }

    public void setIdHab(String idHab) {
        this.idHab = idHab;
    }

    public String getNumeroHab() {
        return NumeroHab;
    }

    public void setNumeroHab(String NumeroHab) {
        this.NumeroHab = NumeroHab;
    }

    public String getDescripcionTHA() {
        return DescripcionTHA;
    }

    public void setDescripcionTHA(String DescripcionTHA) {
        this.DescripcionTHA = DescripcionTHA;
    }

    public String getCostoHab() {
        return CostoHab;
    }

    public void setCostoHab(String CostoHab) {
        this.CostoHab = CostoHab;
    }

    public String getEstadoHab() {
        return EstadoHab;
    }

    public void setEstadoHab(String EstadoHab) {
        this.EstadoHab = EstadoHab;
    }
    
    public static ArrayList<Habitacion> getHabitacionList(){
        ArrayList<Map<String,String>> result = BasicDao.call("Listar_Habitacion", null);
        ArrayList<Habitacion> habitacionList=new ArrayList();
        for(Map<String,String> row:result) 
            habitacionList.add(new Habitacion(row){});
        return habitacionList;
    }
    
    public static ArrayList<Habitacion> getHabitacionTipo(String DescripcionTHA){
        ArrayList<Map<String,String>> result = BasicDao.call("Listar_Habitacion_Tipo", new String[]{"'"+DescripcionTHA+"'"});
        ArrayList<Habitacion> habitacionList=new ArrayList();
        for(Map<String,String> row:result) 
            habitacionList.add(new Habitacion(row){});
        return habitacionList;
    }
    
    public static void updateEstadoHabitacion(String codHab,String estado){
        BasicDao.call("Actualizar_Estado_Habitacion", new String[]{codHab,"'"+estado+"'","'Update'","'Habitacion'","(select idSesiones from Sesiones ORDER BY idSesiones DESC LIMIT 1)"});
    }
}
