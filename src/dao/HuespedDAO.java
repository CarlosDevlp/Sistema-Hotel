/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.HuespedDTO;
import interfaces.CrudDato;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Fernando
 */
public class HuespedDAO implements CrudDato<HuespedDTO>{
    
    
    private static final String SQL_INSERTHUESPED = "";
    private static final String SQL_DELETEHUESPED  = "";
    private static final String SQL_READHUESPED  = "";
    private static final String SQL_UPDATEHUESPED  = "";
    private static final String SQL_READALLHUESPED  = "";
    
    
    

    private static final Conexion con = conexion.Conexion.estadoConexion();
    
    @Override
    public boolean create(HuespedDTO c) {
         PreparedStatement ps;

        try {
            ps = con.getCon().prepareStatement(SQL_INSERTHUESPED);
  
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDNI());

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
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(HuespedDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HuespedDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HuespedDTO> readALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
