package fiuba.algo3.modelo;

/**
 * Created by Mariano on 11/06/2016.
 */
public interface SubEstadoAlgoFormer {

    void mover(Casillero casillero);
    void atacar(AlgoFormer AlgoFormer);
    void volverASubEstadoInicial();
    Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destino);
}
