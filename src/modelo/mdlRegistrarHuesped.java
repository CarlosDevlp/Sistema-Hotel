/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mdlRegistrarHuesped extends Conexion {

    public boolean NuevoHuesped(String nombre, String dni) throws Exception {
        if (valida_datos(nombre, dni)) {
            //Se arma la consulta
            String q = "INSERT INTO huesped (NombreHSP,DNIHSP)"
                                + "VALUES ('" + nombre.toUpperCase() + "', '" + dni + "') ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getCon().prepareStatement(q);
                pstm.execute();
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

    private boolean valida_datos(String nombre, String dni) {

        if (nombre.length() > 0 && dni.length() == 8) {
            return true;
        } else {
            return false;
        }
    }
}
