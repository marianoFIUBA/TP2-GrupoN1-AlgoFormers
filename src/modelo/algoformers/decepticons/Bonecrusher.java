package modelo.algoformers.decepticons;

import modelo.*;
import modelo.estados.EstadoAlterno;
import modelo.movimiento.MovimientoAlternoTerrestre;
import modelo.movimiento.MovimientoHumanoideTerrestre;

public class Bonecrusher extends Decepticon{

    public Bonecrusher(Casillero casillero){

        super("BONECRUSHER", casillero);
        this.puntosDeVida = 200;
        this.puntosDeVidaIniciales = 200;
        this.estado = new EstadoAlterno(30, 3, 8, new MovimientoAlternoTerrestre());
        this.estado.ocuparCasillero(this, casillero);
    }



/*    public void transformarseAModoAlterno(){

        this.estados = this.estados.transformarseAModoAlterno(30, 3, 8);
    }

    public void transformarseAModoHumanoide(){

        this.estados = this.estados.transformarseAModoHumanoide(30, 3, 1);
    }*/

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(30, 3, 8, new MovimientoAlternoTerrestre(this.estado.obtenerMovimiento()));
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(30, 3, 1, new MovimientoHumanoideTerrestre(this.estado.obtenerMovimiento()));
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
