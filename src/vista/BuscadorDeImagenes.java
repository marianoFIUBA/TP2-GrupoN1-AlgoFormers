package vista;

import modelo.AlgoFormer;
import modelo.Bonus;
import modelo.Casillero;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BuscadorDeImagenes {


    public String obtenerPathImagenAlgoformer(AlgoFormer algoFormer){

        String path = "";

        if(algoFormer.obtenerEstado() == "ALTERNO"){

            path = this.obtenerPathImagenAlterno(algoFormer);
        } else {
            path = this.obtenerPathImagenHumanoide(algoFormer);
        }
        return path;
    }


    public String obtenerPathImagenTierra(Casillero casillero){

        String path = "";
        switch (casillero.obtenerTierra()){

            case "ROCA":
                path = "file:src/vista/imagenes/Roca.png";
                break;
            case "PANTANO":
                path = "file:src/vista/imagenes/Pantano.png";
                break;
            case "ESPINAS":
                path = "file:src/vista/imagenes/Espinas.png";
                break;
            case "CHISPA":
                path = "file:src/vista/imagenes/Chispa.png";
                break;
        }

        return path;
    }

    public String obtenerPathImagenAire(Casillero casillero){

        String path = "";
        switch (casillero.obtenerAire()){

            case "NUBE":
                path = "file:src/vista/imagenes/Nube.png";
                break;
            case "TORMENTA":
                path = "file:src/vista/imagenes/Tormenta.png";
                break;
            case "NEBULOSA":
                path = "file:src/vista/imagenes/Nebulosa.png";
                break;
            case "CHISPA":
                path = "file:src/vista/imagenes/Chispa.png";
                break;
        }

        return path;
    }


    private String obtenerPathImagenAlterno(AlgoFormer algoFormer){

        String nombre = algoFormer.obtenerNombre();

        String path = "";

        switch(nombre){

            case "OPTIMUS":
                path = "file:src/vista/imagenes/OptimusAlterno.png";
                break;
            case "BUMBLEBEE":
                path =  "file:src/vista/imagenes/BumblebeeAlterno.png";
                break;
            case "RATCHET":
                path =  "file:src/vista/imagenes/RatchetAlterno.png";
                break;
            case "SUPERION":
                path =  "file:src/vista/imagenes/Superion.png";
                break;
            case "MEGATRON":
                path =  "file:src/vista/imagenes/MegatronAlterno.png";
                break;
            case "FRENZY":
                path =  "file:src/vista/imagenes/FrenzyAlterno.png";
                break;
            case "BONECRUSHER":
                path =  "file:src/vista/imagenes/BonecrusherAlterno.png";
                break;
            case "MENASOR":
                path =  "file:src/vista/imagenes/Menasor.png";
                break;
        }

        return path;
    }

    private String obtenerPathImagenHumanoide(AlgoFormer algoFormer){

        String path = "";

        String nombre = algoFormer.obtenerNombre();
        switch(nombre){

            case "OPTIMUS":
                path = "file:src/vista/imagenes/OptimusHumanoide.png";
                break;
            case "BUMBLEBEE":
                path =  "file:src/vista/imagenes/BumblebeeHumanoide.png";
                break;
            case "RATCHET":
                path =  "file:src/vista/imagenes/RatchetHumanoide.png";
                break;
            case "SUPERION":
                path =  "file:src/vista/imagenes/Superion.png";
                break;
            case "MEGATRON":
                path =  "file:src/vista/imagenes/MegatronHumanoide.png";
                break;
            case "FRENZY":
                path =  "file:src/vista/imagenes/FrenzyHumanoide.png";
                break;
            case "BONECRUSHER":
                path =  "file:src/vista/imagenes/BonecrusherHumanoide.png";
                break;
            case "MENASOR":
                path =  "file:src/vista/imagenes/Menasor.png";
                break;
        }

        return path;
    }

    public String obtenerPathImagenBonus(Bonus bonus) {


        String path = "";

        String nombre = bonus.obtenerNombre();

        switch (nombre){

            case "FLASH":
                path ="file:src/vista/imagenes/Flash.png";
                break;
            case "BURBUJA":
                path = "file:src/vista/imagenes/Burbuja.png";
                break;
            case "DOBLECANION":
                path = "file:src/vista/imagenes/DobleCanion.png";
                break;
        }

        return path;

    }

    public String obtenerColorDeFondoTierra(Casillero casillero){

        String path = "";
        switch (casillero.obtenerTierra()){

            case "ROCA":
                path = "-fx-base: #C0C0C0;";
                break;
            case "PANTANO":
                path = "-fx-base:#4C9900";
                break;
            case "ESPINAS":
                path = "-fx-base:#994C00";
                break;
            case "CHISPA":
                path = "-fx-base: white";
                break;
        }



        return path;
    }

    public String obtenerColorDeFondoAire(Casillero casillero){

        String path = "";
        switch (casillero.obtenerAire()){

            case "NUBE":
                path = "-fx-base: #FFFFFF";
                break;
            case "TORMENTA":
                path = "-fx-base: #3333FF";
                break;
            case "NEBULOSA":
                path = "-fx-base: #990099";
                break;
            case "CHISPA":
                path = "-fx-base: white";
                break;
        }

        return path;
    }
}
