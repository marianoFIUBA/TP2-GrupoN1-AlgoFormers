package fiuba.algo3.modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public class Autobot extends AlgoFormer {

    public void recibirAtaqueDeAutobot(int ataque){

        //lanzar excepcion
    }

    public void recibirAtaqueDeDecepticon(int ataque){

        this.estado.recibirAtaque(ataque);
    }
}
