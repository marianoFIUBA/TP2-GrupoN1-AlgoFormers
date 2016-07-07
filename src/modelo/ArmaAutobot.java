package modelo;

import modelo.Excepciones.AlgoFormerFueraDeAlcanceException;

public class ArmaAutobot extends Arma {


    @Override
    public void atacar(AlgoFormer algoformer, int ataque,int distanciaDeAtque, Casillero casilleroOrigen) {

        if (this.estaEnRango(casilleroOrigen,algoformer.obtenerCasillero(),distanciaDeAtque)){

            int ataqueFinal = ataque;


            if (this.turnosRestantesDobleCanion > 0) {

                ataqueFinal = ataqueFinal * 2;

            }

            algoformer.recibirAtaqueDeAutobot(ataqueFinal);

        } else {throw new AlgoFormerFueraDeAlcanceException();}
    }
}
