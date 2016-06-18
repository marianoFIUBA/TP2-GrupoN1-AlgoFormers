package modelo;


public abstract class Autobot extends AlgoFormer {

    protected Autobot(String nombre, Casillero casillero){

        super(nombre, casillero);
    }
    
    public void recibirAtaqueDeAutobot(int ataque){

        //lanzar excepcion
    }

    public void recibirAtaqueDeDecepticon(int ataque){

        this.puntosDeVida-=ataque;
    }

    public void atacar(AlgoFormer algoformer, int puntosDeAtaque){

        algoformer.recibirAtaqueDeAutobot(puntosDeAtaque);

    }

}
