package fiuba.algo3.modelo.algoformers;

import modelo.Casillero;
import modelo.Juego;
import modelo.algoformers.autobots.Optimus;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 10/7/2016.
 */
public class AlgoformerTransformacionTest {

    //En esta clase se prueba la transformacion de un algoformer.

    @Test
    public void algoformerSeTransformaEnAmbasDirecciones() {


        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Optimus optimus = new Optimus(casilleroInicial);

        Assert.assertTrue(optimus.obtenerEstado() == "ALTERNO");

        optimus.transformarseAModoHumanoide();
        Assert.assertTrue(optimus.obtenerEstado() == "HUMANOIDE");

        optimus.transformarseAModoAlterno();
        Assert.assertTrue(optimus.obtenerEstado() == "ALTERNO");
    }




}
