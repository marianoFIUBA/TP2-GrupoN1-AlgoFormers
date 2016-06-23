package modelo.algoformers;


import modelo.*;


public class Ratchet extends Autobot{

    public Ratchet(Casillero casillero){

        super("RATCHET", casillero);
        this.puntosDeVida = 150;
        this.estado = new EstadoAlterno(35,2,8, new MovimientoAlternoAereo(), false);
        this.modoPostPsionico = false;
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(35, 2, 8);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(5, 5, 1);
    }

    @Override
    public void  cambiarAModoPostPsionico(){

        if (!this.modoPostPsionico){
            this.estado.cambiarAModoPostPsionico(this);
        }
    }
}
