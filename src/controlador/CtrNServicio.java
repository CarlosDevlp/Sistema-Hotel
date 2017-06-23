/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.frmServicioExtra;
import vista.frmServicioHabitacion;
import vista.FrmMain;

/**
 *
 * Grupo Servicio
 * @author Daniel
 */
public class CtrNServicio {
    private frmServicioHabitacion mfrmServicioHabitacion;
    private frmServicioExtra mfrmServicioExtra;
    //private FrmMain mFrmMain;
    
    //constructor

    public CtrNServicio() {
        mfrmServicioHabitacion=new frmServicioHabitacion();
        mfrmServicioExtra=new frmServicioExtra();
        //mFrmMain=new FrmMain();
    }
    
    /**     
     * Muestra el formulario servicio habitacion
     */
    public void showFrmServicioHabitacion(){
        mfrmServicioHabitacion.setVisible(true);
        //mFrmMain.setVisible(false);
    }
    
    
    
    /**     
    * Muestra el formulario servicio extra
    */
    public void showFrmServicioExtra(){
        mfrmServicioExtra.setVisible(true);
        //mFrmMain.setVisible(false);
    }
    
}
