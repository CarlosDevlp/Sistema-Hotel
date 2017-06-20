/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.values;

import java.awt.Color;
import modelo.Pestana;


/**
 * La clase Constant, permite declarar valores globales
 * que pueden ser usados en todo el software. 
 *  
 * @author Carlos
 */
public abstract class Constant {
    //constantes de datos de la app
    public final static String APP_NAME="Hotel Bica";
    
    
    //constantes de la base de datos    

    /*cloud*/
    public final static String DB_SERVER="sl-us-south-1-portal.2.dblayer.com:16643";
    public final static String DB_NAME="CalidadT3Oficial";
    public final static String DB_USER_NAME="admin";
    public final static String DB_USER_PASSWORD="LTKIKOECRZFJOEUM";
    
    /*local
    public final static String DB_SERVER="localhost";
    public final static String DB_NAME="calidadt3";
    public final static String DB_USER_NAME="root";
    public final static String DB_USER_PASSWORD="admin";
        */
    //nombre de las tablas
    public final static String DB_TABLE_ROLES="Roles";
    public final static String DB_TABLE_USUARIO="User";
    
    //nombre de los formularios a nivel de diseño
    public final static String FORM_BUSCAR_ROL="frm_Buscar rol";
    public final static String FORM_BUSCAR_USUARIO="frm_Buscar usuario";
  
    
    //COLORS 
    //nombre de los colores    
    //public final static Color COLOR_PRIMARY=new Color(0xFF3333);
    //public final static Color COLOR_PRIMARY_DARK=new Color(0xFF3333);    
    //public final static Color COLOR_ACCENT=new Color(0xFF3333);
    public final static Color COLOR_RED=new Color(0xFF3333);
    public final static Color COLOR_GREEN=new Color(0x99CC00);
    
    
    //lista de imagenes e íconos
    //public final static ImageIcon IMAGE_ICON_GOOD=new javax.swing.ImageIcon(getClass().getResource("/assets/images/good.png"));
    
    //ARRAYS
    public final static Pestana  []ARRAY_MENU_PESTANA={
                                        //new Pestana("Todos","all"),
                                        new Pestana("Facturación","pfacturacion"),
                                        new Pestana("Reserva","preserva"),
                                        new Pestana("Servicio","pServicio"),
                                        new Pestana("Alojamiento","pAlojamiento"),
                                        new Pestana("Mantenimiento","pMantenimiento")
                                };
    public final static String [][]ARRAY_ROLE_COLUMNS_AND_ALIAS={
                                    {"idRoles","NombreRol"}, //column names
                                    {"ID","Nombre"} //alias
                                };

    public final static String [][]ARRAY_USER_COLUMNS_AND_ALIAS={
                                    {"idUser","UsuarioUse","NombreRol"}, //column names
                                    {"ID","Nombre de usuario","Nombre de rol"} //alias
                                };
    
}