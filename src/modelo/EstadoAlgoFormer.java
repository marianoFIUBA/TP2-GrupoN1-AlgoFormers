package modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public interface EstadoAlgoFormer {

    //void atacar(AlgoFormer algoFormer);

/*    EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad);

    EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad);*/

    EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento);

    EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento);

    int obtenerAtaque();

    void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero);

    int obtenerVelocidad();

    void pasarTurno();

    Casillero obtenerSiguienteCasillero(Casillero casilleroActual, Casillero destino);

    String obtenerEstado();

    EstrategiaDeMovimiento obtenerMovimiento();

    void cambiarAModoEmpantanado();

    void cambiarAModoAtrapadoEnNebulosa();

    boolean esTerrestre();


    void moverA(Casillero casillero, AlgoFormer algoFormer);

    int obtenerDistanciaDeAtaque();

}
