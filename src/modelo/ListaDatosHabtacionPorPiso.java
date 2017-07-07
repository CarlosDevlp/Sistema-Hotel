
package modelo;

import java.util.Map;


public class ListaDatosHabtacionPorPiso {
    private String idHab;
    private int numeroHabitacion; 
    private String tipoHabitacon; 
    private String estadoHabitacion; 

    public ListaDatosHabtacionPorPiso() {
    }

    public ListaDatosHabtacionPorPiso(String idHab) {
        this.idHab = idHab;
    }

    
    
    

    public ListaDatosHabtacionPorPiso(String idHab,int numeroHabitacion, String tipoHabitacon, String estadoHabitacion) {
        this.idHab=idHab;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacon = tipoHabitacon;
        this.estadoHabitacion = estadoHabitacion;
    }

    public ListaDatosHabtacionPorPiso(Map <String, String> args) {
        this.idHab=args.get("Habitacion.idHab");
        this.numeroHabitacion = Integer.parseInt(args.get("Habitacion.NumeroHab"));
        this.tipoHabitacon = args.get("TipoHabitacion.DescripcionTHA");
        this.estadoHabitacion = args.get("Habitacion.EstadoHab");
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacon() {
        return tipoHabitacon;
    }

    public void setTipoHabitacon(String tipoHabitacon) {
        this.tipoHabitacon = tipoHabitacon;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public String getIdHab() {
        return idHab;
    }

    public void setIdHab(String idHab) {
        this.idHab = idHab;
    }

    
    
}
