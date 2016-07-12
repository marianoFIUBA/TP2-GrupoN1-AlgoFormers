package fiuba.algo3.modelo.movimiento;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Excepciones.HumanoideNoPuedeDesempantanarseException;
import modelo.Excepciones.NoPuedeCambiarAModoAtrapadoEnNebulosaException;
import modelo.Juego;
import modelo.algoformers.autobots.Optimus;
import modelo.movimiento.MovimientoHumanoideTerrestre;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mariano on 11/07/2016.
 */
public class MovimientoHumanoideTerrestreTest {

    @Test
    public void ocuparCasilleroAgregaReferenciaAlAlgoformerEnElCasillero(){

        MovimientoHumanoideTerrestre movimiento = new MovimientoHumanoideTerrestre();

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

        MovimientoHumanoideTerrestre movimiento = new MovimientoHumanoideTerrestre();
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

        MovimientoHumanoideTerrestre movimiento = new MovimientoHumanoideTerrestre();
        movimiento.cambiarAModoAtrapadoEnNebulosa();
    }

    @Test
    public void cambiarAModoEmpantanado(){

        MovimientoHumanoideTerrestre movimiento = new MovimientoHumanoideTerrestre();

        Assert.assertFalse(movimiento.estaEmpantanado());

        movimiento.cambiarAModoEmpantanado();
        Assert.assertTrue(movimiento.estaEmpantanado());
    }

    @Test
    public void pasarTurnoNoCambiaElMovmientoAModoNoEmpantanado(){
        MovimientoHumanoideTerrestre movimiento = new MovimientoHumanoideTerrestre();
        movimiento.cambiarAModoEmpantanado();
        Assert.assertTrue(movimiento.estaEmpantanado());
        movimiento.pasarTurno();
        Assert.assertTrue(movimiento.estaEmpantanado());
    }

    @Test (expected = HumanoideNoPuedeDesempantanarseException.class)
    public void cambiarAModoNoEmpantando(){

        MovimientoHumanoideTerrestre movimiento = new MovimientoHumanoideTerrestre();

        movimiento.cambiarAModoEmpantanado();
        Assert.assertTrue(movimiento.estaEmpantanado());
        movimiento.cambiarAModoNoEmpantanado();
    }
}
