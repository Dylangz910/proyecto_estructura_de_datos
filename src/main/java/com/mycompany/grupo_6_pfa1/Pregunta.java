/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author AMD
 */
public class Pregunta {
     String codigo;
    String nombre;
    String respuesta;
    Pregunta siguiente;

    public Pregunta(String codigo, String nombre, String respuesta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.respuesta = respuesta;
        this.siguiente = null;
    }
}
