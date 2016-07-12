package fiuba.algo3.modelo.bonus;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;
import modelo.algoformers.decepticons.Bonecrusher;
import modelo.bonus.BurbujaInmaculada;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mariano on 11/07/2016.
 */
public class BurbujaInmaculadaTest {

    @Test
    public void aplicarALeAsignaElBonusAlAlgoformer(){

        Casillero casillero = new Casillero(1,1,new Nube(), new Roca(), null);
        AlgoFormer algoFormer = new Bonecrusher(casillero);

        Assert.assertFalse(algoFormer.tieneBonusBurbuja());

        Bonus burbujaInmaculada = new BurbujaInmaculada();
        burbujaInmaculada.aplicarA(algoFormer, casillero);

        Assert.assertTrue(algoFormer.tieneBonusBurbuja());
    }
}
