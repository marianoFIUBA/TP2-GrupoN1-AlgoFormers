package fiuba.algo3.modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public abstract class AlgoFormer{

    protected EstadoAlgoFormer estado;

    public void moverA(Casillero casillero) {

        this.estado.mover(casillero);
    }

    public void atacarA(AlgoFormer algoformer){

        this.estado.atacar(algoformer);
    }

    public Casillero obtenerCasillero(){

        return this.estado.obtenerCasillero();
    }

    public void transformarse(){

        this.estado.transformarse();
    }

    public abstract void recibirAtaqueDeDecepticon(int puntosDeAtaque);

    public abstract void recibirAtaqueDeAutobot(int puntosDeAtaque);
}
