package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.EstadoAlgoFormer;
import fiuba.algo3.modelo.SubEstadoAlgoFormer;
import fiuba.algo3.modelo.subestados.HumanoideEnPantano;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by Mariano on 11/06/2016.
 */
public class RatchetHumanoidePS implements EstadoAlgoFormer {

    private int puntosDevida;

    private int puntosDeAtaque = 5;
    private int distanciaDeAtaque = 5;
    private int velocidad = 1;

    private Casillero casillero;
    private SubEstadoAlgoFormer subEstado;

    public RatchetHumanoidePS(int puntosDeVida, Casillero casillero){

        this.puntosDevida = puntosDeVida;
        this.casillero = casillero;
        this.subEstado = new Inicial(this);
    }

    public RatchetHumanoidePS(EstadoAlgoFormer estadoAnterior){

        this.puntosDevida = estadoAnterior.obtenerPuntosDeVida();
        this.casillero = estadoAnterior.obtenerCasillero();
        this.subEstado = estadoAnterior.obtenerSubEstado();
    }
    public void prepararAtaque(AlgoFormer objetivo) {

        this.subEstado.atacar(objetivo);
    }

    public void atacar(AlgoFormer objetivo){

        objetivo.recibirAtaqueDeAutobot(this.puntosDeAtaque);
    }

    public void mover(Casillero destino){

        this.subEstado.mover(destino);
    }
    public EstadoAlgoFormer transformarse(){

        return new RatchetAlternoPS(this);
    }

    public void ocuparCasillero(Casillero casillero){

        this.casillero.alojarHumanoidePorTierra(this);
    }

    public void cambiarSubEstado(SubEstadoAlgoFormer subEstado){

        this.subEstado = subEstado;
    }

    public void recibirAtaque(int ataque){

        this.puntosDevida -= ataque;
    }

    public Casillero obtenerCasillero(){

        return this.casillero;
    }

    public int obtenerAtaque(){

        return this.puntosDeAtaque;
    }

    public SubEstadoAlgoFormer obtenerSubEstado(){

        return this.subEstado;
    }

    public int obtenerPuntosDeVida(){

        return this.puntosDevida;
    }

    public int obtenerVelocidad(){

        return velocidad;

    }

    public void cambiarASubEstadoHumanoideEnPantano(){

        this.subEstado = new HumanoideEnPantano(this);
    }
    public EstadoAlgoFormer cambiarAEstadoPS(){

        return new RatchetHumanoidePS(this);
    }
}

