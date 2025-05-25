package juego;

import java.util.Random;

public class Tablero {
    private Casilla[][] casillas;
    private int filas, columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        casillas = new Casilla[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(i, j);
            }
        }
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void colocarJugador(Jugador jugador) {
        casillas[0][0].colocarJugador(jugador);
    }

    public void generarEnemigos() {
        Random rand = new Random();
        int total = (int) (filas * columnas * 0.4);
        for (int i = 0; i < total; i++) {
            int x = rand.nextInt(filas);
            int y = rand.nextInt(columnas);
            if (casillas[x][y].estaVacia()) {
                casillas[x][y].colocarEnemigo(new Goblin()); // Puedes alternar con Demonio, Dragon
            }
        }
    }

    public void moverJugador(Jugador jugador, String dir) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].getJugador() == jugador) {
                    int ni = i, nj = j;
                    switch (dir) {
                        case "arriba": ni--; break;
                        case "abajo": ni++; break;
                        case "izquierda": nj--; break;
                        case "derecha": nj++; break;
                    }
                    if (ni >= 0 && ni < filas && nj >= 0 && nj < columnas) {
                        casillas[i][j].setJugador(null);
                        casillas[ni][nj].setJugador(jugador);
                    }
                    return;
                }
            }
        }
    }

    public void atacarEnCasilla(Jugador jugador) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casilla c = casillas[i][j];
                if (c.getJugador() == jugador && c.getEnemigo() != null) {
                    Combate.iniciar(jugador.getPersonaje(), c.getEnemigo());
                    if (c.getEnemigo().getHp() <= 0)
                        c.setEnemigo(null);
                    return;
                }
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(casillas[i][j].toString() + " ");
            }
            System.out.println();
        }
    }
}
