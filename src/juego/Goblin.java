package juego;
public class Goblin extends Enemigo {
    public Goblin() {
        hp = 3; ataque = 2; velocidad = 3;
    }

    @Override
    public void atacar(Personaje personaje) {
        System.out.println("El goblin ataca!");
    }
}
