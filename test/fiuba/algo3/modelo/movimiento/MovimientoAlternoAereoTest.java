package fiuba.algo3.modelo.movimiento;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Excepciones.NoEstaEnModoEmpantanadoException;
import modelo.Excepciones.NoPuedeCambiarAModoAtrapadoEnNebulosaException;
import modelo.Excepciones.NoPuedeCambiarAModoEmpantanadoException;
import modelo.Juego;
import modelo.algoformers.autobots.Optimus;
import modelo.movimiento.MovimientoAlternoAereo;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mariano on 10/07/2016.
 */
public class MovimientoAlternoAereoTest {

    @Test
    public void ocuparCasilleroAgregaReferenciaAlAlgoformerEnElCasillero(){

        MovimientoAlternoAereo movimiento = new MovimientoAlternoAereo();

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

        MovimientoAlternoAereo movimiento = new MovimientoAlternoAereo();
        Casillero casilleroOrigen = new Casillero(1,1,new Nube(), new Roca(), null);
        Casillero casilleroDestino = new Casillero(5,5,new Nube(), new Roca(), null);
        int posicionXSiguienteCasillero = 2;
        int posicionYSiguienteCasillero = 2;

        Casillero siguienteCasillero = movimiento.obtenerSiguienteCasillero(casilleroOrigen, casilleroDestino);

        Assert.assertEquals(siguienteCasillero.obtenerPosicionX(), posicionXSiguienteCasillero);
        Assert.assertEquals(siguienteCasillero.obtenerPosicionY(), posicionYSiguienteCasillero);
    }

    @Test
    public void cambiarAModoAtrapadoEnNebulosa(){

        MovimientoAlternoAereo movimiento = new MovimientoAlternoAereo();
        Assert.assertFalse(movimiento.estaAtrapadoEnNebulosa());
        movimiento.cambiarAModoAtrapadoEnNebulosa();
        Assert.assertTrue(movimiento.estaAtrapadoEnNebulosa());
    }

    @Test (expected =  NoPuedeCambiarAModoEmpantanadoException.class)
    public void cambiarAModoEmpantanadoLanzaExcepcion(){

        MovimientoAlternoAereo movimiento = new MovimientoAlternoAereo();
        movimiento.cambiarAModoEmpantanado();
    }

    @Test (expected = NoEstaEnModoEmpantanadoException.class)
    public void cambiarAModoNoEmpantandoLanzaExcepcion(){
        MovimientoAlternoAereo movimiento = new MovimientoAlternoAereo();
        movimiento.cambiarAModoNoEmpantanado();
    }

    @Test
    public void pasarTurnoDisminuyeTurnosPendientesAtrapadoEnNebulosa(){

        MovimientoAlternoAereo movimiento = new MovimientoAlternoAereo();
        movimiento.cambiarAModoAtrapadoEnNebulosa();
        //TurnosPendientes = 4
        Assert.assertTrue(movimiento.estaAtrapadoEnNebulosa());
        movimiento.pasarTurno();
        //TurnosPendientes = 3
        Assert.assertTrue(movimiento.estaAtrapadoEnNebulosa());
        movimiento.pasarTurno();
        //TurnosPendientes = 2
        Assert.assertTrue(movimiento.estaAtrapadoEnNebulosa());
        movimiento.pasarTurno();
        //TurnosPendientes = 1
        Assert.assertTrue(movimiento.estaAtrapadoEnNebulosa());
        movimiento.pasarTurno();
        //TurnosPendientes = 0
        Assert.assertFalse(movimiento.estaAtrapadoEnNebulosa());
    }
}
