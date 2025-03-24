/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 * Nodo generico de una pila que representa un premio o castigo en el juego.
 * @author Dylan Gonzales
 * @param valor un número que representa el valor del premio o castigo.
 * @param operacion un carácter que indica si es un premio ('+') o un castigo ('-' o '=').
 * @param siguiente una referencia al siguiente nodo de la pila.
 */
public class NodoPila {
    int valor; 
    char operacion; 
    NodoPila siguiente; 

    public NodoPila(char operacion, int valor) {
        this.operacion = operacion;
        this.valor = valor;
        this.siguiente = null;
    }
}
