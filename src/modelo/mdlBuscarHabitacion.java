/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import conexion.Conexion;

public class mdlBuscarHabitacion extends Conexion {

    public DefaultTableModel getTablaHabitacion(String tipohab) throws Exception {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Codigo", "Numero", "Tipo", "Costo", "Estado"};
        //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
        //para formar la matriz de datos
        try {
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT count(H.IDHAB) as total ,H.NUMEROHAB,T.DESCRIPCIONTPH,H.COSTOHAB,H.ESTADOHAB FROM HABITACION H JOIN TIPOHABITACION T ON H.IDTPH=T.IDTPH where T.DESCRIPCIONTPH='" + tipohab + "'and H.ESTADOHAB='LIBRE'");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][6];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            //idPersona,FullNamePer,TelefonoPer,EmailPer,DireccionPer,Sexo,Documento
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT H.IDHAB,H.NUMEROHAB,T.DESCRIPCIONTPH,H.COSTOHAB,H.ESTADOHAB FROM HABITACION H JOIN TIPOHABITACION T ON H.IDTPH=T.IDTPH where T.DESCRIPCIONTPH='" + tipohab + "' and H.ESTADOHAB='LIBRE'");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("H.IDHAB");
                data[i][1] = res.getString("H.NUMEROHAB");
                data[i][2] = res.getString("T.DESCRIPCIONTPH");
                data[i][3] = res.getString("H.COSTOHAB");
                data[i][4] = res.getString("H.ESTADOHAB");
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

    public DefaultTableModel getTablaHabitacion2() throws Exception {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Codigo", "Numero", "Tipo", "Costo", "Estado"};
        //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
        //para formar la matriz de datos
        try {
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT count(*) as total FROM habitacion where ESTADOHAB='LIBRE'");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][6];
        try {
            //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
            //idPersona,FullNamePer,TelefonoPer,EmailPer,DireccionPer,Sexo,Documento
            PreparedStatement pstm = this.getCon().prepareStatement("SELECT H.IDHAB,H.NUMEROHAB,T.DESCRIPCIONTPH,H.COSTOHAB,H.ESTADOHAB FROM HABITACION H JOIN TIPOHABITACION T ON H.IDTPH=T.IDTPH where ESTADOHAB='LIBRE'");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("H.IDHAB");
                data[i][1] = res.getString("H.NUMEROHAB");
                data[i][2] = res.getString("T.DESCRIPCIONTPH");
                data[i][3] = res.getString("H.COSTOHAB");
                data[i][4] = res.getString("H.ESTADOHAB");
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
