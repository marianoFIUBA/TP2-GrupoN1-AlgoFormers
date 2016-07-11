package modelo.algoformers.decepticons;


import modelo.*;
import modelo.estados.EstadoAlterno;
import modelo.movimiento.MovimientoAlternoTerrestre;
import modelo.movimiento.MovimientoHumanoideTerrestre;

public class Frenzy extends Decepticon{

    public Frenzy(Casillero casillero){

        super("FRENZY", casillero);
        this.puntosDeVida = 400;
        this.puntosDeVidaIniciales = 400;
        this.estado = new EstadoAlterno(25, 2, 6, new MovimientoAlternoTerrestre());
        this.estado.ocuparCasillero(this, casillero);
    }

/*    public void transformarseAModoAlterno(){

        this.estados = this.estados.transformarseAModoAlterno(25, 2, 6);
    }

    public void transformarseAModoHumanoide(){

        this.estados = this.estados.transformarseAModoHumanoide(10, 5, 2);
    }*/

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(25, 2, 6, new MovimientoAlternoTerrestre(this.estado.obtenerMovimiento()));
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(10, 5, 2, new MovimientoHumanoideTerrestre(this.estado.obtenerMovimiento()));
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
