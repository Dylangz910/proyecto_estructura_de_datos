/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Pila premios y sus funcionaliddades
 * @author Susana Jimenez
 */
public class PilaPremios {
     private NodoPila cima;
     private Random random;

    public PilaPremios() {
        cima = null;
        random = new Random();
    }

    // Método para agregar un premio a la pila
    public void apilar(char operacion, int valor) {
        NodoPila nuevo = new NodoPila(operacion, valor);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    // Método para retirar un premio de la pila
    public NodoPila desapilar() {
        if (cima == null) {
            JOptionPane.showMessageDialog(null, "La pila de premios esta vacía");
            return null;
        }
        NodoPila premio = cima;
        cima = cima.siguiente;
        return premio;
    }

    // Método para listar los premios en la pila
    public void listarPremios() {
        if (cima == null) {
            JOptionPane.showMessageDialog(null, "La pila de premios esta vacía");
            return;
        }
        NodoPila actual = cima;
        String lista = "Lista de premios:\n";
        while (actual != null) {
            lista = lista + actual.operacion + " " + actual.valor +"\n";
            actual = actual.siguiente;
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    public void mantenerPila(){
    int cantidad = 0;
    try {
        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuántos premios desea agregar a la pila"));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
        return; 
    }
    int contador = 0;
    while (contador < cantidad) {
        String premio = JOptionPane.showInputDialog("Ingrese el premio a agregar a la pila");
        if (premio == null || premio.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un premio válido (Ej: +5 o +3)");
            continue;
        }
        premio = premio.trim(); 
        if (premio.length() < 2) {
            JOptionPane.showMessageDialog(null, "Ingrese un premio válido (Ej: +5 o +3)");
            continue;
        }
        char operacion = premio.charAt(0);
        String posicion = premio.substring(1).trim(); 
        int posiciones;
        try { 
            posiciones = Integer.parseInt(posicion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido después del operador");
            continue;
        }
        if (operacion == '+' && posiciones > 0) {
            apilar(operacion, posiciones);
            contador++;
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un premio válido");
        }
    }
    
}


}
