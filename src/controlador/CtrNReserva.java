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
    private CtrGenerarReserva mCtrGenerarReserva;
//    private CtrBuscarCliente mCtrGenerarReserva;
//    private CtrBuscarCliente mCtrBuscarCliente;
//    private CtrBuscarHabitacion mCtrBuscarHabitacion;
//    private CtrBuscarHuesped mCtrBuscarHuesped;
//    private CtrRegistrarCliente mCtrRegistrarCliente;
//    private CtrRegistrarHuesped mCtrRegistrarHuesped;
    
    //constructor

    public CtrNReserva() {
        mCtrGenerarReserva=new CtrGenerarReserva();
//        mCtrBuscarCliente=new CtrGenerarReserva();
//        mCtrBuscarHabitacion=new CtrBuscarHabitacion();
//        mCtrBuscarHuesped=new CtrBuscarHuesped();
//        mCtrRegistrarCliente=new CtrGenerarReserva();
//        mCtrRegistrarHuesped=new CtrGenerarReserva();
       
    }

//    public CtrBuscarHabitacion getmCtrBuscarHabitacion() {
//        return mCtrBuscarHabitacion;
//    }
//
//    public void setmCtrBuscarHabitacion(CtrBuscarHabitacion mCtrBuscarHabitacion) {
//        this.mCtrBuscarHabitacion = mCtrBuscarHabitacion;
//    }
//
//    public CtrBuscarHuesped getmCtrBuscarHuesped() {
//        return mCtrBuscarHuesped;
//    }
//
//    public void setmCtrBuscarHuesped(CtrBuscarHuesped mCtrBuscarHuesped) {
//        this.mCtrBuscarHuesped = mCtrBuscarHuesped;
//    }

    public CtrGenerarReserva getmCtrGenerarReserva() {
        return mCtrGenerarReserva;
    }

    public void setmCtrGenerarReserva(CtrGenerarReserva mCtrGenerarReserva) {
        this.mCtrGenerarReserva = mCtrGenerarReserva;
    }
    
    
    
    
    public void showFrmGenerarReserva(){
        mCtrGenerarReserva=new CtrGenerarReserva();
        mCtrGenerarReserva.showFrmGenerarReserva();
        mCtrGenerarReserva.loadData();
    }
//    public void showFrmBuscarHuesped(){
//        mCtrBuscarHuesped.showFrmBuscarHuesped();
//        mCtrBuscarHuesped.loadData(); 
//    }
//    public void showFrmBuscarHabitacion(){
//        mCtrBuscarHabitacion.showFrmBuscarHabitacion();
//        mCtrBuscarHabitacion.loadData(); 
//    }
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
