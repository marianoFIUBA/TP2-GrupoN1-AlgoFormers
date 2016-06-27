package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import modelo.Casillero;

/**
 * Created by Mariano on 26/06/2016.
 */
public class BotonAccionCasillero implements EventHandler<ActionEvent> {


    private Button boton;

    public BotonAccionCasillero(Button boton , Casillero casillero) {

        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Background imagenDeFondo = this.boton.getBackground();

    }
}
