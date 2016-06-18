package modelo.algoformers;


import modelo.Autobot;
import modelo.Casillero;

/**
 * Created by Mariano on 10/06/2016.
 */
public abstract class Bumblebee extends Autobot {

    public Bumblebee(Casillero casillero){

        super("BUMBLEBEE", casillero);
//        this.estado = new BumblebeeAlterno(350, casillero);

    }

}
