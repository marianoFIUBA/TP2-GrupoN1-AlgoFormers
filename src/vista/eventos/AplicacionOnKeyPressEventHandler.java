package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vista.BarraDeMenuPrincipal;

/**
 * Created by fedek on 6/7/2016.
 */
public class AplicacionOnKeyPressEventHandler implements EventHandler<KeyEvent> {


    private BarraDeMenuPrincipal menuBarPrincipal;
    private Stage stage;

    public AplicacionOnKeyPressEventHandler(Stage stage,BarraDeMenuPrincipal menuBarPrincipal) {
        this.stage = stage;
        this.menuBarPrincipal = menuBarPrincipal;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(true);
            this.menuBarPrincipal.aplicacionMaximizada();
        }
    }
}
