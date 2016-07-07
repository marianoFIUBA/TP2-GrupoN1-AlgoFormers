package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by fedek on 6/7/2016.
 */
public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent event) {

        System.exit(0);

    }
}
