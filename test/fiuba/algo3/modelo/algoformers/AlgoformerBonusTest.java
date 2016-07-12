package fiuba.algo3.modelo.algoformers;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Excepciones.AlgoFormerYaPoseeBonusBurbujaInmaculadaException;
import modelo.Excepciones.AlgoFormerYaPoseeBonusDobleCanionException;
import modelo.Excepciones.AlgoFormerYaPoseeBonusFlashException;
import modelo.Excepciones.MovimientoInvalidoException;
import modelo.Juego;
import modelo.Jugador;
import modelo.bonus.BurbujaInmaculada;
import modelo.bonus.DobleCanion;
import modelo.bonus.Flash;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 10/7/2016.
 */
public class AlgoformerBonusTest {

    //En esta clase se busca probar con tests de integración, las distintas modificaciones que provoca la capturación de los diferentes bonus.


    //-------------------------------------------BONUS DOBLE CANION---------------------------------------------------------


    @Test
    public void bonusDobleCanionFuncionaCorrectamenteEnAmbosEstados(){

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroConBonus = new Casillero(10,10,new Nube(),new Roca(),new DobleCanion());
        Juego.getInstance().modificarCasillero(casilleroConBonus);

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25,25);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(17,17);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        megatron.obtenerObjetoEstado().ocuparCasillero(megatron,casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        Jugador jugador2 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroDestinoOptimus = Juego.getInstance().obtenerCasillero(6,6);

        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        jugador2.seleccionarAlgoformer(optimus);
        jugador2.mover(casilleroDestinoOptimus);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(10,10);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        casilleroDestinoOptimus = Juego.getInstance().obtenerCasillero(9,9);
        jugador2.seleccionarAlgoformer(optimus);
        jugador2.mover(casilleroDestinoOptimus);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 390);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.transformar();

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 370);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 360);



    }

    @Test
    public void algoformerNoPuedeCapturarBonusDobleCanionSiYaLoPosee(){

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroConBonus1 = new Casillero(24, 25, new Nube(), new Roca(), new DobleCanion());
        Juego.getInstance().modificarCasillero(casilleroConBonus1);

        Casillero casilleroConBonus2 = new Casillero(23, 25, new Nube(), new Roca(), new DobleCanion());
        Juego.getInstance().modificarCasillero(casilleroConBonus2);

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25, 25);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        megatron.obtenerObjetoEstado().ocuparCasillero(megatron, casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroConBonus1);

        Juego.getInstance().pasarTurno();
        Juego.getInstance().pasarTurno();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroConBonus2);

        Assert.assertTrue(megatron.obtenerArma().obtenerTurnosRestantes() == 2 );


    }


    //---------------------------------------------BONUS BURBUJA INMACULADA---------------------------------------------------

    @Test
    public void bonusBurbujaInmaculadaFuncionaCorrectamente(){

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroConBonus = new Casillero(10,10,new Nube(),new Roca(),new BurbujaInmaculada());
        Juego.getInstance().modificarCasillero(casilleroConBonus);

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25,25);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(17,17);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        megatron.obtenerObjetoEstado().ocuparCasillero(megatron,casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        Jugador jugador2 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroDestinoRatchet = Juego.getInstance().obtenerCasillero(9,9);

        AlgoFormer ratchet = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer3();
        jugador2.seleccionarAlgoformer(ratchet);
        jugador2.mover(casilleroDestinoRatchet);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(10,10);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(ratchet);
        jugador2.atacar(megatron);

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 550);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.transformar();

        jugador2.seleccionarAlgoformer(ratchet);
        jugador2.atacar(megatron);

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 550);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.transformar();

        jugador2.seleccionarAlgoformer(ratchet);
        jugador2.atacar(megatron);

        Assert.assertFalse(megatron.obtenerPuntosDeVida() == 550);


    }

    @Test
    public void algoformerNoPuedeCapturarBonusBurbujaInmaculadaSiYaLoPosee() {

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroConBonus1 = new Casillero(24, 25, new Nube(), new Roca(), new BurbujaInmaculada());
        Juego.getInstance().modificarCasillero(casilleroConBonus1);

        Casillero casilleroConBonus2 = new Casillero(23, 25, new Nube(), new Roca(), new BurbujaInmaculada());
        Juego.getInstance().modificarCasillero(casilleroConBonus2);

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25, 25);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        megatron.obtenerObjetoEstado().ocuparCasillero(megatron, casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroConBonus1);

        Juego.getInstance().pasarTurno();
        Juego.getInstance().pasarTurno();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroConBonus2);

        Assert.assertTrue(megatron.obtenerArmadura().obtenerTurnosPendientes() == 1 );


    }




    //----------------------------------------BONUS FLASH-----------------------------------------------------


    @Test(expected = MovimientoInvalidoException.class)
    public void bonusFlashFuncionaCorrectamente(){

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25,25);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        megatron.obtenerObjetoEstado().ocuparCasillero(megatron,casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);

        Casillero casilleroConBonus = new Casillero(24,25,new Nube(),new Roca(),new Flash());

        Juego.getInstance().modificarCasillero(casilleroConBonus);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(24,25);

        jugador1.mover(casilleroDestinoMegatron);

        Jugador jugador2 = Juego.getInstance().obtenerJugadorActual();

        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        jugador2.seleccionarAlgoformer(optimus);

        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(9,25);

        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(25,25);
        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(10,25);
        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(20,25);
        jugador1.mover(casilleroDestinoMegatron);

    }

    @Test(expected = MovimientoInvalidoException.class)
    public void bonusFlashFuncionaCorrectamenteEnModoHumanoide(){

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25,25);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        megatron.obtenerObjetoEstado().ocuparCasillero(megatron,casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);

        jugador1.transformar();

        Jugador jugador2 = Juego.getInstance().obtenerJugadorActual();

        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        jugador2.seleccionarAlgoformer(optimus);

        jugador2.transformar();

        Casillero casilleroConBonus = new Casillero(24,25,new Nube(),new Roca(),new Flash());

        Juego.getInstance().modificarCasillero(casilleroConBonus);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(24,25);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(22,25);
        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(20,25);
        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(17,25);
        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(15,25);
        jugador1.mover(casilleroDestinoMegatron);


    }

    @Test(expected = MovimientoInvalidoException.class)
    public void bonusFlashFuncionaCorrectamenteAlternandoEstados(){

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25,25);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        megatron.obtenerObjetoEstado().ocuparCasillero(megatron,casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.transformar();

        Jugador jugador2 = Juego.getInstance().obtenerJugadorActual();
        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        Casillero casilleroConBonus = new Casillero(24,25,new Nube(),new Roca(),new Flash());
        Juego.getInstance().modificarCasillero(casilleroConBonus);
        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(24,25);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(22,25);
        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.transformar();

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(5,25);
        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(15,25);
        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestinoMegatron);

    }

    @Test
    public void algoformerNoPuedeCapturarBonusFlashSiYaLoPosee() {

        Juego.getInstance().iniciarJuego();

        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroConBonus1 = new Casillero(24, 25, new Nube(), new Roca(), new Flash());
        Juego.getInstance().modificarCasillero(casilleroConBonus1);

        Casillero casilleroConBonus2 = new Casillero(23, 25, new Nube(), new Roca(), new Flash());
        Juego.getInstance().modificarCasillero(casilleroConBonus2);

        Casillero casilleroMegatron = Juego.getInstance().obtenerCasillero(25, 25);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        megatron.obtenerObjetoEstado().ocuparCasillero(megatron, casilleroMegatron);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroConBonus1);

        Juego.getInstance().pasarTurno();
        Juego.getInstance().pasarTurno();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroConBonus2);

        Assert.assertTrue(megatron.obtenerPiernas().obtenerTurnosRestantes() == 2 );

    }





}
