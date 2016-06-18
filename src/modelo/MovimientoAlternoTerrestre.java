package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class MovimientoAlternoTerrestre implements EstrategiaDeMovimiento {

    private Calculos calculo;
    private boolean empantanado;

    public MovimientoAlternoTerrestre(){

        this.calculo = new Calculos();
        this.empantanado = false;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        if (!empantanado){
            casillero.alojarAlternoPorTierra(algoFormer);
        } else {
            this.empantanado = false;
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
