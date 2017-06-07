/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mdlRegistrarCliente extends Conexion {

    public boolean NuevoCliente(String nombre, String documento, String sexo, String direccion, String telefono, String correo) throws Exception {
        if (valida_datos(nombre, documento, sexo, direccion, telefono, correo)) {
            //Se arma la consulta
            String q = "INSERT INTO PERSONA (FullNamePer,Documento,sexo,DireccionPer,TelefonoPer,EmailPer)"
                                + "VALUES ('" + nombre.toUpperCase() + "', '" + documento.toUpperCase() + "', '" + sexo.toUpperCase() + "', '" + direccion.toUpperCase() + "', '" + telefono + "', '" + correo.toUpperCase() + "') ";

            String w = "INSERT INTO CLIENTE VALUES((SELECT IDPERSONA FROM PERSONA ORDER BY IDPERSONA DESC LIMIT 1))";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getCon().prepareStatement(q);
                PreparedStatement pstm2 = this.getCon().prepareStatement(w);
                pstm.execute();
                pstm2.execute();
                pstm.close();
                return true;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return false;
        } else {
            return false;
        }
    }

    private boolean valida_datos(String nombre, String documento, String sexo, String direccion, String telefono, String correo) {

        if (nombre.length() > 0 && (documento.length() == 8 || documento.length() == 11) && sexo.length() > 0 && direccion.length() > 0 && telefono.length() > 6 && correo.length() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
