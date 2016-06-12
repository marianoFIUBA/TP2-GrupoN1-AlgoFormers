package fiuba.algo3.modelo.subestados;

import fiuba.algo3.modelo.*;

/**
 * Created by Mariano on 11/06/2016.
 */
public class HumanoideEnPantano implements SubEstadoAlgoFormer {

    private EstadoAlgoFormer estado;
    private Accion accion;

    public HumanoideEnPantano (EstadoAlgoFormer estado){

        this.accion = new Accion();
        this.estado = estado;
    }

    public void mover(Casillero destino){

        // this.accion.mover(destino, estado);
    }

    public void atacar(AlgoFormer objetivo){

        // this.accion.atacar(objetivo, this.estado);
    }

    public void volverASubEstadoInicial(){

        this.estado.volverASubEstadoInicial();
    }

    public Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destino){

        return origen;
    }

    public void pasarTurno(){

    }
}
