package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * Created by fedek on 6/7/2016.
 */
public class OpcionInstruccionesEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Alert alertInstrucciones = new Alert(Alert.AlertType.INFORMATION);
        alertInstrucciones.setTitle("INSTRUCCIONES");
        alertInstrucciones.show();

    }


}
