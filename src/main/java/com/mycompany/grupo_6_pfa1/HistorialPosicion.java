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
    
    /**
     * Obtiene la posición registrada en el historial.
     * @author Julio Quiros
     * @return La posición registrada
     */
    public int getPosicion() {
        return posicion;
    }
    
    /**
     * Establece la posición en el historial.
     * @author Julio Quiros
     * @param posicion La nueva posición a establecer.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    /**
     * Obtiene el timestamp del historial, que representa la fecha y hora en que se registró.
     * @author Julio Quiros
     * @return El timestamp del historial.
     */
    public Date getTimestamp() {
        return timestamp;
    }
    
    /**
     * Establece un nuevo timestamp para el historial.
     * @author Julio Quiros
     * @param timestamp La nueva fecha y hora a establecer.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Obtiene el mensaje asociado con la posición en el historial.
     * @author Julio Quiros
     * @return El mensaje relacionado con la posición.
     */
    public String getMensaje() {
        return mensaje;
    }
    
     /**
     * Establece un nuevo mensaje relacionado con la posición en el historial.
     * @author Julio Quiros
     * @param mensaje El nuevo mensaje a establecer.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    /**
     * Obtiene el siguiente elemento en el historial.
     * @author Julio Quiros
     * @return El siguiente historial o null si no hay más elementos.
     */
    public HistorialPosicion getSiguiente() {
        return siguiente;
    }
    
     /**
     * Establece el siguiente historial en la lista de historiales.
     * @author Julio Quiros
     * @param siguiente El siguiente historial que será enlazado.
     */
    public void setSiguiente(HistorialPosicion siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
