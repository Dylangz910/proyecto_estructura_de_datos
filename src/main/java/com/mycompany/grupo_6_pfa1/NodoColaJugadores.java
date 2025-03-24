/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 * Nodo de la cola que representa a un jugador.
 * @author Dylan Gonzales
 * @param nombre : El nombre del jugador en el Nodo
 * @param posicion : Posicion actual del jugador
 * @param siguiente : Referencia al siguiente Nodo de la cola
 */
public class NodoColaJugadores {
    private String nombre;
    private int posicion;
    private NodoColaJugadores siguiente;
    
    public NodoColaJugadores(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el nombre del jugador.
     * @author Dylan Gonzales
     * @return retorna el nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene la posición del jugador.
     * @author Dylan Gonzales
     * @return retorna la posición del jugador.
     */
    public int getPosicion() {
        return posicion;
    }
    
    /**
     * Establece la posición del jugador.
     * @author Dylan Gonzales
     * @param posicion representa la nueva posición del jugador.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
     /**
     * Establece el siguiente nodo en la cola.
     * @author Dylan Gonzales
     * @param siguiente es Nodo que se establecera como siguiente.
     */
    public void setSiguiente(NodoColaJugadores siguiente) {
        this.siguiente = siguiente;
    }
    
     /**
     * Obtiene el siguiente nodo en la cola.
     * @author Dylan Gonzales
     * @return retorna el siguiente nodo en la cola.
     */
    public NodoColaJugadores getSiguiente() {
        return siguiente;
    }
}
