package com.mycompany.grupo_6_pfa1;

import java.util.Date;


/**
 *
 * @author Julio Quiros
 * Esta clase es para generar el mensaje que mostrara su posicion y fecha
 * @param posicion : ubicacion del jugador
 * @param timestamp : tiempo real que se mostrara
 * @param mensaje : mensaje completo a mostrar
 */

public class HistorialPosicion {
    int posicion;
    Date timestamp;
    String mensaje;
    HistorialPosicion siguiente;

    public HistorialPosicion(int posicion, String mensaje) {
        this.posicion = posicion;
        this.mensaje = mensaje;
        this.timestamp = new Date();
        this.siguiente = null;
    }
}
