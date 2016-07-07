package vista;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import vista.eventos.BotonAccionAlgoformerHandler;
import vista.eventos.BotonAccionCasilleroHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EventListener;
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
    private Button botonDeCasilleroSeleccionadoAnterior;
    private Stage stage;
    private BarraDeMenuPrincipal barraDeMenuPrincipal;
    private MediaPlayer mediaPlayer;

    public ContenedorPrincipal(Stage stage) {

        //this.setMenu(stage);
        this.stage = stage;
        this.generarBarraDeMenuPrincipal();
        this.buscador = new BuscadorDeImagenes();
        this.generarPanelAccion();
        this.generarPanelSeleccion();
        this.generarPanelJugador();
        this.generarTablero("TIERRA");
    }

    public void reproducirMusicaDeFondo() {

        String pathCancionJuego1 = Paths.get("").toAbsolutePath().toUri() + "src/sonidos/cancionJuego1.mp3";
        Media cancionJuego1 = new Media(pathCancionJuego1);
        /*String pathCancionJuego2 = Paths.get("").toAbsolutePath().toUri() + "src/sonidos/cancionJuego2.mp3";
        Media cancionJuego2 = new Media(pathCancionJuego2);*/

        mediaPlayer = new MediaPlayer(cancionJuego1);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

    }

    public void generarTablero(String tipoZonaTablero){

        int dimensionX = Juego.getInstance().obtenerDimensionTableroX();
        int dimensionY = Juego.getInstance().obtenerDimensionTableroY();
        this.vistaActual = tipoZonaTablero;

        /*int dimensionX = 20;
        int dimensionY = 20;*/

        GridPane tablero = new GridPane();

        ToggleGroup grupo = new ToggleGroup();

        for(int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {

                StackPane stack = new StackPane();

                ToggleButton botonSuperficie = new ToggleButton();
                botonSuperficie.setPrefSize(100, 100);
                botonSuperficie.setToggleGroup(grupo);
                //botonSuperficie.setText("Boton_" + String.valueOf(i) + "_" + String.valueOf(j));

                Casillero casilleroActual = Juego.getInstance().obtenerCasillero(i,j);

                String pathImagen = "";
                String colorDeFondoBotonSuperficie= "";
                if (tipoZonaTablero == "TIERRA"){
                    //pathImagen = this.buscador.obtenerPathImagenTierra(casilleroActual);
                    colorDeFondoBotonSuperficie = this.buscador.obtenerColorDeFondoTierra(casilleroActual);

                } else {
                   //pathImagen = this.buscador.obtenerPathImagenAire(casilleroActual);
                    colorDeFondoBotonSuperficie = this.buscador.obtenerColorDeFondoAire(casilleroActual);
                }

                //Image imagen = new Image(pathImagen);
                //BackgroundSize backgroundSizeCasillero = new BackgroundSize(100, 100, true, false, false, true);
                //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSizeCasillero);
                //botonSuperficie.setBackground(new Background(imagenDeFondo));

                BotonAccionCasilleroHandler handlerCasillero = new BotonAccionCasilleroHandler(casilleroActual, this.vistaActual, this.panelAcciones, this.panelSeleccion,botonSuperficie);
                botonSuperficie.setOnAction(handlerCasillero);
                botonSuperficie.setStyle(colorDeFondoBotonSuperficie);

                stack.getChildren().add(0,botonSuperficie);

                if((casilleroActual.tieneBonus())){


                    Button botonBonus = new Button();
                    botonBonus.setPrefSize(50,50);
                    botonBonus.setOnAction(handlerCasillero);

                    Label lblImagenBonus = new Label();

                    lblImagenBonus.setPrefSize(50,50);

                    String pathImagenBonus = buscador.obtenerPathImagenBonus(casilleroActual.obtenerBonus());

                    Image imagenBonus = new Image(pathImagenBonus);

                    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
                    BackgroundImage imagenBonusFondo = new BackgroundImage(imagenBonus, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
                    botonBonus.setBackground(new Background(imagenBonusFondo));

                    stack.getChildren().add(1,botonBonus);
                }

                //Si hay un algoformer en el casillero
                if ((casilleroActual.obtenerAlgoformer() != null)){

                    BotonAccionAlgoformerHandler handlerAlgoformer = new BotonAccionAlgoformerHandler(casilleroActual.obtenerAlgoformer(),  this.panelAcciones, this.panelSeleccion);

                    //String nombre = casilleroActual.obtenerAlgoformer().obtenerNombre();
                    Button botonAlgoFormer = new Button();
                    botonAlgoFormer.setPrefSize(50,50);
                    //botonAlgoFormer.setText(nombre);
                    botonAlgoFormer.setOnAction(handlerAlgoformer);

                    //Se agrega imagen de algoformer al boton
                    String pathImagenAlgo = buscador.obtenerPathImagenAlgoformer(casilleroActual.obtenerAlgoformer());
                    try{

                    Image imagenAlgo = new Image(pathImagenAlgo);

                    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
                    BackgroundImage imagenAlgoFondo = new BackgroundImage(imagenAlgo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
                    botonAlgoFormer.setBackground(new Background(imagenAlgoFondo));
                    } catch (RuntimeException e){

                    }

                    if (stack.getChildren().size() > 1){

                        stack.getChildren().add(2,botonAlgoFormer);

                    } else{

                        stack.getChildren().add(1,botonAlgoFormer);}
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

        Button botonMover = new Button();
        botonMover.setText("Mover");
        botonMover.setPrefWidth(150);
        this.botonMover = botonMover;

        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setPrefWidth(150);
        this.botonAtacar = botonAtacar;

        Button botonTransformar = new Button();
        botonTransformar.setText("Transformase");
        botonTransformar.setPrefWidth(150);
        this.botonTransformar = botonTransformar;

        Button botonCombinar = new Button();
        botonCombinar.setText("Combinar Algoformers");
        botonCombinar.setPrefWidth(150);
        this.botonCombinar = botonCombinar;

        Button botonCapturarChispa = new Button();
        botonCapturarChispa.setText("Capturar Chispa");
        botonCapturarChispa.setPrefWidth(150);

        Label lblVistas = new Label();
        lblVistas.setText("VISTAS DEL TABLERO");
        lblVistas.setLineSpacing(200);

        Button btnAire = new Button();
        btnAire.setText("Vista Aérea");
        btnAire.setPrefWidth(150);
        this.btnAire = btnAire;

        Button btnTierra = new Button();
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

        panelAcciones.getChildren().add(this.generarPanelReferencias());
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
        Image imagenAlgoformer = new Image("file:src/vista/imagenes/SinSeleccion.png");
        Label lblAlgo = new Label();
        this.lblImagen_1 = lblAlgo;
        lblAlgo.setPrefSize(200,200);

        BackgroundImage fontoAlgo = new BackgroundImage(imagenAlgoformer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backkSize);
        lblAlgo.setBackground(new Background(fontoAlgo));

        Image imagenCasillero = new Image("file:src/vista/imagenes/SinSeleccion.png");
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

        Label lblBonus = new Label();
        lblBonus.setLineSpacing(200);

        estadisticas.getChildren().add(lblAtaque);
        estadisticas.getChildren().add(lblDistanciaAtaque);
        estadisticas.getChildren().add(lblVelocidad);
        estadisticas.getChildren().add(lblVida);
        estadisticas.getChildren().add(lblBonus);

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

        Label lblBonus = new Label();
        lblBonus.setLineSpacing(200);

        estadisticas.getChildren().add(PosicionX);
        estadisticas.getChildren().add(PosicionY);
        estadisticas.getChildren().add(lblAereo);
        estadisticas.getChildren().add(lblTerrestre);
        estadisticas.getChildren().add(lblBonus);

        return estadisticas;
    }

    private VBox generarPanelReferencias(){

        VBox referencias = new VBox();

        Label lblTitulo = new Label("REFERENCIAS DE ZONAS");


        referencias.getChildren().add(lblTitulo);
        referencias.getChildren().add(this.generarReferencia("  Roca", "#C0C0C0"));
        referencias.getChildren().add(this.generarReferencia("  Pantano", "#4C9900"));
        referencias.getChildren().add(this.generarReferencia("  Espinas", "#994C00"));
        referencias.getChildren().add(this.generarReferencia("  Nube", "#FFFFFF"));
        referencias.getChildren().add(this.generarReferencia("  Nebulosa", "#990099"));
        referencias.getChildren().add(this.generarReferencia("  Tormenta", "#3333FF"));


        return referencias;
    }

    private HBox generarReferencia(String nombre, String color){

        HBox referencia = new HBox();

        Label lblreferencia = new Label(nombre);
        Label lblColreferencia = new Label();

        lblColreferencia.setPrefSize(30,10);
        String propiedadBackground = "-fx-background-color:" + color + ";-fx-border-color:black; -fx-margin:10;";
        lblColreferencia.setStyle(propiedadBackground);

        referencia.getChildren().addAll(lblColreferencia, lblreferencia);

        return referencia;
    }

    public void generarPanelJugador(){

        StackPane stack = new StackPane();
        stack.setPadding(new Insets(10,10,10,10));

        Label lblNombreEquipo = new Label();

        lblNombreEquipo.setLineSpacing(600);
        lblNombreEquipo.setText("EQUIPO DEL JUGADOR ACTUAL: " + Juego.getInstance().obtenerJugadorActual().obtenerNombreDeEquipo());

        stack.getChildren().add(lblNombreEquipo);

        this.setBottom(stack);

    }

    private void generarBarraDeMenuPrincipal(){

        this.barraDeMenuPrincipal = new BarraDeMenuPrincipal(this.stage);
        this.setTop(this.barraDeMenuPrincipal);
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

    public BarraDeMenuPrincipal getBarraDeMenu() {
        return barraDeMenuPrincipal;
    }
}
