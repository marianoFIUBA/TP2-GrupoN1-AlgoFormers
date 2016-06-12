package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.subestados.AlternoEnPantano;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by Mariano on 10/06/2016.
 */
public class OptimusAlterno implements EstadoAlgoFormer, AlternoTerrestre{

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
    public OptimusAlterno (EstadoAlgoFormer estadoAnterior){

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

        return new OptimusHumanoide(this);
    }

    public void ocuparCasillero(Casillero casillero){

        this.casillero.alojarAlternoPorTierra(this);
    }

    public void recibirAtaque(int ataque){

        this.puntosDevida -= ataque;
    }

    public void volverASubEstadoInicial(){

        this.subEstado = new Inicial(this);
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

    public void cambiarASubEstadoAlternoEnPantano(){

        this.subEstado = new AlternoEnPantano(this);
    }

    public EstadoAlgoFormer cambiarAEstadoPS(){

        return new OptimusAlterno(this);
    }

}
