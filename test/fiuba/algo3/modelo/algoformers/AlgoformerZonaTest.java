package fiuba.algo3.modelo.algoformers;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Excepciones.AlgoFormerAtrapadoEnNebulosaNoSePuedeMoverException;
import modelo.Juego;
import modelo.Jugador;
import modelo.algoformers.autobots.Bumblebee;
import modelo.algoformers.autobots.Optimus;
import modelo.algoformers.autobots.Ratchet;
import modelo.algoformers.autobots.Superion;
import modelo.algoformers.decepticons.Bonecrusher;
import modelo.algoformers.decepticons.Frenzy;
import modelo.algoformers.decepticons.Megatron;
import modelo.algoformers.decepticons.Menasor;
import modelo.zonas.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 10/7/2016.
 */
public class AlgoformerZonaTest {


    //En esta clase se busca probar con tests de integración, la interaccion de los algoformers con los tipos de zonas que tengan los casilleros que ocupen.


    //----------------------------------------------------------ZONA ROCOSA----------------------------------------------------------------

    //AUTOBOTS

    @Test
    public void testOptimusAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);

        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);

        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);

        Optimus optimus = new Optimus(casilleroInicial); //Los algoformers se crean en estados ALTERNO.

        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 15 && optimus.obtenerVelocidad() == 5 && optimus.obtenerPuntosDeVida() == 500);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        optimus.transformarseAModoHumanoide();

        optimus.moverA(casilleroFinal);

        Assert.assertEquals(optimus.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(optimus.obtenerAtaque() == 50 && optimus.obtenerVelocidad() == 2 && optimus.obtenerPuntosDeVida() == 500);

    }

    @Test
    public void testBumblebeeAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 6);
        Bumblebee bumblebee = new Bumblebee(casilleroInicial);

        bumblebee.moverA(casilleroFinal);

        Assert.assertEquals(bumblebee.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(bumblebee.obtenerAtaque() == 20 && bumblebee.obtenerVelocidad() == 5 && bumblebee.obtenerPuntosDeVida() == 350);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);

        bumblebee.transformarseAModoHumanoide();

        bumblebee.moverA(casilleroFinal);

        Assert.assertEquals(bumblebee.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(bumblebee.obtenerAtaque() == 40 && bumblebee.obtenerVelocidad() == 2 && bumblebee.obtenerPuntosDeVida() == 350);


    }

    @Test
    public void testRatchetAtarviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Ratchet ratchet = new Ratchet(casilleroInicial);

        ratchet.moverA(casilleroFinal);

        Assert.assertEquals(ratchet.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(ratchet.obtenerAtaque() == 35 && ratchet.obtenerVelocidad() == 8 && ratchet.obtenerPuntosDeVida() == 150);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        ratchet.transformarseAModoHumanoide();

        ratchet.moverA(casilleroFinal);

        Assert.assertEquals(ratchet.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(ratchet.obtenerAtaque() == 5 && ratchet.obtenerVelocidad() == 1 && ratchet.obtenerPuntosDeVida() == 150);

    }

    @Test
    public void superionAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,4);
        Superion superion = new Superion(casilleroInicial, 100);

        superion.moverA(casilleroFinal);

        Assert.assertEquals(superion.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(superion.obtenerAtaque() == 100 && superion.obtenerVelocidad() == 3 && superion.obtenerPuntosDeVida() == 100);

    }


    //DECEPTICONS

    @Test
    public void menasorAtarviesaZonaRocosaSinProblemas(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,3);
        Menasor menasor = new Menasor(casilleroInicial, 100);

        menasor.moverA(casilleroFinal);

        Assert.assertEquals(menasor.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(menasor.obtenerAtaque() == 115 && menasor.obtenerVelocidad() == 2 && menasor.obtenerPuntosDeVida() == 100);

    }

    @Test
    public void testMegatronAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(megatron.obtenerAtaque() == 55 && megatron.obtenerVelocidad() == 8 && megatron.obtenerPuntosDeVida() == 550);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        megatron.transformarseAModoHumanoide();

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(megatron.obtenerAtaque() == 10 && megatron.obtenerVelocidad() == 1 && megatron.obtenerPuntosDeVida() == 550);

    }

    @Test
    public void testBonecrusherAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicial);

        bonecrusher.moverA(casilleroFinal);

        Assert.assertEquals(bonecrusher.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(bonecrusher.obtenerAtaque() == 30 && bonecrusher.obtenerVelocidad() == 8 && bonecrusher.obtenerPuntosDeVida() == 200);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        bonecrusher.transformarseAModoHumanoide();

        bonecrusher.moverA(casilleroFinal);

        Assert.assertEquals(bonecrusher.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(bonecrusher.obtenerAtaque() == 30 && bonecrusher.obtenerVelocidad() == 1 && bonecrusher.obtenerPuntosDeVida() == 200);

    }

    @Test
    public void testFrenzyAtraviesaZonaRocosaSinProblemas() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 7);
        Frenzy frenzy = new Frenzy(casilleroInicial);

        frenzy.moverA(casilleroFinal);

        Assert.assertEquals(frenzy.obtenerCasillero(), casilleroFinal);
        Assert.assertTrue(frenzy.obtenerAtaque() == 25 && frenzy.obtenerVelocidad() == 6 && frenzy.obtenerPuntosDeVida() == 400);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);

        frenzy.transformarseAModoHumanoide();

        frenzy.moverA(casilleroFinal);

        Assert.assertEquals(frenzy.obtenerCasillero(),casilleroFinal);
        Assert.assertTrue(frenzy.obtenerAtaque() == 10 && frenzy.obtenerVelocidad() == 2 && frenzy.obtenerPuntosDeVida() == 400);


    }


    //------------------------------------------------------------------ZONA PANTANOSA-----------------------------------------------------------


    @Test
    public void testAlgoformerEnEstadoAlternoTerrestreTardaElDobleAlPasarPorZonaPantanosa() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroDestino = Juego.getInstance().obtenerCasillero(1, 9);    //El algoformer en estados ALTERNO TERRESTRE pierde 2 puntos de velocidad en la zona pantanosa, por eso no llega al destino deseado.
        Casillero casilleroConPantano = new Casillero(1, 5, new Nube(), new Pantano(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 8);  //Se modifica un casillero del tablero por un casillero con zona pantanosa.
        Bonecrusher bonecrusher = new Bonecrusher(casilleroInicial);    //Optimus se crea en estados ALTERNO TERRESTRE.

        bonecrusher.moverA(casilleroDestino);

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
        Casillero casilleroConPantano = new Casillero(1, 3,new Nube(), new Pantano(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);


    }


    //-------------------------------------------------------ZONA DE ESPINAS-------------------------------------------------------

    //AUTOBOTS CON ESTADO ALTERNO TERRESTRE

    @Test
    public void optimusPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,6);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Optimus optimus = new Optimus(casilleroInicial);

        optimus.moverA(casilleroFinal);

        Assert.assertTrue(optimus.obtenerPuntosDeVida() == 475);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);
        casilleroConEspinas = new Casillero(1,7,new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        optimus.transformarseAModoHumanoide();
        optimus.moverA(casilleroFinal);

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

        bumblebee.moverA(casilleroFinal);

        Assert.assertTrue(bumblebee.obtenerPuntosDeVida() == 332.5);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,8);
        casilleroConEspinas = new Casillero(1,7, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        bumblebee.transformarseAModoHumanoide();
        bumblebee.moverA(casilleroFinal);

        Assert.assertTrue(bumblebee.obtenerPuntosDeVida() == 315);


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
        optimus.moverA(casilleroFinalOptimus);

        Assert.assertTrue(optimus.obtenerCasillero() == null && casilleroFinalOptimus.obtenerAlgoformer() == null);

    }

    //RATCHET (ALGOFORMER CON ESTADO ALTERNO, SE PRUEBA LA PERDIDA DE PUNTOS DE VIDA EN MODO HUMANOIDE Y QUE EN MODO ALTERNO NO TIENE PROBLEMAS)

    @Test
    public void ratchetPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinasEnModoHumanoide(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,2);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Ratchet ratchet = new Ratchet(casilleroInicial);

        ratchet.transformarseAModoHumanoide();

        ratchet.moverA(casilleroFinal);

        Assert.assertTrue(ratchet.obtenerPuntosDeVida() == 142.5);

    }

    @Test
    public void ratchetAtraviesaZonaDeEspinasSinProblemasEnModoAlterno(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConPantano = new Casillero(1, 3,  new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Ratchet ratchet = new Ratchet(casilleroInicial);

        ratchet.moverA(casilleroFinal);

        Assert.assertEquals(ratchet.obtenerCasillero(), casilleroFinal);

        Assert.assertTrue(ratchet.obtenerPuntosDeVida() == 150);


    }

    //DECEPTICONS

    @Test
    public void frenzyPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinas(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,7);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Frenzy frenzy= new Frenzy(casilleroInicial);

        frenzy.moverA(casilleroFinal);

        Assert.assertTrue(frenzy.obtenerPuntosDeVida() == 380);

        casilleroFinal = Juego.getInstance().obtenerCasillero(1,9);
        casilleroConEspinas = new Casillero(1,8, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);

        frenzy.transformarseAModoHumanoide();
        frenzy.moverA(casilleroFinal);

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

        bonecrusher.moverA(casilleroFinal);

        Assert.assertTrue(bonecrusher.obtenerPuntosDeVida() == 190);

        casilleroConEspinas = new Casillero(1,10, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        casilleroFinal = Juego.getInstance().obtenerCasillero(1,10);

        bonecrusher.transformarseAModoHumanoide();
        bonecrusher.moverA(casilleroFinal);

        Assert.assertTrue(bonecrusher.obtenerPuntosDeVida() == 180);


    }

    //MEGATRON (ALGOFORMER CON ESTADO ALTERNO, SE PRUEBA LA PERDIDA DE PUNTOS DE VIDA EN MODO HUMANOIDE Y QUE EN MODO ALTERNO NO TIENE PROBLEMAS)

    @Test
    public void megatronPierdeUnCincoPorCientoDeVidaAlAtravesarZonaDeEspinasEnModoHumanoide(){

        Juego.getInstance().generarTablero(20,20,false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1,1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1,2);
        Casillero casilleroConEspinas = new Casillero(1,2, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConEspinas);
        Megatron megatron= new Megatron(casilleroInicial);

        megatron.transformarseAModoHumanoide();

        megatron.moverA(casilleroFinal);

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 522.5);

    }

    @Test
    public void megatronAtraviesaZonaDeEspinasSinProblemasEnModoAlterno() {

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConPantano = new Casillero(1, 3, new Nube(), new Espinas(), null);
        Juego.getInstance().modificarCasillero(casilleroConPantano);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertEquals(megatron.obtenerCasillero(), casilleroFinal);

        Assert.assertTrue(megatron.obtenerPuntosDeVida() == 550);

    }

    //---------------------------------------------ZONA CON TORMENTA PSIONICA---------------------------------------------

    //SE PRUEBA QUE UN ALGOFORMER EN ESTADO ALTERNO (MEGATRON) PIERDE PUNTOS DE ATAQUE LUEGO DE ATRAVESAR ESTE TIPO DE ZONA.

    @Test
    public void testAlgoFormerEnEstadoAereoPierdeCuarentaPorCientoDeAtaqueAlAtravesarUnaTormentaPsionica(){

        Juego.getInstance().generarTablero(20, 20, false);
        Casillero casilleroInicial = Juego.getInstance().obtenerCasillero(1, 1);
        Casillero casilleroFinal = Juego.getInstance().obtenerCasillero(1, 9);
        Casillero casilleroConTormenta = new Casillero(1, 3,  new TormentaPsionica(), new Roca(), null);
        Juego.getInstance().modificarCasillero(casilleroConTormenta);
        Megatron megatron = new Megatron(casilleroInicial);

        megatron.moverA(casilleroFinal);

        Assert.assertTrue(megatron.obtenerAtaque() == 33);

        casilleroConTormenta = new Casillero(1, 10,  new TormentaPsionica(), new Roca(), null);
        casilleroFinal = Juego.getInstance().obtenerCasillero(1, 12);

        megatron.moverA(casilleroFinal);

        Assert.assertTrue(megatron.obtenerAtaque() == 33);  //Con este Assert se prueba que el algoformer no vuelve a perder puntos de ataque por atravezar una tormenta psionica si ya ha atravesado una.

    }

    //-------------------------------------ZONA CON NEBULOSA DE ANDROMEDA-----------------------------------------------

    @Test(expected= AlgoFormerAtrapadoEnNebulosaNoSePuedeMoverException.class)
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





    }



















}
