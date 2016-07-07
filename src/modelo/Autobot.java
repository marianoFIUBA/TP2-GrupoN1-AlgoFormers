package modelo;


import modelo.Excepciones.AutobotNoPuedeAtacarAOtroAutobot;

public abstract class Autobot extends AlgoFormer {



    protected Autobot(String nombre, Casillero casillero){

        super(nombre, casillero);
        this.arma= new ArmaAutobot();
        this.nombreDeEquipo = "EQUIPO AUTOBOT";
    }
    
    public void recibirAtaqueDeAutobot(int ataque){

        throw new AutobotNoPuedeAtacarAOtroAutobot();
    }

    public void recibirAtaqueDeDecepticon(int ataque){

        this.puntosDeVida-= this.armadura.modificarDefensa(ataque);
        this.verificarSiSigueConVida();
    }

    public void atacar(AlgoFormer algoformer, int puntosDeAtaque){

        algoformer.recibirAtaqueDeAutobot(puntosDeAtaque);

    }

}
