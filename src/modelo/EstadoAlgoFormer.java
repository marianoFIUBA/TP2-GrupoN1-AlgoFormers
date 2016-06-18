package modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public interface EstadoAlgoFormer {

    //void atacar(AlgoFormer algoFormer);

    EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad);
    EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad);
    Casillero obtenerCasillero();
    int obtenerAtaque();
    int obtenerPuntosDeVida();
    void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero);
    int obtenerVelocidad();
    void pasarTurno();
    Casillero obtenerSiguienteCasillero(Casillero casilleroActual, Casillero destino);
    String obtenerEstado();
}
