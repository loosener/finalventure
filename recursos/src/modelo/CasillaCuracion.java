package modelo;

public class CasillaCuracion extends Casilla {
    private int puntosCuracion;

    public CasillaCuracion(int puntosCuracion) {
        this.puntosCuracion = puntosCuracion;
    }

    @Override
    public void activar(Jugador jugador) {
        jugador.curar(puntosCuracion);
        System.out.println("¡Has recuperado " + puntosCuracion + " puntos de vida!");
    }

    public int getPuntosCuracion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPuntosCuracion'");
    }
}
