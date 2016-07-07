package modelo;

import modelo.zonas.Nube;
import modelo.zonas.Roca;

import java.security.AllPermission;

public class CasilleroChispa extends Casillero{

    public CasilleroChispa(int posicionX, int posicionY){

        super(posicionX, posicionY, new Nube(), new Roca(), null);
    }

    @Override
    public void alojarPorTierra(AlgoFormer algoFormer){

        if (algoFormer.obtenerEstado() == "HUMANOIDE"){
            Juego.getInstance().finalizarJuego(algoFormer.obtenerNombreDeEquipo());
        } else {
            super.alojarPorTierra(algoFormer);
        }
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
