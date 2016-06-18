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
    private boolean ocupado;

    public Casillero(int posicionX, int posicionY, String aire, String tierra){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.aire = aire;
        this.tierra = tierra;
        this.bonus = "";
    }
    public void alojarPorAire(AlgoFormer algoFormer){

        algoFormer.setCasillero(this);
    }

    public void alojarPorAirePS(AlgoFormer algoFormer){

    }

    public void alojarAlternoPorTierra(AlgoFormer algoFormer){

        algoFormer.setCasillero(this);
    }

    public void alojarHumanoidePorTierra(AlgoFormer algoFormer){


    }

    public int obtenerPosicionX(){

        return posicionX;
    }

    public int obtenerPosicionY() {
        return posicionY;
    }

    public void aplicarDaniosHumanoidePortierra(EstadoAlgoFormer algoFormer){

        switch (this.tierra){

            case "ROCOSA":

                break;
            case "PANTANO":

                break;
            case "ESPINAS":

                break;
        }
    }

    public void aplicarDaniosAlternoPorTierra (EstadoAlgoFormer algoFormer){

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
