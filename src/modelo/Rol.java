/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import assets.values.Constant;
import dao.BasicDao;
import java.util.ArrayList;
import java.util.Map;

/**
 *Rol, lista de funcionalidades 
 * disponibles por tipo de usuario
 * @author Carlos Chavez Laguna
 */
public class Rol {
    private String idRoles;
    private String nombreRol;
    private String [] pestanasHabilitadas;
    /**
     * DELIMETER,
     * Permite definir un caracter separador para poder cortar strings
     * y volverlos en arrays
     */
    public static final String DELIMETER=",";
    
//constructor
    public Rol() {
        this.idRoles = "0";
    }

    public Rol(String idRoles, String nombreRol, String[] pestanasHabilitadas) {
        this.idRoles = idRoles;
        this.nombreRol = nombreRol;
        this.pestanasHabilitadas = pestanasHabilitadas;
    }

    
    public Rol(String idRoles, String nombreRol, String  strPestanasHabilitadas) {
        this.idRoles = idRoles;
        this.nombreRol = nombreRol;
        this.pestanasHabilitadas = strPestanasHabilitadas.split(DELIMETER);
    }
    
    
    
    
    
    /**
     * Constructor especial que acepta mapas para convertirlo en el objeto Rol
     *  @param args ,el mapa que contiene los valores del objeto
     */
    public Rol(Map<String,String> args) {
        this.idRoles = args.get("idRoles");
        this.nombreRol = args.get("NombreRol");                
        this.pestanasHabilitadas = args.get("PestanasRol").split(DELIMETER);  
    }
    
    
    
    //setters and getters
    public String getIdRoles() {
        return idRoles;
    }

    
    public void setIdRoles(String idRoles) {
        this.idRoles = idRoles;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String[] getPestanasHabilitadas() {
        return pestanasHabilitadas;
    }

    public String getPestanasHabilitadasString() {
        String pestanasString="";        
        
        for(int i=0;i<this.pestanasHabilitadas.length;i++){
            if(i>0)pestanasString+=",";
            pestanasString+=this.pestanasHabilitadas[i];
        }
        return pestanasString;
    }
    
    public void setPestanasHabilitadas(String[] pestanasHabilitadas) {
        this.pestanasHabilitadas = pestanasHabilitadas;
    }
    
    public void setPestanasHabilitadas(String strPestanasHabilitadas) {
        this.pestanasHabilitadas = strPestanasHabilitadas.split(DELIMETER);
    }
    
    

    //otros métodos    
    public static Rol getRol(String roleId){
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_ROLES, new String[]{"*"}, "idRoles="+roleId);
        return new Rol(result.get(0));
    }
    
    /**
     * obtener la lista de roles dependiendo de la condición 
     * 
     * @param where condición
     * 
     * @return matriz de roles
     */
    public static ArrayList<Rol> getRolList(String where){
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_ROLES, new String[]{"*"}, where);
        ArrayList<Rol> rolList=new ArrayList();
        for(Map<String,String> row:result) rolList.add(new Rol(row));        
        return rolList;
    }
    /**
     * obtener toda la lista de roles existentes
     * en la base de datos.
     * 
     * @return retorna una arraylist de roles
     */
    public static ArrayList<Rol> getRolList(){
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_ROLES, new String[]{"*"}, null);
        ArrayList<Rol> rolList=new ArrayList();
        for(Map<String,String> row:result) rolList.add(new Rol(row));        
        return rolList;
    }
    
    /**
     * 
     * guardar rol en la base de datos
     */
    public void save(){
        String pestanasString="";        
        
        for(int i=0;i<this.pestanasHabilitadas.length;i++){
            if(i>0)pestanasString+=",";
            pestanasString+=this.pestanasHabilitadas[i];
        }
        
        Sesion currentSesion= Usuario.getInstance().getCurrentSesion();
        BasicDao.call("guardarRol", new String[]{currentSesion.getIdSesion(),idRoles,"'"+nombreRol+"'","'"+pestanasString+"'"});
        /*
        //si el rol existe
        if(BasicDao.rowExists(Constant.DB_TABLE_ROLES, "idRoles="+idRoles)) //actualizar sus datos
            BasicDao.update(Constant.DB_TABLE_ROLES, new String []{"NombreRol","PestanasRol"}, new String []{this.nombreRol,pestanasString}, "idRoles="+this.idRoles);
        else //crear al rol con los datos actuales
            BasicDao.insert(Constant.DB_TABLE_ROLES, new String []{"NombreRol","PestanasRol"}, new String []{this.nombreRol,pestanasString});
        */
    }
    
    /**
     * 
     * remover rol de la base de datos
     */
    public void remove(){       
        Sesion currentSesion= Usuario.getInstance().getCurrentSesion();
        BasicDao.call("removerRol", new String[]{currentSesion.getIdSesion(),idRoles});
        /*BasicDao.delete(Constant.DB_TABLE_ROLES, "idRoles="+idRoles);*/
    }
    
}
