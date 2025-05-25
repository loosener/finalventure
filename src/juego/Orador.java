package juego;
public class Orador extends Personaje {
    public Orador() {
        hp = 5; ep = 5; xp = 0;
        ataque = 2; defensa = 3; velocidad = 4;
        inventario = new Inventario();
    }

    @Override
    public void accionEspecial() {
        System.out.println("Inspira al equipo con energía.");
    }
}
