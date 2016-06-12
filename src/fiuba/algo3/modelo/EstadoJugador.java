package fiuba.algo3.modelo;

/**
 * Created by Mariano on 12/06/2016.
 */
public interface EstadoJugador {

    EstadoJugador cambiarEstado();
    void seleccionarAlgoFormer(AlgoFormer algoformer);
    void informarFinDeTurno();
    void atacar(AlgoFormer algoformer);
    void mover(Casillero casillero);
}
