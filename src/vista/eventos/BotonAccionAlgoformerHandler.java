package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoFormer;
import modelo.Juego;

/**
 * Created by Mariano on 26/06/2016.
 */
public class BotonAccionAlgoformerHandler implements EventHandler<ActionEvent> {

        private AlgoFormer algoformer;

    public BotonAccionAlgoformerHandler(AlgoFormer algoformer) {

        this.algoformer = algoformer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        //validar que algofomer pertenezca a jugador actual
        Juego.getInstance().obtenerJugadorActual().seleccionarAlgoformer(algoformer);
        //vista panel derecho --> mostras imagen de algoformer seleccionado
    }

}
