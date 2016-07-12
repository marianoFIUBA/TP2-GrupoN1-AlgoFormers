package modelo.movimiento;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.EstrategiaDeMovimiento;
import modelo.Excepciones.HumanoideNoPuedeDesempantanarse;
import modelo.Excepciones.NoPuedeCambiarAModoAtrapadoEnNebulosaException;

public class MovimientoHumanoideTerrestre extends EstrategiaDeMovimiento {

    private boolean empantanado;

    public MovimientoHumanoideTerrestre(){

        this.empantanado = false;
    }

    public MovimientoHumanoideTerrestre(EstrategiaDeMovimiento estrategiaAnterior){

        this.empantanado = estrategiaAnterior.estaEmpantanado();
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        casillero.alojarPorTierra(algoFormer);

    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (!this.empantanado){

            siguienteCasillero = this.calcularSiguienteCasillero(actual, destino);
        }

        return siguienteCasillero;
    }

    @Override
    public void cambiarAModoAtrapadoEnNebulosa(){
        throw new NoPuedeCambiarAModoAtrapadoEnNebulosaException();
    }

    @Override
    public void cambiarAModoEmpantanado(){
        this.empantanado = true;
    }


    public void pasarTurno(){

    }

    @Override
    public void cambiarAModoNoEmpantanado() {
        throw new HumanoideNoPuedeDesempantanarse();
    }

    public boolean estaEmpantanado(){ return this.empantanado; }

    @Override
    public boolean recibeDaniosPorEspinas() {
        return true;
    }

    @Override
    public boolean estaAtrapadoEnNebulosa() {
        return false;
    }
}
