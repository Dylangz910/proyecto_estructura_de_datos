/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author Susana Jimenez
 */
public class Ayuda {
        public void mostrarAyuda() {
        JOptionPane.showMessageDialog(null, 
         "Versión: 1.0.3\n" +
         "Este es un juego de carreras donde los jugadores avanzan según los resultados de los dados.\n" +
         "Reglas del juego:\n" +
         "1. Los jugadores tiran los dados y avanzan en el tablero.\n" +
         "2. Si el total de los dados es par, reciben un premio.\n" +
         "3. Si el total de los dados es impar, reciben un castigo.\n" +
         "4. Se puede listar los jugadores y su posición actual.\n" +
         "5. Un jugador puede retirarse en cualquier momento.\n\n" +
         "Desarrollado por:\n" +
         "Jesus Anchia\n" +
         "Dylan Gonzalez\n" +
         "Julio Quiros"
         );
    }
}
