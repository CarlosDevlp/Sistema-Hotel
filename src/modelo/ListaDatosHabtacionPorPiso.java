
package modelo;

import java.util.Map;


public class ListaDatosHabtacionPorPiso {
    private int numeroHabitacion; 
    private String tipoHabitacon; 
    private String estadoHabitacion; 

    public ListaDatosHabtacionPorPiso() {
    }
    
    

    public ListaDatosHabtacionPorPiso(int numeroHabitacion, String tipoHabitacon, String estadoHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacon = tipoHabitacon;
        this.estadoHabitacion = estadoHabitacion;
    }

    public ListaDatosHabtacionPorPiso(Map <String, String> args) {
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
    
    
    
}
