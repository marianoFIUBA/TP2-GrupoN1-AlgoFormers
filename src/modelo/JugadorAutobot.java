package modelo;

import modelo.algoformers.autobots.Superion;

import java.util.ArrayList;

public class JugadorAutobot extends Jugador {


    public JugadorAutobot(ArrayList<AlgoFormer> algoformers){

        super(algoformers);
        this.nombreDeEquipo = "EQUIPO AUTOBOT";
    }

    public void combinarAlgoformers(){

        if (this.validarCombinacion()){

            Casillero casillero = this.algoformerSeleccionado.obtenerCasillero();
            double puntosDeVida = this.algoformer1.obtenerPuntosDeVida() + this.algoformer2.obtenerPuntosDeVida() + this.algoformer3.obtenerPuntosDeVida();


            this.algoformer1.desocuparCasillero();
            this.algoformer2.desocuparCasillero();
            this.algoformer3.desocuparCasillero();

            this.combinado = new Superion(casillero, puntosDeVida);
            this.algoformerSeleccionado = this.combinado;

            this.finalizarTurno();
        }
    }
}
