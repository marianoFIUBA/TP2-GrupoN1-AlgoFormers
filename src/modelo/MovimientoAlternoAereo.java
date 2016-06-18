package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class MovimientoAlternoAereo implements EstrategiaDeMovimiento {

    private Calculos calculo;
    private int turnosPendientesEstancado;

    public MovimientoAlternoAereo(){

        this.calculo = new Calculos();
        this.turnosPendientesEstancado = 0;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        casillero.alojarAlternoPorAire(algoFormer);
    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (this.turnosPendientesEstancado == 0){

            siguienteCasillero = this.calculo.obtenerSiguienteCasillero(actual, destino);
        }

        return siguienteCasillero;
    }
}

