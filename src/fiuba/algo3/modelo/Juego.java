package fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Mariano on 11/06/2016.
 */
public class Juego {

    private HashMap<String, Casillero> casilleros;

    public Juego(List<Casillero> casilleros){

        ListIterator<Casillero> iteradorCasilleros = casilleros.listIterator();

        Casillero actual;

        while (iteradorCasilleros.hasNext()){

//            actual = iteradorCasilleros.next();
//            String clave = String.valueOf(actual.obtenerPosicionX) + "." + String.valueOf(actual.obtenerPosicionY);
//            this.casilleros.put(clave,actual);
        }
    }

    public Casillero obtenerCasillero(int posicionX, int posicionY){

        String clave = String.valueOf(posicionX) + "." + String.valueOf(posicionY);
        return this.casilleros.get(clave);
    }
}
