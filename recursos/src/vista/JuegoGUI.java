package vista;

import modelo.*;
import logica.Combate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoGUI extends JFrame {
    private JPanel tableroPanel;
    private JLabel infoLabel;
    private JComboBox<String> temaCombo;

    private final int filas = 10, columnas = 10;
    private Enemigo[][] enemigos = new Enemigo[filas][columnas];
    private JButton[][] botones = new JButton[filas][columnas];
    private Casilla[][] casillas = new Casilla[filas][columnas];

    private int jugadorFila = 0;
    private int jugadorColumna = 0;

    private Jugador jugador = new Jugador(new Guerrero("Héroe"));
    private Jugador jugador2 = new Jugador(new Orador("Orador"));
    private Jugador jugador3 = new Jugador(new Mago("Mago"));

    public JuegoGUI() {
        setTitle("Juego RPG de Tablero");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());

        crearTablero();
        crearPanelInferior();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int nuevaFila = jugadorFila;
                int nuevaColumna = jugadorColumna;

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> nuevaFila = Math.max(0, jugadorFila - 1);
                    case KeyEvent.VK_DOWN -> nuevaFila = Math.min(filas - 1, jugadorFila + 1);
                    case KeyEvent.VK_LEFT -> nuevaColumna = Math.max(0, jugadorColumna - 1);
                    case KeyEvent.VK_RIGHT -> nuevaColumna = Math.min(columnas - 1, jugadorColumna + 1);
                }

                moverJugador(nuevaFila, nuevaColumna);
            }
        });

        setFocusable(true);
        requestFocusInWindow();
        setVisible(true);

        iniciarMovimientoEnemigos();
    }

    private void crearTablero() {
        tableroPanel = new JPanel(new GridLayout(filas, columnas));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setFocusable(false);

                // Asignación aleatoria de enemigos
                double r = Math.random();
                if (r < 0.05) {
                    enemigos[i][j] = new Goblin("Goblin", 30);
                    botones[i][j].setBackground(Color.RED);
                } else if (r < 0.08) {
                    enemigos[i][j] = new Demonio("Demonio", 50);
                    botones[i][j].setBackground(Color.MAGENTA);
                } else if (r < 0.10) {
                    enemigos[i][j] = new Dragon("Dragón", 80);
                    botones[i][j].setBackground(Color.ORANGE);
                }

                // Casillas de curación
                if (Math.random() < 0.1) {
                    casillas[i][j] = new CasillaCuracion(20);
                    botones[i][j].setBackground(Color.GREEN);
                }

                final int x = i, y = j;
                botones[i][j].addActionListener(e -> {
                    if (casillas[x][y] != null) {
                        casillas[x][y].activar(jugador);
                        infoLabel.setText("Activaste una casilla en (" + x + ", " + y + ")");
                    }
                });

                tableroPanel.add(botones[i][j]);
            }
        }

        botones[jugadorFila][jugadorColumna].setText("👤");
        add(tableroPanel, BorderLayout.CENTER);
    }

    private void crearPanelInferior() {
        JPanel panelInferior = new JPanel();
        infoLabel = new JLabel("Bienvenido al juego.");
        panelInferior.add(infoLabel);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private void cambiarTema(String tema) {
        Color fondo, texto;
        if ("Oscuro".equals(tema)) {
            fondo = Color.DARK_GRAY;
            texto = Color.WHITE;
        } else {
            fondo = Color.WHITE;
            texto = Color.BLACK;
        }

        tableroPanel.setBackground(fondo);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j].setForeground(texto);
            }
        }
        infoLabel.setForeground(texto);
    }

    private void moverJugador(int nuevaFila, int nuevaColumna) {
        botones[jugadorFila][jugadorColumna].setText("");

        if (casillas[nuevaFila][nuevaColumna] != null) {
            casillas[nuevaFila][nuevaColumna].activar(jugador);
            infoLabel.setText("Casilla activada en (" + nuevaFila + "," + nuevaColumna + ")");
        } else {
            infoLabel.setText("Te moviste a (" + nuevaFila + "," + nuevaColumna + ")");
        }

        jugadorFila = nuevaFila;
        jugadorColumna = nuevaColumna;
        botones[jugadorFila][jugadorColumna].setText("👤");
    }

    private void iniciarMovimientoEnemigos() {
        Timer timer = new Timer(2000, e -> {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (enemigos[i][j] != null) {
                        int nuevaFila = i + (int)(Math.random() * 3) - 1;
                        int nuevaCol = j + (int)(Math.random() * 3) - 1;

                        if (nuevaFila >= 0 && nuevaFila < filas &&
                            nuevaCol >= 0 && nuevaCol < columnas &&
                            enemigos[nuevaFila][nuevaCol] == null) {

                            enemigos[nuevaFila][nuevaCol] = enemigos[i][j];
                            enemigos[i][j] = null;
                            botones[i][j].setBackground(null);

                            if (enemigos[nuevaFila][nuevaCol] instanceof Goblin)
                                botones[nuevaFila][nuevaCol].setBackground(Color.RED);
                            else if (enemigos[nuevaFila][nuevaCol] instanceof Demonio)
                                botones[nuevaFila][nuevaCol].setBackground(Color.MAGENTA);
                            else if (enemigos[nuevaFila][nuevaCol] instanceof Dragon)
                                botones[nuevaFila][nuevaCol].setBackground(Color.ORANGE);

                            if (nuevaFila == jugadorFila && nuevaCol == jugadorColumna) {
                                infoLabel.setText("¡Un enemigo te ha alcanzado!");

                                Combate combate = new Combate(jugador.getPersonaje(), enemigos[nuevaFila][nuevaCol]);
                                combate.iniciar();

                                // Si el enemigo muere, lo quitamos del tablero
                                if (!enemigos[nuevaFila][nuevaCol].estaVivo()) {
                                    enemigos[nuevaFila][nuevaCol] = null;
                                    botones[nuevaFila][nuevaCol].setBackground(null);
                                }

                                // Si el jugador muere
                                if (!jugador.getPersonaje().estaVivo()) {
                                    infoLabel.setText("¡Has sido derrotado!");
                                    JOptionPane.showMessageDialog(this, "Has perdido el juego.");
                                    this.setEnabled(false);
                                }
                            }
                        }
                    }
                }
            }
        });
        timer.start();
    }
}
