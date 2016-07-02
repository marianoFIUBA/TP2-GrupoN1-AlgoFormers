package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;

/**
 * Created by Mariano on 02/07/2016.
 */
public class Flash implements Bonus{

    private String nombre;

    public Flash(){

        this.nombre = "FLASH";
    }

    public void aplicarA(AlgoFormer algoFormer){

        algoFormer.cambiarAModoFlash();
    }
}
