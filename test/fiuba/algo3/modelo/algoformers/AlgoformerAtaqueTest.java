package fiuba.algo3.modelo.algoformers;

import modelo.Casillero;
import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;
import modelo.Excepciones.AutobotNoPuedeAtacarAOtroAutobot;
import modelo.Excepciones.DecepticonNoPuedeAtacarAOtroDecepticonException;
import modelo.Juego;
import modelo.algoformers.autobots.Bumblebee;
import modelo.algoformers.autobots.Optimus;
import modelo.algoformers.decepticons.Bonecrusher;
import modelo.algoformers.decepticons.Megatron;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 10/7/2016.
 */
public class AlgoformerAtaqueTest {


    @Test
    public void algoFormerAtacaSiEstaEnRango() {

        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2, 2);

        Optimus optimus = new Optimus(casilleroInicial);
        Megatron megatron = new Megatron(casilleroFinal);
        optimus.atacarA(megatron);

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 535);
    }

    @Test(expected= AlgoFormerFueraDeAlcanceException.class)
    public void algoFormerNoAtacaSiNoEstaEnRango() {

        Juego.getInstance().generarTablero(20, 20, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(20, 20);

        Optimus optimus = new Optimus(casilleroInicial);
        Megatron megatron = new Megatron(casilleroFinal);
        optimus.atacarA(megatron);

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 550);

    }

    @Test(expected= AutobotNoPuedeAtacarAOtroAutobot.class)
    public void autobotNoPuedeAtacarAotroAutobot() {

        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2, 2);

        Optimus optimus = new Optimus(casilleroInicial);
        Bumblebee bumblebee = new Bumblebee(casilleroFinal);
        optimus.atacarA(bumblebee);

        Assert.assertTrue(bumblebee.obtenerPuntosDeVida() == 350);
    }

    @Test(expected= DecepticonNoPuedeAtacarAOtroDecepticonException.class)
    public void decepticonNoPuedeAtacarAOtroDecepticon(){

        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2, 2);

        Megatron megatron = new Megatron(casilleroInicial);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroFinal);
        megatron.atacarA(bonecrusher);

        Assert.assertTrue(bonecrusher.obtenerPuntosDeVida() == 200);


    }

    @Test
    public void sePierdeReferenciaDobleEntreElCasilleroYElAlgoformerAlMorirUnAlgoformerPorRecibirElAtaqueDeOtro(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicialOptimus = Juego.getInstance().obtenerCasillero(2,1);
        Optimus optimus = new Optimus(casilleroInicialOptimus);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1,1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        while (optimus.obtenerPuntosDeVida() > 0){

            megatron.atacarA(optimus);

        }

        Assert.assertTrue(optimus.obtenerCasillero() == null && casilleroInicialOptimus.obtenerAlgoformer() == null);

    }
}
