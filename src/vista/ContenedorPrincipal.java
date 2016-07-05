package vista;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import vista.eventos.BotonAccionAlgoformerHandler;
import vista.eventos.BotonAccionCasilleroHandler;

import java.util.Stack;


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
    private BuscadorDeImagenes buscador;
    private Button btnTierra;
    private Button btnAire;
    private String vistaActual;
    private Button botonAtacar;
    private Button botonMover;
    private Button botonTransformar;
    private Button botonCombinar;

    public ContenedorPrincipal() {
        //this.setMenu(stage);

        this.buscador = new BuscadorDeImagenes();
        this.generarPanelAccion();
        this.generarPanelSeleccion();

        this.generarPanelJugador();
        this.generarTablero("TIERRA");
    }

    public void generarTablero(String tipoZonaTablero){

        int dimensionX = Juego.getInstance().obtenerDimensionTableroX();
        int dimensionY = Juego.getInstance().obtenerDimensionTableroY();
        this.vistaActual = tipoZonaTablero;

        /*int dimensionX = 20;
        int dimensionY = 20;*/

        GridPane tablero = new GridPane();

        for(int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {

                StackPane stack = new StackPane();

                javafx.scene.control.Button botonSuperficie = new javafx.scene.control.Button();
                botonSuperficie.setPrefSize(100, 100);
                //botonSuperficie.setText("Boton_" + String.valueOf(i) + "_" + String.valueOf(j));

                Casillero casilleroActual = Juego.getInstance().obtenerCasillero(i,j);

                String pathImagen = "";
                if (tipoZonaTablero == "TIERRA"){
                    pathImagen = this.buscador.obtenerPathImagenTierra(casilleroActual);
                } else {
                   pathImagen = this.buscador.obtenerPathImagenAire(casilleroActual);
                }

                javafx.scene.image.Image imagen = new javafx.scene.image.Image(pathImagen);
                BackgroundSize backgroundSizeCasillero = new BackgroundSize(100, 100, true, false, false, true);
                BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSizeCasillero);
                botonSuperficie.setBackground(new Background(imagenDeFondo));

                BotonAccionCasilleroHandler handlerCasillero = new BotonAccionCasilleroHandler(casilleroActual, this.vistaActual, this.panelAcciones, this.panelSeleccion);
                botonSuperficie.setOnAction(handlerCasillero);

                stack.getChildren().add(botonSuperficie);

                //Si hay un algoformer en el casillero
                if (!(casilleroActual.obtenerAlgoformer() == null)){

                    BotonAccionAlgoformerHandler handlerAlgoformer = new BotonAccionAlgoformerHandler(casilleroActual.obtenerAlgoformer(),  this.panelAcciones, this.panelSeleccion);

                    //String nombre = casilleroActual.obtenerAlgoformer().obtenerNombre();
                    javafx.scene.control.Button botonAlgoFormer = new javafx.scene.control.Button();
                    botonAlgoFormer.setPrefSize(50,50);
                    //botonAlgoFormer.setText(nombre);
                    botonAlgoFormer.setOnAction(handlerAlgoformer);

                    //Se agrega imagen de algoformer al boton
                    String pathImagenAlgo = buscador.obtenerPathImagenAlgoformer(casilleroActual.obtenerAlgoformer());
                    try{


                    javafx.scene.image.Image imagenAlgo = new javafx.scene.image.Image(pathImagenAlgo);

                    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
                    BackgroundImage imagenAlgoFondo = new BackgroundImage(imagenAlgo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
                    botonAlgoFormer.setBackground(new Background(imagenAlgoFondo));
                    } catch (RuntimeException e){

                    }
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
        this.botonMover = botonMover;

        javafx.scene.control.Button botonAtacar = new javafx.scene.control.Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setPrefWidth(150);
        this.botonAtacar = botonAtacar;

        javafx.scene.control.Button botonTransformar = new javafx.scene.control.Button();
        botonTransformar.setText("Transformase");
        botonTransformar.setPrefWidth(150);
        this.botonTransformar = botonTransformar;

        javafx.scene.control.Button botonCombinar = new javafx.scene.control.Button();
        botonCombinar.setText("Combinar Algoformers");
        botonCombinar.setPrefWidth(150);
        this.botonCombinar = botonCombinar;

        javafx.scene.control.Button botonCapturarChispa = new javafx.scene.control.Button();
        botonCapturarChispa.setText("Capturar Chispa");
        botonCapturarChispa.setPrefWidth(150);

        Label lblVistas = new Label();
        lblVistas.setText("VISTAS DEL TABLERO");
        lblVistas.setLineSpacing(200);

        javafx.scene.control.Button btnAire = new javafx.scene.control.Button();
        btnAire.setText("Vista Aérea");
        btnAire.setPrefWidth(150);
        this.btnAire = btnAire;

        javafx.scene.control.Button btnTierra = new javafx.scene.control.Button();
        btnTierra.setText("Vista Terrestre");
        btnTierra.setPrefWidth(150);
        this.btnTierra = btnTierra;

        panelAcciones.getChildren().add(lblAcciones);
        panelAcciones.getChildren().add(botonAtacar);
        panelAcciones.getChildren().add(botonMover);
        panelAcciones.getChildren().add(botonTransformar);
        panelAcciones.getChildren().add(botonCombinar);
        panelAcciones.getChildren().add(botonCapturarChispa);

        botonAtacar.setDisable(true);
        botonMover.setDisable(true);
        botonTransformar.setDisable(true);
        botonCombinar.setDisable(true);
        botonCapturarChispa.setDisable(true);

        panelAcciones.getChildren().add(lblVistas);
        panelAcciones.getChildren().add(btnTierra);
        panelAcciones.getChildren().add(btnAire);

        this.panelAcciones = panelAcciones;
        this.setLeft(panelAcciones);
    }

    public void generarPanelSeleccion(){

        VBox panelSeleccion = new VBox();
        panelSeleccion.setPadding(new Insets(10));
        panelSeleccion.setSpacing(8);

        BackgroundSize backkSize = new BackgroundSize(100, 100, true, false, false, true);

        Label lblSeleccion = new Label();
        lblSeleccion.setText("ALGOFORMER SELECCIONADO");
        lblSeleccion.setLineSpacing(200);

        AlgoFormer algoformerActual = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado();
        javafx.scene.image.Image imagenAlgoformer = new javafx.scene.image.Image("file:src/vista/imagenes/SinSeleccion.png");
        Label lblAlgo = new Label();
        this.lblImagen_1 = lblAlgo;
        lblAlgo.setPrefSize(200,200);

        BackgroundImage fontoAlgo = new BackgroundImage(imagenAlgoformer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backkSize);
        lblAlgo.setBackground(new Background(fontoAlgo));

        javafx.scene.image.Image imagenCasillero = new javafx.scene.image.Image("file:src/vista/imagenes/SinSeleccion.png");
        Label lblCasillero = new Label();
        this.lblImagen_2 = lblCasillero;
        lblCasillero.setPrefSize(200,200);
        BackgroundImage fondoCas = new BackgroundImage(imagenCasillero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backkSize);

        panelSeleccion.getChildren().add(lblSeleccion);
        panelSeleccion.getChildren().add(lblAlgo);
        panelSeleccion.getChildren().add(this.generarVBoxEstadisticasAlgoformer());
        panelSeleccion.getChildren().add(lblCasillero);

        StackPane estadisticas = new StackPane();
        estadisticas.getChildren().addAll(this.generarVBoxEstadisticasAlgoformer(), this.generarVBoxEstadisticasCasillero());

        panelSeleccion.getChildren().add(estadisticas);


        this.panelSeleccion = panelSeleccion;
        this.setRight(panelSeleccion);

    }

    public VBox generarVBoxEstadisticasAlgoformer(){

        VBox estadisticas = new VBox();

        estadisticas.setPadding(new javafx.geometry.Insets(10));
        estadisticas.setSpacing(8);

        Label lblAtaque = new Label();
        lblAtaque.setLineSpacing(200);

        Label lblDistanciaAtaque = new Label();
        lblDistanciaAtaque.setLineSpacing(200);

        Label lblVelocidad = new Label();
        lblVelocidad.setLineSpacing(200);

        Label lblVida = new Label();
        lblVida.setLineSpacing(200);

        estadisticas.getChildren().add(lblAtaque);
        estadisticas.getChildren().add(lblDistanciaAtaque);
        estadisticas.getChildren().add(lblVelocidad);
        estadisticas.getChildren().add(lblVida);

        return estadisticas;
    }

    public VBox generarVBoxEstadisticasCasillero(){

        VBox estadisticas = new VBox();

        estadisticas.setPadding(new javafx.geometry.Insets(10));
        estadisticas.setSpacing(8);

        Label PosicionX = new Label();
        PosicionX.setLineSpacing(200);

        Label PosicionY = new Label();
        PosicionY.setLineSpacing(200);

        Label lblAereo = new Label();
        lblAereo.setLineSpacing(200);

        Label lblTerrestre = new Label();
        lblTerrestre.setLineSpacing(200);

        estadisticas.getChildren().add(PosicionX);
        estadisticas.getChildren().add(PosicionY);
        estadisticas.getChildren().add(lblAereo);
        estadisticas.getChildren().add(lblTerrestre);

        return estadisticas;
    }


    public void generarPanelJugador(){

        StackPane stack = new StackPane();
        stack.setPadding(new Insets(10,10,10,10));

        Label lblNombreEquipo = new Label();

        lblNombreEquipo.setLineSpacing(600);
        lblNombreEquipo.setText("EQUIPO DEL JUGADOR ACTUAL: " + Juego.getInstance().obtenerJugadorActual().obtenerNombreDeEquipo());

        stack.getChildren().add(lblNombreEquipo);

        this.setTop(stack);

    }

    /*public VBox generarVBoxEstadisticasAlgoformerObjetivo(){

    }

    public VBox generarVBoxEstadisticasCasillero(){

    }
*/
/*    public VBox obtenerPanelAcciones(){

        return this.panelAcciones;
    }

    public Label obtenerLblImagen_1(){

        return this.lblImagen_1;
    }

    public VBox obtenerPanelSeleccion(){

        return this.panelSeleccion;
    }*/

    public Button obtenerBotonTierra(){

        return this.btnTierra;
    }

    public Button obtenerBotonAire(){

        return this.btnAire;
    }

    public Button obtenerBotonAtacar() {
        
        return this.botonAtacar;
    }


    public String obtenerVistaActual(){

        return this.vistaActual;
    }

    public Button obtenerBotonMover() {

        return this.botonMover;
    }

    public Button obtenerBotonTransformar() {

        return this.botonTransformar;
    }

    public Button obtenerBotonCombinar() {

        return this.botonCombinar;
    }
}
