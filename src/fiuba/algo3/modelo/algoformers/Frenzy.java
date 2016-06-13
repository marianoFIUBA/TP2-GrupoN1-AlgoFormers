package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.Decepticon;
import fiuba.algo3.modelo.estados.FrenzyAlterno;

import javax.swing.text.html.CSS;

/**
 * Created by fedek on 11/6/2016.
 */
public class Frenzy extends Decepticon {

    public Frenzy(Casillero casillero){

        super("FRENZY");
        this.estado = new FrenzyAlterno(400, casillero);

    }
}
