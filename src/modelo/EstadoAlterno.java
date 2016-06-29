package modelo;

import modelo.Excepciones.NoPuedeTransformarseAModoAlternoException;

/**
 * Created by Franco on 15/6/2016.
 */
public class EstadoAlterno implements EstadoAlgoFormer {
    private int velocidad;
    private int ataque;
    private int distanciaDeAtaque;
    private boolean esTerrestre;

    private EstrategiaDeMovimiento movimiento;

    public EstadoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento, boolean esTerrestre){

        this.velocidad = velocidad;
        this.ataque= ataque;
        this.distanciaDeAtaque = distanciaAtaque;
        this.esTerrestre = esTerrestre;

        if (this.esTerrestre){
            this.movimiento = new MovimientoAlternoTerrestre(movimiento);
        } else {
            this.movimiento = new MovimientoAlternoAereo(movimiento);
        }
    }

    public EstadoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){

        this.ataque = ataque;
        this.distanciaDeAtaque = ataque;
        this.velocidad = velocidad;
        this.movimiento = movimiento;
    }

    /*public EstadoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){

        this.velocidad = velocidad;
        this.ataque= ataque;
        this.distanciaDeAtaque = distanciaAtaque;

        if (this.esTerrestre){
            this.movimiento = new MovimientoAlternoTerrestre(movimiento);
        } else {
            this.movimiento = new MovimientoAlternoAereo(movimiento);
        }
    }*/

/*    @Override
    public EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad){
        return new EstadoHumanoide(ataque, distanciaAtaque, velocidad, this.movimiento);
    }

    @Override
    public EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad){
        return new EstadoAlterno(ataque, distanciaAtaque, velocidad, this.movimiento,this.esTerrestre);
    }*/

    @Override
    public EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){
        return new EstadoAlterno(ataque, distanciaAtaque, velocidad, movimiento);
    }

    @Override
    public EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){
        throw new NoPuedeTransformarseAModoAlternoException();
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


    public boolean esTerrestre(){

        return this.esTerrestre;
    }


    public void cambiarAModoEmpantanado(){

        this.movimiento.cambiarAModoEmpantanado();
    }

    public void cambiarAModoAtrapadoEnNebulosa(){

        this.movimiento.cambiarAModoAtrapadoEnNebulosa();
    }
}