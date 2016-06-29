package vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.application.Application;
import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import vista.eventos.BotonAccionAlgoformer;

import java.util.HashMap;

/**
 * Created by Mariano on 20/06/2016.
 */
public class Aplicacion extends Application{

    Stage stage;
    Casillero casilleroSeleccionado;
    private Background imagenCasilleroSeleccionado;

    public class MiBotonEventHandler implements EventHandler<ActionEvent> {

        private Button miBoton;

        public MiBotonEventHandler(Button miBoton) {
            this.miBoton = miBoton;
        }

        @Override
        public void handle(ActionEvent actionEvent) {

            String textoClickeado = "Me han clickeado !";

            System.out.println(textoClickeado);

            //Casillero casillero = Juego.getInstance().obtenerCasillero(2,2);

            //Juego.getInstance().obtenerJugador1().obtenerAlgoformer1().moverA(casillero);

            //actualizar();


            //this.miBoton.setText(textoClickeado);
        }
    }


    /*public void actualizar(){

        Stage stage = this.stage;

        stage.setTitle("ALGOFORMERS");

        int dimensionX = 20;

        int dimensionY = 20;

        Juego.getInstance().iniciarJuego(dimensionX,dimensionY, true);


        GridPane tablero = new GridPane();

        for(int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {



                StackPane stack = new StackPane();

                Button botonSuperficie = new Button();
                botonSuperficie.setPrefSize(100, 100);
                botonSuperficie.setText("Boton_" + String.valueOf(i) + "_" + String.valueOf(j));

                Casillero casilleroActual = Juego.getInstance().obtenerCasillero(i,j);

                String pathImagen = this.obtenerImagen(casilleroActual);

                Image imagen = new Image(pathImagen);
                BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                botonSuperficie.setBackground(new Background(imagenDeFondo));

                MiBotonEventHandler miBotonEventHandler = new MiBotonEventHandler(botonSuperficie);
                botonSuperficie.setOnAction(miBotonEventHandler);


                stack.getChildren().add(botonSuperficie);

                if (!(casilleroActual.obtenerAlgoformer() == null)){


                    String nombre = casilleroActual.obtenerAlgoformer().obtenerNombre();
                    Button botonAlgoFormer = new Button();
                    botonAlgoFormer.setPrefSize(50,50);
                    botonAlgoFormer.setText(nombre);
                    botonAlgoFormer.setOnAction(miBotonEventHandler);

                    stack.getChildren().add(botonAlgoFormer);


                }



                tablero.add(stack, j, i);


            }
        }


        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);




        BorderPane border = new BorderPane();
        border.setCenter(tablero);
        border.setLeft(vbox);

        Scene scene = new Scene(border, 800, 600);

        stage.setScene(scene);



    }*/



