package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import vista.eventos.OpcionPantallaCompletaEventHandler;
import vista.eventos.OpcionSalirEventHandler;

public class BarraDeMenuPrincipal extends MenuBar {

    private MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");


    public BarraDeMenuPrincipal(Stage stage) {


        Menu menuArchivo = new Menu("Archivo");
        Menu menuOpciones = new Menu("Opciones");

        MenuItem opcionSalir = new MenuItem("Salir");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        menuArchivo.getItems().addAll(opcionSalir);
        menuOpciones.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuOpciones);
    }


    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }

    public void deshabilitarOpcionDePantallaCompleta(){

        opcionPantallaCompleta.setDisable(true);

    }

}
