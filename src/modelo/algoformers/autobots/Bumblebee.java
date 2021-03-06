package modelo.algoformers.autobots;


import modelo.*;
import modelo.estados.EstadoAlterno;
import modelo.movimiento.MovimientoAlternoTerrestre;
import modelo.movimiento.MovimientoHumanoideTerrestre;

public class Bumblebee extends Autobot{

    public Bumblebee(Casillero casillero){

        super("BUMBLEBEE", casillero);
        this.puntosDeVida = 350;
        this.puntosDeVidaIniciales = 350;
        this.estado = new EstadoAlterno(20, 3, 5, new MovimientoAlternoTerrestre());
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(20, 3, 5, new MovimientoAlternoTerrestre(this.estado.obtenerMovimiento()));
        this.estado.ocuparCasillero(this, this.casillero);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(40, 1, 2, new MovimientoHumanoideTerrestre(this.estado.obtenerMovimiento()));
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
