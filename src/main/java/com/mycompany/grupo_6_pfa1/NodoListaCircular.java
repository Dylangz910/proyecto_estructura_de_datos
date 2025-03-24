/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 * Nodo de una lista circular que representa la posicion de un jugador
 * @author Jesús Anchia
 * @param posicion representa la posicion en la que se encuentra el jugador en el estado de juego
 * @param nombreJugador representa el nombre del jugador que se encuentra en esa posicion
 * @param siguiente referencia al siguiente Nodo de la lista circular
 */
public class NodoListaCircular {
    private int posicion;
    private String nombreJugador;
    private NodoListaCircular siguiente;

    public NodoListaCircular(int posicion) {
        this.posicion = posicion;
        this.nombreJugador = "VACIA";
        this.siguiente = null;
    }
    
    /**
     * Obtiene la posición del jugador 
     * @author Jesús Anchia
     * @return retorna la posición del jugador.
     */
    public int getPosicion() {
        return posicion;
    }
    
    /**
     * Establece la posición 
     * @author Jesús Anchia
     * @param posicion establece la nueva posición del jugador.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    /**
     * Obtiene el nombre del jugador en la posicion
     * @author Jesus Anchia
     * @return retorna el nombre del jugador.
     */
    public String getNombreJugador() {
        return nombreJugador;
    }
    
    /**
     * Obtiene el nombre del jugador asociado al nodo.
     * @author Jesús Anchia
     * @return retorna el nombre del jugador.
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    /**
     * Obtiene el siguiente nodo en la cola.
     * @author Dylan Gonzales
     * @return retorna el siguiente nodo en la lista circular.
     */
    public NodoListaCircular getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el siguiente nodo en la lista
     * @author Jesus Anchia
     * @param siguiente es Nodo que se establecera como siguiente.
     */
    public void setSiguiente(NodoListaCircular siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
