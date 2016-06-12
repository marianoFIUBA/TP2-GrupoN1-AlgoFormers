package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.subestados.HumanoideEnPantano;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by Mariano on 10/06/2016.
 */
public class RatchetHumanoide implements EstadoAlgoFormer, HumanoideTerrestre {

    private int puntosDevida;

    private int puntosDeAtaque = 5;
    private int distanciaDeAtaque = 5;
    private int velocidad = 1;

    private Casillero casillero;
    private SubEstadoAlgoFormer subEstado;

    public RatchetHumanoide(int puntosDeVida, Casillero casillero){

        this.puntosDevida = puntosDeVida;
        this.casillero = casillero;
        this.subEstado = new Inicial(this);
    }

    public RatchetHumanoide(EstadoAlgoFormer estadoAnterior){

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

        return new RatchetAlterno(this);
    }

    public void ocuparCasillero(Casillero casillero){

        this.casillero.alojarHumanoidePorTierra(this);
    }

    public void volverASubEstadoInicial(){

        this.subEstado = new Inicial(this);
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

        return new RatchetHumanoide(this);
    }
}
