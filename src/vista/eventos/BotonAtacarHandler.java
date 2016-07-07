package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
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
    private Stage stage;

    public BotonAtacarHandler(Stage stage, ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

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
                    this.contenedorPrincipal.generarPanelJugador();
                    this.contenedorPrincipal.generarTablero(this.contenedorPrincipal.obtenerVistaActual());

                }
            } catch  (AlgoFormerFueraDeAlcanceException exception) {

                System.out.print("Hola");

                Alert alertaAlgoformeFueraDeAlcance = new Alert(Alert.AlertType.WARNING);
                alertaAlgoformeFueraDeAlcance.initOwner(stage);
                alertaAlgoformeFueraDeAlcance.setTitle("CUIDADO!");
                alertaAlgoformeFueraDeAlcance.setHeaderText("El AlgoFormer que querés atacar se encuentra fuera del alcance. ¡Probá con otro!");
                alertaAlgoformeFueraDeAlcance.show();

            }
        }

        if (Juego.getInstance().juegoFinalizado()){

            Alert alertaCasilleroFueraDeAlcance = new Alert(Alert.AlertType.WARNING);
            alertaCasilleroFueraDeAlcance.initOwner(stage);
            alertaCasilleroFueraDeAlcance.setTitle("Fin de Juego!");
            String equipoGanador = Juego.getInstance().obtenerNomreEquipoGanador();
            alertaCasilleroFueraDeAlcance.setHeaderText(equipoGanador + " ha ganado el Juego");
            alertaCasilleroFueraDeAlcance.show();
        }
    }
}
