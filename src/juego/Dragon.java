package juego;
public class Dragon extends Enemigo {
     public Dragon() {
        hp = 10; ataque = 6; velocidad = 2;
    }

    @Override
    public void atacar(Personaje personaje) {
        System.out.println("El Dragon ataca!");
    }

}
