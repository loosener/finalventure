package juego;

public abstract class Personaje {
    protected int hp, ep, xp, ataque, defensa, velocidad;
    protected Inventario inventario;

    public abstract void accionEspecial();
}
