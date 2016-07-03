package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoFormer;
import modelo.Juego;
import modelo.Jugador;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonAtacarHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {

        if(Juego.getInstance().obtenerJugadorActual().obtenerAlgoformerSeleccionado() != null) {

            Jugador jugadorActual = Juego.getInstance().obtenerJugadorActual();

            if(Juego.getInstance().obtenerCasilleroSeleccionado() != null){
                //Jugador mueve algoformer seleccionado
                jugadorActual.mover(Juego.getInstance().obtenerCasilleroSeleccionado());

            } else if (Juego.getInstance().obtenerAlgoformerObjetivo() != null){
                //Jugador ataca con el algoformer seleccionado
                jugadorActual.atacar(Juego.getInstance().obtenerAlgoformerObjetivo());
            }
        }
    }
}
