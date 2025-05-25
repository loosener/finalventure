package juego;
import java.util.Scanner;

public class Jugador {
    private Personaje personaje;
    private Inventario inventario;

    public Jugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige tu personaje (1=Guerrero, 2=Orador, 3=Mago):");
        int opc = sc.nextInt();
        switch (opc) {
            case 1: personaje = new Guerrero(); break;
            case 2: personaje = new Orador(); break;
            case 3: personaje = new Mago(); break;
        }
        inventario = new Inventario();
    }

    public Personaje getPersonaje() {
        return personaje;
    }
}
