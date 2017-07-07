/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



/**
 *
 * Grupo Servicio
 * @author Cristian
 */
public class CtrNReserva {
    private ctrRegistrarReserva mCtrGenerarReserva;
    public static boolean activo=false;
    
    //constructor
    public CtrNReserva() {
        mCtrGenerarReserva=new ctrRegistrarReserva();
    }

    public ctrRegistrarReserva getmCtrGenerarReserva() {
        return mCtrGenerarReserva;
    }

    public void setmCtrGenerarReserva(ctrRegistrarReserva mCtrGenerarReserva) {
        this.mCtrGenerarReserva = mCtrGenerarReserva;
    }
    
    public void showFrmGenerarReserva(){
        if(activo==false){
            mCtrGenerarReserva=new ctrRegistrarReserva();
            mCtrGenerarReserva.showFrmGenerarReserva();
            mCtrGenerarReserva.loadData();
            activo=true;
        }
        else{
            mCtrGenerarReserva.showFrmGenerarReserva();
        }
    }
    public void loadData(){
        mCtrGenerarReserva.loadData();        
    }
    /*************************************       
      Muestra el formulario GenerarReserva
    ***************************************/
   
    /*************************************     
            Muestra los formularios
    ***************************************/
    
    
    
}
