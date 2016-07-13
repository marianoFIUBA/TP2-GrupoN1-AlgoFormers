package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.Excepciones.*;
import modelo.Juego;
import modelo.Jugador;
import vista.ContenedorPrincipal;
import javafx.scene.control.ButtonType;
import java.util.*;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private ContenedorPrincipal contenedorPrincipal;
    private Stage stage;
    public BotonMoverHandler(Stage stage, ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent event) {

        if (Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado() != null) {

            Jugador jugadorActual = Juego.getInstance().obtenerJugadorActual();


            try {
                if (Juego.getInstance().obtenerCasilleroSeleccionado() != null) {
                    //Jugador mueve al algoformer seleccionado
                    jugadorActual.mover(Juego.getInstance().obtenerCasilleroSeleccionado());
                    this.contenedorPrincipal.generarPanelAccion();
                    this.contenedorPrincipal.generarPanelSeleccion();
                    this.contenedorPrincipal.generarPanelJugador();
                    this.contenedorPrincipal.generarTablero(this.contenedorPrincipal.obtenerVistaActual());
                }
            } catch (MovimientoInvalidoException exception) {

                Alert alertaMovimientoInvalido = new Alert(Alert.AlertType.WARNING);
                alertaMovimientoInvalido.initOwner(stage);
                alertaMovimientoInvalido.setTitle("CUIDADO!");
                alertaMovimientoInvalido.setHeaderText("El casillero al cual te que querés mover se encuentra fuera del alcance de tu Algoformer y/o hay un Algoformer en el camino. ¡Probá con otro casillero!");
                alertaMovimientoInvalido.show();
            } catch (AlgoFormerAtrapadoEnNebulosaNoSePuedeMoverException ex){

                Alert alertaAlgoFormerAtrapadoEnNebulosa = new Alert(Alert.AlertType.WARNING);
                alertaAlgoFormerAtrapadoEnNebulosa.initOwner(stage);
                alertaAlgoFormerAtrapadoEnNebulosa.setTitle("CUIDADO!");
                alertaAlgoFormerAtrapadoEnNebulosa.setHeaderText("El algoformer al cual querés mover se encuentra atrapado en una nebulosa. ¡Probá con otro!");
                alertaAlgoFormerAtrapadoEnNebulosa.show();

            } catch(HumanoideNoPuedeMoverSiEstaEnPantanoException ex){

                Alert alertaAlgoFormerAtrapadoEnPantano = new Alert(Alert.AlertType.WARNING);
                alertaAlgoFormerAtrapadoEnPantano.initOwner(stage);
                alertaAlgoFormerAtrapadoEnPantano.setTitle("CUIDADO!");
                alertaAlgoFormerAtrapadoEnPantano.setHeaderText("El algoformer al cual querés mover se encuentra atrapado en un pantano. Transformalo para poder moverlo.");
                alertaAlgoFormerAtrapadoEnPantano.show();

            }

        }

        if (Juego.getInstance().juegoFinalizado()){

            Alert alertaJuegoFinalizado = new Alert(Alert.AlertType.CONFIRMATION );


            alertaJuegoFinalizado.initOwner(stage);
            alertaJuegoFinalizado.setTitle("Fin de Juego!");
            String equipoGanador = Juego.getInstance().obtenerNomreEquipoGanador();
            alertaJuegoFinalizado.setHeaderText(equipoGanador + " ha ganado el Juego \n Desea reiniciar el juego?");

            Optional<ButtonType> result = alertaJuegoFinalizado.showAndWait();
            if (result.get() == ButtonType.OK){
                Juego.getInstance().iniciarJuego();
                this.contenedorPrincipal.generarTablero("TIERRA");
            } else {
                System.exit(0);
            }

        }
    }
}
