package com.mycompany.grupo_6_pfa1;

/**
 *
 * @author Julio Quiros
 * Esta es la clase que contiene NodoDobleCircular para
 * recorrer el historial de jugadores
 * @param nombre : nombre del jugador
 * @param historial : historial de posiciones del jugador
 * @param siguiente : siguiente jugador Nodo a mostrar
 * @param anterior : anterior jugador Nodo a mostrar
 */
public class JugadorBitacora {

    private String nombre;
    private HistorialPosicion historial;
    private JugadorBitacora siguiente;
    private JugadorBitacora anterior;

    public JugadorBitacora(String nombre) {
        this.nombre = nombre;
        this.historial = null;
        this.siguiente = this.anterior = null;
    }
    
    /**
     * Obtiene el nombre del jugador.
     * @author Julio Quiros
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del jugador.
     * @author Julio Quiros
     * @param nombre El nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     /**
     * Obtiene el siguiente jugador en la bitácora.
     * @author Julio Quiros
     * @return El siguiente jugador en la bitácora.
     */
    public JugadorBitacora getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el siguiente jugador en la bitácora.
     * @author Julio Quiros
     * @param siguiente El siguiente jugador en la bitácora.
     */
    public void setSiguiente(JugadorBitacora siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Obtiene el jugador anterior en la bitácora.
     * @author Julio Quiros
     * @return El jugador anterior en la bitácora.
     */
    public JugadorBitacora getAnterior() {
        return anterior;
    }
    
    /**
     * Establece el jugador anterior en la bitácora.
     * @author Julio Quiros
     * @param anterior El jugador anterior en la bitácora.
     */
    public void setAnterior(JugadorBitacora anterior) {
        this.anterior = anterior;
    }
    
     /**
     * Registra un movimiento en el historial del jugador. Si la posición es menor que la anterior,
     * el movimiento se inserta al inicio del historial. Si la posición es igual a una existente,
     * solo se actualiza la información de ese movimiento.
     * @author Julio Quiros
     * @param posicion La posición en la que se encuentra el jugador.
     * @param mensaje Un mensaje con información sobre el premio o catigo
     */
    public void registrarMovimiento(int posicion, String mensaje) {
        HistorialPosicion nuevo = new HistorialPosicion(posicion, mensaje);
        if (historial == null) {
            historial = nuevo;
            return;
        }
        
        if(posicion < historial.getPosicion()) {
            nuevo.setSiguiente(historial);
            historial = nuevo;   
            return;
        }
        
        HistorialPosicion temp = historial;
        while (temp.getSiguiente() != null && temp.getSiguiente().getPosicion() <= posicion){
            if(temp.getSiguiente().getPosicion()==posicion){
                temp = temp.getSiguiente();
                temp.setTimestamp(nuevo.getTimestamp());
                temp.setMensaje(nuevo.getMensaje());
                return;
            }
            temp = temp.getSiguiente();
        }
        nuevo.setSiguiente(temp.getSiguiente());
        temp.setSiguiente(nuevo);
        
    }
    
    /**
     * Muestra el historial de posiciones del jugador, incluyendo la posición, la hora del movimiento y un mensaje.
     * @author Jesus Anchia
     * @return El historial completo del jugador.
     */
    public String mostrarHistorial() {
        StringBuilder sb = new StringBuilder("Historial de " + nombre + ":"+"\n");
        HistorialPosicion actual = historial;
        if (actual == null) {
            sb.append(" Jugador no ha tirado dados ");
        }
        while (actual != null) {
            sb.append("Posición: ").append(actual.getPosicion())
                    .append(" | Hora: ").append(actual.getTimestamp())
                    .append(" | Info: ").append(actual.getMensaje()).append("\n").append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
