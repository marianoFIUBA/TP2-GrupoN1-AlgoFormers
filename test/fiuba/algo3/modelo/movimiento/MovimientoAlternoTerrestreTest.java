package fiuba.algo3.modelo.movimiento;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Excepciones.NoPuedeCambiarAModoAtrapadoEnNebulosaException;
import modelo.Juego;
import modelo.algoformers.autobots.Optimus;
import modelo.movimiento.MovimientoAlternoTerrestre;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mariano on 10/07/2016.
 */
public class MovimientoAlternoTerrestreTest {

    @Test
    public void ocuparCasilleroAgregaReferenciaAlAlgoformerEnElCasillero(){

        MovimientoAlternoTerrestre movimiento = new MovimientoAlternoTerrestre();

        Casillero casillero = new Casillero(1,1,new Nube(), new Roca(), null);
        AlgoFormer optimus = new Optimus(casillero);

        optimus.desocuparCasillero();
        Assert.assertEquals(casillero.obtenerAlgoformer(), null);

        movimiento.ocuparCasillero(optimus, casillero);

        Assert.assertEquals(optimus, casillero.obtenerAlgoformer());
    }

    @Test
    public void obtenerSiguienteCasilleroDevuelveElSiguienteCasilleroEnLaDireccionDelCasilleroDestino(){

        Juego.getInstance().iniciarJuego();

        MovimientoAlternoTerrestre movimiento = new MovimientoAlternoTerrestre();
        Casillero casilleroOrigen = new Casillero(1,1,new Nube(), new Roca(), null);
        Casillero casilleroDestino = new Casillero(5,5,new Nube(), new Roca(), null);
        int posicionXSiguienteCasillero = 2;
        int posicionYSiguienteCasillero = 2;

        Casillero siguienteCasillero = movimiento.obtenerSiguienteCasillero(casilleroOrigen, casilleroDestino);

        Assert.assertEquals(siguienteCasillero.obtenerPosicionX(), posicionXSiguienteCasillero);
        Assert.assertEquals(siguienteCasillero.obtenerPosicionY(), posicionYSiguienteCasillero);
    }

    @Test(expected = NoPuedeCambiarAModoAtrapadoEnNebulosaException.class)
    public void cambiarAModoAtrapadoEnNebulosaLanzaExcepcionEnMovimientosTerrestres(){

        MovimientoAlternoTerrestre movimiento = new MovimientoAlternoTerrestre();
        movimiento.cambiarAModoAtrapadoEnNebulosa();
    }

    @Test
    public void cambiarAModoEmpantanado(){

        MovimientoAlternoTerrestre movimiento = new MovimientoAlternoTerrestre();

        Assert.assertFalse(movimiento.estaEmpantanado());

        movimiento.cambiarAModoEmpantanado();
        Assert.assertTrue(movimiento.estaEmpantanado());
    }

    @Test
    public void pasarTurnoCambiaElMovmientoAModoNoEmpantanado(){

        MovimientoAlternoTerrestre movimiento = new MovimientoAlternoTerrestre();

        movimiento.cambiarAModoEmpantanado();
        Assert.assertTrue(movimiento.estaEmpantanado());
        movimiento.pasarTurno();
        Assert.assertFalse(movimiento.estaEmpantanado());
    }

    @Test
    public void cambiarAModoNoEmpantando(){

        MovimientoAlternoTerrestre movimiento = new MovimientoAlternoTerrestre();

        movimiento.cambiarAModoEmpantanado();
        Assert.assertTrue(movimiento.estaEmpantanado());
        movimiento.cambiarAModoNoEmpantanado();
        Assert.assertFalse(movimiento.estaEmpantanado());
    }
}






