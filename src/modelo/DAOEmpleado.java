/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


import dto.dtoEmpleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author rsoporte
 */
public class DAOEmpleado extends Conexion {
    
    dtoEmpleado Empleado;
    Connection conn;
    CallableStatement cs;
    PreparedStatement st;
    ResultSet rs;

    public DAOEmpleado(){
        
        conn=this.getCon();
    }
    
    public ArrayList<dtoEmpleado> obtenerEmpleado()
    {
        
        ArrayList<dtoEmpleado> lista = new ArrayList<dtoEmpleado>();
        try{
            cs=conn.prepareCall("{call ObtenerEmpleadobyDNI()}");
            //cs.setInt(1,dni);
            rs=cs.executeQuery();
            
            while(rs.next())
            {
                Empleado=new dtoEmpleado(Integer.toString(rs.getInt(1)),
                        rs.getString(2), 
                        rs.getString(3) ,
                        rs.getString(4));

                lista.add(Empleado);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return lista;
    }
    
}
