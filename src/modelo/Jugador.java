package modelo;

import java.util.ArrayList;

/**
 * Created by Mariano on 12/06/2016.
 */
public abstract class Jugador {

    protected EstadoJugador estado;
    protected AlgoFormer algoformer1;
    protected AlgoFormer algoformer2;
    protected AlgoFormer algoformer3;
    protected AlgoFormer combinado;
    protected boolean leTocaJugar;
    protected AlgoFormer algoformerSeleccionado;
    protected Calculos calculos;
//    private EstadoTurno estado;

    public Jugador(ArrayList<AlgoFormer> algoformers){

        this.algoformer1 = algoformers.get(0);
        this.algoformer2 = algoformers.get(1);
        this.algoformer3 = algoformers.get(2);
        this.leTocaJugar = false;
        this.algoformerSeleccionado = null;
        this.combinado = null;
    }

    private void finalizarTurno(){

        this.algoformer1.pasarTurno();
        this.algoformer2.pasarTurno();
        this.algoformer3.pasarTurno();

        Juego.getInstance().pasarTurno();
    }

    public void seleccionarAlgoformer(AlgoFormer algoformer){

        this.algoformerSeleccionado = algoformer;
    }

    public void activar(){

        this.leTocaJugar = true;
    }

    public void desactivar(){

        this.leTocaJugar = false;
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

    public AlgoFormer obtenercombinado(){

        return this.combinado;
    }

    public void atacar(AlgoFormer algoformer){

        this.algoformerSeleccionado.atacarA(algoformer);
        this.finalizarTurno();
    }

    public void mover(Casillero casillero){

        try{
            this.algoformerSeleccionado.moverA(casillero);
            this.finalizarTurno();
        } catch (NullPointerException ex){
            //lanzar exepcion de algoformer no seleccionado
        }
    }

    protected boolean validarCombinacion(){

        return true;
    }

    public abstract void combinarAlgoformers();
}
