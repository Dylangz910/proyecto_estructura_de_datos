/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author AMD
 */
public class ListaPreguntas {
    private Pregunta cabeza;

    public void insertarPregunta(String codigo, String nombre, String respuesta) {
        Pregunta nueva = new Pregunta(codigo, nombre, respuesta);
        if (cabeza == null) {
            cabeza = nueva;
        } else {
            Pregunta temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nueva;
        }
    }

    public void mostrarPreguntas() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "Este nodo no tiene preguntas aún.");
            return;
        }
        StringBuilder sb = new StringBuilder("Preguntas del nodo:\n");
        Pregunta temp = cabeza;
        while (temp != null) {
            sb.append("[").append(temp.codigo).append("] ").append(temp.nombre)
              .append(" → ").append(temp.respuesta).append("\n");
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
