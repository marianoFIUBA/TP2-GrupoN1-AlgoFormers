package modelo.zonas;

import modelo.AlgoFormer;
import modelo.Zona;

/**
 * Created by Mariano on 30/06/2016.
 */
public class Nube implements Zona {


    private String nombre = "NUBE" ;


    public void interactuarCon(AlgoFormer algoformer){

    }

    public String obtenerNombre(){

        return this.nombre;
    }
}
