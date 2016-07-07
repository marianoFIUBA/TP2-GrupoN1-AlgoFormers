package modelo.zonas;

import modelo.AlgoFormer;
import modelo.Zona;

/**
 * Created by Mariano on 30/06/2016.
 */
public class Pantano implements Zona {


    private String nombre = "PANTANO";

    public void interactuarCon(AlgoFormer algoformer) {

        if (!algoformer.estaEmpantanado()) {

            algoformer.cambiarAModoEmpantanado();
        } else if (algoformer.obtenerEstado() == "ALTERNO"){

            algoformer.cambiarAModoNoEmpantanado();
        }
    }

    public String obtenerNombre(){

        return this.nombre;
    }
}
