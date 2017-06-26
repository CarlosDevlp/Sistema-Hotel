/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import conexion.Conexion;
import dto.dtoHabitacion;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author rsoporte
 */
public class DAOHabitacion extends Conexion {
    
    dtoHabitacion Habitacion;
    Connection conn=this.getCon();
    CallableStatement cs;
    PreparedStatement st;
    ResultSet rs;

    public DAOHabitacion() {
        
    }
    
    public ArrayList<String> obtenerTiposHabitacion()
    {
        ArrayList<String> tiposHabitacion=new ArrayList<>();
        
        try{
            st=conn.prepareStatement("select DescripcionTHA from TipoHabitacion");
            rs=st.executeQuery();
            
            while(rs.next())
            {
                tiposHabitacion.add(rs.getString(1));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.toString());
            e.getStackTrace();
        }
        
        return tiposHabitacion;
        
    }
    
    public List obtenerPisos()
    {
        List pisos=new List();
        try{
            st=conn.prepareStatement("select UbicacionPis from Piso");
            rs=st.executeQuery();
            
            while(rs.next())
            {
                pisos.add(rs.getString(1));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.toString());
            e.getStackTrace();
        }        
        
        return pisos;
    }
    
    public List ObtenerNumsHabitacion(String piso)
    {
        List numeros=new List();
        
        try{
            //st=conn.prepareStatement(String.format("select DISTINCT(NumeroHab) from Habitacion WHERE Ubicacion_idUbicacion in(SELECT idUbicacion from Ubicacion where PisoUbi={0})",piso));
            st=conn.prepareStatement("select DISTINCT(NumeroHab) from Habitacion");
            rs=st.executeQuery();
            
            while(rs.next())
            {
                numeros.add(rs.getString(1));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.toString());
            e.getStackTrace();
        }
        return numeros;
    }
    
    public void ActualizarEstadoHabitacion(String num,String estado)
    {
                try{
            //st=conn.prepareStatement(String.format("select DISTINCT(NumeroHab) from Habitacion WHERE Ubicacion_idUbicacion in(SELECT idUbicacion from Ubicacion where PisoUbi={0})",piso));
            st=conn.prepareStatement(String.format("update Habitacion set EstadoHab='%s' where NumeroHab=%d",estado,Integer.parseInt(num)));
            st.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.toString());
        }    
    }
    
    public dtoHabitacion obtenerHabitacion(int numero)
    {
        Habitacion=new dtoHabitacion();
        try{
            cs=conn.prepareCall("{call ObtenerHabitacionbyNumero(?)}");
            cs.setInt(1,numero);
            
            rs=cs.executeQuery();
            
            if(rs.next())
            {
                Habitacion.setIdhabitacion(rs.getInt(1));
                Habitacion.setDescripcion(rs.getString(2));
                Habitacion.setNumero(rs.getInt(3));
                Habitacion.setIdPiso(rs.getInt(4));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Habitacion;
    }
    
    
    public ArrayList<dtoHabitacion> obtenerHabitacionPendientes(String estado)
    {
        ArrayList<dtoHabitacion> habitacionesPendientes=new ArrayList<dtoHabitacion>();
        
                try{
            cs=conn.prepareCall("{call ObtenerHabitacionesPendientes(?)}");
            cs.setString(1,estado);
            rs=cs.executeQuery();
            
            
            while(rs.next())
            {
                Habitacion=new dtoHabitacion();
                
                Habitacion.setIdhabitacion(rs.getInt(1));
                Habitacion.setNumero(rs.getInt(2));
                Habitacion.setDescripcion(rs.getString(3));
                Habitacion.setEstado(rs.getString(4));
                
                habitacionesPendientes.add(Habitacion);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return habitacionesPendientes;
    }
    
}
