package modelo.algoformers;


import modelo.*;


public class Ratchet extends Autobot{

    public Ratchet(Casillero casillero){

        super("RATCHET", casillero);
        this.puntosDeVida = 150;
        this.puntosDeVidaIniciales = 150;
        this.estado = new EstadoAlterno(35,2,8, new MovimientoAlternoAereo());
        this.modoPostPsionico = false;
        this.estado.ocuparCasillero(this, casillero);
    }

/*    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(35, 2, 8);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(5, 5, 1);
    }*/

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(35, 2, 8, new MovimientoAlternoAereo(this.estado.obtenerMovimiento()));
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(5, 5, 1, new MovimientoHumanoideTerrestre(this.estado.obtenerMovimiento()));
    }

    @Override
    public void  cambiarAModoPostPsionico(){

        if (!this.modoPostPsionico){
            this.modoPostPsionico= true;
        }
    }

}
