package fiuba.algo3.modelo;

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
}
