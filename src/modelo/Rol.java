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
    private static final String DELIMETER="|";
    
//constructor
    public Rol() {
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
        this.nombreRol = args.get("nombreRol");
        this.pestanasHabilitadas = args.get("pestanasHabilitadas").split(DELIMETER);
    }
        
    //setters and getters            
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String[] getPestanasHabilitadas() {
        return pestanasHabilitadas;
    }

    public void setPestanasHabilitadas(String[] pestanasHabilitadas) {
        this.pestanasHabilitadas = pestanasHabilitadas;
    }
    

    //otros métodos    
    public static Rol getRol(String roleId){
        ArrayList<Map<String,String>> result=BasicDao.select("roles", new String[]{"*"}, "idRoles="+roleId);
        return new Rol(result.get(0));
    }
    
    
    /**
     * obtener toda la lista de roles existentes
     * en la base de datos.
     * 
     * @return retorna una arraylist de roles
     */
    public static ArrayList<Rol> getRolList(){
        ArrayList<Map<String,String>> result=BasicDao.select("roles", new String[]{"*"}, null);
        ArrayList<Rol> rolList=new ArrayList();
        for(Map<String,String> row:result) rolList.add(new Rol(row));        
        return rolList;
    }
    
}
