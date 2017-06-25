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
    private String mUserName;
    private ArrayList<Log> mLogList;
    
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

    public ArrayList<Log> getLogList() {
        return mLogList;
    }

    public void setLogList(ArrayList<Log> logList) {
        this.mLogList = logList;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }
        
    
    
    //clase log
    public static class Log{        
        private String timekeepLUs;
        private String tablaLUs;
        private String tipoActividad;
        
        //constructor
        public Log() {
        }

        public Log(String timekeepLUs, String tablaLUs, String tipoActividad) {
            this.timekeepLUs = timekeepLUs;
            this.tablaLUs = tablaLUs;
            this.tipoActividad = tipoActividad;
        }

        public Log(Map<String,String> args) {
            this.timekeepLUs = args.get("TimekeepLUs");
            this.tablaLUs = args.get("TablaLUs");
            this.tipoActividad = args.get("DescripcionTHU");            
        }
        
        
        //setters and getters
        public String getTimekeepLUs() {
            return timekeepLUs;
        }

        public void setTimekeepLUs(String timekeepLUs) {
            this.timekeepLUs = timekeepLUs;
        }

        public String getTablaLUs() {
            return tablaLUs;
        }

        public void setTablaLUs(String tablaLUs) {
            this.tablaLUs = tablaLUs;
        }

        public String getTipoActividad() {
            return tipoActividad;
        }

        public void setTipoActividad(String tipoActividad) {
            this.tipoActividad = tipoActividad;
        }
        
        //métodos mágicos
        @Override
        public String toString(){
            return this.timekeepLUs+" - "+this.tipoActividad+" a la tabla "+this.tablaLUs;
        }
        
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
        ArrayList<Map<String,String>> result = BasicDao.select(Constant.DB_TABLE_SESION,new String[] {"*"},where);
        
        ArrayList<Sesion> sesionList=new ArrayList();
        
        for(Map<String,String> row:result){ 
            sesionList.add(new Sesion(row));            
        }
        return sesionList;
    }
    
    
    /**
     * obtener toda la lista de usuarios existentes
     * en la base de datos con condición
     * 
     * @param sesionWhere condición para obtener filas de sesiones
     * @param logWhere condición para obtener filas de logs con respecto a lo anterior
     * @return retorna una arraylist de usuarios
     */
    public static ArrayList<Sesion> getSesionList(String sesionWhere,String logWhere){        
        ArrayList<Map<String,String>> result = BasicDao.select(new String[]{Constant.DB_TABLE_SESION,Constant.DB_TABLE_USUARIO},new String[] {"*"},new String[]{"User_idUser","idUser"},sesionWhere);
        
        ArrayList<Sesion> sesionList=new ArrayList();
        ArrayList<Log> logList;
        
        ArrayList<Map<String,String>> resultLog;
        Sesion sesion;
        for(Map<String,String> row:result){             
            sesion=new Sesion(row);
            sesion.setUserName(row.get("UsuarioUse"));
            sesionList.add(sesion);
            
            
            //obtener log y setear a la sesion
            resultLog=BasicDao.select(new String[]{Constant.DB_TABLE_LOG,Constant.DB_TABLE_TIPO_HISTORIAL},
                                new String[]{"*"},
                                new String[]{"TipoHistorialUser_idTipoHistorialUser","idTipoHistorialUser"},
                                "Sesiones_idSes="+sesion.getIdSesion()+" "+logWhere);
            
            //System.out.println("obteniendo logs.... , size:"+resultLog.size());
            if(!resultLog.isEmpty()){                
                logList=new ArrayList();
                for(Map<String,String> rowLog:resultLog)
                        logList.add(new Log(rowLog));
                
                sesion.setLogList(logList);               
            }
            
            
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