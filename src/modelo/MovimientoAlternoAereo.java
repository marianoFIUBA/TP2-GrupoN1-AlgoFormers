package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class MovimientoAlternoAereo implements EstrategiaDeMovimiento {

    private Calculos calculo;
    private int turnosPendientesAtrapado;

    public MovimientoAlternoAereo(){

        this.calculo = new Calculos();
        this.turnosPendientesAtrapado = 0;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        if (this.turnosPendientesAtrapado == 0) {
            casillero.alojarAlternoPorAire(algoFormer);
        } else {
            this.turnosPendientesAtrapado--;
        }
    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (this.turnosPendientesAtrapado == 0){

            siguienteCasillero = this.calculo.obtenerSiguienteCasillero(actual, destino);
        }

        return siguienteCasillero;
    }

    @Override
    public void cambiarAModoAtrapadoEnNebulosa(){

        this.turnosPendientesAtrapado = 4;
    }

    @Override
    public void cambiarAModoEmpantanado(){
        //lanzarExcepcion
    }

    @Override
    public void cambiarAModoPostPsionico(AlgoFormer algoformer){
        int puntosDeVida = algoformer.getPuntosDeVida() - ((algoformer.getPuntosDeVida() * 40) /100);
        algoformer.activarModoPostPsionico();
        algoformer.setPuntosDeVida(puntosDeVida);
    }

    @Override
    public void pasarTurno(){

        if (this.turnosPendientesAtrapado > 0){
            this.turnosPendientesAtrapado--;
        }
    }
}

