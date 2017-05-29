/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.ClienteDTO;
import interfaces.CrudDato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis Fernandocall
 */
public class ClienteDAO implements CrudDato<ClienteDTO>{
    
    private static final String SQL_INSERTPERSONA = "INSERT INTO persona (Nombre,Apellido,DNI,Telefono,Email,Direccion) VALUES (?,?,?,?,?,?)";
    private static final String SQL_INSERTCLIENTE = "INSERT INTO cliente (persona_idPersona,Empresa,RUC) VALUES ((select idPersona from persona order by idPersona desc limit 1),?,?)";
    private static final String SQL_DELETEClIENTE = "";
    private static final String SQL_READCLIENTE="";
    private static final String SQL_UPDATEPERSONA="";
    private static final String SQL_UPDATECLIENTE=""; 
    private static final String SQL_READALLCLIENTE="";
    
    private static final Conexion con = conexion.Conexion.estadoConexion();

    @Override
    public boolean create(ClienteDTO c) {
        PreparedStatement ps;
        PreparedStatement ps1;

        try {
            ps = con.getCon().prepareStatement(SQL_INSERTPERSONA);
            ps1= con.getCon().prepareStatement(SQL_INSERTCLIENTE);
                      
            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getDireccion());
            
            ps1.setString(1, c.getEmpresa());
            ps1.setString(2, c.getRUC());
          
          if (ps.executeUpdate() > 0) {

                if (ps1.executeUpdate() > 0) {

                    return true;
                }

            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            con.cerrarConexion();
        }
        return false;
       
    }

    @Override
    public boolean delete(Object key) {
       PreparedStatement ps;

        try {

            ps = con.getCon().prepareStatement(SQL_DELETEClIENTE);

            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {

                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ClienteDTO c) {
       try {
            PreparedStatement ps;
            PreparedStatement ps1;

            ps = con.getCon().prepareCall(SQL_UPDATEPERSONA);
            ps1 = con.getCon().prepareStatement(SQL_UPDATECLIENTE);

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getDireccion());
            ps.setString(7, c.getIdPersona());

            ps1.setString(1, c.getEmpresa());
            ps1.setString(2, c.getRUC());
            ps1.setString(3, c.getIdPersona());

            if (ps.executeUpdate() > 0) {

                if (ps1.executeUpdate() > 0) {

                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ClienteDTO read(Object key) {
        
        PreparedStatement ps;
        ResultSet res;
        ClienteDTO l = null;

        try {

            ps = con.getCon().prepareCall(SQL_READCLIENTE);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                l = new ClienteDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return l;
    }

    @Override
    public List<ClienteDTO> readALL() {
        PreparedStatement ps;
        ResultSet res;
         ArrayList<ClienteDTO> Cliente = new ArrayList();

        try {

            ps = con.getCon().prepareStatement(SQL_READALLCLIENTE);

            res = ps.executeQuery();
            while (res.next()) {
                Cliente.add(new ClienteDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return Cliente;
    }
    
    
}