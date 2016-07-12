package modelo;

public class Armadura {

    private int turnosPendientes;

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

    public boolean tieneBonusBurbuja(){

        return this.turnosPendientes > 0;

    }

    public int obtenerTurnosPendientes(){

        return this.turnosPendientes;

    }
}
