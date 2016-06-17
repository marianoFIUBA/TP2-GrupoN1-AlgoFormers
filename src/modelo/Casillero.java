package modelo;


/**
 * Created by Mariano on 10/06/2016.
 */
public class Casillero {

    private int posicionX;
    private int posicionY;
    private String bonus;
    private String aire ;
    private String tierra;

    public Casillero(int posicionX, int posicionY, String aire, String tierra){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.aire = aire;
        this.tierra = tierra;
        this.bonus = "";
    }
    public void alojarPorAire(AlgoFormer estadoAlgoFormer){

    }

    public void alojarPorAirePS(AlgoFormer estadoAlgoFormer){

    }

    public void alojarAlternoPorTierra(AlgoFormer estadoAlgoFormer){

    }

    public void alojarHumanoidePorTierra(AlgoFormer estadoAlgoFormer){

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
