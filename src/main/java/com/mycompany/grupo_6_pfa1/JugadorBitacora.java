package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author Julio Quiros Esta es la clase que contiene NodoDobleCircular para
 * recorrer el historial de jugadores
 * @param nombre : nombre del jugador
 * @param historial : historial de posiciones del jugador
 * @param siguiente : siguiente jugador Nodo a mostrar
 * @param anterior : anterior jugador Nodo a mostrar
 */
public class JugadorBitacora {

    String nombre;
    HistorialPosicion historial;
    JugadorBitacora siguiente;
    JugadorBitacora anterior;

    public JugadorBitacora(String nombre) {
        this.nombre = nombre;
        this.historial = null;
        this.siguiente = this.anterior = null;
    }

    public void registrarMovimiento(int posicion, String mensaje) {
        HistorialPosicion nuevo = new HistorialPosicion(posicion, mensaje);
        if (historial == null) {
            historial = nuevo;
        } else {
            HistorialPosicion actual = historial;
            while (actual.siguiente != null) {
                if (actual.posicion == posicion) {
                    actual.timestamp = nuevo.timestamp;
                    actual.mensaje = nuevo.mensaje;
                    return;
                }
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public String mostrarHistorial() {
        StringBuilder sb = new StringBuilder("Historial de " + nombre + ":");
        HistorialPosicion actual = historial;
        while (actual != null) {
            sb.append("Posición: ").append(actual.posicion)
                    .append(" | Hora: ").append(actual.timestamp)
                    .append(" | Info: ").append(actual.mensaje).append("\n");
            actual = actual.siguiente;
        }
        if (actual == null) {
            sb.append(" Jugador no ah tirado dados ");
        }
        return sb.toString();
    }
}
