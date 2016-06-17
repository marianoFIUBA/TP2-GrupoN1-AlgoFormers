package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class MovimientoAlternoTerrestre implements EstrategiaDeMovimiento {

    private Calculos calculo;

    public MovimientoAlternoTerrestre(){

        this.calculo = new Calculos();
    }

    public void mover(AlgoFormer algoformer,  Casillero destino){

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
    }

}
