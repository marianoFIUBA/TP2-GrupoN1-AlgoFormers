package modelo.algoformers;

import modelo.Casillero;
import modelo.Decepticon;

/**
 * Created by fedek on 11/6/2016.
 */
public abstract class Bonecrusher extends Decepticon {

    public Bonecrusher(Casillero casillero){

        super("BONECRUSHER", casillero);
//        this.estado = new EstadoAlterno(200, casillero);

    }

    public abstract void transformarseAModoAlterno();

    public abstract void transformarseAModoHumanoide();

}
