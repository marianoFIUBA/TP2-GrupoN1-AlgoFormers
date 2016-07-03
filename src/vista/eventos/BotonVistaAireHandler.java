package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.BuscadorDeImagenes;
import vista.ContenedorPrincipal;

/**
 * Created by Mariano on 03/07/2016.
 */
public class BotonVistaAireHandler implements EventHandler<ActionEvent> {

    private BuscadorDeImagenes buscador;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonVistaAireHandler(ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;
        buscador = new BuscadorDeImagenes();
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.contenedorPrincipal.generarTablero("AIRE");
    }
}
