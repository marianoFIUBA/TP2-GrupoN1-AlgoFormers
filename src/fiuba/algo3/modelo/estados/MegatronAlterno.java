package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.EstadoAlgoFormer;
import fiuba.algo3.modelo.SubEstadoAlgoFormer;
import fiuba.algo3.modelo.subestados.Inicial;

/**
 * Created by Mariano on 10/06/2016.
 */
public class MegatronAlterno implements EstadoAlgoFormer {

    private int puntosDevida;

    private int puntosDeAtaque = 55;
    private int distanciaDeAtaque = 2;
    private int velocidad = 8;

    private Casillero casillero;
    private SubEstadoAlgoFormer subEstado;

    public MegatronAlterno (int puntosDeVida, Casillero casillero){

        this.puntosDevida = puntosDeVida;
        this.casillero = casillero;
        this.subEstado = new Inicial(this);
    }

    public MegatronAlterno (MegatronHumanoide estadoAnterior){

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

        return new MegatronHumanoide(this);
    }

    public void ocuparCasillero(Casillero casillero){

        this.casillero.alojarPorAire(this);
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
