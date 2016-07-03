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

    public BotonAccionCasilleroHandler(Casillero casillero) {

        this.casillero = casillero;
        buscador = new BuscadorDeImagenes();
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Juego.getInstance().establecerAlgoformerObjetivo(null);
        Juego.getInstance().establecerCasilleroSeleccionado(casillero);



        //deshabilitar boton de atacar

       /* Image imagenAlgoformer = new Image("file:src/vista/imagenes/Roca.png");
        BackgroundImage fondo = new BackgroundImage(imagenAlgoformer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.boton.setBackground(new Background(fondo));*/
    }
}
