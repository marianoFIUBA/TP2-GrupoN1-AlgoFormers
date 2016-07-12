package modelo;

public abstract class Arma {

    protected int turnosRestantesDobleCanion;

    public Arma(){

        this.turnosRestantesDobleCanion = 0;

    }

    public boolean estaEnRango(Casillero origen, Casillero destino, int distanciaDeAtaque){

        int distanciaX = Math.abs(origen.obtenerPosicionX() - destino.obtenerPosicionX());
        int distanciaY = Math.abs(origen.obtenerPosicionY() - destino.obtenerPosicionY());

        return (distanciaX <= distanciaDeAtaque) && (distanciaY <= distanciaDeAtaque);
    }


    public abstract void atacar(AlgoFormer algoformer, int ataque,int distanciaDeAtaque, Casillero casilleroOrigen);


    public int modificarAtaque(int ataqueInicial){

        int ataqueFinal = ataqueInicial;

        if (this.turnosRestantesDobleCanion > 0) {

            ataqueFinal = ataqueInicial * 2;

        }

        return ataqueFinal;
    }

    public void cambiarAmodoDobleCanion(){

        this.turnosRestantesDobleCanion = 4;

    }


    public void pasarTurno(){

        if (this.turnosRestantesDobleCanion > 0) {

            turnosRestantesDobleCanion--;

        }

    }

    public boolean tieneBonusDobleCanion(){

        return this.turnosRestantesDobleCanion > 0;

    }

    public int obtenerTurnosRestantes() {

        return this.turnosRestantesDobleCanion;
    }
}
