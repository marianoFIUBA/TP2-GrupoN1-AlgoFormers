package modelo.zonas;

import modelo.AlgoFormer;
import modelo.Zona;

/**
 * Created by Mariano on 30/06/2016.
 */
public class NebulosaDeAndromeda implements Zona {


    private String nombre = "NEBULOSA";

    public void interactuarCon(AlgoFormer algoformer){
        algoformer.cambiarAModoAtrapadoEnNebulosa();
    }

    public String obtenerNombre(){

        return this.nombre;
    }
}
