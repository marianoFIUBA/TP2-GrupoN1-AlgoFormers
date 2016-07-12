package fiuba.algo3.modelo.algoformers;

import modelo.Piernas;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 11/7/2016.
 */
public class PiernasTest {

    @Test
    public void modificarVelocidadTriplicaLaVelocidadDadaComoParametroCuandoHayTurnosRestantesConElBonusFlashActivo(){

        int velocidadInicial = 10;
        int velocidadFinal;
        Piernas piernas = new Piernas();
        piernas.cambiarAmodoFlash();  //El método cambiarAmodoFlash() setea los turnos en los cuales el bonus flash estará activo.
        velocidadFinal = piernas.modificarVelocidad(velocidadInicial);

        Assert.assertTrue(velocidadFinal == velocidadInicial * 3);


    }

    @Test
    public void modificarVelocidadNoModificaLaVelocidadDadaComoParametroCuandoNoHayTurnosRestantesConElBonusFlashActivo(){

        int velocidadInicial = 10;
        int velocidadFinal;
        Piernas piernas = new Piernas();
        velocidadFinal = piernas.modificarVelocidad(velocidadInicial);

        //No se llama al método cambiarAmodoFlash(), por lo que los turnos restantes con el bonus flash son cero.

        Assert.assertTrue(velocidadFinal == velocidadInicial);

    }

    @Test
    public void tieneBonusFlashEsVerdaderoSiHayTurnosRestantesConBonusElFlashActivo(){

        Piernas piernas = new Piernas();
        boolean tieneBonus = false;

        piernas.cambiarAmodoFlash();
        tieneBonus = piernas.tieneBonusFlash();

        Assert.assertTrue(tieneBonus);

    }

    @Test
    public void tieneBonusFlashDevuelveEsFalsoSiNoHayTurnosRestantesConElBonusFlashActivo(){

        Piernas piernas = new Piernas();
        boolean tieneBonus = false;

        tieneBonus = piernas.tieneBonusFlash();

        Assert.assertFalse(tieneBonus);

    }

    @Test
    public void pasarTurnoDisminuyeEnUnoElNumeroDeTurnosRestantesConElBonusFlashActivoSiLosTurnosRestantesSonMayoresACero(){

        Piernas piernas = new Piernas();
        int turnosIniciales;
        int turnosFinales;

        piernas.cambiarAmodoFlash();
        turnosIniciales = piernas.obtenerTurnosRestantesFlash();
        piernas.pasarTurno();
        turnosFinales = piernas.obtenerTurnosRestantesFlash();

        Assert.assertTrue(turnosIniciales == 4);
        Assert.assertTrue(turnosFinales == 3);

    }

    @Test
    public void modificarVelocidadTriplicaLaVelocidadDadaComoParametroDuranteCuatroTurnos(){

        Piernas piernas = new Piernas();
        int velocidadInicial = 10;
        int velocidadFinal;

        piernas.cambiarAmodoFlash();
        velocidadFinal = piernas.modificarVelocidad(velocidadInicial);
        piernas.pasarTurno();

        Assert.assertTrue(velocidadFinal == velocidadInicial * 3);

        velocidadFinal = piernas.modificarVelocidad(velocidadInicial);
        piernas.pasarTurno();

        Assert.assertTrue(velocidadFinal == velocidadInicial * 3);

        velocidadFinal = piernas.modificarVelocidad(velocidadInicial);
        piernas.pasarTurno();

        Assert.assertTrue(velocidadFinal == velocidadInicial * 3);

        velocidadFinal = piernas.modificarVelocidad(velocidadInicial);
        piernas.pasarTurno();  //Ultimo turno.

        velocidadFinal = piernas.modificarVelocidad(velocidadInicial);

        Assert.assertTrue(velocidadFinal == velocidadInicial);

    }

    @Test
    public void cambiarAModoFlashLeDaValorCuatroALosTurnosRestantesConBonusFlash(){

        Piernas piernas = new Piernas();
        int turnos;

        piernas.cambiarAmodoFlash();

        turnos = piernas.obtenerTurnosRestantesFlash();

        Assert.assertTrue(turnos == 4);


    }



}
