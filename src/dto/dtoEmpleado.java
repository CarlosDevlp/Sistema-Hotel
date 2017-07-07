/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author rsoporte
 */
public class dtoEmpleado {
        
    protected String dni;
    protected String nombre;
    protected String telefono;
    protected String horariolaboral;

    /**
     * @return the codigo
     */
  
    /**
     * @param codigo the codigo to set
     */
    
    
    
    public dtoEmpleado(String dni, String nombre, String telefono, String horariolaboral) {    
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.horariolaboral = horariolaboral;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the horariolaboral
     */
    public String getHorariolaboral() {
        return horariolaboral;
    }

    /**
     * @param horariolaboral the horariolaboral to set
     */
    public void setHorariolaboral(String horariolaboral) {
        this.horariolaboral = horariolaboral;
    }
}
