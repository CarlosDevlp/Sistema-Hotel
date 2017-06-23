/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Entidad Persona
 * @author carlos
 */
public abstract class Persona{    
    private String idPersona;
    private String RucDNI;
    private String fullNamePer;
    private int edadPer;
    private String telefonoPer;
    private String direccionPer;
    private String emailPer;
    
    public static final String TABLE_PERSONA_COLUMN_ID_PERSONA="idPersona",
                               TABLE_PERSONA_COLUMN_FULL_NAME="FullNamePer",
                               TABLE_PERSONA_COLUMN_TELEFONO="TelefonoPer",
                               TABLE_PERSONA_COLUMN_EMAIL="EmailPer",
                               TABLE_PERSONA_COLUMN_DIRECCION="DireccionPer",
                               TABLE_PERSONA_COLUMN_EDAD="EdadPer";
    
    //Cconstructors
    public Persona(){
        //función por defecto para su uso en factories
        idPersona="0";
    }
    public Persona( String dni, String nombresCompleto, int edad,String telefono,String direccion,String correo) {
        idPersona="0";
        RucDNI = dni;
        fullNamePer = nombresCompleto;        
        edadPer= edad;
        telefonoPer = telefono;
        direccionPer = direccion;
        emailPer= correo;
    }

   //setters and getters     

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }    
    
    public String getFullNamePer() {
        return fullNamePer;
    }

    public void setFullNamePer(String fullNamePer) {
        this.fullNamePer = fullNamePer;
    }    

    public String getRucDNI() {
        return RucDNI;
    }

    public void setRucDNI(String RucDNI) {
        this.RucDNI = RucDNI;
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
        return new String[]{RucDNI ,fullNamePer ,edadPer+"",telefonoPer ,direccionPer ,emailPer};        
    }
}