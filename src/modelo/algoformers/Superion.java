package modelo.algoformers;

import modelo.*;

/**
 * Created by Mariano on 25/06/2016.
 */
public class Superion extends Autobot {

    public Superion(Casillero casillero, int puntosDevida){

        super("SUPERION", casillero);
        this.puntosDeVida = puntosDevida;
        this.estado = new EstadoAlterno(100, 2, 3, new MovimientoAlternoTerrestre(), true);
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){

        //this.estado = this.estado.transformarseAModoAlterno(15, 4, 5);
    }

    public void transformarseAModoHumanoide(){

        //this.estado = this.estado.transformarseAModoHumanoide(50, 2, 2);
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
