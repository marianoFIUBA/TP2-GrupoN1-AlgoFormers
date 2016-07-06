package modelo.algoformers;

import modelo.*;
import modelo.Excepciones.UnidadCombinadaNoPuedeTransformarseException;

/**
 * Created by Mariano on 25/06/2016.
 */
public class Menasor extends Decepticon {

    public Menasor(Casillero casillero, double puntosDevida){

        super("MENASOR", casillero);
        this.puntosDeVida = puntosDevida;
        this.puntosDeVidaIniciales = puntosDeVida;
        this.estado = new EstadoHumanoide(115, 2, 2, new MovimientoHumanoideTerrestre());
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
