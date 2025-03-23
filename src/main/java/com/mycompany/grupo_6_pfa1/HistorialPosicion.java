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
    private int posicion;
    private Date timestamp;
    private String mensaje;
    private HistorialPosicion siguiente;

    public HistorialPosicion(int posicion, String mensaje) {
        this.posicion = posicion;
        this.mensaje = mensaje;
        this.timestamp = new Date();
        this.siguiente = null;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HistorialPosicion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(HistorialPosicion siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
