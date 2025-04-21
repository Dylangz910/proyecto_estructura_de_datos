/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Dylan Gonzáles , Julio Quirós, Jesus Anchia Esta es la clase donde se
 * empieza el juego con sus diferentes funciones y metodos.
 * @param jugadores : representacion de jugadores
 * @param random : metodo random para los dados
 * @param premios : referencia a la funcion de premios
 * @param castigos : referencia a la funcion de castigos
 * @param Ayuda : Referencia clase Ayuda que muestra info
 * @param estado : Estado del juego actual
 * @param posicionMaxima : posicion maxima ingresada
 * @param bitacora : informacion historico de Jugadores
 */
public class Juego {

    private Cola_Jugadores jugadores;
    private Random random;
    private PilaPremios premios;
    private PilaCastigos castigos;
    private Ayuda ayuda;
    private EstadoJuego estado;
    private int posicionMaxima;
    private Bitacora bitacora;
    private boolean permitirAdicionarJugadores;
    private int cantidadDeJugadoresActuales;
    private ArbolFAQ arbolFAQ = new ArbolFAQ();

    public Juego() {
        jugadores = new Cola_Jugadores();
        premios = new PilaPremios();
        castigos = new PilaCastigos();
        random = new Random();
        ayuda = new Ayuda();
        estado = new EstadoJuego();
        posicionMaxima = 0;
        cargarPremiosCastigos();
        bitacora = new Bitacora();

        arbolFAQ = new ArbolFAQ();
        arbolFAQ.precargarFAQ(); // 🚀 Precarga automática
    }

    /**
     * Método privado para cargar los premios y castigos en el juego.
     *
     * @author Dylan Gonzales, Julio Quiros, Jesus Anchia
     */
    private void cargarPremiosCastigos() {
        premios.apilar('+', 2);
        premios.apilar('+', 8);
        premios.apilar('+', 0);

        castigos.apilar('-', 3);
        castigos.apilar('=', 1);
        castigos.apilar('-', 5);
    }

    /**
     * Inicia el juego, solicita la cantidad de jugadores y la posición máxima,
     * y configura si se permiten adicionar jugadores durante el juego.
     *
     * @author Dylan Gonzales, Julio Quiros, Jesus Anchia
     */
    public void iniciarJuego() {
        int cantidad = 0;
        while (true) {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores (4 Máximo)"));
                if (cantidad < 0 || cantidad > 4) {
                    JOptionPane.showMessageDialog(null, "El número de jugadores no puede ser negativo o sobrepasar el máximo");
                } else {
                    break;

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
            }
        }
        cantidadDeJugadoresActuales = cantidad;
        for (int i = 0; i < cantidad; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + (i + 1) + ":");
            jugadores.encolar(new NodoColaJugadores(nombre));
            bitacora.agregarJugador(nombre);
        }

        while (true) {
            try {
                this.posicionMaxima = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion máxima del juego"));
                if (posicionMaxima <= 0) {
                    JOptionPane.showMessageDialog(null, "La posicion máxima no puede ser igual a cero o negativa");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
            }
        }

        String permitir = JOptionPane.showInputDialog("¿Permitir adicionar jugadores durante el juego? (S/N)").toUpperCase();
        if (permitir.equals("S")) {
            permitirAdicionarJugadores = true;
        } else {
            permitirAdicionarJugadores = false;
        }

        estado.generarPosiciones(posicionMaxima);
    }

