package modelo;

/**
 * Created by Franco on 22/6/2016.
 */
public class Armadura {

    int turnosPendientes;

    public void cambiarAModoBurbujaInmaculada(){

        this.turnosPendientes = 3;  //En cuanto se obtiene el bonus, se disminuye un turno.
    }

    public int modificarDefensa(int ataqueInicial){

        int ataqueFinal = ataqueInicial;

        if (this.turnosPendientes > 0){

            ataqueFinal = 0;

        }

        return ataqueFinal;

    }

    public void pasarTurno(){

        if (this.turnosPendientes > 0){

            this.turnosPendientes--;
        }

    }
}
