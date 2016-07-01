package modelo;

import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;

/**
 * Created by fedek on 30/6/2016.
 */
public class ArmaDecepticon extends Arma {

    @Override
    public void atacar(AlgoFormer algoformer, int ataque,int distanciaDeAtque, Casillero casilleroOrigen) {

        if (this.estaEnRango(casilleroOrigen,algoformer.obtenerCasillero(),distanciaDeAtque)){

            int ataqueFinal = ataque;


            if (this.turnosRestantesDobleCanion > 0) {

                ataqueFinal = ataqueFinal * 2;

            }

            algoformer.recibirAtaqueDeDecepticon(ataqueFinal);

        } else {throw new AlgoFormerFueraDeAlcanceException();}
    }
}
