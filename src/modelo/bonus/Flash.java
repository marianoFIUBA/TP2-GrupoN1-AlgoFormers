package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;
import modelo.Excepciones.AlgoFormerYaPoseeBonusBurbujaInmaculadaException;
import modelo.Excepciones.AlgoFormerYaPoseeBonusFlash;

public class Flash implements Bonus{

    private String nombre;

    public Flash(){

        this.nombre = "FLASH";
    }

    public void aplicarA(AlgoFormer algoFormer, Casillero casillero) {

        if (!algoFormer.tieneBonusFlash()) {
            algoFormer.cambiarAModoFlash();
            casillero.borrarBonus();
        } else {//throw new AlgoFormerYaPoseeBonusFlash();
            }
    }
    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
