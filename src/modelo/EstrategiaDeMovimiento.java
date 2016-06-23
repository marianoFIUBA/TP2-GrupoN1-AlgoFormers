package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public interface EstrategiaDeMovimiento {

    //void mover(AlgoFormer algoFormer, Casillero destino);
    void ocuparCasillero(AlgoFormer algoformer, Casillero casillero);
    Casillero obtenerSiguienteCasillero(Casillero actual, Casillero destino);
    void cambiarAModoAtrapadoEnNebulosa();
    void cambiarAModoEmpantanado();
    void pasarTurno();
}
