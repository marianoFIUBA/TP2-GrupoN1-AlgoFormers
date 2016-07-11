package fiuba.algo3.modelo.algoformers;

import modelo.Casillero;
import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;
import modelo.Excepciones.AutobotNoPuedeAtacarAOtroAutobot;
import modelo.algoformers.autobots.Optimus;
import modelo.algoformers.decepticons.Megatron;
import modelo.armas.ArmaAutobot;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Franco on 10/7/2016.
 */
public class ArmaTests {

    @Test
    public void estaEnRangoDevuelveTrueSiElCasilleroEstaLoSuficientementeCercaTest(){

        Casillero casillero1 = new Casillero(5, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(7, 7, new Nube(), new Roca(), null);

        ArmaAutobot armaAutobot = new ArmaAutobot();

        Assert.assertTrue(armaAutobot.estaEnRango(casillero1, casillero2, 2));

    }

    @Test
    public void estaEnRangoDevuelveFalseSiElCasilleroEstaMasLejosDeLaDistanciaDeAtaqueTest(){

        Casillero casillero1 = new Casillero(5, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(40, 40, new Nube(), new Roca(), null);

        ArmaAutobot armaAutobot = new ArmaAutobot();

        Assert.assertFalse(armaAutobot.estaEnRango(casillero1, casillero2, 2));
    }

    @Test
    public void modificarAtaqueDuplicaElAtaqueSiLosTurnosRestantesDeDobleCanionSonMayoresAceroTest(){

        ArmaAutobot armaAutobot = new ArmaAutobot();

        armaAutobot.cambiarAmodoDobleCanion();

        Assert.assertTrue(armaAutobot.modificarAtaque(5) == 10);

    }

    @Test
    public void modificarAtaqueNoHaceNadaSiModoDobleCanionNoFueActivadoTest(){

        ArmaAutobot armaAutobot = new ArmaAutobot();

        Assert.assertTrue(armaAutobot.modificarAtaque(5) == 5);

    }

    @Test
    public void dobleCanionDuraSolo4TurnosTest(){  //Un supuesto es que el turno en el que obtiene el bonus no es tomado en cuenta
                                               // ya que el turno pasa inmediatamente luego de agarrar el bonus (por eso 4 turnos)

        ArmaAutobot armaAutobot = new ArmaAutobot();

        armaAutobot.cambiarAmodoDobleCanion();

        Assert.assertTrue(armaAutobot.modificarAtaque(5) == 10);

        armaAutobot.pasarTurno();
        armaAutobot.pasarTurno();
        armaAutobot.pasarTurno();

        Assert.assertTrue(armaAutobot.modificarAtaque(5) == 10);

        armaAutobot.pasarTurno(); //pasan los 4 turnos

        Assert.assertTrue(armaAutobot.modificarAtaque(5) == 5);

    }

    @Test
    public void tieneBonusDobleCanionSoloDevuelveTrueLuegoDeSerActivadoTest(){

        ArmaAutobot armaAutobot = new ArmaAutobot();

        Assert.assertFalse(armaAutobot.tieneBonusDobleCanion());

        armaAutobot.cambiarAmodoDobleCanion();

        Assert.assertTrue(armaAutobot.tieneBonusDobleCanion());

    }

    @Test(expected= AlgoFormerFueraDeAlcanceException.class)
    public void noSeEfectuaAtaqueSiElCasilleroNoEstaEnRangoTest(){

        Casillero casillero1 = new Casillero(4, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(20, 20, new Nube(), new Roca(), null);

        Megatron megatron = new Megatron(casillero1);

        ArmaAutobot armaAutobot = new ArmaAutobot();

        armaAutobot.atacar(megatron,5,5,casillero2);

    }

    @Test(expected = AutobotNoPuedeAtacarAOtroAutobot.class)
    public void armaAutobotNoAtacaAotroAutobotTest(){

        Casillero casillero1 = new Casillero(4, 5, new Nube(), new Roca(), null);

        Casillero casillero2 = new Casillero(5, 5, new Nube(), new Roca(), null);

        Optimus optimus = new Optimus(casillero1);

        ArmaAutobot armaAutobot = new ArmaAutobot();

        armaAutobot.atacar(optimus,5,5,casillero2);

    }
    
}
