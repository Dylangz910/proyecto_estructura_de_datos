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
 * @param frente : Puntero al final
 */
public class Cola_Jugadores {

    private NodoColaJugadores frente;
    private NodoColaJugadores fin;
    private NodoColaJugadores posicion;

    public Cola_Jugadores() {
        this.frente = this.fin = null;
    }

    public NodoColaJugadores getFrente() {
        return frente;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(NodoColaJugadores nombre) {
        ///NodoColaJugadores nuevo = new NodoColaJugadores(nombre);
        /*
        if (estaVacia()) {
            frente = fin = nombre;
        } else {
            fin.setSiguiente(nombre);
            fin = nombre;
        }
        fin.siguiente = null;
         */
        if (fin == null) {
            frente = fin = nombre;
        } else {
            fin.setSiguiente(nombre);
            fin = nombre;
        }
       fin.setSiguiente(null);

    }
    
    public boolean esVacia(){
        if(frente==null){
            return true;
        }else{
            return false;
        }
    }

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

    public NodoColaJugadores moverAlFinal() {   // cambie a  NodoColaJugadores  remover()

        /*
        if (estaVacia() || frente == fin) return;
        NodoColaJugadores jugador = desencolar();
        encolar(jugador.getNombre());
         */
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
