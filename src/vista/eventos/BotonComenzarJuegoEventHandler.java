package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.ContenedorPrincipal;
import vista.ContenedorTitulo;

/**
 * Created by fedek on 6/7/2016.
 */
public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {


    private ContenedorPrincipal contenedorPrincipal;
    private ContenedorTitulo contenedorTitulo;
    private Stage stage;


    public BotonComenzarJuegoEventHandler(Stage stage, ContenedorTitulo contenedorTitulo, ContenedorPrincipal contenedorPrincipal){

        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
        this.contenedorTitulo = contenedorTitulo;

    }

    @Override
    public void handle(ActionEvent event) {

        Scene escenaJuego = new Scene(contenedorPrincipal);
        stage.setScene(escenaJuego);
        stage.setFullScreen(true);
        contenedorPrincipal.reproducirMusicaDeFondo();
        contenedorPrincipal.getBarraDeMenu().deshabilitarOpcionDePantallaCompleta();
        contenedorTitulo.pararMusicaDeFondo();
        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage,contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

    }
}
