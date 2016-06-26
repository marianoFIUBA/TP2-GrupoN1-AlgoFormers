package fiuba.algo3.modelo.algoformers;

import modelo.*;
import modelo.algoformers.*;
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
    public void testOptimusAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);

        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);

        Optimus optimus = new Optimus(casilleroInicial); //Los algoformers se crean en estado ALTERNO.

        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 15 && optimus.obtenerVelocidad() == 5 && optimus.getPuntosDeVida() == 500);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        optimus.transformarseAModoHumanoide();

        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 50 && optimus.obtenerVelocidad() == 2 && optimus.getPuntosDeVida() == 500);


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

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        bumblebee.transformarseAModoHumanoide();

        bumblebee.moverA(casilleroFinal);

        Assert.assertEquals(bumblebee.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(bumblebee.obtenerAtaque() == 40 && bumblebee.obtenerVelocidad() == 2 && bumblebee.getPuntosDeVida() == 350);



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

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        ratchet.transformarseAModoHumanoide();

        ratchet.moverA(casilleroFinal);

        Assert.assertEquals(ratchet.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(ratchet.obtenerAtaque() == 5 && ratchet.obtenerVelocidad() == 1 && ratchet.getPuntosDeVida() == 150);


    }

    @Test
    public void superionAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,4);
        Superion superion = new Superion(casilleroInicial, 100);

        superion.moverA(casilleroFinal);

        Assert.assertEquals(superion.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(superion.obtenerAtaque() == 100 && superion.obtenerVelocidad() == 3 && superion.getPuntosDeVida() == 100);

    }

    @Test
    public void menasorAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,3);
        Menasor menasor = new Menasor(casilleroInicial, 100);

        menasor.moverA(casilleroFinal);

        Assert.assertEquals(menasor.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(menasor.obtenerAtaque() == 115 && menasor.obtenerVelocidad() == 2 && menasor.getPuntosDeVida() == 100);

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

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        megatron.transformarseAModoHumanoide();

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(megatron.obtenerAtaque() == 10 && megatron.obtenerVelocidad() == 1 && megatron.getPuntosDeVida() == 550);

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

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        bonecrusher.transformarseAModoHumanoide();

        bonecrusher.moverA(casilleroFinal);

        Assert.assertEquals(bonecrusher.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(bonecrusher.obtenerAtaque() == 30 && bonecrusher.obtenerVelocidad() == 1 && bonecrusher.getPuntosDeVida() == 200);

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

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);

        frenzy.transformarseAModoHumanoide();

        frenzy.moverA(casilleroFinal);

        Assert.assertEquals(frenzy.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(frenzy.obtenerAtaque() == 10 && frenzy.obtenerVelocidad() == 2 && frenzy.getPuntosDeVida() == 400);


    }


    @Test
    public void testAlgoformerEnEstadoAlternoTerrestreTardaElDobleAlPasarPorZonaPantanosa() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(1, 6);    //El algoformer en estado ALTERNO TERRESTRE pierde 2 puntos de velocidad en la zona pantanosa, por eso no llega al destino deseado.
        Casillero casilleroConPantano = new Casillero(1, 5, "NUBE", "PANTANO");
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 5);  //Se modifica un casillero del tablero por un casillero con zona pantanosa.
        Optimus optimus = new Optimus(casilleroInicial);    //Optimus se crea en estado ALTERNO TERRESTRE.

        optimus.moverA(casilleroDestino);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertEquals(casilleroFinal.obtenerAlgoformer(), optimus);


    }

    @Test
    public void algoformerEnEstadoHumanoideNoPuedeAtravesarZonaPantanosa(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(1,3);
        Casillero casilleroConPantano = new Casillero (1,2,"NUBE","PANTANO");
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,2);
        Optimus optimus = new Optimus(casilleroInicial);

        optimus.transformarseAModoHumanoide();
        optimus.moverA(casilleroDestino);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertEquals(casilleroFinal.obtenerAlgoformer(), optimus);

        optimus.moverA(casilleroDestino);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertEquals(casilleroFinal.obtenerAlgoformer(), optimus);


    }



    @Test
    public void testAlgoformerEnEstadoAlternoAereoAtraviesaSinProblemasPorZonaPantanosa() {

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
    public void optimusPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,6);
        Casillero casilleroConEspinas = new Casillero(1,2,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Optimus optimus = new Optimus(casilleroInicial);

        optimus.moverA(casilleroFinal);

        Assert.assertTrue(optimus.getPuntosDeVida() == 475);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);
        casilleroConEspinas = new Casillero(1,7,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        optimus.transformarseAModoHumanoide();
        optimus.moverA(casilleroFinal);

        Assert.assertTrue(optimus.getPuntosDeVida() == 450);

    }

    @Test
    public void bumblebeePierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,6);
        Casillero casilleroConEspinas = new Casillero(1,2,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Bumblebee bumblebee = new Bumblebee(casilleroInicial);

        bumblebee.moverA(casilleroFinal);

        Assert.assertTrue(bumblebee.getPuntosDeVida() == 332.5);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);
        casilleroConEspinas = new Casillero(1,7,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        bumblebee.transformarseAModoHumanoide();
        bumblebee.moverA(casilleroFinal);

        Assert.assertTrue(bumblebee.getPuntosDeVida() == 315);


    }

    @Test
    public void frenzyPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,7);
        Casillero casilleroConEspinas = new Casillero(1,2,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Frenzy frenzy= new Frenzy(casilleroInicial);

        frenzy.moverA(casilleroFinal);

        Assert.assertTrue(frenzy.getPuntosDeVida() == 380);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);
        casilleroConEspinas = new Casillero(1,8,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        frenzy.transformarseAModoHumanoide();
        frenzy.moverA(casilleroFinal);

        Assert.assertTrue(frenzy.getPuntosDeVida() == 360);

    }

    @Test
    public void bonecrusherPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);
        Casillero casilleroConEspinas = new Casillero(1,2,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Bonecrusher bonecrusher= new Bonecrusher(casilleroInicial);

        bonecrusher.moverA(casilleroFinal);

        Assert.assertTrue(bonecrusher.getPuntosDeVida() == 190);

        casilleroConEspinas = new Casillero(1,10,"NUBE","ESPINAS");
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        bonecrusher.transformarseAModoHumanoide();
        bonecrusher.moverA(casilleroFinal);

        Assert.assertTrue(bonecrusher.getPuntosDeVida() == 180);


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
    public void testAlgoFormerEnEstadoAereoPierdeCuarentaPorCientoDeAtaqueAlAtravesarUnaTormentaPsionica(){


        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConTormenta = new Casillero(1, 3, "TORMENTA", "ROCOSA");
        Juego.getInstance().modificarCasillero(casilleroConTormenta);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertTrue(megatron.obtenerAtaque() == 33);

    }

    @Test
    public void algoFormerEnEstadoAlternoAereoQuedaAtrapadoEnNebulosaDeAndromedaPorTresTurnos(){

        Juego.getInstance().generarTablero(20,20,false);

        Casillero casilleroInicialMegatron = Juego.getInstance().obtenerCasillero(1, 1);
        Megatron megatron = new Megatron(casilleroInicialMegatron);

        Casillero casilleroInicialBonecrusher = Juego.getInstance().obtenerCasillero(20, 20);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicialBonecrusher);

        Casillero casilleroDestinoMegatron = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroDestinoBonecrusher = Juego.getInstance().obtenerCasillero(20,12);
        Casillero casilleroConNebulosa = new Casillero(1, 3, "NEBULOSA", "ROCOSA");
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
        Casillero casilleroConBonusDobleCanion = new Casillero(1,2,"NUBE","ROCOSA","CANION");
        Juego.getInstance().modificarCasillero(casilleroConBonusDobleCanion);

        ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
        decepticons.add(megatron);
        decepticons.add(null);
        decepticons.add(null);

        Jugador jugador = new JugadorDecepticon(decepticons);

        jugador.seleccionarAlgoformer(megatron);
        jugador.mover(casilleroDestinoMegatron);
        jugador.atacar(optimus);

        Assert.assertTrue(optimus.getPuntosDeVida() == 390);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.getPuntosDeVida() == 280);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.getPuntosDeVida() == 170);

        jugador.atacar(optimus);

        Assert.assertTrue(optimus.getPuntosDeVida() == 115);


    }



}


