package interfaz;

public class VenttanaJuego {
    package interfaz;

import javax.swing.*;
import java.awt.*;
import juego.*;

public class VentanaJuego extends JFrame {
    private PanelTablero panelTablero;
    private PanelControles panelControles;
    private Juego juego;

    public VentanaJuego() {
        super("Final Venture");

        juego = new Juego();
        panelTablero = new PanelTablero(juego);
        panelControles = new PanelControles(juego, panelTablero);

        setLayout(new BorderLayout());
        add(panelTablero, BorderLayout.CENTER);
        add(panelControles, BorderLayout.SOUTH);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}


}
