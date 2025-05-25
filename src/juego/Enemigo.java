package juego;
public abstract class Enemigo {
    protected int hp, ataque, velocidad;
    public abstract void atacar(Personaje personaje);
}
