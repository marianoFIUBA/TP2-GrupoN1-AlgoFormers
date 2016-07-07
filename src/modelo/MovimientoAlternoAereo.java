package modelo;


public class MovimientoAlternoAereo extends EstrategiaDeMovimiento {

    private int turnosPendientesAtrapado;

    public MovimientoAlternoAereo(){

        this.turnosPendientesAtrapado = 0;
    }

    public MovimientoAlternoAereo(EstrategiaDeMovimiento estrategiaAnterior){

        this.turnosPendientesAtrapado = 0;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        if (this.turnosPendientesAtrapado == 0) {
            casillero.alojarPorAire(algoFormer);
        }
    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (this.turnosPendientesAtrapado == 0){

            siguienteCasillero = this.calcularSiguienteCasillero(actual, destino);
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

    @Override
    public boolean estaAtrapadoEnNebulosa() {
        return (this.turnosPendientesAtrapado > 0);
    }
}

