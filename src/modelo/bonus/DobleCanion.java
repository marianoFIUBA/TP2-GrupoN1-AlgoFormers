package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;

public class DobleCanion implements Bonus {

    private String nombre;

    public DobleCanion(){

        this.nombre = "DOBLE CANION";
    }

    public void aplicarA(AlgoFormer algoFormer, Casillero casillero) {

        if (!algoFormer.tieneDobleCanion()) {
            algoFormer.cambiarAModoDobleCanion();
            casillero.borrarBonus();
        }
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
