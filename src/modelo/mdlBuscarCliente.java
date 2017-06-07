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
/**
 * @author  arar
 */
public class mdlBuscarCliente extends Conexion {

    public DefaultTableModel getTablaCliente(String documento) throws Exception {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Codigo", "Nombres", "Documento", "Direccion", "Telefono"};
        //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
        //para formar la matriz de datos
        try {
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT count(*) as total FROM persona where Documento LIKE '%" + documento + "%'");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][5];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            //idPersona,FullNamePer,TelefonoPer,EmailPer,DireccionPer,Sexo,Documento
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT * FROM persona where Documento LIKE '%" + documento + "%'");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("idPersona");
                data[i][1] = res.getString("FullNamePer");
                data[i][2] = res.getString("Documento");
                data[i][3] = res.getString("TelefonoPer");
                data[i][4] = res.getString("DireccionPer");
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

    public DefaultTableModel getTablaCliente2() throws Exception {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Codigo", "Nombres", "Documento", "Direccion", "Telefono"};
        //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
        //para formar la matriz de datos
        try {
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT count(*) as total FROM persona");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total") - 1;
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][5];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            //idPersona,FullNamePer,TelefonoPer,EmailPer,DireccionPer,Sexo,Documento
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT * FROM persona WHERE IDPERSONA>1");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("idPersona");
                data[i][1] = res.getString("FullNamePer");
                data[i][2] = res.getString("Documento");
                data[i][3] = res.getString("TelefonoPer");
                data[i][4] = res.getString("DireccionPer");
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
