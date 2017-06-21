/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.FrmReporteAlojamiento;
import vista.frmAlojamiento;

/**
 *
 * GRUPO ALOJAMIENTO
 * Controladora de Negocio Alojamiento
 * @author Luis Fernando
 */
public class CtrNAlojamiento {
    private frmAlojamiento mFrmAlojamiento;
    private FrmReporteAlojamiento mFrmReporteAlojamiento;

    public CtrNAlojamiento() {
        mFrmAlojamiento=new frmAlojamiento();
        mFrmReporteAlojamiento = new FrmReporteAlojamiento();
        
    }
    
    
    
    /**
     * showFrmAlojamiento <br>
     * Permite mostrar el formulario alojamiento
     *      
     */
    public void showFrmAlojamiento(){
        mFrmAlojamiento.setVisible(true);
    }
    public void showFrmReporteAlojamiento(){
        mFrmReporteAlojamiento.setVisible(true);
    }
}
