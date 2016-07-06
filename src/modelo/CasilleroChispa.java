package modelo;

import modelo.zonas.Nube;
import modelo.zonas.Roca;

import java.security.AllPermission;

/**
 * Created by Mariano on 04/07/2016.
 */
public class CasilleroChispa extends Casillero{

    public CasilleroChispa(int posicionX, int posicionY){

        super(posicionX, posicionY, new Nube(), new Roca(), null);
    }

    @Override
    public void alojarPorTierra(AlgoFormer algoFormer){

        algoFormer.informarFinDeJuego();
    }

    @Override
    public void alojarPorAire(AlgoFormer algoFormer){

       algoFormer.informarFinDeJuego();
    }

    @Override
    public String obtenerTierra(){

        return "CHISPA";
    }

    @Override
    public String obtenerAire(){

        return "CHISPA";
    }
}
