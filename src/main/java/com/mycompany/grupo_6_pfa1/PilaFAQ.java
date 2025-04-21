/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author Julio Quiros
 * Utiliza nodos tipo NodoPilaFAQ para almacenar referencias a nodos del árbol FAQ.
 */
public class PilaFAQ {

    private NodoPilaFAQ cima;

    public PilaFAQ() {
        cima = null;
    }

    public void apilar(NodoArbolFAQ nodo) {
        NodoPilaFAQ nuevo = new NodoPilaFAQ(nodo);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public NodoArbolFAQ desapilar() {
        if (cima == null) {
            return null;
        }
        NodoArbolFAQ temp = cima.nodo;
        cima = cima.siguiente;
        return temp;
    }

    public boolean estaVacia() {
        return cima == null;
    }

}
