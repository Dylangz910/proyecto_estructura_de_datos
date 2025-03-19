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

    public Juego() {
        jugadores = new Cola_Jugadores();
        premios = new PilaPremios();
        castigos = new PilaCastigos();
        random = new Random();
        ayuda = new Ayuda();
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
               JOptionPane.showMessageDialog(null,"Error: " +e.getMessage());
           }
        }
        for (int i = 0; i < cantidad; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador "+(i+1)+":");
            jugadores.encolar(new NodoColaJugadores(nombre));
        }
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
                    opcion =Integer.parseInt(JOptionPane.showInputDialog("***Menu Principal***\n1. Tirar dados\n2. Listar jugadores\n3. Retirar Jugador\n4. Mostrar pila de premios\n5. Mostrar pila de castigos\n6. Mantener pila de premios\n7. Mantener pila de castigos\n8. Mostrar Ayuda\n9. Salir del juego"));
                    break;
                }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
            } 
            }
            if (opcion == 1) {
                tirarDados();
            } else if (opcion == 2) {
                jugadores.listarJugadores();
            } else if (opcion == 3) {
                String jugadorRetirar = JOptionPane.showInputDialog("Ingrese el nombre del jugador a retirar:");
                jugadores.retirarJugador(jugadorRetirar);
            } else if (opcion == 4) {
                premios.listarPremios();
            } else if (opcion == 5) {
                castigos.listarCastigos();
            }  else if (opcion == 6) {
                premios.mantenerPila();
            }  else if (opcion == 7) {
                castigos.mantenerPila();
            } else if (opcion == 8) {
                ayuda.mostrarAyuda();
            }else {
                break;
            }
        }
    }

    private void tirarDados() {
        if (jugadores.estaVacia()) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }
        NodoColaJugadores jugador = jugadores.desencolar();
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int total = dado1 + dado2;
        int posicion = jugador.getPosicion();
        jugador.setPosicion(jugador.getPosicion()+total);
        JOptionPane.showMessageDialog(null,"Jugador " +jugador.getNombre() +" tiro los dados y obtuvo " +dado1 +" y " +dado2 +" puedes avanzar " +total + " posiciones");
        JOptionPane.showMessageDialog(null,"Jugador " +jugador.getNombre() +" estas en la posición "+posicion +", puedes avanzar " +total +" posiciones en la carrera. Ahora su nueva posición es " +jugador.getPosicion());
        if (jugador.getPosicion() % 2 == 0) {
            NodoPila premio = premios.desapilar();
            if (premio == null){
                JOptionPane.showMessageDialog(null, "Mantendrás tu posicion: " +jugador.getPosicion());
                jugadores.encolar(jugador);
                return;
            }
            JOptionPane.showMessageDialog(null, "Estas en una posicion par, debes tomar un premio de la pila. Mucha Suerte");
            jugador.setPosicion(jugador.getPosicion()+premio.valor);
            JOptionPane.showMessageDialog(null, "Obtuviste " + premio.operacion + premio.valor +" de la pila de premios, su nueva posicion es: " +jugador.getPosicion());
           // System.out.println("Posicion nueva: " +jugador.getPosicion());
            
        } else {
            NodoPila castigo = castigos.desapilar();
            if (castigo == null){
                JOptionPane.showMessageDialog(null, "Mantendrás tu posicion: " +jugador.getPosicion());
                jugadores.encolar(jugador);
                return;
            }
            JOptionPane.showMessageDialog(null,"Estas en una posicion impar, debes tomar un castigo de la pila. Mejor suerte la próxima vez");
            if(castigo.operacion == '='){
              jugador.setPosicion(castigo.valor);  
            } else {
              jugador.setPosicion(jugador.getPosicion() - castigo.valor);
            }
            JOptionPane.showMessageDialog(null, "Obtuviste " + castigo.operacion + castigo.valor +" de la pila de castigos, su nueva posicion es: " +jugador.getPosicion()); 
            
            //System.out.println("Posicion nueva: " +jugador.getPosicion());
            
        }
       //jugador.setPosicion(jugador.getPosicion() +total);
       jugadores.encolar(jugador);
    }
}
