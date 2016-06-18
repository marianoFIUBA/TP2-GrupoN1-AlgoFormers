package modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
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

}
