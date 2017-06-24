/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import assets.values.Constant;
import dao.BasicDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Objeto sesión
 * Grupo: Facturación / Seguridad
 * @author Carlos Chavez Laguna
 */
public class Sesion {
    private String idSesion;
    private String descripcionSes;
    private String timeInitSes;
    private String timesFinishSes;
    private String idUser;
    
    
    //constructores
    public Sesion() {
        
    }

    public Sesion(String idSesion, String descripcionSes, String timeInitSes, String timesFinishSes, String idUser) {
        this.idSesion = idSesion;
        this.descripcionSes = descripcionSes;
        this.timeInitSes = timeInitSes;
        this.timesFinishSes = timesFinishSes;
        this.idUser = idUser;
    }

    public Sesion(Map<String, String> args) {
        this.idSesion = args.get("idSesiones");
        this.descripcionSes = args.get("DescripcionSes");
        this.timeInitSes = args.get("TimeInitSes");
        this.timesFinishSes = args.get("TimesFinishSes");
        this.idUser = args.get("User_idUser");
    }
    
    //setters and getters

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public String getDescripcionSes() {
        return descripcionSes;
    }

    public void setDescripcionSes(String descripcionSes) {
        this.descripcionSes = descripcionSes;
    }

    public String getTimeInitSes() {
        return timeInitSes;
    }

    public void setTimeInitSes(String timeStampSes) {
        this.timeInitSes = timeStampSes;
    }

    public String getTimesFinishSes() {
        return timesFinishSes;
    }

    public void setTimesFinishSes(String timesFinishSes) {
        this.timesFinishSes = timesFinishSes;
    }    
    
    public Sesion(String timesFinishSes) {
        this.timesFinishSes = timesFinishSes;
    }
    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
    //otros métodos    
    public void startSesion(){     
        this.timeInitSes=generateCurrentTimeString();
        save();
    }
    
    public void finishSesion(){
        this.timesFinishSes=generateCurrentTimeString();
        save();
    }
    
    public String generateCurrentTimeString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
        return dateFormat.format(new Date());
    }
    
    
     /**
     * Save <br>
     * Guardar datos en la base de datos
     */
    public void save(){
        //si el usuario existe
        if(BasicDao.rowExists(Constant.DB_TABLE_SESION, "idSesiones="+idSesion)) //actualizar sus datos
            BasicDao.update(Constant.DB_TABLE_SESION, new String []{"DescripcionSes","TimeInitSes","TimesFinishSes","User_idUser"}, new String []{this.descripcionSes,this.timeInitSes,this.timesFinishSes,this.idUser}, "idSesiones="+idSesion);
        else //crear al usuario con los datos actuales
            BasicDao.insert(Constant.DB_TABLE_SESION, new String []{"DescripcionSes","TimeInitSes","TimesFinishSes","User_idUser"}, new String []{this.descripcionSes,this.timeInitSes,this.timesFinishSes,this.idUser});
    }
    
    
    public static Sesion getLastSesionOfUser(String userId){
        ArrayList<Map<String,String>> result = BasicDao.select(Constant.DB_TABLE_SESION,new String[] {"*"},"User_idUser="+userId+" ORDER BY idSesiones DESC LIMIT 1 ");        
        return new Sesion(result.get(0));
    }
    
    /**
     * obtener toda la lista de usuarios existentes
     * en la base de datos con condición
     * 
     * @param where condición
     * @return retorna una arraylist de usuarios
     */
    public static ArrayList<Sesion> getSesionList(String where){
        
        //ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_USUARIO, new String[]{"*"}, where);
        //inner join
        ArrayList<Map<String,String>> result = BasicDao.select(Constant.DB_TABLE_SESION,new String[] {"*"},where);
        
        ArrayList<Sesion> sesionList=new ArrayList();
        
        for(Map<String,String> row:result){ 
            sesionList.add(new Sesion(row));            
        }
        return sesionList;
    }
    
    
    
    /**
     * obtener toda la lista de usuarios existentes
     * en la base de datos.
     * 
     * @return retorna una arraylist de usuarios
     */
    public static ArrayList<Sesion> getSesionList(){
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_SESION, new String[]{"*"}, null);
        ArrayList<Sesion> sesionList=new ArrayList();
        for(Map<String,String> row:result){ 
            sesionList.add(new Sesion(row));
        }
        return sesionList;
    }
    
            
    
    
    
}