package vista.eventos;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import com.sun.javafx.scene.BoundsAccessor;
import com.sun.javafx.scene.control.behavior.ToolBarBehavior;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import modelo.Casillero;
import modelo.Juego;
import vista.BuscadorDeImagenes;
import vista.ContenedorPrincipal;

import java.awt.event.ActionListener;

/**
 * Created by Mariano on 26/06/2016.
 */
public class BotonAccionCasilleroHandler implements EventHandler<ActionEvent> {

    private BuscadorDeImagenes buscador;
    private Casillero casillero;
    private Label lblImagen_2;
    private String vistaActual;
    private VBox panelAcciones;
    private VBox estadisticas_2;
    private VBox estadisticasCasillero;
    private ToggleButton botonSuperficie;

    public BotonAccionCasilleroHandler(Casillero casillero, String vistaActual, VBox panelAcciones, VBox panelSeleccion, ToggleButton botonSuperficie) {

        this.casillero = casillero;
        this.lblImagen_2 = (Label) panelSeleccion.getChildren().get(3);
        this.vistaActual = vistaActual;
        this.panelAcciones = panelAcciones;
        buscador = new BuscadorDeImagenes();
        this.botonSuperficie = botonSuperficie;

        StackPane stackSeleccion = (StackPane) panelSeleccion.getChildren().get(4);
        this.estadisticas_2 = (VBox) stackSeleccion.getChildren().get(0);
        this.estadisticasCasillero = (VBox) stackSeleccion.getChildren().get(1);
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Juego.getInstance().establecerAlgoformerObjetivo(null);
        Juego.getInstance().establecerCasilleroSeleccionado(casillero);


        SepiaTone sepia = new SepiaTone();
        botonSuperficie.setEffect(sepia);

        if(botonSuperficie.isSelected()) {
            botonSuperficie.addEventHandler(MouseEvent.MOUSE_EXITED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            botonSuperficie.setEffect(null);
                        }

                    });
        }




        //Visibilidad de botones
        this.panelAcciones.getChildren().get(1).setDisable(Juego.getInstance().obtenerAlgoformerObjetivo() == null);
        this.panelAcciones.getChildren().get(2).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);
        //this.panelAcciones.getChildren().get(3).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);
        //this.panelAcciones.getChildren().get(4).setDisable(Juego.getInstance().obtenerCasilleroSeleccionado() == null);
        this.panelAcciones.getChildren().get(4).setDisable(Juego.getInstance().chispaSeleccionada());

        String pathImagenAlgo = "";
        if (this.vistaActual == "TIERRA"){
            pathImagenAlgo = this.buscador.obtenerPathImagenTierra(this.casillero);
        } else {
            pathImagenAlgo = this.buscador.obtenerPathImagenAire(this.casillero);
        }

        Image imagenCasillero = new Image(pathImagenAlgo);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, false, false, true);  // NUEVO new BackgroundSize(100, 100, true, false, false, true);   VIEJO // new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage imagenCasilleroFondo = new BackgroundImage(imagenCasillero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        this.lblImagen_2.setBackground(new Background(imagenCasilleroFondo));

        Label posicionX = (Label)  this.estadisticasCasillero.getChildren().get(0);
        Label posicionY = (Label)  this.estadisticasCasillero.getChildren().get(1);
        Label lblAereo = (Label)  this.estadisticasCasillero.getChildren().get(2);
        Label lblTerrestre = (Label)  this.estadisticasCasillero.getChildren().get(3);
        Label lblBonus = (Label) this.estadisticasCasillero.getChildren().get(4);

        posicionX.setText("POSICION X: " + this.casillero.obtenerPosicionX());
        posicionY.setText("POSICION Y: " + this.casillero.obtenerPosicionY());
        lblAereo.setText("ZONA AEREA: " + this.casillero.obtenerAire());
        lblTerrestre.setText("ZONA TERRESTRE: " + this.casillero.obtenerTierra());
        if (casillero.tieneBonus()) {
            lblBonus.setText("BONUS: " + this.casillero.obtenerBonus().obtenerNombre());
        } else {
            lblBonus.setText("BONUS: NO TIENE");
        }

        this.estadisticasCasillero.setVisible(true);
        this.estadisticas_2.setVisible(false);

        //deshabilitar boton de atacar

       /* Image imagenAlgoformer = new Image("file:src/vista/imagenes/Roca.png");
        BackgroundImage fondo = new BackgroundImage(imagenAlgoformer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.boton.setBackground(new Background(fondo));*/
    }
}
