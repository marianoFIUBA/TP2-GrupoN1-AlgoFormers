package fiuba.algo3.modelo.algoformers;

import modelo.Bonus;
import modelo.Casillero;
import modelo.Zona;
import modelo.algoformers.autobots.Optimus;
import modelo.algoformers.autobots.Ratchet;
import modelo.bonus.Flash;
import modelo.zonas.Espinas;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import modelo.zonas.TormentaPsionica;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Franco on 10/7/2016.
 */
public class CasilleroTests {

    @Test
    public void alojarCasilleroPorTierraDejaAlAlgoformerEnElCasillero(){

        Casillero casillero1 = new Casillero(4, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(5, 5, new Nube(), new Roca(), null);

        Optimus optimus = new Optimus(casillero1);

        casillero2.alojarPorTierra(optimus);

        Assert.assertEquals(optimus.obtenerCasillero(), casillero2);

        Assert.assertEquals(casillero2.obtenerAlgoformer(), optimus);


    }

    @Test
    public void alojarCasilleroPorAireDejaAlAlgoformerEnElCasillero() {

        Casillero casillero1 = new Casillero(4, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(5, 5, new Nube(), new Roca(), null);

        Ratchet ratchet = new Ratchet(casillero1);

        casillero2.alojarPorAire(ratchet);

        Assert.assertEquals(ratchet.obtenerCasillero(), casillero2);

        Assert.assertEquals(casillero2.obtenerAlgoformer(), ratchet);

    }

    @Test
    public void alojarCasilleroConEspinasBajaLaVidaDeUnAlgoformerTerrestre(){

        Casillero casillero1 = new Casillero(4, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(5, 5, new Nube(), new Espinas(), null);

        Optimus optimus = new Optimus(casillero1);

        casillero2.alojarPorTierra(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() < 500);

    }

    @Test
    public void alojarCasilleroConEspinasLeBajaLaVidaAunAlgoformerAereo(){

        Casillero casillero1 = new Casillero(4, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(5, 5, new TormentaPsionica(), new Roca(), null);

        Ratchet ratchet = new Ratchet(casillero1);

        casillero2.alojarPorAire(ratchet);

        Assert.assertTrue(ratchet.obtenerAtaque() < 35);

    }

    @Test
    public void desocuparCasilleroPierdeReferenciaAlAlgoformer(){

        Casillero casillero1 = new Casillero(4, 5, new Nube(), new Roca(), null);

        Optimus optimus = new Optimus(casillero1);

        casillero1.desocupar();

        Assert.assertTrue(casillero1.obtenerAlgoformer() == null);

    }

    @Test
    public void casilleroConBonusSeCreaCorrectamente(){

        Casillero casillero = new Casillero(4, 5, new Nube(), new Roca(), new Flash());

        Assert.assertTrue(casillero.tieneBonus());

    }


}
