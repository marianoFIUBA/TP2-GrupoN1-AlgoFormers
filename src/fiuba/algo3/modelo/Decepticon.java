package fiuba.algo3.modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public class Decepticon extends AlgoFormer {

    public void recibirAtaqueDeAutobot(int ataque){

        this.estado.recibirAtaque(ataque);
    }

    public void recibirAtaqueDeDecepticon(int ataque){

        //lanzar excepcion
    }
}