package juego;
public class Mago extends Personaje {
    public Mago() {
        hp = 6; ep = 6; xp = 0;
        ataque = 5; defensa = 5; velocidad = 1;
        inventario = new Inventario();
    }

    @Override
    public void accionEspecial() {
        System.out.println("Lanza un hechizo poderoso.");
    }
}
