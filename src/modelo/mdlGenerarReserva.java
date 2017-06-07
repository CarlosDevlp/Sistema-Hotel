/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class mdlGenerarReserva extends Conexion {

    public boolean InsertarDatosReserva(String fecini, String fecsal, String cantres, String estado, String codcli, String fecres, String coti, String codemp) throws Exception {
        //Se arma la consulta
        try {
            String q = "INSERT INTO Reserva (FECHAINICIORES,FECHAFINALRES,CANTIDADRES,ESTADORES,CLIENTE_PERSONA_IDPERSONA,FECHARES,COTIZACIONRES,EMPLEADO_PERSONA_IDPERSONA)"
                                + "VALUES ('" + fecini + "', '" + fecsal + "' , '" + cantres + "', '" + estado + "', '" + codcli + "', '" + fecres + "', '" + coti + "', '" + codemp + "')";

            PreparedStatement pstm = this.getCon().prepareStatement(q);
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public void InsertarDatosDetalleReserva(String codhab, String codhue) throws Exception {
        //Se arma la consulta
        try {
            String q = "INSERT INTO DetalleReserva(Habitacion_idHab,Huesped_idHSP,Reserva_idReserva)"
                                + "VALUES ('" + codhab + "', '" + codhue + "' , (SELECT IDRESERVA FROM RESERVA ORDER BY IDRESERVA DESC LIMIT 1))";

            PreparedStatement pstm = this.getCon().prepareStatement(q);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public String BuscarCodigoReserva() throws Exception {

        String dato = "";

        //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
        //idPersona,FullNamePer,TelefonoPer,EmailPer,DireccionPer,Sexo,Documento
        PreparedStatement pstm = this.getCon().prepareStatement("SELECT IDRESERVA FROM RESERVA ORDER BY IDRESERVA DESC LIMIT 1");
        ResultSet res = pstm.executeQuery();

        while (res.next()) {
            dato = res.getString("IDRESERVA");
        }
        res.close();
        return dato;
    }

    public void ActualizarEstadoReserva_Reservado(String codhab) throws Exception {
        try {
            String q = "CALL ACTUALIZAR_ESTADO_HABITACION(" + codhab + ",'RESERVADO')";

            PreparedStatement pstm = this.getCon().prepareStatement(q);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void ActualizarEstadoReserva_EnLista(String codhab) throws Exception {
        try {
            String q = "CALL ACTUALIZAR_ESTADO_HABITACION(" + codhab + ",'EN LISTA')";

            PreparedStatement pstm = this.getCon().prepareStatement(q);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void ActualizarEstadoReserva_Libre(String codhab) throws Exception {
        try {
            String q = "CALL ACTUALIZAR_ESTADO_HABITACION(" + codhab + ",'LIBRE')";

            PreparedStatement pstm = this.getCon().prepareStatement(q);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
