package modelo;

public class Item {
    private String nombre;
    private String tipo;
    private int valor;

    public Item(String nombre, String tipo, int valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getValor() { return valor; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", +" + valor + ")";
    }
}