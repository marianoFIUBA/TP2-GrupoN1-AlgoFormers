package fiuba.algo3.modelo.algoformers;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import modelo.Jugador;
import modelo.algoformers.Bumblebee;
import modelo.algoformers.Megatron;
import modelo.algoformers.Optimus;
import org.junit.Assert;
import org.junit.Test;


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

    @Test
    public void algoFormerAtacaSiEstaEnRango(){

        Juego.getInstance().generarTablero(5,5,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2,2);

        Optimus optimus = new Optimus(casilleroInicial);
        Megatron megatron = new Megatron(casilleroFinal);
        optimus.atacarA(megatron);

        Assert.assertTrue(megatron.getPuntosDeVida() == 535);
    }

    @Test
    public void algoFormerNoAtacaSiNoEstaEnRango(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(20,20);

        Optimus optimus = new Optimus(casilleroInicial);
        Megatron megatron = new Megatron(casilleroFinal);
        optimus.atacarA(megatron);

        Assert.assertTrue(megatron.getPuntosDeVida() == 550);
    }

    @Test
    public void autobotNoAtacaAotroAutobot(){

        Juego.getInstance().generarTablero(5,5,false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2,2);

        Optimus optimus = new Optimus(casilleroInicial);
        Bumblebee bumblebee = new Bumblebee(casilleroFinal);
        optimus.atacarA(bumblebee);

        Assert.assertTrue(bumblebee.getPuntosDeVida() == 350);
    }

}
