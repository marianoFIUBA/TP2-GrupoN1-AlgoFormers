package fiuba.algo3.modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public interface EstadoAlgoFormer {

    void atacar(AlgoFormer algoFormer);
    void mover(Casillero casillero);
    void recibirAtaque(int ataque);
    EstadoAlgoFormer transformarse();
    Casillero obtenerCasillero();
    int obtenerAtaque();
    int obtenerPuntosDeVida();
    SubEstadoAlgoFormer obtenerSubEstado();
    void cambiarSubEstado(SubEstadoAlgoFormer subEstado);
    void ocuparCasillero(Casillero casillero);
}
