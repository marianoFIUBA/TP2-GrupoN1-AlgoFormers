package modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;
import modelo.Excepciones.AlgoFormerYaPoseeBonusDobleCanionException;

/**
 * Created by Mariano on 02/07/2016.
 */
public class DobleCanion implements Bonus {

    private String nombre;

    public DobleCanion(){

        this.nombre = "DOBLE CANION";
    }

    public void aplicarA(AlgoFormer algoFormer, Casillero casillero) {

        if (!algoFormer.tieneDobleCanion()) {
            algoFormer.cambiarAModoDobleCanion();
            casillero.borrarBonus();
        } else {//throw new AlgoFormerYaPoseeBonusDobleCanionException();
        }
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
