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
public class ArbolFAQ {
    private NodoArbolFAQ raiz;

    public ArbolFAQ() {
        raiz = new NodoArbolFAQ("1", "Preguntas Frecuentes (FAQ)");
    }

    public NodoArbolFAQ buscarNodo(String codigo) {
        return buscarRec(raiz, codigo);
    }

    private NodoArbolFAQ buscarRec(NodoArbolFAQ nodo, String codigo) {
    if (nodo == null) return null;
    if (nodo.codigo.equals(codigo)) return nodo;

    NodoArbolFAQ izquierdo = buscarRec(nodo.izquierdo, codigo);
    if (izquierdo != null) return izquierdo;

    return buscarRec(nodo.derecho, codigo);
}

    public void insertarNodoPadre() {
        String codigoPadre = JOptionPane.showInputDialog("Ingrese el código del nodo padre (ej: 1 o 111)");
        NodoArbolFAQ padre = buscarNodo(codigoPadre);

        if (padre == null) {
            JOptionPane.showMessageDialog(null, "Nodo padre no encontrado.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo nodo");

        if (padre.izquierdo == null) {
            padre.izquierdo = new NodoArbolFAQ(codigoPadre + "1", nombre);
            JOptionPane.showMessageDialog(null, "Nodo insertado a la izquierda con código: " + padre.izquierdo.codigo);
        } else if (padre.derecho == null) {
            padre.derecho = new NodoArbolFAQ(codigoPadre + "2", nombre);
            JOptionPane.showMessageDialog(null, "Nodo insertado a la derecha con código: " + padre.derecho.codigo);
        } else {
            JOptionPane.showMessageDialog(null, "Este nodo ya tiene dos hijos.");
        }
    }

    public void insertarPreguntaHija() {
        String codigoNodo = JOptionPane.showInputDialog("Ingrese el código del nodo hoja donde desea insertar la pregunta");
        NodoArbolFAQ nodo = buscarNodo(codigoNodo);

        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
            return;
        }

        if (!nodo.esHoja()) {
            JOptionPane.showMessageDialog(null, "Este nodo no es hoja. Solo los nodos hoja pueden tener preguntas.");
            return;
        }

        if (nodo.preguntas == null) nodo.preguntas = new ListaPreguntas();

        String cod = JOptionPane.showInputDialog("Ingrese el código de la pregunta");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la pregunta");
        String resp = JOptionPane.showInputDialog("Ingrese la respuesta");

        nodo.preguntas.insertarPregunta(cod, nombre, resp);
    }

    public void imprimirPreguntasNodo() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del nodo hoja para ver sus preguntas");
        NodoArbolFAQ nodo = buscarNodo(codigo);

        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
            return;
        }

        if (!nodo.esHoja()) {
            JOptionPane.showMessageDialog(null, "Este nodo no es hoja. Solo los nodos hoja pueden tener preguntas.");
            return;
        }

        if (nodo.preguntas == null) {
            JOptionPane.showMessageDialog(null, "Este nodo no tiene preguntas aún.");
            return;
        }

        nodo.preguntas.mostrarPreguntas();
    }
}
