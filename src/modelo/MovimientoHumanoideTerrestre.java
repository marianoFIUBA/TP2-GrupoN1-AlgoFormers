package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class MovimientoHumanoideTerrestre implements EstrategiaDeMovimiento{

    private Calculos calculo;
    private boolean empantanado;

    public MovimientoHumanoideTerrestre(){

        this.calculo = new Calculos();
        this.empantanado = false;
    }

    public MovimientoHumanoideTerrestre(EstrategiaDeMovimiento estrategiaAnterior){

        this.calculo = new Calculos();
        this.empantanado = false;
    }

    public void ocuparCasillero(AlgoFormer algoFormer, Casillero casillero){

        if (!empantanado){
            casillero.alojarHumanoidePorTierra(algoFormer);
        }
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
    public void cambiarAModoPostPsionico(AlgoFormer algoformer){
        //lanzar excepcion
    }

    public void pasarTurno(){

        this.empantanado = false;
    }
}
