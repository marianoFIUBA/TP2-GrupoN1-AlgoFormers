package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;

/**
 * Created by Mariano on 02/07/2016.
 */
public class DobleCanion implements Bonus {

    private String nombre;

    public DobleCanion(){

        this.nombre = "DOBLECANION";
    }

    public void aplicarA(AlgoFormer algoFormer){

        algoFormer.cambiarAModoDobleCanion();
    }
}
