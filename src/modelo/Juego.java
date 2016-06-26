package modelo;

import modelo.Excepciones.CasilleroNoPerteneceAlTableroException;
import modelo.algoformers.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

/**
 * Created by Mariano on 11/06/2016.
 */
public class Juego {

    private static Juego juego;
    private HashMap<String, Casillero> casilleros;
    private boolean iniciado;
    private int[] superficiesTierra = {1,2,1,3,1,1};
    private int[] superficiesAire = {1,1,1,1,2,3};
    private int [] bonus = {1,1,1,1,1,1,3,1,1,1,1,1,1,4,1,1,1,1,1,2};
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private int dimensionTableroX;
    private int dimensionTableroY;

    private Juego() {

        this.iniciado = false;
        this.casilleros = new HashMap<String, Casillero>();
    }

    public static Juego getInstance(){

        if ( juego == null){

            juego = new Juego();
        }
        return juego;
    }

    private void guardarCasilleros(ArrayList<Casillero> casilleros){

        ListIterator<Casillero> iteradorCasilleros = casilleros.listIterator();
        Casillero actual;

        while (iteradorCasilleros.hasNext()){

            actual = iteradorCasilleros.next();
            String clave = String.valueOf(actual.obtenerPosicionX()) + "." + String.valueOf(actual.obtenerPosicionY());
            this.casilleros.put(clave,actual);
        }
    }

    public Casillero obtenerCasillero(int posicionX, int posicionY){

        String clave = String.valueOf(posicionX) + "." + String.valueOf(posicionY);
        try{
            return this.casilleros.get(clave);
        }catch (NullPointerException ex){
            throw new CasilleroNoPerteneceAlTableroException();
        }
    }

    public void iniciarJuego(int dimensionX, int dimensionY, boolean generarSuperficiesAleatorias){

        if (!this.iniciado){

            ArrayList<Casillero> casilleros = this.generarCasilleros(dimensionX, dimensionY, generarSuperficiesAleatorias);

            Optimus optimus = new Optimus(casilleros.get(0));
            optimus.estado.ocuparCasillero(optimus,casilleros.get(0));

            Bumblebee bumblebee = new Bumblebee(casilleros.get(1));
            bumblebee.estado.ocuparCasillero(bumblebee,casilleros.get(1));

            Ratchet ratchet = new Ratchet(casilleros.get(2));
            ratchet.estado.ocuparCasillero(ratchet,casilleros.get(2));

            ArrayList<AlgoFormer> autobots = new ArrayList<AlgoFormer>();
            autobots.add(optimus);
            autobots.add(bumblebee);
            autobots.add(ratchet);

            Megatron megatron = new Megatron(casilleros.get(casilleros.size()-1));
            megatron.estado.ocuparCasillero(megatron,casilleros.get(casilleros.size()-1));

            Bonecrusher bonecrusher = new Bonecrusher(casilleros.get(casilleros.size()-2));
            bonecrusher.estado.ocuparCasillero(bonecrusher,casilleros.get(casilleros.size()-2));

            Frenzy frenzy = new Frenzy(casilleros.get(casilleros.size()-3));
            frenzy.estado.ocuparCasillero(frenzy,casilleros.get(casilleros.size()-3));

            ArrayList<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();

            decepticons.add(megatron);
            decepticons.add(bonecrusher);
            decepticons.add(frenzy);

            this.jugador1 = new JugadorDecepticon(decepticons);
            this.jugador2 = new JugadorAutobot(autobots);

            this.guardarCasilleros(casilleros);
            this.jugadorActual = this.jugador1;

            this.iniciado = true;
        } else {
            //lanzar excepcion de juego ya iniciado
        }
    }

