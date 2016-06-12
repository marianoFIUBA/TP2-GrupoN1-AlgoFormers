package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.EstadoAlgoFormer;
import fiuba.algo3.modelo.SubEstadoAlgoFormer;
import fiuba.algo3.modelo.subestados.AlternoEnPantano;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by fedek on 11/6/2016.
 */
public class BonecrusherAlterno implements EstadoAlgoFormer {

    private int puntosDevida;

    private int puntosDeAtaque = 30;
    private int distanciaDeAtaque = 3;
    private int velocidad = 8;

    private Casillero casillero;
    private SubEstadoAlgoFormer subEstado;

    public BonecrusherAlterno (int puntosDeVida, Casillero casillero){

        this.puntosDevida = puntosDeVida;
        this.casillero = casillero;
        this.subEstado = new Inicial(this);
    }

    public BonecrusherAlterno (EstadoAlgoFormer estadoAnterior){

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

        return new BonecrusherHumanoide(this);
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

    public int obtenerVelocidad(){

        return this.velocidad;
    }

    public void cambiarASubEstadoAlternoEnPantano(){

        this.subEstado = new AlternoEnPantano(this);
    }

    public EstadoAlgoFormer cambiarAEstadoPS() {

        return new BonecrusherAlterno(this);
    }


}


