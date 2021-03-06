package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;

public class BurbujaInmaculada implements Bonus {

    private String nombre;

    public BurbujaInmaculada(){

        this.nombre = "BURBUJA INMACULADA";
    }

    public void aplicarA(AlgoFormer algoFormer, Casillero casillero) {

        if (!algoFormer.tieneBonusBurbuja()) {
            algoFormer.cambiarAModoBurbujaInmaculada();
            casillero.borrarBonus();
        }
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
