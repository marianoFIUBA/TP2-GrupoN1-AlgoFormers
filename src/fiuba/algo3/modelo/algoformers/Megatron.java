package fiuba.algo3.modelo.algoformers;


import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.Decepticon;
import fiuba.algo3.modelo.estados.MegatronAlterno;

/**
 * Created by Mariano on 10/06/2016.
 */
public class Megatron extends Decepticon {

    public Megatron(Casillero casillero){

        this.estado = new MegatronAlterno(550, casillero);
    }
}
