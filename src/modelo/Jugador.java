package modelo;

import java.util.ArrayList;

/**
 * Created by Mariano on 12/06/2016.
 */
public class Jugador {

    private EstadoJugador estado;

    private AlgoFormer algoformer1;
    private AlgoFormer algoformer2;
    private AlgoFormer algoformer3;

//    private EstadoTurno estado;

    public Jugador(ArrayList<AlgoFormer> algoformers){

        this.algoformer1 = algoformers.get(0);
        this.algoformer2 = algoformers.get(1);
        this.algoformer3 = algoformers.get(2);

        this.estado = new JugadorInactivo(this);
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

    public AlgoFormer obtenerAlgoformer1(){

        return this.algoformer1;
    }

    public AlgoFormer obtenerAlgoformer2(){

        return this.algoformer2;
    }
    public AlgoFormer obtenerAlgoformer3(){

        return this.algoformer3;
    }
}
