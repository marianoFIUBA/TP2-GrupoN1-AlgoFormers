package modelo;


import modelo.bonus.BurbujaInmaculada;
import modelo.bonus.DobleCanion;
import modelo.bonus.Flash;
import modelo.zonas.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Tablero {

    private int dimensionX;
    private int dimensionY;
    private ArrayList<Casillero> casilleros;


    public Tablero(JSONObject json){

        this.dimensionX = Integer.valueOf(json.get("dimensionX").toString());
        this.dimensionY = Integer.valueOf(json.get("dimensionY").toString());

        this.casilleros = new ArrayList<Casillero>();
        JSONArray casillerosJSON = (JSONArray)json.get("Casilleros");
        for (int i = 0; i < casillerosJSON.size(); i++) {

            this.casilleros.add(this.generarCasilleroAPartirdeJson((JSONObject) casillerosJSON.get(i)));

        }
    }

    private Casillero generarCasilleroAPartirdeJson(JSONObject json){

        int posicionX = Integer.valueOf(json.get("posicionX").toString()) ;
        int posicionY = Integer.valueOf(json.get("posicionY").toString()) ;
        Zona aire = this.obtenerAire(json.get("aire").toString());
        Zona tierra = this.obtenerTierra(json.get("tierra").toString());
        Bonus bonus = this.obtenerBonus(json.get("bonus"));

        return new Casillero(posicionX, posicionY, aire, tierra, bonus);
    }

    public ArrayList<Casillero> obtenerCasilleros(){

        return this.casilleros;
    }

    private Bonus obtenerBonus(Object objBonus){

        Bonus bonus = null;

        if(objBonus != null) {

            String nombreBonus = objBonus.toString();

            switch(nombreBonus){

                case "DOBLE_CANION":
                    bonus = new DobleCanion();
                    break;
                case "BURBUJA":
                    bonus = new BurbujaInmaculada();
                    break;
                case "FLASH":
                    bonus = new Flash();
                    break;
            }
        }
        return bonus;
    }

    private Zona obtenerTierra(String tierra){

        Zona zona = null;

        if(tierra != null) {

            switch(tierra){

                case "ROCA":
                    zona = new Roca();
                    break;
                case "PANTANO":
                    zona = new Pantano();
                    break;
                case "ESPINAS":
                    zona = new Espinas();
                    break;
            }
        }
        return zona;
    }

    private Zona obtenerAire(String aire){

        Zona zona = null;

        if(aire != null) {

            switch(aire){

                case "NUBE":
                    zona = new Nube();
                    break;
                case "NEBULOSA":
                    zona = new NebulosaDeAndromeda();
                    break;
                case "TORMENTA":
                    zona = new TormentaPsionica();
                    break;
            }
        }
        return zona;
    }

    public int obtenerDimensionX(){

        return this.dimensionX;

    }

    public int obtenerDimensionY(){

        return this.dimensionY;

    }

}
