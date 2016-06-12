package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Autobot;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.estados.BumblebeeAlterno;



/**
 * Created by Mariano on 10/06/2016.
 */
public class Bumblebee extends Autobot {

    public Bumblebee(Casillero casillero){

        this.estado = new BumblebeeAlterno(350, casillero);

    }

}
