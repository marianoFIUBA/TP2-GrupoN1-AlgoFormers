package modelo;

/**
 * Created by Franco on 22/6/2016.
 */
public class Piernas {

    private int turnosRestantesFlash;

    public Piernas(){

        this.turnosRestantesFlash = 0;

    }

    public int modificarVelocidad(int velocidadInicial){

        int velocidadFinal = velocidadInicial;

        if (this.turnosRestantesFlash > 0) {

            velocidadFinal = velocidadInicial * 3;

        }

        return velocidadFinal;
    }

    public void cambiarAmodoFlash(){

        this.turnosRestantesFlash = 4;

    }

    public void pasarTurno(){

        if (this.turnosRestantesFlash > 0){

            this.turnosRestantesFlash--;
        }

    }

}
