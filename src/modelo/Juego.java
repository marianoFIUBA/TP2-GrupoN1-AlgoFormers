package modelo;

import modelo.Excepciones.CasilleroNoPerteneceAlTableroException;
import modelo.algoformers.autobots.Bumblebee;
import modelo.algoformers.autobots.Optimus;
import modelo.algoformers.autobots.Ratchet;
import modelo.algoformers.decepticons.Bonecrusher;
import modelo.algoformers.decepticons.Frenzy;
import modelo.algoformers.decepticons.Megatron;
import modelo.bonus.BurbujaInmaculada;
import modelo.bonus.DobleCanion;
import modelo.bonus.Flash;
import modelo.zonas.*;
import org.json.simple.JSONObject;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class Juego {

    private static Juego juego;
    private HashMap<String, Casillero> casilleros;
    private boolean iniciado;
    private int[] superficiesTierra = {1, 2, 1, 3, 1, 1};
    private int[] superficiesAire = {1, 1, 1, 1, 2, 3};
    private int[] bonus = {1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 2};
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private int dimensionTableroX;
    private int dimensionTableroY;
    private ChispaSuprema chispa;

    private Casillero casilleroSeleccionado;
    private AlgoFormer algoformerObjetivo;
    private String equipoGanador;
    private boolean finalizado;

    private Juego() {

        this.iniciado = false;
        this.casilleros = new HashMap<String, Casillero>();
    }

    public static Juego getInstance() {

        if (juego == null) {

            juego = new Juego();
        }
        return juego;
    }

    private void guardarCasilleros(ArrayList<Casillero> casilleros) {

        ListIterator<Casillero> iteradorCasilleros = casilleros.listIterator();
        Casillero actual;

        while (iteradorCasilleros.hasNext()) {

            actual = iteradorCasilleros.next();
            String clave = String.valueOf(actual.obtenerPosicionX()) + "." + String.valueOf(actual.obtenerPosicionY());
            this.casilleros.put(clave, actual);
        }
    }

    public Casillero obtenerCasillero(int posicionX, int posicionY) {

        String clave = String.valueOf(posicionX) + "." + String.valueOf(posicionY);
        try {
            return this.casilleros.get(clave);
        } catch (NullPointerException ex) {
            throw new CasilleroNoPerteneceAlTableroException();
        }
    }

    public void iniciarJuego() {

        this.finalizado = false;
        //if (!this.iniciado) {

            if (true) {

            ArrayList<Casillero> casilleros = this.generarCasillerosDesdeJSON();
            Optimus optimus = new Optimus(casilleros.get(0));
            optimus.estado.ocuparCasillero(optimus, casilleros.get(0));

            Bumblebee bumblebee = new Bumblebee(casilleros.get(1));
            bumblebee.estado.ocuparCasillero(bumblebee, casilleros.get(1));

            Ratchet ratchet = new Ratchet(casilleros.get(2));
            ratchet.estado.ocuparCasillero(ratchet, casilleros.get(2));

            ArrayList<AlgoFormer> autobots = new ArrayList<AlgoFormer>();
            autobots.add(optimus);
            autobots.add(bumblebee);
            autobots.add(ratchet);

            Megatron megatron = new Megatron(casilleros.get(casilleros.size() - 1));
            megatron.estado.ocuparCasillero(megatron, casilleros.get(casilleros.size() - 1));

            Bonecrusher bonecrusher = new Bonecrusher(casilleros.get(casilleros.size() - 2));
            bonecrusher.estado.ocuparCasillero(bonecrusher, casilleros.get(casilleros.size() - 2));

            Frenzy frenzy = new Frenzy(casilleros.get(casilleros.size() - 3));
            frenzy.estado.ocuparCasillero(frenzy, casilleros.get(casilleros.size() - 3));

            ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();

            decepticons.add(megatron);
            decepticons.add(bonecrusher);
            decepticons.add(frenzy);

            this.jugador1 = new JugadorDecepticon(decepticons);
            this.jugador2 = new JugadorAutobot(autobots);

            this.guardarCasilleros(casilleros);
            this.jugadorActual = this.jugador1;

            CasilleroChispa casilleroChispa = new CasilleroChispa(this.generarPosicionXChispa(), this.generarPosicionYChispa());
            this.modificarCasillero(casilleroChispa);

            this.iniciado = true;
        } else {
            //lanzar excepcion de juego ya iniciado
        }
    }

    private ArrayList<Casillero> generarCasilleros(int dimesionX, int dimensionY, boolean generarSuperficiesAleatorias) {

        this.dimensionTableroX = dimesionX;
        this.dimensionTableroY = dimensionY;

        ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
        Casillero nuevoCasillero;

        for (int x = 1; x <= dimesionX; x++) {
            for (int y = 1; y <= dimensionY; y++) {

                Zona superficie = new Roca();
                Zona aire = new Nube();
                Bonus bonus = null;

                if (generarSuperficiesAleatorias && !esCasilleroInicialDeAlgoFormer(x, y, dimesionX, dimensionY)) {

                    int superficieAletoriaTierra = (int) (Math.random() * this.superficiesTierra.length + 1);
                    int superficieAleatoriaAire = (int) (Math.random() * this.superficiesAire.length + 1);
                    int bonusAleatorio = (int) (Math.random() * this.bonus.length + 1);

                    bonus = this.obtenerBonus(bonusAleatorio);
                    superficie = this.obtenerSuperficieTierra(superficieAletoriaTierra);
                    aire = this.obtenerSuperficieAire(superficieAleatoriaAire);
                }
                nuevoCasillero = new Casillero(x, y, aire, superficie, bonus);
                casilleros.add(nuevoCasillero);
            }
        }


        return casilleros;
    }

    private Bonus obtenerBonus(int tipoBonus) {

        Bonus bonus = null;
        switch (tipoBonus) {

            case 2:
                bonus = new DobleCanion();
                break;
            case 3:
                bonus = new BurbujaInmaculada();
                break;
            case 4:
                bonus = new Flash();
                break;
        }
        return null;


    }

    private boolean esCasilleroInicialDeAlgoFormer(int posicionX, int posicionY, int dimensionX, int dimensionY) {

        boolean algoFormer1 = ((posicionX == 1) && (posicionY == 1));
        boolean algoFormer2 = ((posicionX == 1) && (posicionY == 2));
        boolean algoFormer3 = ((posicionX == 1) && (posicionY == 3));

        boolean algoFormer4 = ((posicionX == dimensionX) && (posicionY == dimensionY));
        boolean algoFormer5 = ((posicionX == dimensionX) && (posicionY == dimensionY - 1));
        boolean algoFormer6 = ((posicionX == dimensionX) && (posicionY == dimensionY - 2));

        return (algoFormer1 || algoFormer2 || algoFormer3 || algoFormer4 || algoFormer5 || algoFormer6);

    }


    private Zona obtenerSuperficieTierra(int tipo) {

        Zona superficieTierra = new Roca();

        switch (tipo) {

            case 2:
                superficieTierra = new Pantano();
                break;
            case 3:
                superficieTierra = new Espinas();
                break;
        }
        return superficieTierra;
    }

    private Zona obtenerSuperficieAire(int tipo) {

        Zona zonaAerea = new Nube();

        switch (tipo) {
            case 2:
                zonaAerea = new NebulosaDeAndromeda();
                break;
            case 3:
                zonaAerea = new TormentaPsionica();
                break;
        }
        return zonaAerea;
    }

    public void pasarTurno() {

        if (this.jugadorActual.equals(this.jugador1)) {

            this.jugadorActual = this.jugador2;

        } else {

            this.jugadorActual = this.jugador1;

        }

    }

    public Jugador obtenerJugador1() {

        return this.jugador1;
    }

    public Jugador obtenerJugador2() {

        return this.jugador2;
    }

    public void generarTablero(int dimesionX, int dimensionY, boolean generarSuperficiesAleatorias) {

        ArrayList<Casillero> casilleros = new ArrayList<Casillero>();

        casilleros = this.generarCasilleros(dimesionX, dimensionY, generarSuperficiesAleatorias);
        this.guardarCasilleros(casilleros);
    }

    public void modificarCasillero(Casillero casillero) {

        String clave = String.valueOf(casillero.obtenerPosicionX()) + "." + String.valueOf(casillero.obtenerPosicionY());
        try {
            this.casilleros.replace(clave, casillero);
        } catch (NullPointerException ex) {

            throw new CasilleroNoPerteneceAlTableroException();
        }
    }

    public HashMap<String, Casillero> obtenerCasilleros() {

        return this.casilleros;
    }

    public Casillero obtenerCasilleroAleatorio() {

        int posicionX = (int) (Math.random() * this.dimensionTableroX);
        int posicionY = (int) (Math.random() * this.dimensionTableroY);

        return this.obtenerCasillero(posicionX, posicionY);
    }

    public void asignarChispaAAlgoformer(AlgoFormer algoFormer) {

        if (this.chispa.getCasillero().equals(algoFormer.obtenerCasillero())) {
            this.chispa.setAlgoformer(algoFormer);
        } else {
            //lanzar excepcion
        }
    }

    public Jugador obtenerJugadorActual() {

        return this.jugadorActual;
    }

    public ArrayList<Casillero> generarCasillerosDesdeJSON(){

        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            JSONObject tableroJSON = (JSONObject) parser.parse(new FileReader("tableroAlgoformers_validado.json"));

            Tablero objTablero = new Tablero(tableroJSON);

            this.dimensionTableroX = objTablero.obtenerDimensionX();
            this.dimensionTableroY= objTablero.obtenerDimensionY();

            return objTablero.obtenerCasilleros();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean algoformerPerteneceAJugadorActual(AlgoFormer algoformer){

        return this.jugadorActual.poseeAlgoformer(algoformer);
    }

    public void establecerAlgoformerObjetivo(AlgoFormer algoFormer){

        this.algoformerObjetivo = algoFormer;
    }

    public void establecerCasilleroSeleccionado(Casillero casillero){

        this.casilleroSeleccionado = casillero;
    }

    public int obtenerDimensionTableroX(){

        return this.dimensionTableroX;
    }

    public int obtenerDimensionTableroY(){

        return this.dimensionTableroY;
    }

    public Casillero obtenerCasilleroSeleccionado(){

        return this.casilleroSeleccionado;
    }

    public AlgoFormer obtenerAlgoformerObjetivo(){

        return this.algoformerObjetivo;
    }

    public boolean chispaSeleccionada(){

        return false;
    }

    private int generarPosicionXChispa(){

        int valorMinimo = (int) ((this.dimensionTableroX) / 2);
        valorMinimo -= 2;

       return  (int)(Math.random() * 2) + valorMinimo ;
    }

    private int generarPosicionYChispa(){

        int valorMinimo = (int) ((this.dimensionTableroY) / 2);
        valorMinimo -= 2;

        return  (int) (Math.random() * 2) + valorMinimo;

    }

    public void finalizarJuego(String nombreDeEquipoGanador){

       this.equipoGanador = nombreDeEquipoGanador;
        this.finalizado = true;
    }

    public boolean juegoFinalizado(){

        return this.finalizado;
    }

    public String obtenerNomreEquipoGanador(){

        return this.equipoGanador;
    }

    public void normalizarTablero(){

        for (int i = 1 ; i <= dimensionTableroX ; i++){
            for(int j = 1 ; j <= dimensionTableroY ; j ++){

                Casillero casilleroNormal = new Casillero(i,j,new Nube(),new Roca(),null);

                Juego.getInstance().modificarCasillero(casilleroNormal);

            }
        }
            }
}

