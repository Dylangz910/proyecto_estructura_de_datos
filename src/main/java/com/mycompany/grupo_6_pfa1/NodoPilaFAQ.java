/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author Julio Quiros
 * Esta clase Almacena una referencia a un nodo del árbol de preguntas frecuente
 */
public class NodoPilaFAQ {

    NodoArbolFAQ nodo;
    NodoPilaFAQ siguiente;

    public NodoPilaFAQ(NodoArbolFAQ nodo) {
        this.nodo = nodo;
        this.siguiente = null;
    }

}
