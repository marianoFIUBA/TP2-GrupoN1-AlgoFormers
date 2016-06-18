package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class MovimientoAlternoTerrestre implements EstrategiaDeMovimiento {

    private Calculos calculo;
    private int turnosPendientesEstancado;

    public MovimientoAlternoTerrestre(){

        this.calculo = new Calculos();
        this.turnosPendientesEstancado = 0;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        casillero.alojarAlternoPorTierra(algoFormer);
    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (this.turnosPendientesEstancado == 0){

            siguienteCasillero = this.calculo.obtenerSiguienteCasillero(actual, destino);
        }

        return siguienteCasillero;
    }

  /*  public void mover(AlgoFormer algoformer,  Casillero destino){

        Casillero casilleroActual = algoformer.obtenerCasillero();

        if (calculo.movimientoValido(casilleroActual, destino, algoformer.obtenerVelocidad())){

            int distancia = calculo.obtenerDistancia(casilleroActual, destino);
            int movimientosDisponibles = algoformer.obtenerVelocidad();

            while (distancia > 0 && movimientosDisponibles > 0){

                casilleroActual = this.calculo.obtenerSiguienteCasillero(casilleroActual, destino);
                casilleroActual.alojarAlternoPorTierra(algoformer);
            }

        } else {

            //lanzar excepcion
        }
}*/

}
