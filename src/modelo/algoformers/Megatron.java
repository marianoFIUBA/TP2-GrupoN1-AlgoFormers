package modelo.algoformers;


import modelo.Casillero;
import modelo.Decepticon;

/**
 * Created by Mariano on 10/06/2016.
 */
public abstract class Megatron extends Decepticon {

    public Megatron(Casillero casillero){

            super("MEGATRON", casillero);
//        this.estado = new MegatronAlterno(550, casillero);
    }
}
