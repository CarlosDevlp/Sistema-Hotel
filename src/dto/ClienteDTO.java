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
public class ClienteDTO extends PersonaDTO{

    private String Empresa;
    private String RUC;

    public ClienteDTO() {
    }

    public ClienteDTO(String idPersona) {
        super(idPersona);
    }

    public ClienteDTO(String idPersona, String Empresa, String RUC, String Nombre, String Apellido, String DNI, String Telefono, String Email, String Direccion) {
        super(idPersona, Nombre, Apellido, DNI, Telefono, Email, Direccion);
        this.Empresa = Empresa;
        this.RUC = RUC;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }


    
}
