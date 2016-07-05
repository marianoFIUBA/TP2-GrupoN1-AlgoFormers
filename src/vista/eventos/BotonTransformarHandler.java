package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;
import modelo.Excepciones.NoPuedeTransformarseAModoAlternoException;
import modelo.Excepciones.NoPuedeTransformarseAModoHumaoideException;
import modelo.Juego;
import modelo.Jugador;
import vista.ContenedorPrincipal;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonTransformarHandler implements EventHandler<ActionEvent> {


    private ContenedorPrincipal contenedorPrincipal;
    public BotonTransformarHandler(ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;

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

            } catch  (NoPuedeTransformarseAModoAlternoException | NoPuedeTransformarseAModoHumaoideException ex1 ){}
        }




    }
}
