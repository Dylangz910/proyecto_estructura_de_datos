package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;


/**
 *
 * @author Julio Quiros
 * Esta es la para controlar el NodoDobleCircular 
 * @param actual : Nodo puntero
 */

public class Bitacora {
    private JugadorBitacora actual;
    private JugadorBitacora cabeza;
    
    /**	
	* Agrega un jugador a la lista circular en orden alfábetico
	* @author Julio Quirós
	* @param nombre Nombre del jugador que sera agregado
    */
    public void agregarJugador(String nombre) {
        JugadorBitacora nuevo = new JugadorBitacora(nombre);
        if(cabeza==null){
            cabeza = nuevo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
            actual = cabeza;
            return;
        }
        
        if(nombre.compareToIgnoreCase(cabeza.getNombre()) < 0){
            nuevo.setSiguiente(cabeza);
            nuevo.setAnterior(cabeza.getAnterior());
            cabeza.getAnterior().setSiguiente(nuevo);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
            actual = cabeza;
            return;
        }
        
        JugadorBitacora temp = cabeza;
        while(temp.getSiguiente() != cabeza && temp.getSiguiente().getNombre().compareToIgnoreCase(nombre) < 0){
            temp = temp.getSiguiente();
        }
        nuevo.setSiguiente(temp.getSiguiente());
        nuevo.setAnterior(temp);
        temp.getSiguiente().setAnterior(nuevo);
        temp.setSiguiente(nuevo);
    }
    
    /**	
	* Elimina un jugador de la lista circular de la bitácora-historial
	* @author Julio Quirós
	* @param nombre Nombre del jugador que sera eliminado
    */
    public void eliminarJugador(String nombre){
        if(cabeza.getNombre().equals(nombre)){
            cabeza.getAnterior().setSiguiente(cabeza.getSiguiente());
            cabeza.getSiguiente().setAnterior(cabeza.getAnterior());
            cabeza = cabeza.getSiguiente();
            reiniciarActual();
            return;
        } 
        JugadorBitacora temp = cabeza;
        while(temp.getNombre()!=nombre){
            temp = temp.getSiguiente();
        }
        temp.getAnterior().setSiguiente(temp.getSiguiente());
        temp.getSiguiente().setAnterior(temp.getAnterior());
        
    }
    
    /**	
	* Método que agrega nuevos datos a la lista enlazada interna, que almacena el historial
	* @author Julio Quirós
	* @param posicion Posicion por la que paso el jugador que sera registrada
        * @param mensaje Mensaje que indica el premio o castigo que se obtuvo, si esta vacio lo indicará
    */
    public void registrar(String nombre, int posicion, String mensaje) {
        JugadorBitacora temp = actual;
        if (temp == null) return;

        do {
            if (temp.getNombre().equals(nombre)) {
                temp.registrarMovimiento(posicion, mensaje);
                return;
            }
            temp = temp.getSiguiente();
        } while (temp != actual);
    }
    
    /**	
	* Muestra el jugador que se encuentra actualmente almacenado en el puntero actual
	* @author Julio Quirós
    */
    public void mostrarJugadorActual() {
        if (actual != null) {
            JOptionPane.showMessageDialog(null, actual.mostrarHistorial());
        }
    }
    
    /**	
	* Cambia la referencia de actual, al siguiente jugador
	* @author Julio Quirós
    */
    public void siguiente() {
        if (actual != null) actual = actual.getSiguiente();
    }
    
    /**	
	* Cambia la referencia de actual, al jugador anterior
	* @author Julio Quirós
    */
    public void anterior() {
        if (actual != null) actual = actual.getAnterior();
    }
    
    /**	
	* Reinicia el puntero de acrual para que vuelva a apuntar a cabeza
	* @author Julio Quirós
    */
    public void reiniciarActual() {
        actual = cabeza;
    }
}
