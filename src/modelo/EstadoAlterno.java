package modelo;

/**
 * Created by Franco on 15/6/2016.
 */
public class EstadoAlterno implements EstadoAlgoFormer {
    private int velocidad;
    private int ataque;
    private int puntosDeVida;
    private int distanciaDeAtaque;

    private Casillero casillero;
    private EstrategiaDeMovimiento movimiento;

    public EstadoAlterno(int puntosDeVida, Casillero casillero, int velocidad, int ataque, EstrategiaDeMovimiento movimiento){

        this.velocidad = velocidad;
        this.puntosDeVida = puntosDeVida;
        this.ataque = ataque;
        this.casillero = casillero;
        this.movimiento = movimiento;
    }

    public EstadoAlterno (EstadoAlgoFormer estadoAnterior){
        this.puntosDeVida = estadoAnterior.obtenerPuntosDeVida();
        this.casillero = estadoAnterior.obtenerCasillero();
    }

    @Override
    public void mover(Casillero casillero) {

    }

    @Override
    public void recibirAtaque(int ataque) {

    }

    @Override
    public EstadoAlgoFormer transformarse() {
        return new EstadoHumanoide(this);
    }

    @Override
    public Casillero obtenerCasillero() {
        return null;
    }

    @Override
    public int obtenerAtaque() {
        return 0;
    }

    @Override
    public int obtenerPuntosDeVida() {
        return 0;
    }

    @Override
    public void ocuparCasillero(Casillero casillero) {

    }

    @Override
    public int obtenerVelocidad() {
        return 0;
    }

    @Override
    public void pasarTurno() {

    }
}