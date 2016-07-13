package modelo.algoformers.autobots;


import modelo.*;
import modelo.estados.EstadoAlterno;
import modelo.movimiento.MovimientoAlternoTerrestre;
import modelo.movimiento.MovimientoHumanoideTerrestre;

public class Optimus extends Autobot{

    public Optimus(Casillero casillero){

        super("OPTIMUS", casillero);
        this.puntosDeVida = 500;
        this.puntosDeVidaIniciales = 500;
        this.estado = new EstadoAlterno(15, 4, 5, new MovimientoAlternoTerrestre());
        this.estado.ocuparCasillero(this, casillero);
    }


    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(15, 4, 5, new MovimientoAlternoTerrestre(this.estado.obtenerMovimiento()));
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(50, 2, 2, new MovimientoHumanoideTerrestre(this.estado.obtenerMovimiento()));
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
