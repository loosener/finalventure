package modelo;

public abstract class Personaje {
    protected String nombre;
    protected int salud;
    protected int energia;
    protected int experiencia;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected String tipo;

    public Personaje(String nombre, int salud, int energia, int ataque, int defensa, int velocidad, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.energia = energia;
        this.experiencia = 0;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public void recibirDanio(int danio) {
        int danioReal = danio - defensa;
        salud -= Math.max(danioReal, 0);
    }

    public int atacar() {
        return ataque;
    }

    public void usarEnergia(int cantidad) {
        energia -= cantidad;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getEnergia() { return energia; }
    public int getExperiencia() { return experiencia; }
    public int getVelocidad() { return velocidad; }
    public String getTipo() { return tipo; }
}