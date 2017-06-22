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
 * Entidad Persona
 * @author carlos
 */
public abstract class Persona{  
    
    private String idPersona;
    private String RucDNI;
    private String fullNamePer;
    private String mApellidos;
    private String mGenero;
    private int edadPer;
    private String telefonoPer;
    private String direccionPer;
    private String emailPer;
    
    //Cconstructors
    public Persona(){
        //función por defecto para su uso en factories
    }
    public Persona( String dni, String nombres, String apellidos,String genero,int edad,String telefono,String direccion,String correo) {
        RucDNI = dni;
        fullNamePer = nombres;
        mApellidos = apellidos;                        
        mGenero= genero;
        edadPer= edad;
        telefonoPer = telefono;
        direccionPer = direccion;
        emailPer= correo;
    }
     public Persona(Map<String, String> args) {
        idPersona=args.get("idPersona");
        RucDNI = args.get("RucDNIRSo");
        fullNamePer = args.get("FullNamePer"); 
        edadPer= Integer.parseInt(args.get("EdadPer"));
        telefonoPer = args.get("TelefonoPer");
        direccionPer = args.get("DireccionPer");
        emailPer= args.get("EmailPer");
    }
   //setters and getters 
     
    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }
    
    public String getNombre() {
        return fullNamePer;
    }

    public void setNombre(String _nombre) {
        this.fullNamePer = _nombre;
    }

    public String getDni() {
        return RucDNI;
    }

    public void setDni(String _dni) {
        this.RucDNI = _dni;
    }

    public String getDireccion() {
        return direccionPer;
    }

    public void setDireccion(String _direccion) {
        this.direccionPer = _direccion;
    }
  
    public String getTelefono() {
        return telefonoPer;
    }

    public void setTelefono(String telefono) {
        this.telefonoPer = telefono;
    }

    public String getApellidos() {
        return mApellidos;
    }

    public void setApellidos(String mApellidos) {
        this.mApellidos = mApellidos;
    }

    public String getGenero() {
        return mGenero;
    }

    public void setGenero(String mGenero) {
        this.mGenero = mGenero;
    }

    public int getEdad() {
        return edadPer;
    }

    public void setEdad(int mEdad) {
        this.edadPer = mEdad;
    }

    public String getCorreo() {
        return emailPer;
    }

    public void setCorreo(String mCorreo) {
        this.emailPer = mCorreo;
    }
    
    
    public String []toArray(){
        
        return new String[]{RucDNI ,fullNamePer ,mApellidos ,mGenero,edadPer+"",telefonoPer ,direccionPer ,emailPer};
        
    }
    
    public static ArrayList<Persona> getClienteList(){
        ArrayList<Map<String,String>> result = BasicDao.call("Listar_Cliente", null);
        ArrayList<Persona> clienteList=new ArrayList();
        for(Map<String,String> row:result) 
            clienteList.add(new Persona(row){});
        return clienteList;
        
    }
    
    
    public static ArrayList<Persona> getClienteDni(String dni){
        ArrayList<Map<String,String>> result = BasicDao.call("Listar_Cliente_DNI", new String[]{dni});
        ArrayList<Persona> clienteList=new ArrayList();
        for(Map<String,String> row:result) 
            clienteList.add(new Persona(row){});
        return clienteList;
        
    }
    
    public void nuevoPersona(){
        
            BasicDao.insert("RazonSocial",  new String []{"RucDNIRSo"},new String []{this.RucDNI} );
            Map<String,String> result;
            result= BasicDao.selectLastRow("RazonSocial",new String []{"idRazonSocial"},"idRazonSocial");
            BasicDao.insert("Persona", new String []{"FullNamePer","RazonSocial_idRazonSocial","TelefonoPer","EdadPer","DireccionPer","EmailPer"}, new String []{this.fullNamePer,result.get("idRazonSocial"),this.telefonoPer,String.valueOf(this.edadPer),this.direccionPer,this.emailPer});
            Map<String,String> lastIdPer;
            lastIdPer=BasicDao.selectLastRow("Persona", new String[]{"idPersona"}, "idPersona");
            BasicDao.insert("Cliente",  new String []{"Persona_idPersona"},new String []{lastIdPer.get("idPersona")} );  
    }
}