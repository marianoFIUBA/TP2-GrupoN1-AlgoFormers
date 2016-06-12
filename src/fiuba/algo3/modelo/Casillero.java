package fiuba.algo3.modelo;

import fiuba.algo3.modelo.subestados.HumanoideEnPantano;

/**
 * Created by Mariano on 10/06/2016.
 */
public class Casillero {

    private int posicionX;
    private int posicionY;
    private String bonus;
    private String aire = "tormenta psionica";
    private String tierra;

    public Casillero(int posicionX, int posicionY, String aire, String tierra){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.aire = aire;
        this.tierra = tierra;
        this.bonus = "";
    }
    public void alojarPorAire(EstadoAlgoFormer estadoAlgoFormer){

    }

    public void alojarPorAirePS(EstadoAlgoFormer estadoAlgoFormer){

    }

    public void alojarAlternoPorTierra(EstadoAlgoFormer estadoAlgoFormer){

    }

    public void alojarHumanoidePorTierra(EstadoAlgoFormer estadoAlgoFormer){

    }

    public int obtenerPosicionX(){

        return posicionX;
    }

    public int obtenerPosicionY() {
        return posicionY;
    }

    public void aplicarDaniosHumanoidePortierra(EstadoAlgoFormer estadoAlgoFormer){

        switch (this.tierra){

            case "ROCOSA":

                break;
            case "PANTANO":

                break;
            case "ESPINAS":

                break;
        }
    }

    public void aplicarDaniosAlternoPorTierra (EstadoAlgoFormer estadoAlgoFormer){

        switch (this.tierra){

            case "ROCOSA":

                break;
            case "PANTANO":

                break;
            case "ESPINAS":

                break;
        }
    }

    public void aplicarDaniosAire(EstadoAlgoFormer estadoAlgoFormer){

        switch (this.aire){

            case "NUBE":

                break;
            case "NEBULOSA":

                break;
            case "TORMENTA":

                break;
        }
    }
}
