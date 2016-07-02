package modelo;

import modelo.Excepciones.NoPuedeTransformarseAModoHumaoideException;

/**
 * Created by Franco on 15/6/2016.
 */
public class EstadoHumanoide implements EstadoAlgoFormer {
    private int velocidad;
    private int ataque;
    private int distanciaDeAtaque;
    private boolean esTerrestre;
    private EstrategiaDeMovimiento movimiento;

/*    public EstadoHumanoide(int puntosDeVida, Casillero casillero, int velocidad, int ataque, EstrategiaDeMovimiento movimiento){

        this.velocidad = velocidad;
        this.puntosDeVida = puntosDeVida;
        this.ataque = ataque;
        this.casillero = casillero;
        this.movimiento = movimiento;
    }*/

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

   /* @Override
    public EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad){
        return new EstadoHumanoide(ataque, distanciaAtaque, velocidad, this.movimiento);
    }

    @Override
    public EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad){

        return new EstadoAlterno(ataque, distanciaAtaque, velocidad, this.movimiento,this.esTerrestre);
    }*/

    @Override
    public EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){
        throw new NoPuedeTransformarseAModoHumaoideException();
    }

    @Override
    public EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){
        return new EstadoAlterno(ataque, distanciaAtaque, velocidad, movimiento);
    }

/*    public EstadoHumanoide (EstadoAlgoFormer estadoAnterior) {
        this.puntosDeVida = estadoAnterior.obtenerPuntosDeVida();
        this.casillero = estadoAnterior.obtenerCasillero();
    }*/

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