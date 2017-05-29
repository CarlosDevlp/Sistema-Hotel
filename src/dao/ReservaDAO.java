/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.ReservaDTO;
import interfaces.CrudDato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Fernando
 */
public class ReservaDAO implements CrudDato<ReservaDTO> {

    private static final String SQL_INSERTRESERVA = "";
    private static final String SQL_DELETERESERVA = "";
    private static final String SQL_READRESERVA = "";
    private static final String SQL_UPDATERESERVA = "";
    private static final String SQL_READALLRESERVA = "";

    private static final Conexion con = conexion.Conexion.estadoConexion();

    @Override
    public boolean create(ReservaDTO c) {
        PreparedStatement ps;
   
        try {
            ps = con.getCon().prepareStatement(SQL_INSERTRESERVA);

           // ps.setDate(1, java.sql.Date.valueOf(c.getFechaInicioReserva().toGMTString()));
            ps.setString(1, c.getFechaInicioReserva().toString());
            ps.setString(2, c.getFechaFinalReserva().toString());
            ps.setInt(3, c.getCantidadReserva());
            ps.setString(4, c.getEstadoReserva());
            ps.setString(5, c.getFechaReserva().toString());
            ps.setDouble(6, c.getCotizacionReserva());
            ps.setString(7, c.getIdPersonaReserva());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;

        try {

            ps = con.getCon().prepareStatement(SQL_DELETERESERVA);

            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {

                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ReservaDTO c) {
        try {
            
            PreparedStatement ps;

            ps = con.getCon().prepareCall(SQL_UPDATERESERVA);

            ps.setString(1, c.getFechaInicioReserva().toString());
            ps.setString(2, c.getFechaFinalReserva().toString());
            ps.setInt(3, c.getCantidadReserva());
            ps.setString(4, c.getEstadoReserva());
            ps.setString(5, c.getFechaReserva().toString());
            ps.setDouble(6, c.getCotizacionReserva());
            ps.setString(7, c.getIdPersonaReserva());
            ps.setString(8, c.getIdReserva());

            if (ps.executeUpdate() > 0) {
                    return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ReservaDTO read(Object key) {
         PreparedStatement ps;
        ResultSet res;
        ReservaDTO l = null;

        try {

            ps = con.getCon().prepareCall(SQL_READRESERVA);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                l = new ReservaDTO(res.getString(1), res.getDate(2),res.getDate(3), res.getInt(4),
                        res.getString(5),res.getDate(6), res.getDouble(7), res.getString(8));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return l;
    }

    @Override
    public List<ReservaDTO> readALL() {
        PreparedStatement ps;
        ResultSet res;
         ArrayList<ReservaDTO> Reserva = new ArrayList();

        try {

            ps = con.getCon().prepareStatement(SQL_READALLRESERVA);

            res = ps.executeQuery();
            while (res.next()) {
                Reserva.add(new ReservaDTO(res.getString(1), res.getDate(2),res.getDate(3), res.getInt(4),
                        res.getString(5),res.getDate(6), res.getDouble(7), res.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return Reserva;
    }

}
