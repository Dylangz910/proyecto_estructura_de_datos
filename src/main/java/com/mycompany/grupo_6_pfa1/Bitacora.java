package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;


/**
 *
 * @author Julio Quiros
 * Esta es la para controlar el NodoDobleCircular 
 * @param actual : Nodo puntero
 */

public class Bitacora {
    private JugadorBitacora actual;

    public void agregarJugador(String nombre) {
        JugadorBitacora nuevo = new JugadorBitacora(nombre);
        if (actual == null) {
            actual = nuevo;
            actual.siguiente = actual.anterior = actual;
        } else {
            JugadorBitacora ultimo = actual.anterior;
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            nuevo.siguiente = actual;
            actual.anterior = nuevo;
        }
    }

    public void registrar(String nombre, int posicion, String mensaje) {
        JugadorBitacora temp = actual;
        if (temp == null) return;

        do {
            if (temp.nombre.equals(nombre)) {
                temp.registrarMovimiento(posicion, mensaje);
                return;
            }
            temp = temp.siguiente;
        } while (temp != actual);
    }

    public void mostrarJugadorActual() {
        if (actual != null) {
            JOptionPane.showMessageDialog(null, actual.mostrarHistorial());
        }
    }

    public void siguiente() {
        if (actual != null) actual = actual.siguiente;
    }

    public void anterior() {
        if (actual != null) actual = actual.anterior;
    }
}
