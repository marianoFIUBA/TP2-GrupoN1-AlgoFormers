package fiuba.algo3.modelo.algoformers;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 10/7/2016.
 */
public class AlgoformerCombinacionTest {

    //En esta clase se prueban la combinacion y la descombinacion de los algoformers.

    @Test
    public void algoformersSeCombinanCorrectamente(){

        Juego.getInstance().iniciarJuego();

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        AlgoFormer bonecrusher = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer2();
        AlgoFormer frenzy = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer3();
        Casillero casilleroMegatron = megatron.obtenerCasillero();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(megatron);
        Juego.getInstance().obtenerJugadorActual().combinarAlgoformers();

        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        AlgoFormer bumblebee = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer2();
        AlgoFormer ratchet = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer3();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(optimus);
        Juego.getInstance().obtenerJugadorActual().combinarAlgoformers();

        AlgoFormer menasor = Juego.getInstance().obtenerJugadorActual().obtenerCombinado();
        Casillero casilleroInicialMenasor = menasor.obtenerCasillero();

        Assert.assertEquals(casilleroMegatron,casilleroInicialMenasor);
        Assert.assertTrue(megatron.obtenerCasillero() == null && bonecrusher.obtenerCasillero() == null && frenzy.obtenerCasillero() == null);

        AlgoFormer superion = Juego.getInstance().obtenerJugadorActual().obtenerCombinado();
        Casillero casilleroInicialSuperion = superion.obtenerCasillero();

        Assert.assertEquals(casilleroMegatron,casilleroInicialSuperion);
        Assert.assertTrue(optimus.obtenerCasillero() == null && bumblebee.obtenerCasillero() == null && ratchet.obtenerCasillero() == null);

    }

    @Test
    public void algoformerCombinadoSeDescombinaCorrectamente(){

        Juego.getInstance().iniciarJuego();

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        AlgoFormer bonecrusher = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer2();
        AlgoFormer frenzy = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer3();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(megatron);
        Juego.getInstance().obtenerJugadorActual().combinarAlgoformers();

        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        AlgoFormer bumblebee = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer2();
        AlgoFormer ratchet = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer3();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(optimus);
        Juego.getInstance().obtenerJugadorActual().combinarAlgoformers();

        AlgoFormer menasor = Juego.getInstance().obtenerJugadorActual().obtenerCombinado();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(menasor);
        Juego.getInstance().obtenerJugadorActual().descombinarAlgoformers();

        Juego.getInstance().pasarTurno();

        AlgoFormer superion = Juego.getInstance().obtenerJugadorActual().obtenerCombinado();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(superion);
        Juego.getInstance().obtenerJugadorActual().descombinarAlgoformers();

        Juego.getInstance().pasarTurno();

        menasor = Juego.getInstance().obtenerJugadorActual().obtenerCombinado();
        Assert.assertTrue(megatron.obtenerCasillero() != null && bonecrusher.obtenerCasillero() != null && frenzy.obtenerCasillero() != null);
        Assert.assertEquals(menasor,null);

        superion = Juego.getInstance().obtenerJugadorActual().obtenerCombinado();
        Assert.assertTrue(optimus.obtenerCasillero() != null && bumblebee.obtenerCasillero() != null && ratchet.obtenerCasillero() != null);
        Assert.assertEquals(superion,null);

    }



}
