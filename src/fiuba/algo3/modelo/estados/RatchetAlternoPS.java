package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.subestados.AtrapadoEnNebulosa;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by Mariano on 11/06/2016.
 */
public class RatchetAlternoPS implements EstadoAlgoFormer, AlternoAereo{

    private int puntosDevida;

    private int puntosDeAtaque = 21; //Ataque reducido en un 40%
    private int distanciaDeAtaque = 2;
    private int velocidad = 8;

    private Casillero casillero;
    private SubEstadoAlgoFormer subEstado;

    public RatchetAlternoPS (int puntosDeVida, Casillero casillero){

        this.puntosDevida = puntosDeVida;
        this.casillero = casillero;
        this.subEstado = new Inicial(this);
    }

    public RatchetAlternoPS (EstadoAlgoFormer estadoAnterior){

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

        return new RatchetHumanoidePS(this);
    }

    public void ocuparCasillero(Casillero casillero){

        this.casillero.alojarPorAirePS(this);
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

        return this.velocidad;
    }

    public void cambiarASubEstadoAtrapadoEnNebulosa(){

        this.subEstado = new AtrapadoEnNebulosa(this);
    }

    public EstadoAlgoFormer cambiarAEstadoPS(){

        return new RatchetAlternoPS(this);
    }
}

