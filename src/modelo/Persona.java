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

   //setters and getters    
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
}