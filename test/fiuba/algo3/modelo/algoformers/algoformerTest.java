package fiuba.algo3.modelo.algoformers;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import modelo.Jugador;
import modelo.algoformers.Optimus;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mariano on 12/06/2016.
 */
public class AlgoformerTest {

    @Test
    public void algoformerSeMueveACasilleroEperado(){

        /*
            Se genera tablero de 5x5 casilleros. El tercer parámetro indica que no deben generarse
            terrenos de forma aleatoria. Ésto es, el atributo tierra es "ROCOSO" y el atributo aire
            es "NUBE" para todos los csilleros del tablero.
        */
        Juego.getInstance().generarTablero(5,5,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(4,5);

        Optimus optimus = new Optimus(casilleroInicial);
        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
    }

    @Test
    public void algoformerSeTransformaEnAmbasDirecciones(){

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Optimus optimus = new Optimus(casilleroInicial);

        Assert.assertTrue(optimus.obtenerEstado() == "ALTERNO");

        optimus.transformarseAModoHumanoide();
        Assert.assertTrue(optimus.obtenerEstado() == "HUMANOIDE");

        optimus.transformarseAModoAlterno();
        Assert.assertTrue(optimus.obtenerEstado() == "ALTERNO");
    }
}
