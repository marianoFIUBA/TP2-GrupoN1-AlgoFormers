package modelo.algoformers;

import modelo.*;

/**
 * Created by Mariano on 25/06/2016.
 */
public class Menasor extends Decepticon {

    public Menasor(Casillero casillero, double puntosDevida){

        super("MENASOR", casillero);
        this.puntosDeVida = puntosDevida;
        this.puntosDeVidaIniciales = puntosDeVida;
        this.estado = new EstadoAlterno(105, 2, 2, new MovimientoAlternoTerrestre(), true);
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){

        //this.estado = this.estado.transformarseAModoAlterno(30, 3, 8);
    }

    public void transformarseAModoHumanoide(){

        //this.estado = this.estado.transformarseAModoHumanoide(30, 3, 1);
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }


}
