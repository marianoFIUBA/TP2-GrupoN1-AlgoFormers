package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;

public class Flash implements Bonus{

    private String nombre;

    public Flash(){

        this.nombre = "FLASH";
    }

    public void aplicarA(AlgoFormer algoFormer, Casillero casillero) {

        if (!algoFormer.tieneBonusFlash()) {
            algoFormer.cambiarAModoFlash();
            casillero.borrarBonus();
        }
    }
    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
