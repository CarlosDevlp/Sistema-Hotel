/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *Interfaz Callback
 * @author Carlos Chavez Laguna
 * 
 * @param <T> tipo de dato de la plantilla 
 */
public interface Callback<T> {
    void execute(T []args);
}
