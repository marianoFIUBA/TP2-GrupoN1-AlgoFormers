package fiuba.algo3.modelo.algoformers;

import modelo.Casillero;
import modelo.Excepciones.MovimientoInvalidoException;
import modelo.Juego;
import modelo.algoformers.autobots.Optimus;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 10/7/2016.
 */
public class AlgoformerMovimientoTest {

    //En esta clase se prueba el movimiento de los algoformers.

    @Test
    public void algoformerSeMueveACasilleroEperado() {

        /*  Se genera tablero de 5x5 casilleros. El tercer parámetro indica que no deben generarse
            terrenos de forma aleatoria. Ésto es, el atributo tierra es "ROCOSO" y el atributo aire
            es "NUBE" para todos los csilleros del tablero.
        */
        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(4, 5);

        Optimus optimus = new Optimus(casilleroInicial);
        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
    }

    @Test(expected = MovimientoInvalidoException.class)
    public void algoformerNoSeMueveSiElCasilleroNoEstaEnSuRangoDeVelocidad(){

        Juego.getInstance().generarTablero(10, 10, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 10);

        Optimus optimus = new Optimus(casilleroInicial);
        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);

    }



}
