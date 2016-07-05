package modelo;

import modelo.algoformers.Menasor;

import java.util.ArrayList;

/**
 * Created by Mariano on 25/06/2016.
 */
public class JugadorDecepticon extends Jugador {

    public JugadorDecepticon(ArrayList<AlgoFormer> algoformers){

        super(algoformers);
    }

    public void combinarAlgoformers(){

        if (this.validarCombinacion()){

            Casillero casillero = this.algoformerSeleccionado.obtenerCasillero();
            double puntosDeVida = this.algoformer1.obtenerPuntosDeVida() + this.algoformer2.obtenerPuntosDeVida() + this.algoformer3.obtenerPuntosDeVida();

            this.algoformer1.desocuparCasillero();
            this.algoformer2.desocuparCasillero();
            this.algoformer3.desocuparCasillero();

            this.combinado = new Menasor(casillero, puntosDeVida);
            this.algoformerSeleccionado = this.combinado;

            this.finalizarTurno();
        }
    }
}
