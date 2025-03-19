/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author  Susana Jimenez
 * 
 */
public class PilaCastigos {
   private NodoPila cima;
   private Random random;

    public PilaCastigos() {
        cima = null;
        random = new Random();
    }

    // Método para agregar un castigo a la pila
    public void apilar(char operacion, int valor) {
        NodoPila nuevo = new NodoPila(operacion, valor);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    // Método para retirar un castigo de la pila
    public NodoPila desapilar() {
        if (cima == null) {
            JOptionPane.showMessageDialog(null, "La pila de castigos esta vacía");
            return null;
        }
        NodoPila castigo = cima;
        cima = cima.siguiente;
        return castigo;
    }

    // Método para listar los castigos en la pila
    public void listarCastigos() {
        if (cima == null) {
            JOptionPane.showMessageDialog(null, "La pila de castigos esta vacía");
            return;
        }
        NodoPila actual = cima;
        String lista = "Lista de castigos:\n";
        while (actual != null) {
            lista = lista + actual.operacion + " " + actual.valor +"\n";
            actual = actual.siguiente;
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    public void mantenerPila(){
    int cantidad = 0;
    try {
        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuántos castigos desea agregar a la pila"));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
        return; 
    }
    int contador = 0;
    while (contador < cantidad) {
        String castigo = JOptionPane.showInputDialog("Ingrese el castigo a agregar a la pila");
        if (castigo == null || castigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un castigo válido (Ej: =5 o -3)");
            continue;
        }
        castigo = castigo.trim(); 
        if (castigo.length() < 2) {
            JOptionPane.showMessageDialog(null, "Ingrese un castigo válido (Ej: =5 o -3)");
            continue;
        }
        char operacion = castigo.charAt(0);
        String posicion = castigo.substring(1).trim(); 
        int posiciones;
        try { 
            posiciones = Integer.parseInt(posicion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido después del operador");
            continue;
        }
        if ((operacion == '=' || operacion == '-') && posiciones > 0) {
            apilar(operacion, posiciones);
            contador++;
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un castigo válido");
        }
    }
    }


}
