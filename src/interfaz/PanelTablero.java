package interfaz;
package interfaz;

import javax.swing.*;
import java.awt.*;
import juego.*;

public class PanelTablero extends JPanel {
    private Juego juego;
    private JButton[][] botones;

    public PanelTablero(Juego juego) {
        this.juego = juego;
        setLayout(new GridLayout(10, 10));
        botones = new JButton[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setEnabled(false);
                add(botones[i][j]);
            }
        }

        actualizarTablero();
    }

    public void actualizarTablero() {
        Casilla[][] casillas = juego.getTablero().getCasillas();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton btn = botones[i][j];
                Casilla c = casillas[i][j];

                if (c.getJugador() != null) {
                    btn.setText("J");
                    btn.setBackground(Color.BLUE);
                } else if (c.getEnemigo() != null) {
                    btn.setText("E");
                    btn.setBackground(Color.RED);
                } else if (c.getItem() != null) {
                    btn.setText("I");
                    btn.setBackground(Color.GREEN);
                } else {
                    btn.setText("");
                    btn.setBackground(Color.LIGHT_GRAY);
                }
            }
        }
    }
}
