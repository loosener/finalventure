package modelo;

public abstract class Enemigo {
    protected String tipo;
    protected int salud;
    protected int ataque;
    protected int velocidad;

    public Enemigo(String tipo, int salud, int ataque, int velocidad) {
        this.tipo = tipo;
        this.salud = salud;
        this.ataque = ataque;
        this.velocidad = velocidad;
        
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
    }

    public int atacar() {
        return ataque;
    }

    public String getTipo() { return tipo; }
    public int getSalud() { return salud; }
    public int getVelocidad() { return velocidad; }
}