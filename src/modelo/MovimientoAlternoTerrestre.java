package modelo;


public class MovimientoAlternoTerrestre extends EstrategiaDeMovimiento {

    private boolean empantanado;

    public MovimientoAlternoTerrestre(){

        this.empantanado = false;
    }

    public MovimientoAlternoTerrestre(EstrategiaDeMovimiento estrategiaAnterior){

        this.empantanado = estrategiaAnterior.estaEmpantanado();
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        casillero.alojarPorTierra(algoFormer);
    }

    public Casillero obtenerSiguienteCasillero(Casillero actual,Casillero destino){

        Casillero siguienteCasillero = actual;

        if (!this.empantanado){

            siguienteCasillero = this.calcularSiguienteCasillero(actual,destino);}

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

    @Override
    public boolean estaAtrapadoEnNebulosa() {
        return false;
    }
}
