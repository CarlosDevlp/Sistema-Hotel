/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * 
 * @author Carlos Chavez Laguna
 */
public class Pestana {
    private String nombrePes;
    private String aliasPes;
    
    //constructor
        
    public Pestana() {
    }

    public Pestana(String nombre, String alias) {
        this.nombrePes = nombre;
        this.aliasPes = alias;
    }

    public String getNombre() {
        return nombrePes;
    }

    public void setNombre(String nombrePes) {
        this.nombrePes = nombrePes;
    }

    public String getAlias() {
        return aliasPes;
    }

    public void setAlias(String aliasPes) {
        this.aliasPes = aliasPes;
    }           
    
}