    /**
     * Ejecuta el ciclo principal del juego, mostrando el menú y gestionando las
     * interacciones con los jugadores.
     *
     * @author Dylan Gonzales, Julio Quiros, Jesus Anchia
     */
    public void jugar() {
        while (true) {
            if (jugadores.esVacia()) {
                JOptionPane.showMessageDialog(null, "No hay mas jugadores en el juego\nSaliendo del Juego.....");
                break;
            }
            int opcion = 0;
            while (true) {
                try {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("***Menu Principal***\n"
                            + "1. Tirar dados\n"
                            + "2. Listar jugadores\n"
                            + "3. Retirar Jugador\n"
                            + "4. Mostrar pila de premios\n"
                            + "5. Mostrar pila de castigos\n"
                            + "6. Mantener pila de premios\n"
                            + "7. Mantener pila de castigos\n"
                            + "8. Estado Actual del Juego\n"
                            + "9. Agregar jugador\n"
                            + "10. Mostrar Ayuda\n"
                            + "11. Bitacora-Historial\n"
                            + "12. Insertar Nodo del Árbol FAQ\n"
                            + "13. Insertar Pregunta en Nodo Hoja\n"
                            + "14. Imprimir Preguntas de Nodo\n"
                            + "15. Ver Chatbot (Preguntas Frecuentes)\n"
                            + "16. Salir del Juego"));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                }
            }
            if (opcion == 1) {
                if (tirarDados()) {
                    JOptionPane.showMessageDialog(null, "¡Felicidades!, Has alcanzado la meta y ganado el juego");
                    break;
                }
            } else if (opcion == 2) {
                jugadores.listarJugadores();
            } else if (opcion == 3) {
                String jugadorRetirar = JOptionPane.showInputDialog("Ingrese el nombre del jugador a retirar:");
                bitacora.eliminarJugador(jugadorRetirar);
                jugadores.retirarJugador(jugadorRetirar);
                estado.vaciarPosicion(jugadorRetirar);
            } else if (opcion == 4) {
                premios.listarPremios();
            } else if (opcion == 5) {
                castigos.listarCastigos();
            } else if (opcion == 6) {
                premios.mantenerPila();
            } else if (opcion == 7) {
                castigos.mantenerPila();
            } else if (opcion == 8) {
                estado.mostrarEstadoDeJuego(posicionMaxima);
            } else if (opcion == 9) {
                if (!permitirAdicionarJugadores) {
                    JOptionPane.showMessageDialog(null, "¡ERROR! La configuración de este juego no permite ingresar más jugadores, deberá esperar a que inicie uno nuevo.");
                } else {
                    if (cantidadDeJugadoresActuales == 4) {
                        JOptionPane.showMessageDialog(null, "¡ERROR! Ya se ha alcanzado el numero maximo de jugadores, deberá esperar a que inicie uno nuevo.");
                    } else {
                        String nuevoJugador = JOptionPane.showInputDialog("Ingrese el nombre del nuevo jugador:");
                        jugadores.encolar(new NodoColaJugadores(nuevoJugador));
                        bitacora.agregarJugador(nuevoJugador);
                        cantidadDeJugadoresActuales++;
                        JOptionPane.showMessageDialog(null, "Jugador agregado correctamente.");
                    }
                }
            } else if (opcion == 10) {
                ayuda.mostrarAyuda();
            } else if (opcion == 11) {
                boolean salir = false;
                while (!salir) {
                    bitacora.mostrarJugadorActual();
                    String nav = JOptionPane.showInputDialog("Ver (A)nterior, (S)iguiente o (X) para salir").toUpperCase();
                    switch (nav) {
                        case "A":
                            bitacora.anterior();
                            break;
                        case "S":
                            bitacora.siguiente();
                            break;
                        default:
                            bitacora.reiniciarActual();
                            salir = true;
                            break;
                    }
                }
            } else if (opcion == 15) {
                  arbolFAQ.verChatbot(); 
               
            } else if (opcion == 12) {
                arbolFAQ.insertarNodoPadre();
            } else if (opcion == 13) {
                arbolFAQ.insertarPreguntaHija();
            } else if (opcion == 14) {
                arbolFAQ.imprimirPreguntasNodo();
            } 
            else if (opcion == 16) {
                break;
            } 
            else {
                JOptionPane.showMessageDialog(null, "Opcion invalida.");
            }
        }
    }

    /**
     * Lanza los dados para el jugador y actualiza su posición según el
     * resultado.
     *
     * @author Dylan Gonzales, Julio Quiros, Jesus Anchia
     * @return true si el jugador ha ganado el juego, false de lo contrario.
     */
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
        JOptionPane.showMessageDialog(null, "Jugador " + jugador.getNombre()
                + " tiró los dados y obtuvo " + dado1 + " y " + dado2
                + ". Avanza " + total + " posiciones. Nueva posición: " + jugador.getPosicion());

        if (verificarGanador(jugador)) {
            return true;
        }

        NodoPila premio = null;
        NodoPila castigo = null;

        if (jugador.getPosicion() % 2 == 0) {
            premio = premios.desapilar();
            if (premio != null) { // Evita NullPointerException
                JOptionPane.showMessageDialog(null, "Estas en una posición par, debes tomar un premio de la pila. ¡Mucha suerte!");
                jugador.setPosicion(jugador.getPosicion() + premio.valor);
                JOptionPane.showMessageDialog(null, "Obtuviste " + premio.operacion + premio.valor
                        + " de la pila de premios. Nueva posición: " + jugador.getPosicion());
            } else {
                JOptionPane.showMessageDialog(null, "No quedan premios. Mantienes tu posición: " + jugador.getPosicion());
            }
        } else {
            castigo = castigos.desapilar();
            if (castigo != null) {
                JOptionPane.showMessageDialog(null, "Estas en una posición impar, debes tomar un castigo de la pila. ¡Buena Suerte la Proxima!");
                if (castigo.operacion == '=') {
                    jugador.setPosicion(castigo.valor);
                } else {
                    jugador.setPosicion(jugador.getPosicion() - castigo.valor);
                }
                JOptionPane.showMessageDialog(null, "Obtuviste " + castigo.operacion + castigo.valor
                        + " de la pila de castigos. Nueva posición: " + jugador.getPosicion());
            } else {
                JOptionPane.showMessageDialog(null, "No quedan castigos. Mantienes tu posición: " + jugador.getPosicion());
            }
        }
        if (verificarGanador(jugador)) {
            if (jugador.getPosicion() == posicionMaxima) {
                return true;
            } else if (jugador.getPosicion() > posicionMaxima) {
                int exceso = jugador.getPosicion() - posicionMaxima;
                int nuevaPosicion = posicionMaxima - exceso;
                jugador.setPosicion(nuevaPosicion);
                JOptionPane.showMessageDialog(null, "Sobrepasaste la posición máxima. Rebotas hacia atrás a la posición: " + nuevaPosicion);
                return false;
            } else {
                return false;
            }
        }

        jugadores.encolar(jugador);
        estado.actualizarEstadoDeJuego(jugador.getPosicion(), jugador.getNombre());

        // Registrar en bitácora
        String mensaje = " Posición <---" + jugador.getPosicion() + "--> no tiene castigos/premios";
        if (premio != null) {
            mensaje = "Premio: " + premio.operacion + premio.valor;
        } else if (castigo != null) {
            mensaje = "Castigo: " + castigo.operacion + castigo.valor;
        }

        bitacora.registrar(jugador.getNombre(), jugador.getPosicion(), mensaje);

        return false;
    }

    /**
     * Verifica si el jugador ha ganado el juego al alcanzar la posición máxima.
     *
     * @author Dylan Gonzales, Julio Quiros, Jesus Anchia
     * @param jugador El jugador a verificar.
     * @return true si el jugador ha ganado, false de lo contrario.
     */
    private boolean verificarGanador(NodoColaJugadores jugador) {
        if (jugador.getPosicion() == posicionMaxima) {
            return true;
        } else if (jugador.getPosicion() > posicionMaxima) {
            int dif = jugador.getPosicion() - posicionMaxima;
            jugador.setPosicion(posicionMaxima - dif);
            JOptionPane.showMessageDialog(null, "Sobrepasaste la posicion máxima, se te devolvera a la posicion: " + jugador.getPosicion());
            return false;
        } else {
            return false;
        }
    }
    
    
    
    ///
    
    
}
