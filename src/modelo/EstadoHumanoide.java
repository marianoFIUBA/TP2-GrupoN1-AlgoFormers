package modelo;

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

        this.velocidad = velocidad;
        this.ataque= ataque;
        this.movimiento = new MovimientoHumanoideTerrestre(movimiento);
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
    public void recibirDanioDeEspinas(AlgoFormer algoFormer){

        int puntosDeVida =(algoFormer.getPuntosDeVida() - (algoFormer.getPuntosDeVida() * 5) / 100);
        algoFormer.setPuntosDeVida(puntosDeVida);
    }

    public void cambiarAModoEmpantanado(){

        this.movimiento.cambiarAModoEmpantanado();
    }

    public void cambiarAModoAtrapadoEnNebulosa(){

        this.movimiento.cambiarAModoAtrapadoEnNebulosa();
    }
}