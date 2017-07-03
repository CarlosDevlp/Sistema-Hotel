/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import conexion.Conexion;
import dto.dtoHabitacionMantenimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rsoporte
 */
public class DaoHabitacionMantenimiento extends Conexion{
    
    dtoHabitacionMantenimiento MantHabitacion;
    Connection conn=this.getCon();
    PreparedStatement st;
    CallableStatement cs;
    ResultSet rs;

    public DaoHabitacionMantenimiento() {
    }
    
    public ArrayList<dtoHabitacionMantenimiento> ObtenerHabitacionesMantenimiento()
    {
        ArrayList<dtoHabitacionMantenimiento> habitacionesPendientes=new ArrayList<dtoHabitacionMantenimiento>();
        
                try{
            cs=conn.prepareCall("{call ObtenerHabitacionesMantenimiento()}");
            rs=cs.executeQuery();
            
            
            while(rs.next())
            {
                MantHabitacion=new dtoHabitacionMantenimiento();
                
                MantHabitacion.setCodMantenimiento(rs.getInt(1));
                MantHabitacion.setNumHab(rs.getInt(2));
                MantHabitacion.setTipoHab(rs.getString(3));
                MantHabitacion.setPersonal(rs.getString(4));
                
                habitacionesPendientes.add(MantHabitacion);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return habitacionesPendientes;
    }
    
    public void RegistrarMantenimiento(int idper,int idhab,String fecha,String obs)
    {
        try{
            String query="insert into RegistroLimpiezaHabitacion values(null,?,?,?,?)";
            st=conn.prepareStatement(query);
            st.setInt(2,idhab);
            st.setInt(1,idper);
            st.setString(3,fecha);
            st.setString(4,obs);
            st.execute();
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public void EliminarHabitacionesMantenimiento(String codRHL)
    {
                        try{
            cs=conn.prepareCall("{call EliminarRLH(?)}");
            cs.setString(1,codRHL);
            cs.execute();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
    
    public void ActualizarEstadoRHL(int codRHL)
    {
                        try{
            cs=conn.prepareCall("{call ActualizarEstadoHabitacionesMantenimiento(?)}");
            cs.setInt(1,codRHL);
            cs.execute();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
}
