package fiuba.algo3.modelo;

/**
 * Created by Mariano on 12/06/2016.
 */
public class JugadorInactivo implements EstadoJugador {

    private Jugador jugador;

    JugadorInactivo(Jugador jugador){

        this.jugador = jugador;
    }
    public EstadoJugador cambiarEstado(){

        return new JugadorActivo(this.jugador);
    }

    public void seleccionarAlgoFormer(AlgoFormer algoformer){

        // lanzar excepcion de jugador inactivo
    }

    public void informarFinDeTurno(){

        // lanzar excepcion de jugador inactivo
    }

    public void atacar(AlgoFormer algoformer){

        // lanzar excepcion de jugador inactivo
    }

    public void mover(Casillero casillero) {

        // lanzar excepcion de jugador inactivo
    }
}
