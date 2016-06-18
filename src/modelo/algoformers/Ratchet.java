package modelo.algoformers;


import modelo.*;


public class Ratchet extends Autobot {

    public Ratchet(Casillero casillero){

        super("RATCHET", casillero);
        this.puntosDeVida = 150;
        this.estado = new EstadoAlterno(35,2,8, new MovimientoAlternoAereo());

    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(35, 2, 8);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(5, 5, 1);
    }

}
