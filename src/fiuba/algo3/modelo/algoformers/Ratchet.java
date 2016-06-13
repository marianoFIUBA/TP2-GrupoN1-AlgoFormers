package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Autobot;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.estados.RatchetAlterno;

/**
 * Created by Mariano on 10/06/2016.
 */
public class Ratchet extends Autobot {

    public Ratchet(Casillero casillero){

        super("RATCHET");
        this.estado = new RatchetAlterno(150, casillero);
    }
}
