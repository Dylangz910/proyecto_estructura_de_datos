/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author AMD , Julio Quiros
 * 
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
        if (nodo == null) {
            return null;
        }
        if (nodo.codigo.equals(codigo)) {
            return nodo;
        }

        NodoArbolFAQ izquierdo = buscarRec(nodo.izquierdo, codigo);
        if (izquierdo != null) {
            return izquierdo;
        }

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

        if (nodo.preguntas == null) {
            nodo.preguntas = new ListaPreguntas();
        }

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

    public void precargarFAQ() {
        // Nivel 1
        raiz.izquierdo = new NodoArbolFAQ("11", "Preguntas para jugadores");
        raiz.derecho = new NodoArbolFAQ("12", "Preguntas para Administradores");

        // Nivel 2
        NodoArbolFAQ nodo11 = raiz.izquierdo;
        NodoArbolFAQ nodo12 = raiz.derecho;

        nodo11.izquierdo = new NodoArbolFAQ("111", "Primera vez que juego");
        nodo11.derecho = new NodoArbolFAQ("112", "Jugador Experimentado");

        nodo12.izquierdo = new NodoArbolFAQ("121", "Funcionalidades");

        // Nivel 3
        NodoArbolFAQ nodo111 = nodo11.izquierdo;
        NodoArbolFAQ nodo112 = nodo11.derecho;
        NodoArbolFAQ nodo121 = nodo12.izquierdo;

        nodo111.izquierdo = new NodoArbolFAQ("1111", "Soy nuevo en videojuegos");
        nodo111.derecho = new NodoArbolFAQ("1112", "Ya he jugado otros juegos similares");

        nodo121.izquierdo = new NodoArbolFAQ("1211", "Administrador preguntas");
        nodo121.derecho = new NodoArbolFAQ("1212", "Mejorar Juego");

        // Nivel 4 (Preguntas en hojas)
        agregarPreguntas(nodo111.izquierdo, new String[][]{
            {"Q1", "¿Cuántos jugadores pueden participar simultáneamente?", "Se tiene un máximo de 4 jugadores."},
            {"Q2", "¿Hay un tiempo máximo por partida?", "No, el juego termina cuando un jugador alcance la posición máxima."}
        });

        agregarPreguntas(nodo111.derecho, new String[][]{
            {"Q3", "¿Puedo jugar en línea?", "No, en la versión liberada no se permite jugar en línea."},
            {"Q4", "¿Si hay un ganador, los demás jugadores pueden continuar?", "Sí, no hay restricción que les impida continuar."}
        });

        agregarPreguntas(nodo112, new String[][]{
            {"Q5", "¿En qué lenguaje fue implementado?", "El juego fue implementado en JAVA."},
            {"Q6", "¿Cuándo liberan una nueva versión?", "Esperamos liberar una nueva versión en noviembre de 2024."}
        });

        // Nivel 4 admin hojas (sin preguntas definidas aún)
        nodo121.izquierdo.preguntas = new ListaPreguntas();
        nodo121.derecho.preguntas = new ListaPreguntas();
    }

    public void verChatbot() {
        JOptionPane.showMessageDialog(null, "¡Hola! Bienvenido al Chatbot de Preguntas Frecuentes 😊");
        NodoArbolFAQ actual = raiz;
        PilaFAQ historial = new PilaFAQ();

        while (true) {
            String mensaje = "📌 Estás en: " + actual.nombre + "\n";

            if (actual.izquierdo != null) {
                mensaje += "1. " + actual.izquierdo.nombre + "\n";
            }
            if (actual.derecho != null) {
                mensaje += "2. " + actual.derecho.nombre + "\n";
            }
            if (actual.esHoja() && actual.preguntas != null) {
                mensaje += "3. Ver preguntas\n";
            }

            mensaje += "R. Regresar\nX. Salir";

            String opcion = JOptionPane.showInputDialog(mensaje);
            if (opcion == null) {
                break;
            }

            opcion = opcion.trim().toUpperCase();

            switch (opcion) {
                case "1":
                    if (actual.izquierdo != null) {
                        historial.apilar(actual);
                        actual = actual.izquierdo;
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay opción 1 disponible.");
                    }
                    break;
                case "2":
                    if (actual.derecho != null) {
                        historial.apilar(actual);
                        actual = actual.derecho;
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay opción 2 disponible.");
                    }
                    break;
                case "3":
                    if (actual.esHoja() && actual.preguntas != null) {
                        actual.preguntas.mostrarPreguntas();
                    } else {
                        JOptionPane.showMessageDialog(null, "Este nodo no contiene preguntas.");
                    }
                    break;
                case "R":
                    NodoArbolFAQ anterior = historial.desapilar();
                    if (anterior != null) {
                        actual = anterior;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya estás en el inicio del chatbot.");
                    }
                    break;
                case "X":
                    JOptionPane.showMessageDialog(null, "¡Gracias por visitar el Chatbot! Hasta pronto. 👋");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private void agregarPreguntas(NodoArbolFAQ nodo, String[][] preguntas) {
        nodo.preguntas = new ListaPreguntas();
        for (String[] p : preguntas) {
            nodo.preguntas.insertarPregunta(p[0], p[1], p[2]);
        }
    }

}
