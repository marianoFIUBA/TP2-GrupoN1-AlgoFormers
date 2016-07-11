package modelo.algoformers.autobots;

import modelo.*;
import modelo.Excepciones.UnidadCombinadaNoPuedeTransformarseException;
import modelo.estados.EstadoHumanoide;
import modelo.movimiento.MovimientoHumanoideTerrestre;

/**
 * Created by Mariano on 25/06/2016.
 */
public class Superion extends Autobot {

    public Superion(Casillero casillero, double puntosDevida){

        super("SUPERION", casillero);
        this.puntosDeVida = puntosDevida;
        this.puntosDeVidaIniciales = puntosDevida;
        this.estado = new EstadoHumanoide(100, 2, 3, new MovimientoHumanoideTerrestre());
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){
        throw new UnidadCombinadaNoPuedeTransformarseException();
    }

    public void transformarseAModoHumanoide(){
        throw new UnidadCombinadaNoPuedeTransformarseException();
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
