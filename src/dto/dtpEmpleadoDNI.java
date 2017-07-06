
package dto;


public class dtpEmpleadoDNI {
    
    private String codigoEmpleado;
    private String nombreEmpleado; 
    
    
        public dtpEmpleadoDNI() {
            }

    public dtpEmpleadoDNI(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Override
    public String toString() {
        return nombreEmpleado;
    }
    
    
}
