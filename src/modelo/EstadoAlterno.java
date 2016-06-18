package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class EstadoAlterno implements EstadoAlgoFormer {
    private int velocidad;
    private int ataque;
    private int distanciaDeAtaque;

    private EstrategiaDeMovimiento movimiento;

    public EstadoAlterno(int ataque, int distanciaAtaque, int velocidad, EstrategiaDeMovimiento movimiento){

        this.velocidad = velocidad;
        this.ataque= ataque;
        this.movimiento = movimiento;
        this.distanciaDeAtaque = distanciaAtaque;
    }
    @Override
    public EstadoAlgoFormer transformarseAModoHumanoide(int ataque, int distanciaAtaque, int velocidad){

        return new EstadoHumanoide(ataque, distanciaAtaque, velocidad, this.movimiento);
    }

    @Override
    public EstadoAlgoFormer transformarseAModoAlterno(int ataque, int distanciaAtaque, int velocidad){
        return new EstadoAlterno(ataque, distanciaAtaque, velocidad, this.movimiento);
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

    }

    @Override
    public String obtenerEstado(){

        return "ALTERNO";
    }
}