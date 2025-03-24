/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author Julio Quiros
 * @param frente : Puntero al inicio
 * @param fin : Puntero al final
 * @param posicion : Posicion del jugador
 */
public class Cola_Jugadores {

    private NodoColaJugadores frente;
    private NodoColaJugadores fin;
    private NodoColaJugadores posicion;

    public Cola_Jugadores() {
        this.frente = this.fin = null;
    }
    
    /**	
	* Extrae el nodo que esta en el frente
	* @author Julio Quirós
        * @return retorna el Nodo que se encuentra a inicio de la cola
    */
    public NodoColaJugadores getFrente() {
        return frente;
    }
    
    /**	
	* Retorna si la cola se encuentra vacia
	* @author Julio Quirós
        * @return retorna boolean, el resultado de frente=null
    */
    public boolean estaVacia() {
        return frente == null;
    }
    
    /**	
	* Encola al jugador al final de la cola
	* @author Julio Quirós
        * @param nombre Corresponde al Nodo que se colocara al final de la cola
    */
    public void encolar(NodoColaJugadores nombre) {
        if (fin == null) {
            frente = fin = nombre;
        } else {
            fin.setSiguiente(nombre);
            fin = nombre;
        }
       fin.setSiguiente(null);

    }
    
    /**
     * Verifica si la cola está vacía.
     * @author Julio Quirós
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean esVacia(){
        if(frente==null){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Desencola el jugador que se encuentra al inicio de la cola.
     * @author Julio Quirós
     * @return El nodo que representa al jugador desencolado o null si la cola está vacía.
     */
    public NodoColaJugadores desencolar() {
        if (estaVacia()) {
            return null;
        }
        NodoColaJugadores jugador = frente;
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return jugador;
    }
    
    /**
     * Mueve el jugador al final de la cola.
     * @author Julio Quirós
     * @return El jugador que se movió al final de la cola o null si la cola está vacía.
     */
    public NodoColaJugadores moverAlFinal() {   
        if (frente == null) {
            return null;
        }
        NodoColaJugadores temp = frente;
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return temp;

    }
    
     /**
     * Lista todos los jugadores en la cola.
     * @author Julio Quirós
     */
    public void listarJugadores() {
        NodoColaJugadores actual = frente;
        String lista = "Lista de Jugadores:\n";
        while (actual != null) {
            lista = lista + "Jugador: " + actual.getNombre() + " | Posicion: " + actual.getPosicion() +"\n";
            actual = actual.getSiguiente();

            if (actual == frente) {
                JOptionPane.showMessageDialog(null,"Error: Se detectó un ciclo en la cola de jugadores.");
                break;
            }
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    /**
     * Retira un jugador de la cola por su nombre.
     * @author Julio Quirós
     * @param nombre Nombre del jugador que se desea retirar de la cola.
     */
    public void retirarJugador(String nombre) {
        if (estaVacia()) {
            return;
        }

        NodoColaJugadores actual = frente, previo = null;
        while (actual != null && !actual.getNombre().equals(nombre)) {
            previo = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            JOptionPane.showMessageDialog(null,"Jugador no encontrado");
            return;
        }

        if (previo == null) {
            frente = actual.getSiguiente();
        } else {
            previo.setSiguiente(actual.getSiguiente());
        }

        if (actual == fin) {
            fin = previo;
        }
        JOptionPane.showMessageDialog(null,"Jugador " + nombre + " ha salido del juego.");
    }
}
