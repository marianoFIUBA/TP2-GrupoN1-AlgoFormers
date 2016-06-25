package modelo;

/**
 * Created by Mariano on 25/06/2016.
 */
public class EstadoCombinado implements EstadoAlgoFormer {


    private int velocidad;
    private int ataque;
    private int distanciaDeAtaque;
    private boolean esTerrestre;

    private EstrategiaDeMovimiento movimiento;

    public EstadoCombinado(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento, boolean esTerrestre){

        this.velocidad = velocidad;
        this.ataque= ataque;
        this.movimiento = movimiento;
        this.distanciaDeAtaque = distanciaAtaque;
        this.esTerrestre = esTerrestre;
    }

    public EstadoCombinado(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){

        this.velocidad = velocidad;
        this.ataque= ataque;
        this.distanciaDeAtaque = distanciaAtaque;

        if (this.esTerrestre){
            this.movimiento = new MovimientoAlternoTerrestre(movimiento);
        } else {
            this.movimiento = new MovimientoAlternoAereo(movimiento);
        }
    }

    @Override
    public EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad){
        return new EstadoHumanoide(ataque, distanciaAtaque, velocidad, this.movimiento);
    }

    @Override
    public EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad){
        return new EstadoCombinado(ataque, distanciaAtaque, velocidad, this.movimiento);
    }

    @Override
    public int obtenerAtaque() {
        return this.ataque;
    }

    @Override
    public void ocuparCasillero(AlgoFormer algoformer, Casillero casillero) {

        this.movimiento.ocuparCasillero(algoformer, casillero);
    }

    @Override
    public Casillero obtenerSiguienteCasillero(Casillero actual, Casillero destino){

        return  this.movimiento.obtenerSiguienteCasillero(actual, destino);
    }

    @Override
    public int obtenerVelocidad() {
        return this.velocidad;
    }

    @Override
    public void pasarTurno() {

        this.movimiento.pasarTurno();
    }

    @Override
    public String obtenerEstado(){

        return "ALTERNO";
    }

    @Override
    public EstrategiaDeMovimiento obtenerMovimiento(){

        return this.movimiento;
    }


    public void recibirDanioDeEspinas(AlgoFormer algoFormer){

        //lanzar excepcion
    }

    public void cambiarAModoEmpantanado(){

        this.movimiento.cambiarAModoEmpantanado();
    }

    public void cambiarAModoAtrapadoEnNebulosa(){

        this.movimiento.cambiarAModoAtrapadoEnNebulosa();
    }

}
