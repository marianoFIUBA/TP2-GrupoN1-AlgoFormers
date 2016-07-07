package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import modelo.AlgoFormer;
import modelo.Juego;
import vista.BuscadorDeImagenes;

import java.util.Stack;

/**
 * Created by Mariano on 26/06/2016.
 */
public class BotonAccionAlgoformerHandler implements EventHandler<ActionEvent> {

        private BuscadorDeImagenes buscador;
        private AlgoFormer algoformer;
        private Label lblImagen_1;
        private Label lblImagen_2;
        private VBox estadisticas_1;
        private VBox estadisticas_2;
        private VBox estadisticasCasillero;
        private VBox panelAcciones;
        private VBox panelSeleccion;

    public BotonAccionAlgoformerHandler(AlgoFormer algoformer, VBox panelAcciones, VBox panelSeleccion) {

        this.algoformer = algoformer;
        this.buscador = new BuscadorDeImagenes();
        this.lblImagen_1 = (Label) panelSeleccion.getChildren().get(1);
        this.estadisticas_1 = (VBox) panelSeleccion.getChildren().get(2);
        this.lblImagen_2 = (Label) panelSeleccion.getChildren().get(3);

        StackPane stack = (StackPane) panelSeleccion.getChildren().get(4);
        this.estadisticas_2 = (VBox) stack.getChildren().get(0);
        this.estadisticasCasillero = (VBox) stack.getChildren().get(1);

        this.panelAcciones = panelAcciones;
        this.panelSeleccion = panelSeleccion;
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

            this.estadisticas_1.setVisible(true);
            Label ataque = (Label)  this.estadisticas_1.getChildren().get(0);
            Label distancia = (Label)  this.estadisticas_1.getChildren().get(1);
            Label velocidad = (Label)  this.estadisticas_1.getChildren().get(2);
            Label vida = (Label)  this.estadisticas_1.getChildren().get(3);
            Label bonus = (Label) this.estadisticas_1.getChildren().get(4);

            ataque.setText("ATAQUE: " + this.algoformer.obtenerAtaque());
            distancia.setText("DISTANCIA DE ATAQUE: " + this.algoformer.obtenerDistanciaDeAtaque());
            velocidad.setText("VELOCIDAD: " + this.algoformer.obtenerVelocidad());
            vida.setText("PUNTOS DE VIDA: " + this.algoformer.obtenerPuntosDeVida());

            if(this.algoformer.tieneBonusFlash()){

                bonus.setText("BONUS CAPTURADO: FLASH");

            } else if (this.algoformer.tieneDobleCanion()){

                bonus.setText("BONUS CAPTURADO: DOBLE CANION");

            } else if (this.algoformer.tieneBonusBurbuja()){

                bonus.setText("BONUS CAPTURADO: BURBUJA INMACULADA");

            } else {bonus.setText("BONUS CAPTURADO: NINGUNO");}

            //Visibilidad de botones
            this.panelAcciones.getChildren().get(1).setDisable(Juego.getInstance().obtenerAlgoformerObjetivo() == null);
            this.panelAcciones.getChildren().get(2).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);
            this.panelAcciones.getChildren().get(3).setDisable((Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado()) == null);
            this.panelAcciones.getChildren().get(4).setDisable((Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado()) == null);
            this.panelAcciones.getChildren().get(5).setDisable(!Juego.getInstance().chispaSeleccionada());

        } else {
            Juego.getInstance().establecerAlgoformerObjetivo(this.algoformer);
            Juego.getInstance().establecerCasilleroSeleccionado(null);

            AlgoFormer algoFormerObjetivo = Juego.getInstance().obtenerAlgoformerObjetivo();



            this.estadisticasCasillero.setVisible(false);
            this.estadisticas_2.setVisible(true);

            this.panelAcciones.getChildren().get(1).setDisable(algoFormerObjetivo == null);
            this.panelAcciones.getChildren().get(2).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);


            Label ataque = (Label)  this.estadisticas_2.getChildren().get(0);
            Label distancia = (Label)  this.estadisticas_2.getChildren().get(1);
            Label velocidad = (Label)  this.estadisticas_2.getChildren().get(2);
            Label vida = (Label)  this.estadisticas_2.getChildren().get(3);
            Label bonus = (Label) this.estadisticas_2.getChildren().get(4);

            ataque.setText("ATAQUE: " + algoFormerObjetivo.obtenerAtaque());
            distancia.setText("DISTANCIA DE ATAQUE: " + algoFormerObjetivo.obtenerDistanciaDeAtaque());
            velocidad.setText("VELOCIDAD: " + algoFormerObjetivo.obtenerVelocidad());
            vida.setText("PUNTOS DE VIDA: " + algoFormerObjetivo.obtenerPuntosDeVida());

            if(algoFormerObjetivo.tieneBonusFlash()){

                bonus.setText("BONUS CAPTURADO: FLASH");

            } else if (algoFormerObjetivo.tieneDobleCanion()){

                bonus.setText("BONUS CAPTURADO: DOBLE CANION");

            } else if (algoFormerObjetivo.tieneBonusBurbuja()){

                bonus.setText("BONUS CAPTURADO: BURBUJA INMACULADA");

            } else {bonus.setText("BONUS CAPTURADO: NINGUNO");}


            if (!Juego.getInstance().obtenerAlgoformerObjetivo().equals(this.algoformer)){
                Juego.getInstance().establecerAlgoformerObjetivo(this.algoformer);
                Juego.getInstance().establecerCasilleroSeleccionado(null);
            }

            this.lblImagen_2.setBackground(new Background(imagenAlgoFondo));
        }
    }

}
