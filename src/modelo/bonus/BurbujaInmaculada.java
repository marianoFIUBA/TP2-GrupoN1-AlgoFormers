package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;
import modelo.Excepciones.AlgoFormerYaPoseeBonusBurbujaInmaculadaException;

/**
 * Created by Mariano on 02/07/2016.
 */
public class BurbujaInmaculada implements Bonus {

    private String nombre;

    public BurbujaInmaculada(){

        this.nombre = "BURBUJA";
    }

    public void aplicarA(AlgoFormer algoFormer, Casillero casillero) {

        if (!algoFormer.tieneBonusBurbuja()) {
            algoFormer.cambiarAModoBurbujaInmaculada();
            casillero.borrarBonus();
        } else{//throw new AlgoFormerYaPoseeBonusBurbujaInmaculadaException();
             }
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
