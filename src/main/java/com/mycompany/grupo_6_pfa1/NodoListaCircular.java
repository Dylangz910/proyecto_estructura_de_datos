/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author ramon
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public NodoListaCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaCircular siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
