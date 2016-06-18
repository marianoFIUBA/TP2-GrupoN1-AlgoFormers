package modelo.algoformers;


import modelo.Casillero;
import modelo.Decepticon;

/**
 * Created by fedek on 11/6/2016.
 */
public abstract class Frenzy extends Decepticon {

    public Frenzy(Casillero casillero){

        super("FRENZY", casillero);
//        this.estado = new FrenzyAlterno(400, casillero);

    }
}
