package modelo.zonas;

import modelo.AlgoFormer;
import modelo.Zona;

/**
 * Created by Mariano on 30/06/2016.
 */
public class Espinas implements Zona {

    public void interactuarCon(AlgoFormer algoformer){
        algoformer.recibirDanioDeEspinas();
        algoformer.verificarSiSigueConVida();
    }
}