    private String obtenerImagenTierra(Casillero casillero){

        String path = "";
        switch (casillero.obtenerTierra()){

            case "ROCOSA":
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



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        stage.setTitle("ALGOFORMERS");

        Scene scene = this.getScene();
        stage.setScene(scene);

        stage.show();
    }

    private Scene getScene(){

        int dimensionX = 20;

        int dimensionY = 20;

        Juego.getInstance().iniciarJuego(dimensionX,dimensionY, true);

        GridPane tablero = this.generarTablero(dimensionX, dimensionY);

/*        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);*/

        VBox vbox = this.generarPanelDeAciones();

        BorderPane border = new BorderPane();
        border.setCenter(tablero);
        border.setLeft(vbox);
        border.setRight(this.generarPanelSeleccion());
        border.setTop(this.generarTitulo());

        return new Scene(border, 1366, 768);

    }

    public Pane generarTitulo(){

        Pane pane = new Pane();
        Label label = new Label();
        label.setPrefSize(1300, 150);
        Image imagen = new Image("file:src/vista/imagenes/tituloAlgoformers.png");
        BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        label.setBackground(new Background(fondo));

        pane.getChildren().add(label);

        return pane;


    }

    public GridPane generarTablero(int dimensionX, int dimensionY){

        GridPane tablero = new GridPane();

        for(int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {

                StackPane stack = new StackPane();

                Button botonSuperficie = new Button();
                botonSuperficie.setPrefSize(100, 100);
                //botonSuperficie.setText("Boton_" + String.valueOf(i) + "_" + String.valueOf(j));

                Casillero casilleroActual = Juego.getInstance().obtenerCasillero(i,j);

                String pathImagen = this.obtenerImagenTierra(casilleroActual);

                Image imagen = new Image(pathImagen);
                BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                botonSuperficie.setBackground(new Background(imagenDeFondo));

                MiBotonEventHandler miBotonEventHandler = new MiBotonEventHandler(botonSuperficie);
                botonSuperficie.setOnAction(miBotonEventHandler);

                stack.getChildren().add(botonSuperficie);

                if (!(casilleroActual.obtenerAlgoformer() == null)){

                    BotonAccionAlgoformer eventoAccion = new BotonAccionAlgoformer();
                    String nombre = casilleroActual.obtenerAlgoformer().obtenerNombre();
                    Button botonAlgoFormer = new Button();
                    botonAlgoFormer.setPrefSize(50,50);
                    botonAlgoFormer.setText(nombre);
                    botonAlgoFormer.setOnAction(eventoAccion);

                    stack.getChildren().add(botonAlgoFormer);
                }

                tablero.add(stack, j, i);
            }
        }

        return tablero;
    }

    public VBox generarPanelDeAciones(){

        VBox panelAcciones = new VBox();
        panelAcciones.setPadding(new Insets(10));
        panelAcciones.setSpacing(8);

        Label lblAcciones = new Label();
        lblAcciones.setText("ACCIONES");
        lblAcciones.setLineSpacing(200);

        Button botonMover = new Button();
        botonMover.setText("Mover");
        botonMover.setPrefWidth(150);

        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setPrefWidth(150);

        Button botonTransformar = new Button();
        botonTransformar.setText("Transformase");
        botonTransformar.setPrefWidth(150);

        Button botonCombinar = new Button();
        botonCombinar.setText("Combinar Algoformers");
        botonCombinar.setPrefWidth(150);

        Button botonCapturarChispa = new Button();
        botonCapturarChispa.setText("Capturar Chispa");
        botonCapturarChispa.setPrefWidth(150);

        panelAcciones.getChildren().add(lblAcciones);
        panelAcciones.getChildren().add(botonAtacar);
        panelAcciones.getChildren().add(botonMover);
        panelAcciones.getChildren().add(botonTransformar);
        panelAcciones.getChildren().add(botonCombinar);
        panelAcciones.getChildren().add(botonCapturarChispa);

        return panelAcciones;
    }

    public VBox generarPanelSeleccion(){

        VBox panelSeleccion = new VBox();
        panelSeleccion.setPadding(new Insets(10));
        panelSeleccion.setSpacing(8);

        Label lblSeleccion = new Label();
        lblSeleccion.setText("ALGOFORMER SELECCIONADO");
        lblSeleccion.setLineSpacing(200);

        AlgoFormer algoformerActual = Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado();
        Image imagenAlgoformer = new Image("file:src/vista/imagenes/Espinas.png");
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

        Image imagenCasillero = new Image("file:src/vista/imagenes/Espinas.png");
        Label lblCasillero = new Label();
        lblCasillero.setPrefSize(200,200);
        BackgroundImage fondoCas = new BackgroundImage(imagenCasillero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        lblCasillero.setBackground(new Background(fondoCas));

        panelSeleccion.getChildren().add(lblSeleccion);
        panelSeleccion.getChildren().add(lblAlgo);
        panelSeleccion.getChildren().add(lblCasillero);



        return panelSeleccion;
    }

    private Image obtenerImagenAlgoformer(String nombre,String estado){

        if(estado == "ALTERNO"){

            return this.obtenerImagenAlterno(nombre);
        } else {

            return this.obtenerImagenHumanoide(nombre);
        }
    }

    private Image obtenerImagenAlterno(String nombre){

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
            case "BONECHUSHER":
                path =  "file:src/vista/imagenes/BonecrusherAlterno.png";
                break;
            case "MENASOR":
                path =  "file:src/vista/imagenes/Menasor.png";
                break;
        }

        Image imagen = new Image(path);

        return imagen;
    }

    private Image obtenerImagenHumanoide(String nombre){

        String path = "";

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
            case "BONECHUSHER":
                path =  "file:src/vista/imagenes/BonecrusherHumanoide.png";
                break;
            case "MENASOR":
                path =  "file:src/vista/imagenes/Menasor.png";
                break;
        }

        Image imagen = new Image(path);

        return imagen;
    }
}
