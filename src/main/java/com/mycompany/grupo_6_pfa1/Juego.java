/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Andy , Julio 
 */
public class Juego {

    private Cola_Jugadores jugadores;
    private Random random;
    private PilaPremios premios;
    private PilaCastigos castigos;
    private Ayuda ayuda;
    private EstadoJuego estado;
    private int posicionMaxima;

    public Juego() {
        jugadores = new Cola_Jugadores();
        premios = new PilaPremios();
        castigos = new PilaCastigos();
        random = new Random();
        ayuda = new Ayuda();
        estado = new EstadoJuego();
        posicionMaxima = 0;
        cargarPremiosCastigos();
    }

    private void cargarPremiosCastigos() {
        premios.apilar('+', 2);
        premios.apilar('+', 8);
        premios.apilar('+', 0);

        castigos.apilar('-', 3);
        castigos.apilar('=', 1);
        castigos.apilar('-', 5);
    }

    public void iniciarJuego() {
        int cantidad = 0;
        while(true){
           try{
               cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores (4 Máximo)"));
               if(cantidad < 0 || cantidad > 4) {
                 JOptionPane.showMessageDialog(null,"El número de jugadores no puede ser negativo o sobrepasar el máximo");
               }else{
                 break;
                 
           }
           }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Ingrese una cantidad válida");
           }
        }
        
        for (int i = 0; i < cantidad; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador "+(i+1)+":");
            jugadores.encolar(new NodoColaJugadores(nombre));
        }
        
        while(true){
            try{
               this.posicionMaxima=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion máxima del juego"));
               if(cantidad <= 0) {
                 JOptionPane.showMessageDialog(null,"La posicion máxima no puede ser igual a cero o negativa");
               }else{
                 break;     
           }
           }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Ingrese una cantidad válida");
           }
           
        }
        estado.generarPosiciones(posicionMaxima);
    }

    public void jugar() {
        while (true) {
            if(jugadores.esVacia()){
                JOptionPane.showMessageDialog(null,"No hay mas jugadores en el juego\nSaliendo del Juego.....");
                break;
            }
            int opcion = 0;
            while (true) {
                try{
                    opcion =Integer.parseInt(JOptionPane.showInputDialog("***Menu Principal***\n1. Tirar dados\n2. Listar jugadores\n3. Retirar Jugador\n4. Mostrar pila de premios\n5. Mostrar pila de castigos\n6. Mantener pila de premios\n7. Mantener pila de castigos\n8. Estado Actual del Juego\n9. Mostrar Ayuda\n10.Salir del Juego"));
                    break;
                }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
            } 
            }
            if (opcion == 1) {
                if(tirarDados()){
                    JOptionPane.showMessageDialog(null, "¡Felicidades!, Has alcanzado la meta y ganado el juego");
                    break;
                }
            } else if (opcion == 2) {
                jugadores.listarJugadores();
            } else if (opcion == 3) {
                String jugadorRetirar = JOptionPane.showInputDialog("Ingrese el nombre del jugador a retirar:");
                jugadores.retirarJugador(jugadorRetirar);
                estado.vaciarPosicion(jugadorRetirar);
            } else if (opcion == 4) {
                premios.listarPremios();
            } else if (opcion == 5) {
                castigos.listarCastigos();
            }  else if (opcion == 6) {
                premios.mantenerPila();
            }  else if (opcion == 7) {
                castigos.mantenerPila();
            } else if (opcion == 8) {
                estado.mostrarEstadoDeJuego(posicionMaxima);
            } else if (opcion == 9) {
                ayuda.mostrarAyuda();
            }else {
                break;
            }
        }
    }

    private boolean tirarDados() {
    if (jugadores.estaVacia()) {
        System.out.println("No hay jugadores en la partida.");
        return false;
    }
    
    NodoColaJugadores jugador = jugadores.desencolar();
    int dado1 = random.nextInt(6) + 1;
    int dado2 = random.nextInt(6) + 1;
    int total = dado1 + dado2;
    int posicion = jugador.getPosicion();
    
    jugador.setPosicion(posicion + total);
    JOptionPane.showMessageDialog(null, "Jugador " + jugador.getNombre() +
        " tiró los dados y obtuvo " + dado1 + " y " + dado2 + 
        ". Avanza " + total + " posiciones. Nueva posición: " + jugador.getPosicion());
    
    if (verificarGanador(jugador)) {
        return true;
    }
  
    if (jugador.getPosicion() % 2 == 0) {
        NodoPila premio = premios.desapilar();
        if (premio != null) { // Evita NullPointerException
            JOptionPane.showMessageDialog(null, "Estas en una posición par, debes tomar un premio de la pila. ¡Mucha suerte!");
            jugador.setPosicion(jugador.getPosicion() + premio.valor);
            JOptionPane.showMessageDialog(null, "Obtuviste " + premio.operacion + premio.valor +
                " de la pila de premios. Nueva posición: " + jugador.getPosicion());
        } else {
            JOptionPane.showMessageDialog(null, "No quedan premios. Mantienes tu posición: " + jugador.getPosicion());
        }
    } 
    
    else {
        NodoPila castigo = castigos.desapilar();
        if (castigo != null) { 
            JOptionPane.showMessageDialog(null, "Estas en una posición impar, debes tomar un castigo de la pila. ¡Buena Suerte la Proxima!");
            if (castigo.operacion == '=') {
                jugador.setPosicion(castigo.valor);
            } else {
                jugador.setPosicion(jugador.getPosicion() - castigo.valor);
            }
            JOptionPane.showMessageDialog(null, "Obtuviste " + castigo.operacion + castigo.valor +
                " de la pila de castigos. Nueva posición: " + jugador.getPosicion());
        } else {
            JOptionPane.showMessageDialog(null, "No quedan castigos. Mantienes tu posición: " + jugador.getPosicion());
        }
    }
    if (verificarGanador(jugador)) {
        return true;
    }

    jugadores.encolar(jugador);
    estado.actualizarEstadoDeJuego(jugador.getPosicion(), jugador.getNombre());

    return false;
}
    
    private boolean verificarGanador(NodoColaJugadores jugador){
        if(jugador.getPosicion()==posicionMaxima){
            return true;
        }else if(jugador.getPosicion() > posicionMaxima){
            int dif = jugador.getPosicion()-posicionMaxima;
            jugador.setPosicion(posicionMaxima-dif);
            JOptionPane.showMessageDialog(null, "Sobrepasaste la posicion máxima, se te devolvera a la posicion: "+jugador.getPosicion());
            return false;
        }else{
            return false;
        }
    }
}

