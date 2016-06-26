package modelo.algoformers;

import modelo.*;

public class Bonecrusher extends Decepticon{

    public Bonecrusher(Casillero casillero){

        super("BONECRUSHER", casillero);
        this.puntosDeVida = 200;
        this.puntosDeVidaIniciales = 200;
        this.estado = new EstadoAlterno(30, 3, 8, new MovimientoAlternoTerrestre(), true);
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(30, 3, 8);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(30, 3, 1);
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
