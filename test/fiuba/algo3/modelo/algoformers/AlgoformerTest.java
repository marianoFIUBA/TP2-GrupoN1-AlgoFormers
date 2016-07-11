package fiuba.algo3.modelo.algoformers;

import modelo.*;
import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;
import modelo.Excepciones.AlgoFormerInhabilitadoPorEsteTurno;
import modelo.Excepciones.AutobotNoPuedeAtacarAOtroAutobot;
import modelo.Excepciones.MovimientoInvalidoException;
import modelo.algoformers.autobots.Bumblebee;
import modelo.algoformers.autobots.Optimus;
import modelo.algoformers.autobots.Ratchet;
import modelo.algoformers.autobots.Superion;
import modelo.algoformers.decepticons.Bonecrusher;
import modelo.algoformers.decepticons.Frenzy;
import modelo.algoformers.decepticons.Megatron;
import modelo.algoformers.decepticons.Menasor;
import modelo.bonus.BurbujaInmaculada;
import modelo.bonus.DobleCanion;
import modelo.bonus.Flash;
import modelo.zonas.*;
import org.junit.Assert;
import org.junit.Test;


public class AlgoformerTest {

    @Test
    public void algoformerSeMueveACasilleroEperado() {

        /*  Se genera tablero de 5x5 casilleros. El tercer parámetro indica que no deben generarse
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

    /*@Test
    public void testOptimusAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);

        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);

        Optimus optimus = new Optimus(casilleroInicial); //Los algoformers se crean en estados ALTERNO.

        optimus.moverA(casilleroFinal,optimus);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 15 && optimus.obtenerVelocidad() == 5 && optimus.obtenerPuntosDeVida() == 500);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        optimus.transformarseAModoHumanoide();

        optimus.moverA(casilleroFinal,optimus);

        Assert.assertEquals(optimus.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 50 && optimus.obtenerVelocidad() == 2 && optimus.obtenerPuntosDeVida() == 500);

    }*/

    /*@Test
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


    }*/

    /*@Test
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

    }*/

   /* @Test
    public void superionAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,4);
        Superion superion = new Superion(casilleroInicial, 100);

        superion.moverA(casilleroFinal,superion);

        Assert.assertEquals(superion.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(superion.obtenerAtaque() == 100 && superion.obtenerVelocidad() == 3 && superion.obtenerPuntosDeVida() == 100);

    }*/

    /*@Test
    public void menasorAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,3);
        Menasor menasor = new Menasor(casilleroInicial, 100);

        menasor.moverA(casilleroFinal,menasor);

        Assert.assertEquals(menasor.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(menasor.obtenerAtaque() == 115 && menasor.obtenerVelocidad() == 2 && menasor.obtenerPuntosDeVida() == 100);

    }*/

    /*@Test
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

    }*/

    /*@Test
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

    }*/

    /*@Test
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


    }*/


    /*@Test
    public void testAlgoformerEnEstadoAlternoTerrestreTardaElDobleAlPasarPorZonaPantanosa() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(1, 9);    //El algoformer en estados ALTERNO TERRESTRE pierde 2 puntos de velocidad en la zona pantanosa, por eso no llega al destino deseado.
        Casillero casilleroConPantano = new Casillero(1, 5, new Nube(), new Pantano(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 8);  //Se modifica un casillero del tablero por un casillero con zona pantanosa.
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicial);    //Optimus se crea en estados ALTERNO TERRESTRE.

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


    }*/

    /*@Test
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


    }*/

    /*@Test
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


    }*/

    /*@Test
    public void testAlgoFormerEnEstadoAereoPierdeCuarentaPorCientoDeAtaqueAlAtravesarUnaTormentaPsionica(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConTormenta = new Casillero(1, 3,  new TormentaPsionica(), new Roca(), null);
        Juego.getInstance().modificarCasillero(casilleroConTormenta);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal,megatron);

        Assert.assertTrue(megatron.obtenerAtaque() == 33);

    }*/

    /*@Test(expected= AlgoFormerInhabilitadoPorEsteTurno.class)
    public void algoFormerEnEstadoAlternoAereoQuedaAtrapadoEnNebulosaDeAndromedaPorTresTurnos(){

        Juego.getInstance().iniciarJuego();
        Juego.getInstance().normalizarTablero();

        Jugador jugador1 = Juego.getInstance().obtenerJugadorActual();

        Casillero casilleroConNebulosa = new Casillero(24,24,new NebulosaDeAndromeda(),new Roca(),null);
        Juego.getInstance().modificarCasillero(casilleroConNebulosa);

        AlgoFormer megatron = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroConNebulosa);

        Jugador jugador2 = Juego.getInstance().obtenerJugadorActual();

        AlgoFormer optimus = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformer1();

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(23,24);

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestino);
        Assert.assertEquals(megatron.obtenerCasillero(), casilleroConNebulosa);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestino);
        Assert.assertEquals(megatron.obtenerCasillero(), casilleroConNebulosa);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestino);
        Assert.assertEquals(megatron.obtenerCasillero(), casilleroConNebulosa);

        jugador2.seleccionarAlgoformer(optimus);
        jugador2.transformar();

        jugador1.seleccionarAlgoformer(megatron);
        jugador1.mover(casilleroDestino);
        Assert.assertNotEquals(megatron.obtenerCasillero(), casilleroConNebulosa);

    }*/

    /*@Test
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



    }*/


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


    /*@Test(expected = MovimientoInvalidoException.class)
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

    }*/


   /* @Test
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

    }*/

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



}


