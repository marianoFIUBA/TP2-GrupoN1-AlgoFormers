package modelo;

public class Arma {

    private int turnosRestantesDobleCanion;

    public Arma(){

        this.turnosRestantesDobleCanion = 0;

    }

    public int modificarAtaque(int ataqueInicial){

        int ataqueFinal = ataqueInicial;

        if (this.turnosRestantesDobleCanion > 0) {

            ataqueFinal = ataqueInicial * 3;
            turnosRestantesDobleCanion--;

        }

        return ataqueFinal;
    }

    public void cambiarAmodoDobleCanion(){

        this.turnosRestantesDobleCanion = 3;

    }

}
