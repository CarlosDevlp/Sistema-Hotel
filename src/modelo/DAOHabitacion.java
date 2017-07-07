/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import conexion.Conexion;
import dto.dtoHabitacion;
import dto.dtpEmpleadoDNI;
import java.awt.List;
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
public class DAOHabitacion extends Conexion {
    
    Piso piso;
    dtoHabitacion Habitacion;
    dtpEmpleadoDNI empleadodni;
    ListaDatosHabtacionPorPiso listahab;
    Connection conn=this.getCon();
    CallableStatement cs;
    PreparedStatement st;
    ResultSet rs;

    public DAOHabitacion() {
        
    }
    
    
    public ArrayList<Piso> consultarPiso(){
    ArrayList<Piso> lista = new ArrayList<Piso>();
        try {
            st= conn.prepareCall("{call CargarPisos()}");
            rs= st.executeQuery();
            while (rs.next()) {                
                piso = new Piso();
                piso.setUbicacionPis(rs.getString("Piso.UbicacionPis"));
                lista.add(piso);
            }
           
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
           
        }finally{
            if(st !=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR EN SQL" + e);
                }
            }
        }
        return lista;
}
     
    
    public dtpEmpleadoDNI consultarPorCodigo(String codigo){
       empleadodni= new dtpEmpleadoDNI();
        try {
            cs=conn.prepareCall("{call consultarEmpleado(?)}");
            cs.setString(1, codigo);
            rs= cs.executeQuery();
            if (rs.next()) {
                empleadodni.setNombreEmpleado(rs.getString("Persona.FullNamePer"));
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro a empleado");
            }
            rs.close();
            cs.close();
        } catch (SQLException e) {
            throw  new RuntimeException(e.getMessage());
        }
        
        return empleadodni;
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
    
   public void ActualizarHab(int id){
       try {
           cs= conn.prepareCall("{call actualizarestadoaAsignar(?)}");
           st.setInt(1, id);
           int n= st.executeUpdate();
           if (n>0) {
               JOptionPane.showMessageDialog(null, "Los datos se han guardado exitosamente");
           }
           
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "ERROR EN SQL "+e);
       }
   }
    
    public ArrayList<ListaDatosHabtacionPorPiso> obtenerTabla(Object piso){
        System.out.println("Ingreso al OBTENER TABLA");
        ArrayList<ListaDatosHabtacionPorPiso> list = new ArrayList<ListaDatosHabtacionPorPiso>();
        try {
            cs=conn.prepareCall("{call ListarHabitacionPorMantener(?)}");
            cs.setString(1, piso.toString());
            rs= cs.executeQuery();
            while (rs.next()) {                
                listahab = new ListaDatosHabtacionPorPiso(
                        rs.getString("Habitacion.idHab"),
                        rs.getInt("Habitacion.NumeroHab"), 
                        rs.getString("TipoHabitacion.DescripcionTHA"),
                        rs.getString("Habitacion.EstadoHab"));
                list.add(listahab);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Horror"+e);
        }
        return list;
    }
    
    public ArrayList<ListaDatosHabtacionPorPiso> obtenerTablaLista(){
        ArrayList<ListaDatosHabtacionPorPiso> list = new ArrayList<ListaDatosHabtacionPorPiso>();
        try {
            cs=conn.prepareCall("{call ListarHabitacionAsignada()}");
            
            rs= cs.executeQuery();
            while (rs.next()) {                
                listahab = new ListaDatosHabtacionPorPiso(
                        rs.getString("Habitacion.idHab"),
                        rs.getInt("Habitacion.NumeroHab"), 
                        rs.getString("TipoHabitacion.DescripcionTHA"),
                        rs.getString("Habitacion.EstadoHab"));
                list.add(listahab);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Horror"+e);
        }
        return list;
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
