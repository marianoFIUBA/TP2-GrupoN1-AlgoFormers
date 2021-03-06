package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Excepciones.UnidadCombinadaNoPuedeTransformarseException;
import modelo.Juego;
import modelo.Jugador;
import vista.ContenedorPrincipal;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonCombinarHandler implements EventHandler<ActionEvent>{

    private ContenedorPrincipal contenedorPrincipal;
    public BotonCombinarHandler(ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;

    }


    @Override
    public void handle(ActionEvent event) {

        if(Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado() != null) {

            Jugador jugadorActual = Juego.getInstance().obtenerJugadorActual();

            try {
                //Jugador combina los algoformers
                jugadorActual.combinarAlgoformers();
                this.contenedorPrincipal.generarPanelSeleccion();
                this.contenedorPrincipal.generarPanelJugador();
                this.contenedorPrincipal.generarTablero(this.contenedorPrincipal.obtenerVistaActual());

            } catch  (UnidadCombinadaNoPuedeTransformarseException ex){}
        }




    }



}
