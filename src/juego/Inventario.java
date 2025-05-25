package juego;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> items;

    public Inventario() {
        items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        if (items.size() < 5) {
            items.add(item);
        } else {
            System.out.println("Inventario lleno");
        }
    }
}

