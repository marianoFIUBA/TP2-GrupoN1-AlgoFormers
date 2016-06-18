package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class MovimientoHumanoideTerrestre {

    private Calculos calculo;
    private boolean empantanado;

    public MovimientoHumanoideTerrestre(){

        this.calculo = new Calculos();
        this.empantanado = false;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        if (!empantanado){
            casillero.alojarHumanoidePorTierra(algoFormer);
        }
    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (!this.empantanado){

            siguienteCasillero = this.calculo.obtenerSiguienteCasillero(actual, destino);
        }

        return siguienteCasillero;
    }
}
