package modelo.algoformers;


import modelo.Autobot;
import modelo.Casillero;

/**
 * Created by Mariano on 10/06/2016.
 */
public abstract class Ratchet extends Autobot {

    public Ratchet(Casillero casillero){

        super("RATCHET", casillero);
//        this.estado = new RatchetAlterno(150, casillero);
    }
}
//