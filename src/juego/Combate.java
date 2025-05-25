package juego;
public class Combate {
    public static void iniciar(Personaje jugador, Enemigo enemigo) {
        System.out.println("¡Combate iniciado!");
        while (jugador.hp > 0 && enemigo.hp > 0) {
            jugador.hp -= enemigo.ataque - jugador.defensa;
            enemigo.hp -= jugador.ataque - 1;
            System.out.println("Jugador HP: " + jugador.hp + " | Enemigo HP: " + enemigo.hp);
        }

        if (jugador.hp > 0) {
            System.out.println("Ganaste el combate.");
        } else {
            System.out.println("Fuiste derrotado.");
        }
    }
}
