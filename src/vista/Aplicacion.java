package vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.application.Application;
import modelo.Casillero;
import modelo.Juego;

import java.util.HashMap;

/**
 * Created by Mariano on 20/06/2016.
 */
public class Aplicacion extends Application{

    Stage stage;

    public class MiBotonEventHandler implements EventHandler<ActionEvent> {

        private Button miBoton;

        public MiBotonEventHandler(Button miBoton) {
            this.miBoton = miBoton;
        }

        @Override
        public void handle(ActionEvent actionEvent) {

            String textoClickeado = "ยก Me han clickeado !";

            System.out.println(textoClickeado);

            /*Casillero casillero = Juego.getInstance().obtenerCasillero(2,2);

            Juego.getInstance().obtenerJugador1().obtenerAlgoformer1().moverA(casillero);

            actualizar();*/


            //this.miBoton.setText(textoClickeado);
        }
    }



    private String obtenerImagen(Casillero casillero){

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

        stage.show();
    }


}
