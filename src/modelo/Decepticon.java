package modelo;

public abstract class Decepticon extends AlgoFormer {

    protected Decepticon(String nombre, Casillero casillero){

        super(nombre, casillero);
    }

    public void atacar(AlgoFormer objetivo) {

       objetivo.recibirAtaqueDeDecepticon(this.estado.obtenerAtaque());
    }

    public void recibirAtaqueDeAutobot(int ataque){

        this.puntosDeVida-=ataque;
    }

    public void recibirAtaqueDeDecepticon(int ataque){

        //lanzar excepcion
    }

    public void atacar(AlgoFormer algoformer, int puntosDeAtaque){

        algoformer.recibirAtaqueDeDecepticon(puntosDeAtaque);


    }

}
