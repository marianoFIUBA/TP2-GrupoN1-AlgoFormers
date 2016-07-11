package modelo;

import modelo.Excepciones.DecepticonNoPuedeAtacarAOtroDecepticon;
import modelo.armas.ArmaDecepticon;

public abstract class Decepticon extends AlgoFormer {

    protected Decepticon(String nombre, Casillero casillero){

        super(nombre, casillero);
        this.arma = new ArmaDecepticon();
        this.nombreDeEquipo = "EQUIPO DECEPTICON";
    }

    public void recibirAtaqueDeAutobot(int ataque){

        this.puntosDeVida-= this.armadura.modificarDefensa(ataque);
        this.verificarSiSigueConVida();
    }

    public void recibirAtaqueDeDecepticon(int ataque){

        throw new DecepticonNoPuedeAtacarAOtroDecepticon();
    }

    public void atacar(AlgoFormer algoformer, int puntosDeAtaque){

        algoformer.recibirAtaqueDeDecepticon(puntosDeAtaque);


    }

}
