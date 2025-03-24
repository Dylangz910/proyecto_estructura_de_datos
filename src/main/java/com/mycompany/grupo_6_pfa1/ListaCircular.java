/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 * Clase que implementa una lista circular simple.
 * Los nodos de la lista están conectados de tal manera que el último nodo apunta al primero
 * @author Jesús Anchia
 * @param frente : Frente de la lista circular
 * @param ultimo : Ultimo Nodo en la lista circular
 */
public class ListaCircular {
    private NodoListaCircular frente;
    private NodoListaCircular ultimo;

    public ListaCircular() {
        this.frente = null;
        this.ultimo = null;
    }
    
    /**
     * Obtiene el nodo que está en la posición del frente de la lista circular. 
     * @author Jesús Anchia
     * @return NodoListaCircular, el primer nodo de la lista.
     */
    public NodoListaCircular getFrente() {
        return frente;
    }
    
    /**
     * Establece el nodo que estará en la posición frente de la lista circular.
     * @author Jesús Anchia
     * @param frente el nodo que se establecerá como el primero de la lista.
     */
    public void setFrente(NodoListaCircular frente) {
        this.frente = frente;
    }
    
     /**
     * Obtiene el nodo que está en la última posición de la lista circular.
     * @author Jesús Anchia
     * @return el último nodo de la lista.
     */
    public NodoListaCircular getUltimo() {
        return ultimo;
    }
    
    
    /**
     * Establece el nodo que estará en la última posición de la lista circular.
     * @author Jesús Anchia
     * @param ultimo el nodo que se establecerá como el último de la lista.
     */
    public void setUltimo(NodoListaCircular ultimo) {
        this.ultimo = ultimo;
    }
    
    /**
     * Inserta un nuevo nodo con la posición del parametro
     * @author Jesús Anchia
     * @param posicion la posición del nuevo nodo a insertar
     */
    public void insertar(int posicion) {
        NodoListaCircular nuevo = new NodoListaCircular(posicion);
        if(frente == null){
            frente = nuevo;
            ultimo = nuevo;
            nuevo.setSiguiente(frente);
        } else {
            nuevo.setSiguiente(frente);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        
    }  
}
