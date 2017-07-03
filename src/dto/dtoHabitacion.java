/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Administrador
 */
public class dtoHabitacion {
    
    protected int idhabitacion;
    protected String Descripcion;
    protected int Numero;
    protected int Costo;
    protected int idTipo;
    protected String Estado;
    protected int idPiso;

    /**
     * @return the idhabitacion
     */
    public int getIdhabitacion() {
        return idhabitacion;
    }

    /**
     * @param idhabitacion the idhabitacion to set
     */
    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Numero
     */
    public int getNumero() {
        return Numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    /**
     * @return the Costo
     */
    public int getCosto() {
        return Costo;
    }

    /**
     * @param Costo the Costo to set
     */
    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    /**
     * @return the idTipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the idPiso
     */
    public int getIdPiso() {
        return idPiso;
    }

    /**
     * @param idPiso the idPiso to set
     */
    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }

}
