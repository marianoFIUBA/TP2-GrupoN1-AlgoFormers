package modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public abstract class AlgoFormer {

    protected String nombre;
    protected EstadoAlgoFormer estado;
    protected Arma arma;
    protected Calculos calculo;
    protected Casillero casillero;
    protected int puntosDeVida;

    protected AlgoFormer(String nombre, Casillero casillero) {

        this.nombre = nombre;
        this.casillero = casillero;
        this.calculo = new Calculos();
    }

/*    public void moverA(Casillero casillero) {

        this.estado.mover(casillero);
    }*/

    public void moverA( Casillero destino){

        Casillero casilleroActual = this.casillero;

        if (calculo.movimientoValido(casilleroActual, destino, this.obtenerVelocidad())){

            int distancia = calculo.obtenerDistancia(casilleroActual, destino);
            int movimientosDisponibles = this.estado.obtenerVelocidad();

            while (distancia > 0 && movimientosDisponibles > 0){

                Casillero casilleroAnterior = this.obtenerCasillero();
                casilleroActual = this.estado.obtenerSiguienteCasillero(casilleroActual, destino);
                this.estado.ocuparCasillero(this, casilleroActual);
                movimientosDisponibles--;

                if (!casilleroAnterior.equals(this.obtenerCasillero())){

                    distancia--;
                }
//                casilleroActual.alojarAlternoPorTierra(algoformer);
            }

        } else {
            //lanzar excepcion
        }
    }

    public void atacarA(AlgoFormer algoformer) {

    }

    public Casillero obtenerCasillero() {

        return this.casillero;
        //return this.estado.obtenerCasillero();
    }

    public void pasarTurno() {

        this.estado.pasarTurno();
    }

    public abstract void recibirAtaqueDeDecepticon(int puntosDeAtaque);

    public abstract void recibirAtaqueDeAutobot(int puntosDeAtaque);

    public String obtenerNombre() {

        return this.nombre;
    }

    public int obtenerVelocidad() {

        return this.estado.obtenerVelocidad();
    }

    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }

    public String obtenerEstado(){

        return this.estado.obtenerEstado();
    }

    public abstract void transformarseAModoAlterno();

    public abstract void transformarseAModoHumanoide();
}
