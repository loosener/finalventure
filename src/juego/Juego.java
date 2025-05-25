package juego;
package juego;

public class Juego {
    private Tablero tablero;
    private Jugador jugador;

    public void iniciar() {
        tablero = new Tablero(10, 10);
        jugador = new Jugador();
        tablero.colocarJugador(jugador);
        tablero.generarEnemigos();
        tablero.mostrar();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void moverJugador(String direccion) {
        tablero.moverJugador(jugador, direccion);
    }

    public void atacarEnemigo() {
        tablero.atacarEnCasilla(jugador);
    }
}