    private ArrayList<Casillero> generarCasilleros(int dimesionX, int dimensionY, boolean generarSuperficiesAleatorias){

        this.dimensionTableroX = dimesionX;
        this.dimensionTableroY = dimensionY;

        ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
        Casillero nuevoCasillero;

        for (int x = 1; x <= dimesionX; x++){
            for (int y = 1; y <= dimensionY; y++){

                String tierra =  "ROCOSA";
                String aire = "NUBE";
                String bonus = "";

                if (generarSuperficiesAleatorias && !esCasilleroInicialDeAlgoFormer(x,y,dimesionX,dimensionY)){

                    int superficieAletoriaTierra = (int)(Math.random()*this.superficiesTierra.length + 1);
                    int superficieAleatoriaAire = (int)(Math.random()*this.superficiesAire.length + 1);
                    int bonusAleatorio = (int)(Math.random()*this.bonus.length + 1);

                    bonus = this.obtenerBonus(bonusAleatorio);
                    tierra = this.obtenerSuperficieTierra(superficieAletoriaTierra);
                    aire = this.obtenerSuperficieAire(superficieAleatoriaAire);
                }
                nuevoCasillero = new Casillero(x,y,aire,tierra, bonus);
                casilleros.add(nuevoCasillero);
            }
        }


        return casilleros;
    }

    private String obtenerBonus(int tipoBonus){

        String bonus = "";
        switch(tipoBonus){

            case 2:
                bonus = "CANION";
                break;
            case 3:
                bonus = "BURBUJA";
                break;
            case 4:
                bonus = "FLASH";
                break;
        }
        return bonus;


    }

    private boolean esCasilleroInicialDeAlgoFormer (int posicionX, int posicionY,int dimensionX, int dimensionY){

        boolean algoFormer1 = ((posicionX == 1) && (posicionY == 1));
        boolean algoFormer2 = ((posicionX == 1) && (posicionY == 2));
        boolean algoFormer3 = ((posicionX == 1) && (posicionY == 3));

        boolean algoFormer4 = ((posicionX == dimensionX ) && (posicionY == dimensionY ));
        boolean algoFormer5 = ((posicionX == dimensionX ) && (posicionY == dimensionY - 1 ));
        boolean algoFormer6 = ((posicionX == dimensionX ) && (posicionY == dimensionY - 2 ));

        return ( algoFormer1 || algoFormer2 || algoFormer3 || algoFormer4 || algoFormer5 || algoFormer6 );

    }


    private String obtenerSuperficieTierra(int tipo){

        String superficieTierra = "ROCOSA";

        switch(tipo){

            case 1:
                superficieTierra = "ROCOSA";
                break;
            case 2:
                superficieTierra = "PANTANO";
                break;
            case 3:
                superficieTierra = "ESPINAS";
                break;
        }
        return superficieTierra;
    }

    private String obtenerSuperficieAire(int tipo){

        String superficieAire = "NUBE";

        switch(tipo){

            case 1:
                superficieAire = "NUBE";
                break;
            case 2:
                superficieAire = "NEBULOSA";
                break;
            case 3:
                superficieAire = "TORMENTA";
                break;
        }
        return superficieAire;
    }

    public void pasarTurno(){

        if (this.jugadorActual.equals(this.jugador1)) {

            this.jugadorActual =  this.jugador2;

        } else {

            this.jugadorActual = this.jugador1;

        }

    }

    public Jugador obtenerJugador1(){

        return this.jugador1;
    }

    public Jugador obtenerJugador2(){

        return this.jugador2;
    }

    public void generarTablero(int dimesionX, int dimensionY, boolean generarSuperficiesAleatorias){

        ArrayList<Casillero> casilleros = new ArrayList<Casillero>();

        casilleros = this.generarCasilleros(dimesionX, dimensionY, generarSuperficiesAleatorias);
        this.guardarCasilleros(casilleros);
    }

    public void modificarCasillero(Casillero casillero){

        String clave = String.valueOf(casillero.obtenerPosicionX()) + "." + String.valueOf(casillero.obtenerPosicionY());
        try{
            this.casilleros.replace(clave, casillero);
        } catch (NullPointerException ex){

            throw new CasilleroNoPerteneceAlTableroException();
        }
    }

    public HashMap<String, Casillero> obtenerCasilleros(){

        return this.casilleros;
    }

    public Casillero obtenerCasilleroAleatorio(){

        int posicionX = (int)(Math.random()*this.dimensionTableroX);
        int posicionY = (int)(Math.random()*this.dimensionTableroY);

        return this.obtenerCasillero(posicionX, posicionY);
    }
}

