package interfaz;
package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import juego.*;

public class PanelControles extends JPanel {
    private Juego juego;
    private PanelTablero panelTablero;

    public PanelControles(Juego juego, PanelTablero panelTablero) {
        this.juego = juego;
        this.panelTablero = panelTablero;

        setLayout(new GridLayout(2, 3));

        JButton btnArriba = new JButton("↑");
        JButton btnAbajo = new JButton("↓");
        JButton btnIzquierda = new JButton("←");
        JButton btnDerecha = new JButton("→");
        JButton btnAccion = new JButton("Acción Especial");
        JButton btnAtacar = new JButton("Atacar");

        add(btnArriba);
        add(btnAbajo);
        add(btnIzquierda);
        add(btnDerecha);
        add(btnAccion);
        add(btnAtacar);

        // Movimientos
        btnArriba.addActionListener(e -> {
            juego.moverJugador("arriba");
            panelTablero.actualizarTablero();
        });
        btnAbajo.addActionListener(e -> {
            juego.moverJugador("abajo");
            panelTablero.actualizarTablero();
        });
        btnIzquierda.addActionListener(e -> {
            juego.moverJugador("izquierda");
            panelTablero.actualizarTablero();
        });
        btnDerecha.addActionListener(e -> {
            juego.moverJugador("derecha");
            panelTablero.actualizarTablero();
        });

        btnAccion.addActionListener(e -> {
            juego.getJugador().getPersonaje().accionEspecial();
        });

        btnAtacar.addActionListener(e -> {
            juego.atacarEnemigo();
            panelTablero.actualizarTablero();
        });
    }
}
