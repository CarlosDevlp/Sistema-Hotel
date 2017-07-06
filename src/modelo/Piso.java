
package modelo;


public class Piso {
    
    private int idPis; 
    private String UbicacionPis;

    public Piso() {
    }

    public Piso(int idPis, String UbicacionPis) {
        this.idPis = idPis;
        this.UbicacionPis = UbicacionPis;
    }

    public int getIdPis() {
        return idPis;
    }

    public void setIdPis(int idPis) {
        this.idPis = idPis;
    }

    public String getUbicacionPis() {
        return UbicacionPis;
    }

    public void setUbicacionPis(String UbicacionPis) {
        this.UbicacionPis = UbicacionPis;
    }

    @Override
    public String toString() {
        return  UbicacionPis;
    }

  
    
  
    
    
    
}
