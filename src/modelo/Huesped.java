
package modelo;

import dao.BasicDao;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


public class Huesped {
    private String idHuesped;
    private String nombre;
    private String dni;

    public Huesped() {
    
    }
    public Huesped(String idHuesped, String nombre, String dni) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public Huesped(Map<String, String> args) {
        this.idHuesped = args.get("idHSP");
        this.nombre = args.get("NombreHue");
        this.dni = args.get("DNIHue");
    }

    public String getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(String idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public static ArrayList<Huesped> getHuespedList(){
        ArrayList<Map<String,String>> result=BasicDao.select("Huesped", new String[]{"*"}, "idHSP not in (select Huesped_idHSP from DetalleReserva)");
        ArrayList<Huesped> huespedList=new ArrayList();
        for(Map<String,String> row:result) 
            huespedList.add(new Huesped(row));
        return huespedList;
    }
    
    public static ArrayList<Huesped> getHuespedDni(String dni){
        ArrayList<Map<String,String>> result=BasicDao.select("Huesped", new String[]{"*"}, "idHSP not in (select Huesped_idHSP from DetalleReserva) and DNIHue LIKE '%"+dni+"%'");
        ArrayList<Huesped> huespedList=new ArrayList();
        for(Map<String,String> row:result) 
            huespedList.add(new Huesped(row));
        return huespedList;
    }
    
    public void nuevoHuesped(){
        BasicDao.insert("Huesped", new String []{"NombreHue","DNIHue"}, new String []{this.nombre,this.dni});
    }
    
}
