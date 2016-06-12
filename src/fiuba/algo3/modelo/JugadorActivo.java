package fiuba.algo3.modelo;

/**
 * Created by Mariano on 12/06/2016.
 */
public class JugadorActivo implements EstadoJugador {

    private AlgoFormer algoformerSeleccionado;
    private Jugador jugador;

    JugadorActivo(Jugador jugador){

        this.jugador = jugador;
    }

    public EstadoJugador cambiarEstado(){

        return new JugadorInactivo(this.jugador);
    }

    public void seleccionarAlgoFormer(AlgoFormer algoformer){

        this.algoformerSeleccionado = algoformer;
    }

    public void informarFinDeTurno(){

        this.jugador.finalizarTurno();
    }

    public void atacar(AlgoFormer algoformer){

        this.algoformerSeleccionado.atacarA(algoformer);
    }

    public void mover(Casillero casillero){

        try{
            this.algoformerSeleccionado.moverA(casillero);
        } catch (NullPointerException ex){
            //lanzar exepcion de algoformer no seleccionado
        }

    }
}
