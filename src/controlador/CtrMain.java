/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BasicDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import modelo.Callback;
import modelo.Rol;
import modelo.Usuario;
import vista.FrmMain;

/**
 * Controlador principal para el formulario principal
 * @author Carlos chavez laguna
 */
public class CtrMain implements ActionListener{

    private FrmMain mFrmMain;
    private Usuario mUsuario;      
    private CtrNSeguridad mCtrNSeguridad;
    private CtrNReserva mCtrNReserva;    
    private CtrNServicio mCtrNServicio;
    private CtrNAlojamiento mCtrNAlojamiento;
    
   
    private final String LOG_TAG="CtrMain",LOG_TAG_ERROR="CtrMain-error";
    
    //constructores
    public CtrMain() {        
    }
    
    public CtrMain(FrmMain frmMain) {        
        mFrmMain=frmMain;
        mFrmMain.SmnMantenerUsuario.addActionListener(this);
        mFrmMain.MnVerPerfil.addActionListener(this);
        mFrmMain.MnGenerarReserva.addActionListener(this);        
        mFrmMain.MnSalir.addActionListener(this);                
        mFrmMain.smServicioExtra.addActionListener(this);
        mFrmMain.smServicioHabitacion.addActionListener(this);
        mFrmMain.smRegistrarAlojamiento.addActionListener(this);
    }
    
    /**
     * 
     * ActionPerformed, recibe todos los eventos de UI
     * por componente, lo identificas y ejecutas la acción
     * dependiendo del nombre de este último.
     * PD: refierase al componente como: TextField, Button, etc.
     * 
     * @param e el ui llama pasa este parámetro por componente
     */ 
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        System.out.println(obj.getName());
        switch(obj.getName()){
            case "pmantenerusuario":    
                this.mCtrNSeguridad.showFrmMantenerUsuario();
                break;
            case "pperfil":
                this.mCtrNSeguridad.showFrmVerPerfil();
                break;
            case "pGenerarReserva":
                this.mCtrNReserva.showGenerarReserva();                
                break;
            case "pServicioHabitacion":
                this.mCtrNServicio.showFrmServicioHabitacion();
                break;
            case "pServicioExtra":
                this.mCtrNServicio.showFrmServicioExtra();
                break;
            case "pRegistrarAlojamiento":
                this.mCtrNAlojamiento.showFrmAlojamiento();
                break;
            case "exit":
                System.exit(0);                
                break;
        }
        
    }
    
    //método importante
    /**
     * Init <br>
     * método que inicializa las configuraciones
     * importantes del sistema.
     */
    public void init(){            
        //inicializar la conexión de base de datos
        BasicDao.init();        
        BasicDao.DEBUG=false;
        //maximizar la ventana principal
        mFrmMain.maximize();
        //inhabilitar el formulario principal
        disableFrmMain();
        //mostrar el login (seguridad)
        mCtrNSeguridad.showFrmLogin();                
        
        
        mCtrNSeguridad.loadData();
        //cuando el usuario se logea, esto debe pasar
        mCtrNSeguridad.setOnUserLogged(new Callback(){
            @Override
            public void execute(String[] args) {                
                //habilitar el formulario principal
                enableFrmMain();
                enableMenus();                
            }
        });
    }

    //setters and getters
    public CtrNSeguridad getCtrNFacturacion() {
        return mCtrNSeguridad;
    }

    public void setCtrNSeguridad(CtrNSeguridad ctrNSeguridad) {
        this.mCtrNSeguridad = ctrNSeguridad;
    }
    
    public CtrNReserva getCtrNReserva() {
        return mCtrNReserva;
    }

    public void setCtrNReserva(CtrNReserva mCtrNReserva) {
        this.mCtrNReserva = mCtrNReserva;
    }

    public CtrNServicio getCtrNServicio() {
        return mCtrNServicio;
    }

    public void setCtrNServicio(CtrNServicio ctrNServicio) {
        this.mCtrNServicio = ctrNServicio;
    }

    public CtrNAlojamiento getCtrNAlojamiento() {
        return mCtrNAlojamiento;
    }

    public void setCtrNAlojamiento(CtrNAlojamiento ctrNAlojamiento) {
        this.mCtrNAlojamiento = ctrNAlojamiento;
    }    
    /**
     * Permite habilitar y desabilitar menus dependiendo
     * del tipo de rol que el usuario principal tiene.
     * 
     */
    public void enableMenus(){
        mUsuario=Usuario.getInstance();
        Rol userRol=mUsuario.getRolUser();
        String[] pestanaList=mUsuario.getRolUser().getPestanasHabilitadas();
        
        System.out.println(userRol.getNombreRol());
        //iterar cada  pestaña que se va a habilitar 
        for(String pestana :pestanaList) {
            System.out.println(pestana);
            switch(pestana){
                case "pfacturacion":
                    mFrmMain.MnFacturacion.setEnabled(true);
                    break;
                case "preserva":
                    mFrmMain.MnReserva.setEnabled(true);
                    break;
                case "all":
                    mFrmMain.MnAdministrador.setEnabled(true);
                    mFrmMain.MnFacturacion.setEnabled(true);                    
                    mFrmMain.MnReserva.setEnabled(true);
                    mFrmMain.MnAlojamiento.setEnabled(true);
                    mFrmMain.MnServicio.setEnabled(true);
                    
                    
            }
        }
            
    }
    
    
    /**
     * showFrmMain <br>
     * Permite mostrar el formulario principal
     *      
    */ 
    private void showFrmMain(){
        mFrmMain.setVisible(true);
    }
    
    
    /**
     * hideFrmMain <br>
     * Permite mostrar el formulario principal
     *      
    */ 
    private void hideFrmMain(){
        mFrmMain.setVisible(false);        
    }
    
    /**
     * disableFrmMain <br>
     * inhabilita el formulario principal
     *      
    */ 
    private void disableFrmMain(){
        mFrmMain.setEnabled(false);
        mFrmMain.toBack();
    }
    
    
    /**
     * enableFrmMain <br>
     * habilita el formulario principal
     *      
    */ 
    private void enableFrmMain(){
        mFrmMain.setEnabled(true);        
    }

    
            
    
}

