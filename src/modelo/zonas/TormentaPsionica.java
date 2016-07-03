package modelo.zonas;

import modelo.AlgoFormer;
import modelo.Zona;

/**
 * Created by Mariano on 30/06/2016.
 */
public class TormentaPsionica implements Zona {

    private String nombre= "TORMENTA";


    public void interactuarCon(AlgoFormer algoformer){
        algoformer.cambiarAModoPostPsionico();
    }

    public String obtenerNombre(){

        return this.nombre;
    }
}
