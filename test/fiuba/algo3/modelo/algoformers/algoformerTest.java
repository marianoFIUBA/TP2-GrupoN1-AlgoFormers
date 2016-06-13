package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mariano on 12/06/2016.
 */
public class algoformerTest {

    @Test
    public void testIntegracion(){

        Juego.getInstance().iniciarJuego(10,10);

        Jugador jugador1 = Juego.getInstance().obtenerJugador1();
        AlgoFormer algoformer1 = jugador1.obtenerAlgoformer1();
        algoformer1.obtenerNombre();
        Assert.assertEquals(algoformer1.obtenerNombre(), "MEGATRON");
    }
}
