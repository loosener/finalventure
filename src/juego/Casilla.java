package juego;
public class Casilla {
    private int fila, columna;
    private Jugador jugador;
    private Enemigo enemigo;
    private Item item;

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public boolean estaVacia() {
        return jugador == null && enemigo == null && item == null;
    }

    public void colocarJugador(Jugador j) {
        jugador = j;
    }

    public void colocarEnemigo(Enemigo e) {
        enemigo = e;
    }

    @Override
    public String toString() {
        if (jugador != null) return "J";
        if (enemigo != null) return "E";
        if (item != null) return "I";
        return ".";
    }
}
