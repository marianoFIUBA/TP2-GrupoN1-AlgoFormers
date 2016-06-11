package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.EstadoAlgoFormer;
import fiuba.algo3.modelo.SubEstadoAlgoFormer;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by Mariano on 10/06/2016.
 */
public class OptimusAlterno implements EstadoAlgoFormer{

    private int puntosDevida;

    private int puntosDeAtaque = 15;
    private int distanciaDeAtaque = 4;
    private int velocidad = 5;

    private Casillero casillero;
    private SubEstadoAlgoFormer subEstado;

    public OptimusAlterno(int puntosDeVida, Casillero casillero){

        this.puntosDevida = puntosDeVida;
        this.casillero = casillero;
        this.subEstado = new Inicial(this);
    }
    public OptimusAlterno (OptimusHumanoide estadoAnterior){

        this.puntosDevida = estadoAnterior.obtenerPuntosDeVida();
        this.casillero = estadoAnterior.obtenerCasillero();
        this.subEstado = estadoAnterior.obtenerSubEstado();
    }
    public void atacar(AlgoFormer objetivo) {

        this.subEstado.atacar(objetivo);
    }

    public void mover(Casillero destino){

        this.subEstado.mover(destino);
    }
    public EstadoAlgoFormer transformarse(){

        return new OptimusHumanoide(this);
    }

    public void ocuparCasillero(Casillero casillero){

        this.casillero.alojarAlternoPorTierra(this);
    }

    public void recibirAtaque(int ataque){

        this.puntosDevida -= ataque;
    }

    public void cambiarSubEstado(SubEstadoAlgoFormer subEstado){

        this.subEstado = subEstado;
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

}
