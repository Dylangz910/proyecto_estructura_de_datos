/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author ramon
 */
public class ListaCircular {
    private NodoListaCircular frente;
    private NodoListaCircular ultimo;

    public ListaCircular() {
        this.frente = null;
        this.ultimo = null;
    }

    public NodoListaCircular getFrente() {
        return frente;
    }

    public void setFrente(NodoListaCircular frente) {
        this.frente = frente;
    }

    public NodoListaCircular getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaCircular ultimo) {
        this.ultimo = ultimo;
    }
    
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
