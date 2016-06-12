package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.subestados.AlternoEnPantano;
import fiuba.algo3.modelo.subestados.HumanoideEnPantano;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by fedek on 11/6/2016.
 */
public class BonecrusherHumanoide implements EstadoAlgoFormer, HumanoideTerrestre {

    private int puntosDevida;

    private int puntosDeAtaque = 30;
    private int distanciaDeAtaque = 3;
    private int velocidad = 1;

    private Casillero casillero;
    private SubEstadoAlgoFormer subEstado;

    public BonecrusherHumanoide(int puntosDeVida, Casillero casillero){

        this.puntosDevida = puntosDeVida;
        this.casillero = casillero;
        this.subEstado = new Inicial(this);
    }

    public BonecrusherHumanoide(EstadoAlgoFormer estadoAnterior){

        this.puntosDevida = estadoAnterior.obtenerPuntosDeVida();
        this.casillero = estadoAnterior.obtenerCasillero();
        this.subEstado = estadoAnterior.obtenerSubEstado();
    }
    public void prepararAtaque(AlgoFormer objetivo) {

        this.subEstado.atacar(objetivo);
    }

    public void atacar(AlgoFormer objetivo){

        objetivo.recibirAtaqueDeDecepticon(this.puntosDeAtaque);
    }

    public void mover(Casillero destino){

        this.subEstado.mover(destino);
    }
    public EstadoAlgoFormer transformarse(){

        return new BonecrusherAlterno(this);
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

        return new BonecrusherHumanoide(this);
    }
}




