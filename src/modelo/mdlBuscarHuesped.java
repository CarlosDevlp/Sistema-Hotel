/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class mdlBuscarHuesped extends Conexion {

    public DefaultTableModel getTablaHuesped(String dni) throws Exception {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Codigo", "Nombres", "DNI"};
        //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
        //para formar la matriz de datos
        try {
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT count(*) as total FROM huesped where dnihsp LIKE '%" + dni + "%' AND IDHSP NOT IN(SELECT H.IDHSP FROM HUESPED H JOIN DETALLERESERVA DR ON H.IDHSP=DR.HUESPED_IDHSP)");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][4];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT * FROM huesped where dnihsp LIKE '%" + dni + "%'and IDHSP NOT IN(SELECT H.IDHSP FROM HUESPED H JOIN DETALLERESERVA DR ON H.IDHSP=DR.HUESPED_IDHSP)");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("idhsp");
                data[i][1] = res.getString("nombrehsp");
                data[i][2] = res.getString("dnihsp");
                i++;
            }
            res.close();
            //se añade la matriz de datos en el DefaultTableModel
            tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablemodel;
    }

    public DefaultTableModel getTablaHuesped2() throws Exception {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Codigo", "Nombres", "DNI"};
        //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
        //para formar la matriz de datos
        try {
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT count(*) as total FROM huesped WHERE IDHSP NOT IN(SELECT H.IDHSP FROM HUESPED H JOIN DETALLERESERVA DR ON H.IDHSP=DR.HUESPED_IDHSP)");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][4];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT * FROM huesped WHERE IDHSP NOT IN(SELECT H.IDHSP FROM HUESPED H JOIN DETALLERESERVA DR ON H.IDHSP=DR.HUESPED_IDHSP)");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("idhsp");
                data[i][1] = res.getString("nombrehsp");
                data[i][2] = res.getString("dnihsp");
                i++;
            }
            res.close();
            //se añade la matriz de datos en el DefaultTableModel
            tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablemodel;
    }
}
