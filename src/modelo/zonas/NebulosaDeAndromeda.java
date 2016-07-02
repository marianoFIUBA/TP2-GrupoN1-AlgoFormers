package modelo.zonas;

import modelo.AlgoFormer;
import modelo.Zona;

/**
 * Created by Mariano on 30/06/2016.
 */
public class NebulosaDeAndromeda implements Zona {

    public void interactuarCon(AlgoFormer algoformer){
        algoformer.cambiarAModoAtrapadoEnNebulosa();
    }
}
