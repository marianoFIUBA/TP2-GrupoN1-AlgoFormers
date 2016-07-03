package vista;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import vista.eventos.BotonAccionAlgoformerHandler;
import vista.eventos.BotonAccionCasilleroHandler;

import java.awt.*;
import java.awt.Button;
import java.awt.Image;

/**
 * Created by Mariano on 03/07/2016.
 */
public class ContenedorPrincipal extends BorderPane {

    private VBox panelSeleccion;
    private GridPane tablero;
    private VBox panelAcciones;
    private Label lblImagen_1;
    private Label lblImagen_2;
    private Button btnAtacar;
    private Button btnMover;

    public ContenedorPrincipal() {
        //this.setMenu(stage);
        this.generarTablero();
        this.generarPanelAccion();
        this.generarPanelSeleccion();
    }

    public void generarTablero(){

/*        int dimensionX = Juego.getInstance().obtenerDimensionTableroX();
        int dimensionY = Juego.getInstance().obtenerDimensionTableroY();*/

        int dimensionX = 10;
        int dimensionY = 10;

        GridPane tablero = new GridPane();

        for(int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {

                StackPane stack = new StackPane();

                javafx.scene.control.Button botonSuperficie = new javafx.scene.control.Button();
                botonSuperficie.setPrefSize(100, 100);
                //botonSuperficie.setText("Boton_" + String.valueOf(i) + "_" + String.valueOf(j));

                Casillero casilleroActual = Juego.getInstance().obtenerCasillero(i,j);

                String pathImagen = this.obtenerImagenTierra(casilleroActual);

                javafx.scene.image.Image imagen = new javafx.scene.image.Image(pathImagen);
                BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                botonSuperficie.setBackground(new Background(imagenDeFondo));

                BotonAccionCasilleroHandler handlerCasillero = new BotonAccionCasilleroHandler(casilleroActual);
                botonSuperficie.setOnAction(handlerCasillero);

                stack.getChildren().add(botonSuperficie);

                //Si hay un algoformer en el casillero
                if (!(casilleroActual.obtenerAlgoformer() == null)){

                    BotonAccionAlgoformerHandler handlerAlgoformer = new BotonAccionAlgoformerHandler(casilleroActual.obtenerAlgoformer());

                    String nombre = casilleroActual.obtenerAlgoformer().obtenerNombre();
                    javafx.scene.control.Button botonAlgoFormer = new javafx.scene.control.Button();
                    botonAlgoFormer.setPrefSize(50,50);
                    botonAlgoFormer.setText(nombre);
                    botonAlgoFormer.setOnAction(handlerAlgoformer);

                    stack.getChildren().add(botonAlgoFormer);
                }

                tablero.add(stack, j, i);
            }
        }

        this.setCenter(tablero);
    }

    private void generarPanelAccion(){

        VBox panelAcciones = new VBox();
        panelAcciones.setPadding(new javafx.geometry.Insets(10));
        panelAcciones.setSpacing(8);

        Label lblAcciones = new Label();
        lblAcciones.setText("ACCIONES");
        lblAcciones.setLineSpacing(200);

        javafx.scene.control.Button botonMover = new javafx.scene.control.Button();
        botonMover.setText("Mover");
        botonMover.setPrefWidth(150);

        javafx.scene.control.Button botonAtacar = new javafx.scene.control.Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setPrefWidth(150);

        javafx.scene.control.Button botonTransformar = new javafx.scene.control.Button();
        botonTransformar.setText("Transformase");
        botonTransformar.setPrefWidth(150);

        javafx.scene.control.Button botonCombinar = new javafx.scene.control.Button();
        botonCombinar.setText("Combinar Algoformers");
        botonCombinar.setPrefWidth(150);

        javafx.scene.control.Button botonCapturarChispa = new javafx.scene.control.Button();
        botonCapturarChispa.setText("Capturar Chispa");
        botonCapturarChispa.setPrefWidth(150);

        panelAcciones.getChildren().add(lblAcciones);
        panelAcciones.getChildren().add(botonAtacar);
        panelAcciones.getChildren().add(botonMover);
        panelAcciones.getChildren().add(botonTransformar);
        panelAcciones.getChildren().add(botonCombinar);
        panelAcciones.getChildren().add(botonCapturarChispa);

        this.setLeft(panelAcciones);
    }

    private void generarPanelSeleccion(){

        VBox panelSeleccion = new VBox();
        panelSeleccion.setPadding(new Insets(10));
        panelSeleccion.setSpacing(8);

        Label lblSeleccion = new Label();
        lblSeleccion.setText("ALGOFORMER SELECCIONADO");
        lblSeleccion.setLineSpacing(200);

        AlgoFormer algoformerActual = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado();
        javafx.scene.image.Image imagenAlgoformer = new javafx.scene.image.Image("file:src/vista/imagenes/Espinas.png");
        Label lblAlgo = new Label();
        lblAlgo.setPrefSize(200,200);

        BackgroundImage fontoAlgo = new BackgroundImage(imagenAlgoformer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        lblAlgo.setBackground(new Background(fontoAlgo));

        /*if (algoformerActual != null){
            String nombreAlgoformerActual = algoformerActual.obtenerNombre();
            String estado = algoformerActual.obtenerEstado();
            imagenAlgoformer = this.obtenerImagenAlgoformer(nombreAlgoformerActual, estado);
        } else {
            imagenAlgoformer = new Image("file:src/vista/imagenes/SinSeleccion.png");
        }
*/

        javafx.scene.image.Image imagenCasillero = new javafx.scene.image.Image("file:src/vista/imagenes/Espinas.png");
        Label lblCasillero = new Label();
        lblCasillero.setPrefSize(200,200);
        BackgroundImage fondoCas = new BackgroundImage(imagenCasillero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        lblCasillero.setBackground(new Background(fondoCas));

        panelSeleccion.getChildren().add(lblSeleccion);
        panelSeleccion.getChildren().add(lblAlgo);
        panelSeleccion.getChildren().add(lblCasillero);

        this.setRight(panelSeleccion);

    }

    public VBox obtenerPanelSeleccion(){

        return this.panelSeleccion;
    }

    private String obtenerImagenTierra(Casillero casillero){

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
        }

        return path;
    }

}
