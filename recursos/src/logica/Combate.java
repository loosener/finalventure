package logica;

import modelo.Personaje;
import modelo.Enemigo;
import modelo.Jugador;

import javax.swing.*;

public class Combate {
    private Personaje personaje;
    private Enemigo enemigo;

    public Combate(Personaje jugador, Enemigo enemigo) {
        this.personaje = jugador;
        this.enemigo = enemigo;
    }

    

   



    public void iniciar() {
        StringBuilder resultado = new StringBuilder("¡Comienza el combate!\n");
        while (personaje.estaVivo() && enemigo.estaVivo()) {
            enemigo.recibirDanio(personaje.atacar());
            if (enemigo.estaVivo()) {
                personaje.recibirDanio(enemigo.atacar());
            }
        }
        if (personaje.estaVivo()) {
            resultado.append(personaje.getNombre()).append(" ha ganado.");
        } else {
            resultado.append("El enemigo ").append(enemigo.getTipo()).append(" ha ganado.");
        }
        JOptionPane.showMessageDialog(null, resultado.toString(), "Resultado del combate", JOptionPane.INFORMATION_MESSAGE);
    }
}