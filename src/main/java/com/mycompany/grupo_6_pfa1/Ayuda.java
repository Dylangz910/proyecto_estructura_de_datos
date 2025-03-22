/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_6_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author Julio Quiros
 */
public class Ayuda {

    public void mostrarAyuda() {
        JOptionPane.showMessageDialog(null,
                "Versión: 2.0.0\n"
                + "Este es un juego de carreras donde los jugadores avanzan según los resultados de los dados.\n\n"
                + "📌 FUNCIONALIDADES:\n"
                + "1. Los jugadores tiran dos dados y avanzan en el tablero.\n"
                + "2. Si el resultado es par, obtienen un premio (se aplica efecto).\n"
                + "3. Si es impar, reciben un castigo (se aplica efecto).\n"
                + "4. El estado actual del juego se muestra gráficamente en colores:\n"
                + "   🟩 Verde: primeras posiciones\n"
                + "   🟨 Amarillo: zona media\n"
                + "   🟥 Rojo: tramo final\n"
                + "5. Se pueden retirar jugadores del juego.\n"
                + "6. Se puede adicionar jugadores dinámicamente si se configuró al iniciar.\n"
                + "7. Se guarda una bitácora con el historial de cada jugador:\n"
                + "   - Muestra las posiciones visitadas, hora y premio/castigo recibido.\n"
                + "   - Navegación circular hacia adelante y atrás.\n\n"
                + "Desarrollado por:\n"
                + "Jesus Anchia\n"
                + "Dylan Gonzalez\n"
                + "Julio Quiros"
        );
    }
}
