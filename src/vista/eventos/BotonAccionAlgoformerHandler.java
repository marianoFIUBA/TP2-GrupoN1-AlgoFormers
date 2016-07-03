package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import modelo.AlgoFormer;
import modelo.Juego;
import vista.BuscadorDeImagenes;

/**
 * Created by Mariano on 26/06/2016.
 */
public class BotonAccionAlgoformerHandler implements EventHandler<ActionEvent> {

        private BuscadorDeImagenes buscador;
        private AlgoFormer algoformer;
        private Label lblImagen_1;
        private VBox panelAcciones;

    public BotonAccionAlgoformerHandler(AlgoFormer algoformer, Label lblImagen_1, VBox panelAcciones) {

        this.algoformer = algoformer;
        this.buscador = new BuscadorDeImagenes();
        this.lblImagen_1 = lblImagen_1;
        this.panelAcciones = panelAcciones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        //validar que algofomer pertenezca a jugador actual
        if (Juego.getInstance().algoformerPerteneceAJugadorActual(this.algoformer)) {
            Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(this.algoformer);
            String pathImagenAlgo = this.buscador.obtenerPathImagenAlgoformer(this.algoformer);


            javafx.scene.image.Image imagenAlgo = new javafx.scene.image.Image(pathImagenAlgo);

            BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
            BackgroundImage imagenAlgoFondo = new BackgroundImage(imagenAlgo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            this.lblImagen_1.setBackground(new Background(imagenAlgoFondo));
            
        }
    }

}
