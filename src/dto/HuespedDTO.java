/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Luis Fernando
 */
public class HuespedDTO {
    
    private String idHuesped;
    private String Nombre;
    private String DNI;

    public HuespedDTO(String idHuesped) {
        this.idHuesped = idHuesped;
    }

    public HuespedDTO() {
    }

    public HuespedDTO(String idHuesped, String Nombre, String DNI) {
        this.idHuesped = idHuesped;
        this.Nombre = Nombre;
        this.DNI = DNI;
    }

    public String getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(String idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    
}
