/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author AMD
 */
public class NodoArbolFAQ {
    String codigo;
    String nombre;
    NodoArbolFAQ izquierdo, derecho;
    ListaPreguntas preguntas;

    public NodoArbolFAQ(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
        this.preguntas = null;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}
