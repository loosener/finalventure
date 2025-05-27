package modelo;

public class Jugador {
    private Personaje personaje;
    private Inventario inventario;
    protected int vida,puntos,vidaMaxima;

    public Jugador(Personaje personaje) {
        this.personaje = personaje;
        this.inventario = new Inventario();
    }

    public void curar(int puntos) {
    this.vida = Math.min(this.vida + puntos, this.vidaMaxima);
}


    public Personaje getPersonaje() {
        return personaje;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public boolean recogerItem(Item item) {
        return inventario.agregarItem(item);
    }

    public boolean estaVivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaVivo'");
    }
}