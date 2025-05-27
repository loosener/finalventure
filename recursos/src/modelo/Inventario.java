package modelo;

import java.util.ArrayList;

public class Inventario {
    private final int capacidadMaxima = 10;
    private ArrayList<Item> items;

    public Inventario() {
        items = new ArrayList<>();
    }

    public boolean agregarItem(Item item) {
        if (items.size() < capacidadMaxima) {
            items.add(item);
            return true;
        }
        return false;
    }

    public void mostrarInventario() {
        if (items.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}