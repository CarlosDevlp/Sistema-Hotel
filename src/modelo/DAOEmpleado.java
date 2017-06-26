/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import com.mysql.jdbc.MySQLConnection;
import dto.dtoEmpleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexion.Conexion;

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
    
    public dtoEmpleado obtenerEmpleado(int dni)
    {
        Empleado=new dtoEmpleado();
        
        try{
            cs=conn.prepareCall("{call ObtenerEmpleadobyDNI(?)}");
            cs.setInt(1,dni);
            rs=cs.executeQuery();
            
            if(rs.next())
            {
                Empleado.setCodigo(Integer.toString(rs.getInt(1)));
                Empleado.setDni(Integer.toString(rs.getInt(2)));
                Empleado.setNombre(rs.getString(3));
                Empleado.setTelefono(Integer.toString(rs.getInt(4)));
                Empleado.setHorariolaboral(rs.getString(5));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return Empleado;
    }
    
}
