package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Autobot;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.estados.OptimusAlterno;

/**
 * Created by Mariano on 10/06/2016.
 */
public class Optimus extends Autobot {

    public Optimus(Casillero casillero){

        this.estado = new OptimusAlterno(500, casillero);
    }
}
