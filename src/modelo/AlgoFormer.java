package modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public abstract class AlgoFormer {

    protected String nombre;
    protected EstadoAlgoFormer estado;
    protected Arma arma;

    protected AlgoFormer(String nombre) {

        this.nombre = nombre;
    }

    public void moverA(Casillero casillero) {

        this.estado.mover(casillero);
    }

    public void atacarA(AlgoFormer algoformer) {

    }

    public Casillero obtenerCasillero() {

        return this.estado.obtenerCasillero();
    }

    public void transformarse() {

        this.estado.transformarse();
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

}
