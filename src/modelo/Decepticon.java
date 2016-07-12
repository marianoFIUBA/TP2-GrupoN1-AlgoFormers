package modelo;

import modelo.Excepciones.DecepticonNoPuedeAtacarAOtroDecepticonException;
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

        throw new DecepticonNoPuedeAtacarAOtroDecepticonException();
    }

    public void atacar(AlgoFormer algoformer, int puntosDeAtaque){

        algoformer.recibirAtaqueDeDecepticon(puntosDeAtaque);


    }

}
