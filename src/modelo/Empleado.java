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
    private static int id=0;
    private String _idEmpleado,_cargo;
    private Usuario _usuario;
    Empleado(String _nombre,String _cargo, Usuario _usuario,String _dni, String _direccion, String _idDistrito, String _idProvincia, String _idDepartamento, int _telefono){
        //super(_nombre,  _dni, _direccion, _idDistrito, _idProvincia, _idDepartamento, _telefono);
        this._idEmpleado="EMP"+Empleado.generador();        
        this._cargo=_cargo;
        this._usuario=_usuario;
    }
    private static int generador(){       
        id++;
        return id;
    }
    
}