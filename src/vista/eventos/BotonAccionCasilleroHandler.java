package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.Casillero;
import modelo.Juego;
import vista.BuscadorDeImagenes;

/**
 * Created by Mariano on 26/06/2016.
 */
public class BotonAccionCasilleroHandler implements EventHandler<ActionEvent> {

    private BuscadorDeImagenes buscador;
    private Casillero casillero;
    private Label lblImagen_2;
    private String vistaActual;

    public BotonAccionCasilleroHandler(Casillero casillero, Label lblImagen_2, String vistaActual) {

        this.casillero = casillero;
        this.lblImagen_2 = lblImagen_2;
        this.vistaActual = vistaActual;
        buscador = new BuscadorDeImagenes();
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Juego.getInstance().establecerAlgoformerObjetivo(null);
        Juego.getInstance().establecerCasilleroSeleccionado(casillero);

        String pathImagenAlgo = "";
        if (this.vistaActual == "TIERRA"){
            pathImagenAlgo = this.buscador.obtenerPathImagenTierra(this.casillero);
        } else {
            pathImagenAlgo = this.buscador.obtenerPathImagenAire(this.casillero);
        }

        javafx.scene.image.Image imagenCasillero = new javafx.scene.image.Image(pathImagenAlgo);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage imagenCasilleroFondo = new BackgroundImage(imagenCasillero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        this.lblImagen_2.setBackground(new Background(imagenCasilleroFondo));

        
        //deshabilitar boton de atacar

       /* Image imagenAlgoformer = new Image("file:src/vista/imagenes/Roca.png");
        BackgroundImage fondo = new BackgroundImage(imagenAlgoformer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.boton.setBackground(new Background(fondo));*/
    }
}
