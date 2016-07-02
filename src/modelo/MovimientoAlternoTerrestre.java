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

    public MovimientoAlternoTerrestre(EstrategiaDeMovimiento estrategiaAnterior){

        this.calculo = new Calculos();
        this.empantanado = estrategiaAnterior.estaEmpantanado();
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        casillero.alojarPorTierra(algoFormer);
    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (!this.empantanado){

            siguienteCasillero = this.calculo.obtenerSiguienteCasillero(actual, destino);
        }

        return siguienteCasillero;
    }

    @Override
    public void cambiarAModoAtrapadoEnNebulosa(){
        //lanzar excepcion
    }

    @Override
    public void cambiarAModoEmpantanado(){
        this.empantanado = true;
    }

    @Override
    public void pasarTurno(){

        this.empantanado = false;
    }

    @Override
    public void cambiarAModoNoEmpantanado() {

        this.empantanado = false;

    }

    @Override
    public boolean estaEmpantanado() {
        return this.empantanado;
    }

    @Override
    public boolean recibeDaniosPorEspinas() {
        return true;
    }
}
