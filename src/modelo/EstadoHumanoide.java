package modelo;

import modelo.Excepciones.NoPuedeTransformarseAModoHumaoideException;

public class EstadoHumanoide implements EstadoAlgoFormer {
    private int velocidad;
    private int ataque;
    private int distanciaDeAtaque;
    private boolean esTerrestre;
    private EstrategiaDeMovimiento movimiento;


    public EstadoHumanoide(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento, boolean esTerrestre){

        this.velocidad = velocidad;
        this.ataque= ataque;
        this.movimiento = movimiento;
        this.distanciaDeAtaque = distanciaAtaque;
        this.esTerrestre = esTerrestre;
    }

    public EstadoHumanoide(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){

        this.ataque = ataque;
        this.distanciaDeAtaque = ataque;  //Ataque ???
        this.velocidad = velocidad;
        this.movimiento = movimiento;
    }

    @Override
    public EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){
        throw new NoPuedeTransformarseAModoHumaoideException();
    }

    @Override
    public EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){
        return new EstadoAlterno(ataque, distanciaAtaque, velocidad, movimiento);
    }

    public void atacar(AlgoFormer algoFormer) {

    }

    @Override
    public Casillero obtenerSiguienteCasillero(Casillero actual, Casillero destino){

        return  this.movimiento.obtenerSiguienteCasillero(actual, destino);
    }

    @Override
    public int obtenerAtaque(){

        return this.ataque;
    }

    @Override
    public void ocuparCasillero(AlgoFormer algoformer, Casillero casillero) {

        this.movimiento.ocuparCasillero(algoformer, casillero);

    }

    public int obtenerVelocidad() {
        return this.velocidad;
    }

    @Override
    public void pasarTurno() {

        this.movimiento.pasarTurno();
    }

    @Override
    public String obtenerEstado(){
        return "HUMANOIDE";
    }

    @Override
    public EstrategiaDeMovimiento obtenerMovimiento(){

        return this.movimiento;
    }

    @Override
    public boolean esTerrestre() {

        return this.esTerrestre;

    }

    @Override
    public void moverA(Casillero casillero, AlgoFormer algoFormer) {

        this.movimiento.mover(casillero,algoFormer);

    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return this.distanciaDeAtaque;
    }


    public void cambiarAModoEmpantanado(){

        this.movimiento.cambiarAModoEmpantanado();
    }

    public void cambiarAModoAtrapadoEnNebulosa(){

        this.movimiento.cambiarAModoAtrapadoEnNebulosa();
    }
}