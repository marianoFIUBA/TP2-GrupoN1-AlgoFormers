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
    private AlgoFormer algoFormer;

    public Casillero(int posicionX, int posicionY, String aire, String tierra){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.aire = aire;
        this.tierra = tierra;
        this.bonus = "";
        this.algoFormer = null;
    }
    public void alojarAlternoPorAire(AlgoFormer algoFormer){

        algoFormer.setCasillero(this);
        this.algoFormer = algoFormer;
        this.aplicarEfectoAire(algoFormer);
    }

    public void alojarAlternoPorTierra(AlgoFormer algoFormer){

        algoFormer.setCasillero(this);
        this.algoFormer = algoFormer;
        this.aplicarEfectoAlternoPorTierra(algoFormer);
    }

    public void alojarHumanoidePorTierra(AlgoFormer algoFormer){

        algoFormer.setCasillero(this);
        this.algoFormer = algoFormer;
        this.aplicarEfectoHumanoidePorTierra(algoFormer);
    }

    public int obtenerPosicionX(){

        return posicionX;
    }

    public int obtenerPosicionY() {
        return posicionY;
    }


    private void aplicarEfectoHumanoidePorTierra(AlgoFormer algoFormer){

        switch (this.tierra){

            case "ROCOSA":

                break;
            case "PANTANO":
                algoFormer.cambiarAModoEmpantanado();
                break;
            case "ESPINAS":
                algoFormer.recibirDanioDeEspinas();
                break;
        }
    }

    private void aplicarEfectoAlternoPorTierra (AlgoFormer algoFormer){

        switch (this.tierra){

            case "ROCOSA":

                break;
            case "PANTANO":
                algoFormer.cambiarAModoEmpantanado();
                break;
            case "ESPINAS":
                algoFormer.recibirDanioDeEspinas();
                break;
        }
    }

    private void aplicarEfectoAire(AlgoFormer algoFormer){

        switch (this.aire){

            case "NUBE":

                break;
            case "NEBULOSA":
                algoFormer.cambiarAModoAtrapadoEnNebulosa();
                break;
            case "TORMENTA":
                algoFormer.cambiarAModoPostPsionico();
                break;
        }
    }

    private void aplicarBonus(){


    }

    public String obtenerTierra(){

        return this.tierra;
    }

    public void desocupar(){

        this.algoFormer = null;
    }

    public AlgoFormer obtenerAlgoformer(){

        return this.algoFormer;
    }

}
