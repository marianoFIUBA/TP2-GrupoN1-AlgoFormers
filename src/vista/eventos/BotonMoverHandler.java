package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;
import modelo.Excepciones.CasilleroFueraDeRangoException;
import modelo.Excepciones.MovimientoInvalidoException;
import modelo.Juego;
import modelo.Jugador;
import vista.ContenedorPrincipal;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private ContenedorPrincipal contenedorPrincipal;
    public BotonMoverHandler(ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;

    }

    @Override
    public void handle(ActionEvent event) {

        if (Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado() != null) {

            Jugador jugadorActual = Juego.getInstance().obtenerJugadorActual();


            try {
                if (Juego.getInstance().obtenerCasilleroSeleccionado() != null) {
                    //Jugador mueve al algoformer seleccionado
                    jugadorActual.mover(Juego.getInstance().obtenerCasilleroSeleccionado());
                    this.contenedorPrincipal.generarPanelSeleccion();
                    this.contenedorPrincipal.generarPanelJugador();
                    this.contenedorPrincipal.generarTablero(this.contenedorPrincipal.obtenerVistaActual());
                }
            } catch (MovimientoInvalidoException exception) {

                Alert alertaCasilleroFueraDeAlcance = new Alert(Alert.AlertType.WARNING);
                alertaCasilleroFueraDeAlcance.setTitle("CUIDADO!");
                alertaCasilleroFueraDeAlcance.setHeaderText("El casillero al cual te que querés mover se encuentra fuera del alcance de tu Algoformer. ¡Probá con otro!");
                alertaCasilleroFueraDeAlcance.show();

            }

        }

    }
}
