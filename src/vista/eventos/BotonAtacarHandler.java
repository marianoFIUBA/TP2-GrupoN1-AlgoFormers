package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoFormer;
import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;
import modelo.Juego;
import modelo.Jugador;
import vista.ContenedorPrincipal;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonAtacarHandler implements EventHandler<ActionEvent> {


    private ContenedorPrincipal contenedorPrincipal;
    public BotonAtacarHandler(ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado() != null) {

            Jugador jugadorActual = Juego.getInstance().obtenerJugadorActual();


            try {
                if (Juego.getInstance().obtenerAlgoformerObjetivo() != null) {
                    //Jugador ataca con el algoformer seleccionado
                    jugadorActual.atacar(Juego.getInstance().obtenerAlgoformerObjetivo());
                    this.contenedorPrincipal.generarPanelSeleccion();
                    this.contenedorPrincipal.generarTablero(this.contenedorPrincipal.obtenerVistaActual());

                }
            } catch  (AlgoFormerFueraDeAlcanceException exception) {

            }
        }
    }
}
