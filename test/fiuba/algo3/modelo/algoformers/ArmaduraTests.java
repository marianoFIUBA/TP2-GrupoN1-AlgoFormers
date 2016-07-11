package fiuba.algo3.modelo.algoformers;

/**
 * Created by Pedro on 11/07/2016.
 */

import modelo.*;
import org.junit.Assert;
import org.junit.Test;

public class ArmaduraTests {

    @Test
    public void TieneBonusBurbujaDevuelveTrueSiTieneAplicadoElBonus(){
        Armadura armadura = new Armadura();
        armadura.cambiarAModoBurbujaInmaculada();
        Assert.assertTrue(armadura.tieneBonusBurbuja());
    }

    @Test
    public void TieneBonusBurbujaDevuelveFalseSiNoTieneAplicadoElBonus(){
        Armadura armadura = new Armadura();
        Assert.assertFalse(armadura.tieneBonusBurbuja());

        armadura.cambiarAModoBurbujaInmaculada();
        Assert.assertTrue(armadura.tieneBonusBurbuja());

        armadura.pasarTurno();
        armadura.pasarTurno();
        armadura.pasarTurno();
        Assert.assertFalse(armadura.tieneBonusBurbuja());
    }


    @Test
    public void modificarDefensaleDevuelveElAtaqueInicialSiNoTieneBurbujaInmaculada(){
        Armadura armadura = new Armadura();
        Assert.assertTrue(armadura.modificarDefensa(10)==10);
    }

    @Test
    public void modificarDefensaDevuelveCeroSiTieneBurbujaInmaculada(){
        Armadura armadura = new Armadura();
        armadura.cambiarAModoBurbujaInmaculada();
        Assert.assertTrue(armadura.modificarDefensa(10)==0);
    }
}
