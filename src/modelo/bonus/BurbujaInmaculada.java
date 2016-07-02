package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;

/**
 * Created by Mariano on 02/07/2016.
 */
public class BurbujaInmaculada implements Bonus {

    private String nombre;

    public BurbujaInmaculada(){

        this.nombre = "BURBUJA";
    }

    public void aplicarA(AlgoFormer algoFormer){

        algoFormer.cambiarAModoBurbujaInmaculada();
    }
}
