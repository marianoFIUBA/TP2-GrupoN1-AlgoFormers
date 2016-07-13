package vista;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.util.Duration;
import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Juego;
import vista.eventos.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;




public class Aplicacion extends Application{


    final static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Juego.getInstance().iniciarJuego();

        stage.setTitle("ALGOFORMERS");

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);

        ContenedorTitulo contenedorTitulo = new ContenedorTitulo(stage,contenedorPrincipal);
        Scene escenaTitulo = new Scene(contenedorTitulo,1200,600);

        /*BotonVistaAireHandler handlerBotonVista = new BotonVistaAireHandler(contenedorPrincipal);
        contenedorPrincipal.obtenerBotonAire().setOnAction(handlerBotonVista);

        BotonVistaTierraHandler handlerBotonTierra = new BotonVistaTierraHandler(contenedorPrincipal);
        contenedorPrincipal.obtenerBotonTierra().setOnAction(handlerBotonTierra);

        BotonAtacarHandler handlerAtacar = new BotonAtacarHandler(stage,contenedorPrincipal);
        contenedorPrincipal.obtenerBotonAtacar().setOnAction(handlerAtacar);

        BotonMoverHandler handlerMover = new BotonMoverHandler(stage,contenedorPrincipal);
        contenedorPrincipal.obtenerBotonMover().setOnAction(handlerMover);

        BotonTransformarHandler handlerTransformar= new BotonTransformarHandler(stage, contenedorPrincipal);
        contenedorPrincipal.obtenerBotonTransformar().setOnAction(handlerTransformar);

        BotonCombinarHandler handlerCombinar = new BotonCombinarHandler(contenedorPrincipal);
        contenedorPrincipal.obtenerBotonCombinar().setOnAction(handlerCombinar);*/


        stage.setScene(escenaTitulo);
        stage.setFullScreen(true);
        stage.show();

    }
}
