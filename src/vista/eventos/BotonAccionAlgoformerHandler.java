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
        private Label lblImagen_2;
        private VBox panelAcciones;

    public BotonAccionAlgoformerHandler(AlgoFormer algoformer, Label lblImagen_1, Label lblImagen_2, VBox panelAcciones) {

        this.algoformer = algoformer;
        this.buscador = new BuscadorDeImagenes();
        this.lblImagen_1 = lblImagen_1;
        this.lblImagen_2 = lblImagen_2;
        this.panelAcciones = panelAcciones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {


        String pathImagenAlgo = this.buscador.obtenerPathImagenAlgoformer(this.algoformer);
        javafx.scene.image.Image imagenAlgo = new javafx.scene.image.Image(pathImagenAlgo);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage imagenAlgoFondo = new BackgroundImage(imagenAlgo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);


        //validar que algofomer pertenezca a jugador actual
        if (Juego.getInstance().algoformerPerteneceAJugadorActual(this.algoformer)) {
            Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(this.algoformer);
           this.lblImagen_1.setBackground(new Background(imagenAlgoFondo));

            //Visibilidad de botones
            this.panelAcciones.getChildren().get(1).setDisable(Juego.getInstance().obtenerAlgoformerObjetivo() == null);
            this.panelAcciones.getChildren().get(2).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);
            //this.panelAcciones.getChildren().get(3).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);
            //this.panelAcciones.getChildren().get(4).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);
            this.panelAcciones.getChildren().get(4).setDisable(Juego.getInstance().chispaSeleccionada());

        } else {

            if(Juego.getInstance().obtenerAlgoformerObjetivo() != null){
                if (!Juego.getInstance().obtenerAlgoformerObjetivo().equals(this.algoformer)){
                    Juego.getInstance().establecerAlgoformerObjetivo(this.algoformer);
                    Juego.getInstance().establecerCasilleroSeleccionado(null);
                }
            }
            this.lblImagen_2.setBackground(new Background(imagenAlgoFondo));
        }
    }

}
