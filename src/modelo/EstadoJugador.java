package modelo;


public interface EstadoJugador {

    EstadoJugador cambiarEstado();
    void seleccionarAlgoFormer(AlgoFormer algoformer);
    void informarFinDeTurno();
    void atacar(AlgoFormer algoformer);
    void mover(Casillero casillero);
}
