package fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Mariano on 12/06/2016.
 */
public class Jugador {

    private EstadoJugador estado;

    private AlgoFormer algoformer1;
    private AlgoFormer algoformer2;
    private AlgoFormer algoformer3;

    private ArrayList<AlgoFormer> algoformers;
//    private EstadoTurno estado;

    public Jugador(ArrayList<AlgoFormer> algoformers){

        this.algoformers = algoformers;
    }

    public void finalizarTurno(){

        this.algoformer1.pasarTurno();
        this.algoformer2.pasarTurno();
        this.algoformer3.pasarTurno();

        Juego.getInstance().pasarTurno();
    }

    public void seleccionarAlgoformer(AlgoFormer algoformer){

        this.estado.seleccionarAlgoFormer(algoformer);
    }

    public void cambiarEstado(){

        this.estado = this.estado.cambiarEstado();
    }
}
