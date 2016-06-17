package modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public interface EstadoAlgoFormer {

    //void atacar(AlgoFormer algoFormer);
    public abstract void mover(Casillero casillero);

    void recibirAtaque(int ataque);
    EstadoAlgoFormer transformarse();
    Casillero obtenerCasillero();
    int obtenerAtaque();
    int obtenerPuntosDeVida();
    void ocuparCasillero(Casillero casillero);
    int obtenerVelocidad();
    void pasarTurno();
}
