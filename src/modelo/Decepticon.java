package modelo;

/**
 * Created by Mariano on 10/06/2016.
 */
public class Decepticon extends AlgoFormer {

    protected Decepticon(String nombre){

        super(nombre);
    }

    public void atacar(AlgoFormer objetivo) {

       objetivo.recibirAtaqueDeDecepticon(this.estado.obtenerAtaque());
    }

    public void recibirAtaqueDeAutobot(int ataque){

        //this.estado.recibirAtaque(ataque);
    }

    public void recibirAtaqueDeDecepticon(int ataque){

        //lanzar excepcion
    }
}
