/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.frmServicioExtra;
import vista.FrmServicioHabitacion;
import vista.FrmBuscarProducto;

/**
 *
 * Grupo Servicio
 * @author ChristianHC
 */
public class CtrNServicio {
    FrmServicioHabitacion mfrmServicioHabitacion;
    frmServicioExtra mfrmServicioExtra;
    
    //constructor

    public CtrNServicio() {
        mfrmServicioHabitacion=new FrmServicioHabitacion();
        mfrmServicioExtra=new frmServicioExtra();
    }
    
    /**     
     * Muestra el formulario servicio habitacion
     */
    public void showFrmServicioHabitacion(){
        mfrmServicioHabitacion.setVisible(true);
    }
    
    
    
    /**     
    * Muestra el formulario servicio extra
    */
    public void showFrmServicioExtra(){
        mfrmServicioExtra.setVisible(true);
    }
    
}
