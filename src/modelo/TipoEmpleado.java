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
 * @author Carlos Chavez Laguna
 */
public class TipoEmpleado {
    private String idTem;
    private String descripcion;

    //constructores
    
    public TipoEmpleado() {
    }
    
        
    public TipoEmpleado(String idTem, String descripcion) {
        this.idTem = idTem;
        this.descripcion = descripcion;
    }
       
    public TipoEmpleado(Map<String, String> args) {
        this.idTem = args.get("idTEm");
        this.descripcion = args.get("DescripcionTEm");
    }
    
    //setters and getters
    public String getIdTem() {
        return idTem;
    }

    public void setIdTem(String idTem) {
        this.idTem = idTem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    //otros métodos    
    /**
     * 
     * obtiene un tipo empleado
     * 
     * @param tipoempladoId id del tipo empleado a buscar
     * 
     * @return el objeto buscado     
     */
    
    public static TipoEmpleado getTipoEmpleado(String tipoempladoId){
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_TIPO_EMPLEADO, new String[]{"*"}, "idTem="+tipoempladoId);
        return new TipoEmpleado(result.get(0));
    }
    
    
    /**
     * obtener toda la lista de tipos de empleado existentes
     * en la base de datos.
     * 
     * @return retorna una arraylist de empleados
     */
    public static ArrayList<TipoEmpleado> getTipoEmpleadoList(){
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_TIPO_EMPLEADO, new String[]{"*"}, null);
        ArrayList<TipoEmpleado> tipoEmpleadoList=new ArrayList();
        for(Map<String,String> row:result) tipoEmpleadoList.add(new TipoEmpleado(row));
        return tipoEmpleadoList;
    }

       
    
}
