package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public interface EstrategiaDeMovimiento {

    //void mover(AlgoFormer algoFormer, Casillero destino);
    void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero);
    Casillero obtenerSiguienteCasillero(Casillero actual, Casillero destino);
}
