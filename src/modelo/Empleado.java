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
    private int estadoEmp;
    private Empleado usuario;    
    private TipoEmpleado  tipoEmpleado;
    private String horarioLaboralEmp;

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
        super.setIdPersona(args.get("idPersona"));
        super.setFullNamePer(args.get("FullNamePer"));
        super.setTelefono(args.get("TelefonoPer"));
        super.setCorreo(args.get("EmailPer"));
        super.setDireccion(args.get("DireccionPer"));
        super.setEdad(Integer.parseInt(args.get("EdadPer")));
        this.sueldoEmp=Float.parseFloat(args.get("SueldoEmp"));
        this.horarioLaboralEmp=args.get("HorarioLaboralEmp");
        //this.estadoEmp= preguntar a la gente...
    }
    
    
    //setters and getters

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
    
 
    
    
     /**
     * Save <br>
     * Guardar datos en la base de datos
     */
    public void save(){                
        //call guardarEmpleado (0,76935184,'Carlos Chavez Laguna',965124295,'carloscl94r@gmail.com','jr pataz 1344, Los olivos',22,2500,'lun-vie, 9-16hrs');
        BasicDao.call("guardarEmpleado", new String []{ super.getIdPersona(), //id 
                                                        super.getRucDNI(),//persona
                                                        "'"+super.getFullNamePer()+"'",//persona
                                                        super.getTelefono(),//persona
                                                        "'"+super.getCorreo()+"'",//persona
                                                        "'"+super.getDireccion()+"'",//persona
                                                        super.getEdad()+"",//persona
                                                        this.sueldoEmp+"",//empleado
                                                        "'"+this.horarioLaboralEmp+"'",//empleado
                                                    });        
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
        ArrayList<Map<String,String>> result = BasicDao.select(new String[] {Constant.DB_TABLE_EMPLEADO,Constant.DB_TABLE_PERSONA},
                                                               new String[] {"*"},new String[] {"Persona_idPersona","idPersona"}, where);
        
        ArrayList<Empleado> empleadoList=new ArrayList();
        
        for(Map<String,String> row:result){ 
            empleadoList.add(new Empleado(row));            
            //empleadoList.get(empleadoList.size()-1).setTipoEmpleado(new TipoEmpleado(row));
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
        ArrayList<Map<String,String>> result = BasicDao.select(new String[] {Constant.DB_TABLE_EMPLEADO,Constant.DB_TABLE_PERSONA},
                                                               new String[] {"*"},new String[] {"Persona_idPersona","idPersona"}, null);
        
        ArrayList<Empleado> empleadoList=new ArrayList();
        for(Map<String,String> row:result){ 
            empleadoList.add(new Empleado(row));
            //empleadoList.get(empleadoList.size()-1).setTipoEmpleado(Rol.getRol(row.get("Roles_idRoles")));
        }
        return empleadoList;
    }
    
    
    /**
     * 
     * remover usuario de la base de datos
     */
    public void remove(){
        BasicDao.delete(Constant.DB_TABLE_EMPLEADO, "Persona_idPersona="+super.getIdPersona());        
        BasicDao.delete(Constant.DB_TABLE_PERSONA, "idPersona="+super.getIdPersona());
        BasicDao.delete(Constant.DB_TABLE_RAZON_SOCIAL, "RucDNISo="+super.getRucDNI());
    }

    
    
}