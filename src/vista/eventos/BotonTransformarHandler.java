package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.Excepciones.NoPuedeTransformarseAModoAlternoException;
import modelo.Excepciones.NoPuedeTransformarseAModoHumanoideException;
import modelo.Juego;
import modelo.Jugador;
import vista.ContenedorPrincipal;

import java.util.Optional;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonTransformarHandler implements EventHandler<ActionEvent> {


    private ContenedorPrincipal contenedorPrincipal;
    private Stage stage;

    public BotonTransformarHandler(Stage stage, ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent event) {

        if(Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado() != null) {

            Jugador jugadorActual = Juego.getInstance().obtenerJugadorActual();


            try {
                //Jugador transformar al algoformer seleccionado
                jugadorActual.transformar();
                this.contenedorPrincipal.generarPanelSeleccion();
                this.contenedorPrincipal.generarPanelJugador();
                this.contenedorPrincipal.generarTablero(this.contenedorPrincipal.obtenerVistaActual());

            } catch  (NoPuedeTransformarseAModoAlternoException | NoPuedeTransformarseAModoHumanoideException ex1 ){}
        }

        if (Juego.getInstance().juegoFinalizado()){

            Alert alertaCasilleroFueraDeAlcance = new Alert(Alert.AlertType.CONFIRMATION );

       /*     Button botonJuegoNuevo = new Button();
            alertaCasilleroFueraDeAlcance.alertTypeProperty()*/
            alertaCasilleroFueraDeAlcance.initOwner(stage);
            alertaCasilleroFueraDeAlcance.setTitle("Fin de Juego!");
            String equipoGanador = Juego.getInstance().obtenerNomreEquipoGanador();
            alertaCasilleroFueraDeAlcance.setHeaderText(equipoGanador + " ha ganado el Juego \n Desea reiniciar el juego?");
            //alertaCasilleroFueraDeAlcance.show();

            Optional<ButtonType> result = alertaCasilleroFueraDeAlcance.showAndWait();
            if (result.get() == ButtonType.OK){
                Juego.getInstance().iniciarJuego();
                this.contenedorPrincipal.generarTablero("TIERRA");
            } else {
                System.exit(0);
            }

        }



    }
}
