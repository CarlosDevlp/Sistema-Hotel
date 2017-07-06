package conexion;


import assets.values.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Luis Fernando
 * @deprecated NO USARRRRRRRRRRRRRRRRRRRR!!!
 */


public class Conexion {
    
    public static Conexion instancia;
    private Connection con;
    
    public Conexion(){
        
        try{
            
                Class.forName("com.mysql.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://"+Constant.DB_SERVER+"/"+Constant.DB_NAME+"?zeroDateTimeBehavior=convertToNull",Constant.DB_USER_NAME,Constant.DB_USER_PASSWORD);       
                //con=DriverManager.getConnection("jdbc:mysql://sl-us-south-1-portal.2.dblayer.com:16643/CalidadT3Oficial?zeroDateTimeBehavior=convertToNull","admin","LTKIKOECRZFJOEUM");       

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    public synchronized static Conexion estadoConexion(){
        
        if(instancia == null){ 
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Connection getCon(){
        return con;
    }
    
    
    public void cerrarConexion(){
  
        instancia = null;
    }
   
        
}
