/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;

/**
 * Clase que gestiona el estado del juego, permitiendo generar posiciones, actualizar el estado de los jugadores en esas posiciones,
 * @author Jesus Anchia
 */
public class EstadoJuego {
    ListaCircular lista;

    public EstadoJuego() {
        this.lista = new ListaCircular();
    }
    
    /**
     * Genera las posiciones en el juego, insertando números desde 1 hasta la posición máxima.
     * @author Jesus Anchia
     * @param posicionMaxima La cantidad máxima de posiciones que se generarán en el juego.
     */
    public void generarPosiciones(int posicionMaxima){
        for(int i= 1; i<=posicionMaxima; i++){
           lista.insertar(i);
        }
    }
    
    /**
     * Actualiza el estado de juego asignando un nombre de jugador a una posición específica.
     * Si un jugador ya está en la posición, su nombre será marcado como "VACIA".
     * @author Jesus Anchia
     * @param posicion La posición que se actualizará.
     * @param nombreJugador El nombre del jugador que ocupará la posición.
     */
    public void actualizarEstadoDeJuego(int posicion, String nombreJugador){
        if (lista == null || lista.getFrente() == null) {
        return; 
        }
        NodoListaCircular temp = lista.getFrente();
        do{
           if(temp.getNombreJugador().equals(nombreJugador)){
               temp.setNombreJugador("VACIA");
           }
           if(temp.getPosicion()==posicion){
               temp.setNombreJugador(nombreJugador);
           }
           temp = temp.getSiguiente();
        }while(temp!=lista.getFrente());
        }
    
    /**
     * Muestra el estado actual del juego, destacando a los jugadores con diferentes colores según su posición en el juego.
     * El color verde representa las primeras posiciones, amarillo las intermedias, y rojo las posiciones finales.
     * @author Jesus Anchia
     * @param posicionMaxima El total de posiciones disponibles en el juego para determinar los porcentajes de colores.
     */
    public void mostrarEstadoDeJuego(int posicionMaxima){
      if (lista.getFrente() == null) {  
        JOptionPane.showMessageDialog(null, "La lista está vacía. No hay posiciones para mostrar.");
        return;
      }
      NodoListaCircular temp = lista.getFrente();
      
      int porcentajeVerde = (int) (posicionMaxima*0.40);
      int porcentajeAmarillo = (int) (posicionMaxima*0.80);
      
      StringBuilder listaPosiciones = new StringBuilder("<html><b>ESTADO DEL JUEGO</b><br>");
      int contador = 0;
      do{
         String color = "";
         if(contador < porcentajeVerde){
            color = "green"; 
         }else if(contador < porcentajeAmarillo){
            color = "#E1A800";
         }else{
            color = "red"; 
         }
         
         listaPosiciones.append("<font color='").append(color).append("'>").append("Posicion: ").append(temp.getPosicion()).append("</font>").append(" | ")
                 .append("<font color='black'>").append(temp.getNombreJugador()).append("</font><br>");
        temp = temp.getSiguiente();
        contador++;
      }while(temp != lista.getFrente());
      
      listaPosiciones.append("</html>");
      JOptionPane.showMessageDialog(null, listaPosiciones);
    }
    
    /**
     * Vacía la posición de un jugador específico en el juego.
     * @author Jesus Anchia
     * @param jugadorEliminar El nombre del jugador que se desea eliminar de la posición.
     */
    public void vaciarPosicion(String jugadorEliminar){
        NodoListaCircular temp = lista.getFrente();
        boolean encontrado=false;
        do{
           if(temp.getNombreJugador().equals(jugadorEliminar)){
               encontrado = true;
               break;
           }
           temp = temp.getSiguiente();
        }while(temp!=lista.getFrente());
        
        if(encontrado){
            temp.setNombreJugador("VACIA");
        }else{
            return;
        }
    }
    
    
}
