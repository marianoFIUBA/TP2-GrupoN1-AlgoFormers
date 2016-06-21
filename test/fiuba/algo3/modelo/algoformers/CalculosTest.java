package fiuba.algo3.modelo.algoformers;


import modelo.Calculos;

import modelo.Casillero;
import modelo.Juego;
import modelo.algoformers.Optimus;
import org.junit.Assert;
import org.junit.Test;

public class CalculosTest {

    @Test
    public void movimientoEsValidoSiEstaEnRangoYnoHayAlgoformerEnElCaminoTest(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(5,5);

        Calculos calculos = new Calculos();

        Assert.assertTrue(calculos.movimientoValido(casilleroInicial, casilleroFinal, 10));

    }

    @Test
    public void moverACasilleroLimitrofeEsValidoSinoHayAlgoformerTest(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2,2);

        Calculos calculos = new Calculos();

        Assert.assertTrue(calculos.movimientoValido(casilleroInicial, casilleroFinal, 10));

    }

    @Test
    public void movimientoNoEsValidoSiHayAlgofoemerEnElCaminoTest(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroConAlgoformer = Juego.getInstance().obtenerCasillero(2,2);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(3,3);

        Optimus optimus = new Optimus(casilleroConAlgoformer);

        Calculos calculos = new Calculos();

        Assert.assertFalse(calculos.movimientoValido(casilleroInicial, casilleroFinal, 5));

    }

    @Test
    public void movimientoNoEsValidoSiHayAlgofoemerEnElCaminoMasLejosTest(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroConAlgoformer = Juego.getInstance().obtenerCasillero(4,4);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(5,5);

        Optimus optimus = new Optimus(casilleroConAlgoformer);

        Calculos calculos = new Calculos();

        Assert.assertFalse(calculos.movimientoValido(casilleroInicial, casilleroFinal, 5));

    }


}
