package modelo.zonas;

import modelo.AlgoFormer;
import modelo.Zona;

/**
 * Created by Mariano on 30/06/2016.
 */
public class Roca implements Zona {

    private String nombre = "ROCA";

    public void interactuarCon(AlgoFormer algoformer){

    }

    public String obtenerNombre(){

        return this.nombre;
    }

}
