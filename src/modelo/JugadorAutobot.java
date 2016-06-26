package modelo;

import modelo.algoformers.Optimus;
import modelo.algoformers.Superion;

import java.util.ArrayList;

/**
 * Created by Mariano on 25/06/2016.
 */
public class JugadorAutobot extends Jugador {

    public JugadorAutobot(ArrayList<AlgoFormer> algoformers){

        super(algoformers);
    }

    public void combinarAlgoformers(){

        if (this.validarCombinacion()){

            Casillero casillero = this.algoformerSeleccionado.obtenerCasillero();
            double puntosDeVida = this.algoformer1.getPuntosDeVida() + this.algoformer2.getPuntosDeVida() + this.algoformer3.getPuntosDeVida();
            this.combinado = new Superion(casillero, puntosDeVida);
            this.algoformerSeleccionado = this.combinado;

            this.algoformer1.desocuparCasillero();
            this.algoformer2.desocuparCasillero();
            this.algoformer3.desocuparCasillero();
        }
    }

}
