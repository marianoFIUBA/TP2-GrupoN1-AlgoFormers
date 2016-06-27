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

    public MovimientoAlternoAereo(EstrategiaDeMovimiento estrategiaAnterior){

        this.calculo = new Calculos();
        this.turnosPendientesAtrapado = 0;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        if (this.turnosPendientesAtrapado == 0) {
            casillero.alojarAlternoPorAire(algoFormer);
        } /*else {
            this.turnosPendientesAtrapado--;
        }*/
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
    public void pasarTurno(){

        if (this.turnosPendientesAtrapado > 0){
            this.turnosPendientesAtrapado--;
        }
    }

    @Override
    public void cambiarAModoNoEmpantanado() {
        
    }

    @Override
    public boolean estaEmpantanado() {
        return false;
    }

    @Override
    public boolean recibeDaniosPorEspinas() {
        return false;
    }
}

