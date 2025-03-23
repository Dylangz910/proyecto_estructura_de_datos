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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JugadorBitacora getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(JugadorBitacora siguiente) {
        this.siguiente = siguiente;
    }

    public JugadorBitacora getAnterior() {
        return anterior;
    }

    public void setAnterior(JugadorBitacora anterior) {
        this.anterior = anterior;
    }

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
