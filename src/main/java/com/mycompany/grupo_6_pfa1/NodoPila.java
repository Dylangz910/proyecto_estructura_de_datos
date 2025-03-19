/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author SusanaJF
 */
public class NodoPila {
    int valor; // Número que representa el premio o castigo
    char operacion; // '+' para premios, '-' o '=' para castigos
    NodoPila siguiente; // Apunta al siguiente nodo en la pila

    public NodoPila(char operacion, int valor) {
        this.operacion = operacion;
        this.valor = valor;
        this.siguiente = null;
    }
}
