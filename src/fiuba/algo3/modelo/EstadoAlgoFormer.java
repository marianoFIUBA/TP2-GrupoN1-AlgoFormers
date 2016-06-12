package fiuba.algo3.modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public interface EstadoAlgoFormer {

    void prepararAtaque(AlgoFormer algoFormer);
    void atacar(AlgoFormer algoFormer);
    void mover(Casillero casillero);
    void recibirAtaque(int ataque);
    EstadoAlgoFormer transformarse();
    Casillero obtenerCasillero();
    int obtenerAtaque();
    int obtenerPuntosDeVida();
    SubEstadoAlgoFormer obtenerSubEstado();
    void volverASubEstadoInicial();
    void ocuparCasillero(Casillero casillero);
    int obtenerVelocidad();
    EstadoAlgoFormer cambiarAEstadoPS();
}
