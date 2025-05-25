package juego;
public class Guerrero extends Personaje {
    public Guerrero() {
        hp = 5; ep = 3; xp = 0;
        ataque = 4; defensa = 4; velocidad = 2;
        inventario = new Inventario();
    }

    @Override
    public void accionEspecial() {
        System.out.println("Golpe brutal del Guerrero!");
    }
}
