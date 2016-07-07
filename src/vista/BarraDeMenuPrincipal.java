package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import vista.eventos.OpcionInstruccionesEventHandler;
import vista.eventos.OpcionPantallaCompletaEventHandler;
import vista.eventos.OpcionSalirEventHandler;

/**
 * Created by fedek on 6/7/2016.
 */
public class BarraDeMenuPrincipal extends MenuBar {

    private MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");


    public BarraDeMenuPrincipal(Stage stage) {


        Menu menuArchivo = new Menu("Archivo");
        Menu menuOpciones = new Menu("Opciones");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionInstrucciones = new MenuItem("Instrucciones");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionInstruccionesEventHandler opcionInstruccionesHandler = new OpcionInstruccionesEventHandler();
        opcionInstrucciones.setOnAction(opcionInstruccionesHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        //opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionSalir);
        menuAyuda.getItems().addAll(opcionInstrucciones);
        menuOpciones.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuOpciones, menuAyuda);
    }


    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }

    public void deshabilitarOpcionDePantallaCompleta(){

        opcionPantallaCompleta.setDisable(true);

    }

}
