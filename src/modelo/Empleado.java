/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import assets.values.Constant;
import dao.BasicDao;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author carlos
 */
public class Empleado  extends Persona{
    private float sueldoEmp;
    private String estadoEmp;
    private Empleado usuario;    
    private TipoEmpleado  tipoEmpleado;
    private String horarioLaboralEmp;
    private String userId;
    
            
    private static final String TABLE_EMPLEADO_SUELDO="SueldoEmp",
                                TABLE_EMPLEADO_ESTADO="EstadoEmp",
                                TABLE_EMPLEADO_HORARIO="HorarioLaboralEmp";
   
    //constructores   
    public Empleado(){
        super();
    }

    public Empleado(String dni, String nombresCompleto, int edad, String telefono, String direccion, String correo,float sueldoEmp) {
        super(dni, nombresCompleto, edad, telefono, direccion, correo);
        this.sueldoEmp = sueldoEmp;
    }
    
    
    
    
    /**
     * Constructor especial que acepta mapas para convertirlo en el objeto Empleado
     *  @param args ,el mapa que contiene los valores del objeto
     */    
    public Empleado(Map<String,String> args){
        //super.setRucDNI(args.get("idRazonSocial"));
        super(args);
        this.sueldoEmp=Float.parseFloat(args.get("SueldoEmp"));
        this.horarioLaboralEmp=args.get("HorarioLaboralEmp");
        this.estadoEmp= args.get("EstadoEmp");
    }
    
    
    //setters and   getters

    public float getSueldo() {
        return sueldoEmp;
    }

    public void setSueldo(float sueldo) {
        this.sueldoEmp = sueldo;
    }

    public Empleado getEmpleado() {
        return usuario;
    }

    public void setEmpleado(Empleado usuario) {
        this.usuario = usuario;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getHorarioLaboralEmp() {
        return horarioLaboralEmp;
    }

    public void setHorarioLaboralEmp(String horarioLaboralEmp) {
        this.horarioLaboralEmp = horarioLaboralEmp;
    }

    public String getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(String estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }    
 
    
    
     /**
     * Save <br>
     * Guardar datos en la base de datos
     */
    public void save(){                
        //call guardarEmpleado (0,76935184,'Carlos Chavez Laguna',965124295,'carloscl94r@gmail.com','jr pataz 1344, Los olivos',22,2500,'lun-vie, 9-16hrs');
        //call guardarEmpleado (0,12345678,'hackerman',87654321,'hackerman@someone.com','mountain view, california',22,8,2500,'lun-vie, 9-16hrs','vacaciones');
        
        Sesion currentSesion= Usuario.getInstance().getCurrentSesion();
        
        BasicDao.call("guardarEmpleado", new String []{ 
                                                        currentSesion.getIdSesion(),
                                                        super.getIdPersona(), //id 
                                                        super.getRucDNI(),//persona
                                                        "'"+super.getFullNamePer()+"'",//persona
                                                        super.getTelefono(),//persona
                                                        "'"+super.getCorreo()+"'",//persona
                                                        
                                                        "'"+super.getDireccion()+"'",//persona
                                                        super.getEdad()+"",//persona
                                                        this.tipoEmpleado.getIdTem(),//empleado
                                                        this.sueldoEmp+"",//empleado
                                                        "'"+this.horarioLaboralEmp+"'",//empleado
                                                        "'"+this.estadoEmp+"'",//empleado
                                                    });
    }
    
    /**
     * asignar un usuario al empleado
     */
    public void assignUser(){
        BasicDao.update(Constant.DB_TABLE_EMPLEADO, new String[]{"User_idUser"}, new String[]{this.userId}, "Persona_idPersona="+super.getIdPersona());
    }
    /**
     * obtener toda la lista de empleados existentes
     * en la base de datos con condición
     * 
     * @param where condición
     * @return retorna una arraylist de empleados
     */
    public static ArrayList<Empleado> getEmpleadoList(String where){
                
        //inner join
        ArrayList<Map<String,String>> result = BasicDao.select(Constant.DB_TABLE_EMPLEADO+" INNER JOIN "+Constant.DB_TABLE_PERSONA+" ON Persona_idPersona=idPersona "+
                                                                                          " INNER JOIN "+Constant.DB_TABLE_RAZON_SOCIAL+" ON RazonSocial_idRazonSocial=idRazonSocial"  ,
                                                               new String[] {"*"}, where);
        
        ArrayList<Empleado> empleadoList=new ArrayList();
       
        for(Map<String,String> row:result){ 
            empleadoList.add(new Empleado(row));                        
            empleadoList.get(empleadoList.size()-1).setTipoEmpleado(TipoEmpleado.getTipoEmpleado( row.get("idTEm") ));
        }
        return empleadoList;
    }
        
    
    /**
     * obtener toda la lista de empleados existentes
     * en la base de datos.
     * 
     * @return retorna una arraylist de empleados
     */
    public static ArrayList<Empleado> getEmpleadoList(){
        //inner join
        ArrayList<Map<String,String>> result = BasicDao.select(Constant.DB_TABLE_EMPLEADO+" INNER JOIN "+Constant.DB_TABLE_PERSONA+" ON Persona_idPersona=idPersona "+
                                                                                          " INNER JOIN "+Constant.DB_TABLE_RAZON_SOCIAL+" ON RazonSocial_idRazonSocial=idRazonSocial"  ,
                                                               new String[] {"*"}, null);
        
        
        ArrayList<Empleado> empleadoList=new ArrayList();
        //Empleado currentEmpleado;currentEmpleado=empleadoList.get(empleadoList.size()-1);
        for(Map<String,String> row:result){ 
            empleadoList.add(new Empleado(row));
            empleadoList.get(empleadoList.size()-1).setTipoEmpleado(TipoEmpleado.getTipoEmpleado( row.get("idTEm") ));
        }
        return empleadoList;
    }
    
    
    /**
     * 
     * remover usuario de la base de datos
     */
    public void remove(){
        Sesion currentSesion= Usuario.getInstance().getCurrentSesion();
        
        BasicDao.call("removerEmpleado",new String[]{currentSesion.getIdSesion(),super.getIdPersona(),super.getRucDNI()});
        /*BasicDao.delete(Constant.DB_TABLE_EMPLEADO, "Persona_idPersona="+super.getIdPersona());        
        BasicDao.delete(Constant.DB_TABLE_PERSONA, "idPersona="+super.getIdPersona());
        BasicDao.delete(Constant.DB_TABLE_RAZON_SOCIAL, "RucDNIRSo="+super.getRucDNI());*/
    }

    
    
}