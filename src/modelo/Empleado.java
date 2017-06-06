/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author carlos
 */
public class Empleado  extends Persona{
    private String _idEmpleado;
    private float sueldo;
    private Usuario usuario;    
    private String  tipoEmpleado;
   
    

    //constructores
   
    Empleado(String idEmpleado,String _nombre, Usuario _usuario,String _dni, String _direccion, String _idDistrito, String _idProvincia, String _idDepartamento, int _telefono){
        //super(_nombre,  _dni, _direccion, _idDistrito, _idProvincia, _idDepartamento, _telefono);
        this._idEmpleado=idEmpleado;        
        this.usuario=_usuario;
    }
    
    
    
    //setters and getters
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
}