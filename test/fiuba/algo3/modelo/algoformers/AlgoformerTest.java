package fiuba.algo3.modelo.algoformers;

import modelo.*;
import modelo.algoformers.*;
import org.junit.Assert;
import org.junit.Test;


public class AlgoformerTest {

    @Test
    public void algoformerSeMueveACasilleroEperado() {

        /*
            Se genera tablero de 5x5 casilleros. El tercer parámetro indica que no deben generarse
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

    @Test
    public void algoformerSeTransformaEnAmbasDirecciones() {

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Optimus optimus = new Optimus(casilleroInicial);

        Assert.assertTrue(optimus.obtenerEstado() == "ALTERNO");

        optimus.transformarseAModoHumanoide();
        Assert.assertTrue(optimus.obtenerEstado() == "HUMANOIDE");

        optimus.transformarseAModoAlterno();
        Assert.assertTrue(optimus.obtenerEstado() == "ALTERNO");
    }

    @Test
    public void algoFormerAtacaSiEstaEnRango() {

        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2, 2);

        Optimus optimus = new Optimus(casilleroInicial);
        Megatron megatron = new Megatron(casilleroFinal);
        optimus.atacarA(megatron);

        Assert.assertTrue(megatron.getPuntosDeVida() == 535);
    }

    @Test
    public void algoFormerNoAtacaSiNoEstaEnRango() {

        Juego.getInstance().generarTablero(20, 20, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(20, 20);

        Optimus optimus = new Optimus(casilleroInicial);
        Megatron megatron = new Megatron(casilleroFinal);
        optimus.atacarA(megatron);

        Assert.assertTrue(megatron.getPuntosDeVida() == 550);
    }

    @Test
    public void autobotNoAtacaAotroAutobot() {

        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2, 2);

        Optimus optimus = new Optimus(casilleroInicial);
        Bumblebee bumblebee = new Bumblebee(casilleroFinal);
        optimus.atacarA(bumblebee);

        Assert.assertTrue(bumblebee.getPuntosDeVida() == 350);
    }

    @Test
    public void testoptimusAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);

        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);

        Optimus optimus = new Optimus(casilleroInicial); //Los algoformers se crean en estado ALTERNO.

        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 15 && optimus.obtenerVelocidad() == 5 && optimus.getPuntosDeVida() == 500);

        /*casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        optimus.transformarseAModoHumanoide();

        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 50 && optimus.obtenerVelocidad() == 2 && optimus.getPuntosDeVida() == 500);*/


    }

    @Test
    public void testBumblebeeAtraviesaZonaRocosaSinProblemas() {


        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);
        Bumblebee bumblebee = new Bumblebee(casilleroInicial);

        bumblebee.moverA(casilleroFinal);

        Assert.assertEquals(bumblebee.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(bumblebee.obtenerAtaque() == 20 && bumblebee.obtenerVelocidad() == 5 && bumblebee.getPuntosDeVida() == 350);

        //Aca se transforma a humanoide y se prueba su movimiento y paso por zona rocosa

    }

    @Test
    public void testRatchetAtarviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Ratchet ratchet = new Ratchet(casilleroInicial);

        ratchet.moverA(casilleroFinal);

        Assert.assertEquals(ratchet.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(ratchet.obtenerAtaque() == 35 && ratchet.obtenerVelocidad() == 8 && ratchet.getPuntosDeVida() == 150);

        //Aca se transforma a humanoide y se prueba su movimiento y paso por zona rocosa


    }

    @Test
    public void testMegatronAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(megatron.obtenerAtaque() == 55 && megatron.obtenerVelocidad() == 8 && megatron.getPuntosDeVida() == 550);

        //Aca se transforma a humanoide y se prueba su movimiento y paso por zona rocosa


    }

    @Test
    public void testBonecrusherAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicial);

        bonecrusher.moverA(casilleroFinal);

        Assert.assertEquals(bonecrusher.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(bonecrusher.obtenerAtaque() == 30 && bonecrusher.obtenerVelocidad() == 8 && bonecrusher.getPuntosDeVida() == 200);

        //Aca se transforma a humanoide y se prueba su movimiento y paso por zona rocosa

    }

    @Test
    public void testFrenzyAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 7);
        Frenzy frenzy = new Frenzy(casilleroInicial);

        frenzy.moverA(casilleroFinal);

        Assert.assertEquals(frenzy.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(frenzy.obtenerAtaque() == 25 && frenzy.obtenerVelocidad() == 6 && frenzy.getPuntosDeVida() == 400);

        //Aca se transforma a humanoide y se prueba su movimiento y paso por zona rocosa


    }


    @Test
    public void testAlgoformerEnEstadoAlternoTerrestreTardaElDobleAlPasarPorZonaPantanosa() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(1, 6);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 5);  //El algoformer en estado ALTERNO TERRESTRE pierde 2 puntos de velocidad en la zona pantanosa, por eso no llega al destino deseado.
        Casillero casilleroConPantano = new Casillero(1, 3, "NUBE", "PANTANO");
        Juego.getInstance().modificarCasillero(casilleroConPantano);          //Se modifica un casillero del tablero por un casillero con zona pantanosa.
        Optimus optimus = new Optimus(casilleroInicial);   //Optimus se crea en estado ALTERNO TERRESTRE.

        optimus.moverA(casilleroDestino);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);


    }

    @Test
    public void testAlgoformerEnEstadoAlterneAereoAtraviesaSinProblemasPorZonaPantanosa() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConPantano = new Casillero(1, 3, "NUBE", "PANTANO");
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);


    }


    @Test
    public void testAlgoformerEnEstadoAlternoAereoAtraviesaSinProblemasPorZonaDeEspinas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConPantano = new Casillero(1, 3, "NUBE", "ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);


    }

    @Test
    public void testAlgoFormerEnEstadoAereoPierdeCincoPorCientoDeVidaAlAtravesarUnaTormentaPsionica(){


        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConPantano = new Casillero(1, 3, "TORMENTA ", "ROCOSA");
        Juego.getInstance().modificarCasillero(casilleroConPantano);                            //CORREGIR LOGICA DE TORMENTA PSIONICA, SE ESTA QUITANDO PUNTOS DE VIDA EN VEZ DE PUNTOS DE ATAQUE !!!
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertTrue(megatron.obtenerAtaque() == 22);


    }

}


