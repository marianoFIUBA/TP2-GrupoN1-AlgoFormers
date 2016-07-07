package vista;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import vista.eventos.BotonComenzarJuegoEventHandler;

import java.nio.file.Paths;

/**
 * Created by fedek on 6/7/2016.
 */
public class ContenedorTitulo extends BorderPane {


    private Stage stage;
    private ContenedorPrincipal contenedorPrincipal;
    private MediaPlayer mediaPlayerCancion;
    private MediaPlayer mediaPlayerVideo;


    public ContenedorTitulo(Stage stage,ContenedorPrincipal contenedorPrincipal) {

        super();

        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;

        String pathMusicaDeFondo = Paths.get("").toAbsolutePath().toUri() + "src/sonidos/cancionTitulo.mp3";
        Media musicaDeFondo = new Media(pathMusicaDeFondo);
        mediaPlayerCancion = new MediaPlayer(musicaDeFondo);

        mediaPlayerCancion.setAutoPlay(true);
        mediaPlayerCancion.setStartTime(Duration.seconds(126));
        mediaPlayerCancion.setStopTime(Duration.seconds(290));
        mediaPlayerCancion.setCycleCount(MediaPlayer.INDEFINITE);


        Image imagen = new Image("file:src/vista/imagenes/ImagenContenedorTitulo.png");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        this.setBackground(new Background(imagenDeFondo));

        Button botonComenzarJuego = new Button();
        botonComenzarJuego.setPrefSize(500,75);

        Image imagenComenzarJuego = new Image("file:src/vista/imagenes/ComenzarJuego.png");
        BackgroundSize backgroundSizeComenzarJuego = new BackgroundSize(100,100,true,true,true,false);
        BackgroundImage imagenDeFondoComenzarJuego = new BackgroundImage(imagenComenzarJuego, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,backgroundSizeComenzarJuego);
        botonComenzarJuego.setBackground(new Background(imagenDeFondoComenzarJuego));

        MotionBlur blur = new MotionBlur();

        botonComenzarJuego.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    botonComenzarJuego.setEffect(blur);
                }

            });

        botonComenzarJuego.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        botonComenzarJuego.setEffect(null);
                    }

                });


        BotonComenzarJuegoEventHandler nuevoJuegoHandler = new BotonComenzarJuegoEventHandler(stage,this,contenedorPrincipal);
        botonComenzarJuego.setOnAction(nuevoJuegoHandler);

        this.setLeft(botonComenzarJuego);
    }

    public void pararMusicaDeFondo() {

        mediaPlayerCancion.stop();

    }
}
