/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author byxdy
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
    
    public String getNombre() {
        return nombre;
    }
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void setSiguiente(NodoColaJugadores siguiente) {
        this.siguiente = siguiente;
    }
    public NodoColaJugadores getSiguiente() {
        return siguiente;
    }
}
