/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author ramon
 */
public class EstadoJuego {
    ListaCircular lista;

    public EstadoJuego() {
        this.lista = new ListaCircular();
    }
    
    public void generarPosiciones(int posicionMaxima){
        for(int i= 1; i<=posicionMaxima; i++){
           lista.insertar(i);
        }
    }
        
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
    
    public void mostrarEstadoDeJuego(int posicionMaxima){
      if (lista.getFrente() == null) {  // Validar que la lista no esté vacía
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
