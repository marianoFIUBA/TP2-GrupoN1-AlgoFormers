package modelo;


public interface EstadoAlgoFormer {


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
