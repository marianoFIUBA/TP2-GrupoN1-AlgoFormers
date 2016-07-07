package fiuba.algo3.modelo.algoformers;

import modelo.*;
import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;
import modelo.Excepciones.AlgoFormerInhabilitadoPorEsteTurno;
import modelo.Excepciones.AutobotNoPuedeAtacarAOtroAutobot;
import modelo.algoformers.*;
import modelo.bonus.BurbujaInmaculada;
import modelo.bonus.DobleCanion;
import modelo.bonus.Flash;
import modelo.zonas.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


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
        optimus.moverA(casilleroFinal,optimus);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
    }

    @Test
    public void algoformerSeTransformaEnAmbasDirecciones() {


        Juego.getInstance().generarTablero(5, 5, false);

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
    public void autobotNoAtacaAotroAutobot() {

        Juego.getInstance().generarTablero(5, 5, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(2, 2);

        Optimus optimus = new Optimus(casilleroInicial);
        Bumblebee bumblebee = new Bumblebee(casilleroFinal);
        optimus.atacarA(bumblebee);

        Assert.assertTrue(bumblebee.obtenerPuntosDeVida() == 350);
    }

    @Test
    public void testOptimusAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);

        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);

        Optimus optimus = new Optimus(casilleroInicial); //Los algoformers se crean en estado ALTERNO.

        optimus.moverA(casilleroFinal,optimus);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 15 && optimus.obtenerVelocidad() == 5 && optimus.obtenerPuntosDeVida() == 500);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        optimus.transformarseAModoHumanoide();

        optimus.moverA(casilleroFinal,optimus);

        Assert.assertEquals(optimus.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 50 && optimus.obtenerVelocidad() == 2 && optimus.obtenerPuntosDeVida() == 500);


    }

    @Test
    public void testBumblebeeAtraviesaZonaRocosaSinProblemas() {


        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);
        Bumblebee bumblebee = new Bumblebee(casilleroInicial);

        bumblebee.moverA(casilleroFinal,bumblebee);

        Assert.assertEquals(bumblebee.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(bumblebee.obtenerAtaque() == 20 && bumblebee.obtenerVelocidad() == 5 && bumblebee.obtenerPuntosDeVida() == 350);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        bumblebee.transformarseAModoHumanoide();

        bumblebee.moverA(casilleroFinal,bumblebee);

        Assert.assertEquals(bumblebee.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(bumblebee.obtenerAtaque() == 40 && bumblebee.obtenerVelocidad() == 2 && bumblebee.obtenerPuntosDeVida() == 350);



    }

    @Test
    public void testRatchetAtarviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Ratchet ratchet = new Ratchet(casilleroInicial);

        ratchet.moverA(casilleroFinal,ratchet);

        Assert.assertEquals(ratchet.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(ratchet.obtenerAtaque() == 35 && ratchet.obtenerVelocidad() == 8 && ratchet.obtenerPuntosDeVida() == 150);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        ratchet.transformarseAModoHumanoide();

        ratchet.moverA(casilleroFinal,ratchet);

        Assert.assertEquals(ratchet.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(ratchet.obtenerAtaque() == 5 && ratchet.obtenerVelocidad() == 1 && ratchet.obtenerPuntosDeVida() == 150);


    }

    @Test
    public void superionAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,4);
        Superion superion = new Superion(casilleroInicial, 100);

        superion.moverA(casilleroFinal,superion);

        Assert.assertEquals(superion.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(superion.obtenerAtaque() == 100 && superion.obtenerVelocidad() == 3 && superion.obtenerPuntosDeVida() == 100);

    }

    @Test
    public void menasorAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,3);
        Menasor menasor = new Menasor(casilleroInicial, 100);

        menasor.moverA(casilleroFinal,menasor);

        Assert.assertEquals(menasor.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(menasor.obtenerAtaque() == 115 && menasor.obtenerVelocidad() == 2 && menasor.obtenerPuntosDeVida() == 100);

    }

    @Test
    public void testMegatronAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal,megatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(megatron.obtenerAtaque() == 55 && megatron.obtenerVelocidad() == 8 && megatron.obtenerPuntosDeVida() == 550);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        megatron.transformarseAModoHumanoide();

        megatron.moverA(casilleroFinal,megatron);

        Assert.assertEquals(megatron.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(megatron.obtenerAtaque() == 10 && megatron.obtenerVelocidad() == 1 && megatron.obtenerPuntosDeVida() == 550);

    }

    @Test
    public void testBonecrusherAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicial);

        bonecrusher.moverA(casilleroFinal,bonecrusher);

        Assert.assertEquals(bonecrusher.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(bonecrusher.obtenerAtaque() == 30 && bonecrusher.obtenerVelocidad() == 8 && bonecrusher.obtenerPuntosDeVida() == 200);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        bonecrusher.transformarseAModoHumanoide();

        bonecrusher.moverA(casilleroFinal,bonecrusher);

        Assert.assertEquals(bonecrusher.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(bonecrusher.obtenerAtaque() == 30 && bonecrusher.obtenerVelocidad() == 1 && bonecrusher.obtenerPuntosDeVida() == 200);

    }

    @Test
    public void testFrenzyAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 7);
        Frenzy frenzy = new Frenzy(casilleroInicial);

        frenzy.moverA(casilleroFinal,frenzy);

        Assert.assertEquals(frenzy.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(frenzy.obtenerAtaque() == 25 && frenzy.obtenerVelocidad() == 6 && frenzy.obtenerPuntosDeVida() == 400);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);

        frenzy.transformarseAModoHumanoide();

        frenzy.moverA(casilleroFinal,frenzy);

        Assert.assertEquals(frenzy.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(frenzy.obtenerAtaque() == 10 && frenzy.obtenerVelocidad() == 2 && frenzy.obtenerPuntosDeVida() == 400);


    }


    @Test
    public void testAlgoformerEnEstadoAlternoTerrestreTardaElDobleAlPasarPorZonaPantanosa() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(1, 9);    //El algoformer en estado ALTERNO TERRESTRE pierde 2 puntos de velocidad en la zona pantanosa, por eso no llega al destino deseado.
        Casillero casilleroConPantano = new Casillero(1, 5, new Nube(), new Pantano(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 8);  //Se modifica un casillero del tablero por un casillero con zona pantanosa.
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicial);    //Optimus se crea en estado ALTERNO TERRESTRE.

        bonecrusher.moverA(casilleroDestino,bonecrusher);

        Assert.assertEquals(bonecrusher.obtenerCasillero(), casilleroFinal);
        Assert.assertEquals(casilleroFinal.obtenerAlgoformer(), bonecrusher);


    }

    @Test
    public void algoformerEnEstadoHumanoideNoPuedeAtravesarZonaPantanosa(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(1,3);
        Casillero casilleroConPantano = new Casillero (1,2,new Nube(), new Pantano(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,2);
        Optimus optimus = new Optimus(casilleroInicial);

        optimus.transformarseAModoHumanoide();
        optimus.moverA(casilleroDestino,optimus);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertEquals(casilleroFinal.obtenerAlgoformer(), optimus);

        optimus.moverA(casilleroDestino,optimus);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertEquals(casilleroFinal.obtenerAlgoformer(), optimus);


    }



    @Test
    public void testAlgoformerEnEstadoAlternoAereoAtraviesaSinProblemasPorZonaPantanosa() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConPantano = new Casillero(1, 3,new Nube(), new Pantano(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal,megatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);


    }

    @Test
    public void optimusPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,6);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Optimus optimus = new Optimus(casilleroInicial);

        optimus.moverA(casilleroFinal,optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 475);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);
        casilleroConEspinas = new Casillero(1,7,new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        optimus.transformarseAModoHumanoide();
        optimus.moverA(casilleroFinal,optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 450);

    }

    @Test
    public void bumblebeePierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,6);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Bumblebee bumblebee = new Bumblebee(casilleroInicial);

        bumblebee.moverA(casilleroFinal,bumblebee);

        Assert.assertTrue(bumblebee.obtenerPuntosDeVida() == 332.5);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);
        casilleroConEspinas = new Casillero(1,7, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        bumblebee.transformarseAModoHumanoide();
        bumblebee.moverA(casilleroFinal,bumblebee);

        Assert.assertTrue(bumblebee.obtenerPuntosDeVida() == 315);


    }

    @Test
    public void frenzyPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,7);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Frenzy frenzy= new Frenzy(casilleroInicial);

        frenzy.moverA(casilleroFinal,frenzy);

        Assert.assertTrue(frenzy.obtenerPuntosDeVida() == 380);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);
        casilleroConEspinas = new Casillero(1,8, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        frenzy.transformarseAModoHumanoide();
        frenzy.moverA(casilleroFinal,frenzy);

        Assert.assertTrue(frenzy.obtenerPuntosDeVida() == 360);

    }

    @Test
    public void bonecrusherPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Bonecrusher bonecrusher= new Bonecrusher(casilleroInicial);

        bonecrusher.moverA(casilleroFinal,bonecrusher);

        Assert.assertTrue(bonecrusher.obtenerPuntosDeVida() == 190);

        casilleroConEspinas = new Casillero(1,10, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        bonecrusher.transformarseAModoHumanoide();
        bonecrusher.moverA(casilleroFinal,bonecrusher);

        Assert.assertTrue(bonecrusher.obtenerPuntosDeVida() == 180);


    }


    @Test
    public void testAlgoformerEnEstadoAlternoAereoAtraviesaSinProblemasPorZonaDeEspinas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConPantano = new Casillero(1, 3,  new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal,megatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);


    }

    @Test
    public void testAlgoFormerEnEstadoAereoPierdeCuarentaPorCientoDeAtaqueAlAtravesarUnaTormentaPsionica(){


        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConTormenta = new Casillero(1, 3,  new TormentaPsionica(), new Roca(), null);
        Juego.getInstance().modificarCasillero(casilleroConTormenta);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal,megatron);

        Assert.assertTrue(megatron.obtenerAtaque() == 33);

    }

    @Test(expected= AlgoFormerInhabilitadoPorEsteTurno.class)
    public void algoFormerEnEstadoAlternoAereoQuedaAtrapadoEnNebulosaDeAndromedaPorTresTurnos(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1, 1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialBonecrusher = Juego.getInstance().obtenerCasillero(20, 20);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicialBonecrusher);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroDestinoBonecrusher = Juego.getInstance().obtenerCasillero(20,12);
        Casillero casilleroConNebulosa = new Casillero(1, 3, new NebulosaDeAndromeda(), new Roca(), null);
        Juego.getInstance().modificarCasillero(casilleroConNebulosa);
        Casillero casilleroFinalMegatron = Juego.getInstance().obtenerCasillero(1, 3);

        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(bonecrusher);
        decepticons.add(null);

        Jugador jugador = new JugadorDecepticon(decepticons);

        jugador.seleccionarAlgoformer(megatron);
        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinalMegatron);

        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinalMegatron);

        jugador.seleccionarAlgoformer(bonecrusher);
        jugador.mover(casilleroDestinoBonecrusher);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinalMegatron);

        jugador.seleccionarAlgoformer(megatron);
        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinalMegatron);

        jugador.mover(casilleroDestinoMegatron);

        casilleroFinalMegatron = casilleroDestinoMegatron;

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinalMegatron);

    }

    @Test
    public void bonusDobleCanionFuncionaCorrectamente(){

        Juego.getInstance().generarTablero(10,10,false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1,1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialOptimus = Juego.getInstance().obtenerCasillero(1,5);
        Optimus optimus = new Optimus(casilleroInicialOptimus);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,3);
        Casillero casilleroConBonusDobleCanion = new Casillero(1,2, new Nube(), new Roca(), new DobleCanion());
        Juego.getInstance().modificarCasillero(casilleroConBonusDobleCanion);

        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(null);
        decepticons.add(null);

        Jugador jugador = new JugadorDecepticon(decepticons);

        jugador.seleccionarAlgoformer(megatron);
        jugador.mover(casilleroDestinoMegatron);
        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 390);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 280);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 170);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 115);


    }

    @Test
    public void bonusDobleCanionFuncionaCorrectamenteEnModoHumanoide() {

        Juego.getInstance().generarTablero(10, 10, false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1, 1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialOptimus = Juego.getInstance().obtenerCasillero(1, 4);
        Optimus optimus = new Optimus(casilleroInicialOptimus);

        Casillero casilleroConBonusDobleCanion = new Casillero(1, 2,new Nube(), new Roca(), new DobleCanion());
        Juego.getInstance().modificarCasillero(casilleroConBonusDobleCanion);
        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1, 2);

        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(null);
        decepticons.add(null);

        Jugador jugador = new JugadorDecepticon(decepticons);

        jugador.seleccionarAlgoformer(megatron);
        jugador.transformar();
        jugador.mover(casilleroDestinoMegatron);
        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 480);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 460);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 440);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 430);


    }

    @Test
    public void bonusBurbujaInmaculadaFuncionaCorrectamente(){

        Juego.getInstance().generarTablero(10,10,false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1,1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialOptimus = Juego.getInstance().obtenerCasillero(1,5);
        Optimus optimus = new Optimus(casilleroInicialOptimus);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,3);
        Casillero casilleroConBonusDobleCanion = new Casillero(1,2,new Nube(), new Roca(), new BurbujaInmaculada());
        Juego.getInstance().modificarCasillero(casilleroConBonusDobleCanion);

        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(null);
        decepticons.add(null);


        Jugador jugadorDecepticon = new JugadorDecepticon(decepticons);

        jugadorDecepticon.seleccionarAlgoformer(megatron);
        jugadorDecepticon.mover(casilleroDestinoMegatron);

        optimus.atacarA(megatron);
        jugadorDecepticon.transformar();

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 550);

        optimus.atacarA(megatron);
        jugadorDecepticon.transformar();

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 550);

        optimus.atacarA(megatron);

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 535);

    }

    @Test
    public void bonusFlashFuncionaCorrectamente(){

        Juego.getInstance().generarTablero(50,50,false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1,1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialBonecrusher = Juego.getInstance().obtenerCasillero(50,50);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicialBonecrusher);


        Casillero casilleroConBonusFlash = new Casillero(1,2,new Nube(), new Roca(), new Flash());
        Juego.getInstance().modificarCasillero(casilleroConBonusFlash);
        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,2);


        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(bonecrusher);
        decepticons.add(null);

        Jugador jugador = new JugadorDecepticon(decepticons);

        jugador.seleccionarAlgoformer(megatron);

        jugador.mover(casilleroDestinoMegatron);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,23);

        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador.seleccionarAlgoformer(bonecrusher);
        Casillero casilleroDestinoBonecrusher = Juego.getInstance().obtenerCasillero(50,45);
        jugador.mover(casilleroDestinoBonecrusher);

        jugador.seleccionarAlgoformer(megatron);
        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,44);
        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,34);

        jugador.mover(casilleroDestinoMegatron);

        Assert.assertNotEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

    }

    @Test
    public void bonusFlashFuncionaCorrectamenteEnModoHumanoide(){

        Juego.getInstance().generarTablero(50,50,false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1,1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialBonecrusher = Juego.getInstance().obtenerCasillero(50,50);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicialBonecrusher);


        Casillero casilleroConBonusFlash = new Casillero(1,2,new Nube(), new Roca(), new Flash());
        Juego.getInstance().modificarCasillero(casilleroConBonusFlash);
        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,2);


        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(bonecrusher);
        decepticons.add(null);

        Jugador jugador = new JugadorDecepticon(decepticons);

        jugador.seleccionarAlgoformer(megatron);

        jugador.transformar();

        jugador.mover(casilleroDestinoMegatron);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,5);

        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador.seleccionarAlgoformer(bonecrusher);
        Casillero casilleroDestinoBonecrusher = Juego.getInstance().obtenerCasillero(50,45);
        jugador.mover(casilleroDestinoBonecrusher);

        jugador.seleccionarAlgoformer(megatron);
        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,8);
        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,10);

        jugador.mover(casilleroDestinoMegatron);

        Assert.assertNotEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);


    }

    @Test
    public void bonusFlashFuncionaCorrectamenteAlternandoEstados(){

        Juego.getInstance().generarTablero(50,50,false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1,1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialBonecrusher = Juego.getInstance().obtenerCasillero(50,50);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicialBonecrusher);


        Casillero casilleroConBonusFlash = new Casillero(1,2,new Nube(), new Roca(), new Flash());
        Juego.getInstance().modificarCasillero(casilleroConBonusFlash);
        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,2);


        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(bonecrusher);
        decepticons.add(null);

        Jugador jugador = new JugadorDecepticon(decepticons);

        jugador.seleccionarAlgoformer(megatron);

        jugador.transformar();

        jugador.mover(casilleroDestinoMegatron);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,5);

        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador.transformar();

        casilleroConBonusFlash = new Casillero(1,26,new Nube(), new Roca(), new Flash());
        Juego.getInstance().modificarCasillero(casilleroConBonusFlash);

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,26);
        jugador.mover(casilleroDestinoMegatron);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

        jugador.transformar();

        casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1,30);
        jugador.mover(casilleroDestinoMegatron);

        Assert.assertNotEquals(megatron.obtenerCasillero(), casilleroDestinoMegatron);

    }


    @Test
    public void sePierdeReferenciaDobleEntreElCasilleroYElAlgoformerAlMorirUnAlgoformerPorRecibirDaniosPorEspinas(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicialOptimus = Juego.getInstance().obtenerCasillero(2,1);
        Optimus optimus = new Optimus(casilleroInicialOptimus);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1,1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        while (optimus.obtenerPuntosDeVida() > 25){

            megatron.atacarA(optimus);

        }

        Casillero casilleroConEspinas1 = new Casillero(2,2,new Nube(),new Espinas(),null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas1);

        Casillero casilleroFinalOptimus = Juego.getInstance().obtenerCasillero(2,6);
        optimus.moverA(casilleroFinalOptimus,optimus);

        Assert.assertTrue(optimus.obtenerCasillero() == null && casilleroFinalOptimus.obtenerAlgoformer() == null);

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

    @Test
    public void algoformersSeCombinanCorrectamnete(){

        Juego.getInstance().iniciarJuego();

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(megatron);

        Juego.getInstance().obtenerJugadorActual().combinarAlgoformers();

        int numero = 6;


    }

    @Test
    public void algoFormerCombinadoSeDescombinaCorrectamente(){

        Juego.getInstance().iniciarJuego();

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(megatron);
        Juego.getInstance().obtenerJugadorActual().combinarAlgoformers();

        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(optimus);
        Juego.getInstance().obtenerJugadorActual().transformar();

        AlgoFormer menasor = Juego.getInstance().obtenerJugadorActual().obtenerCombinado();
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(menasor);
        Casillero casilleroDestinoMenasor = Juego.getInstance().obtenerCasillero(10,9);
        Juego.getInstance().obtenerJugadorActual().mover(casilleroDestinoMenasor); //1 TURNO PERDIDO


        /*Casillero casilleroDestinoOptimus = Juego.getInstance().obtenerCasillero(2,1);
        Juego.getInstance().obtenerJugadorActual().mover(casilleroDestinoOptimus);

        casilleroDestinoMenasor = Juego.getInstance().obtenerCasillero(10,8);
        Juego.getInstance().obtenerJugadorActual().mover(casilleroDestinoMenasor); //2 TURNO PERDIDOS

        casilleroDestinoOptimus = Juego.getInstance().obtenerCasillero(3,1);
        Juego.getInstance().obtenerJugadorActual().mover(casilleroDestinoOptimus);

        casilleroDestinoMenasor = Juego.getInstance().obtenerCasillero(10,7);
        Juego.getInstance().obtenerJugadorActual().mover(casilleroDestinoMenasor); //3 TURNO PERDIDOS
*/
        int numero = 9;


    }









}


