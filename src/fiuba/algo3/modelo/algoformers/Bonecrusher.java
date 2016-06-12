package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.Decepticon;
import fiuba.algo3.modelo.estados.BonecrusherAlterno;

/**
 * Created by fedek on 11/6/2016.
 */
public class Bonecrusher extends Decepticon {

    public Bonecrusher(Casillero casillero){

        this.estado = new BonecrusherAlterno(200, casillero);

    }

}
