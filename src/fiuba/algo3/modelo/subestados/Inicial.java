package fiuba.algo3.modelo.subestados;

import fiuba.algo3.modelo.*;

/**
 * Created by Mariano on 11/06/2016.
 */
public class Inicial implements SubEstadoAlgoFormer {

    private EstadoAlgoFormer estado;
    private Accion accion;

    public Inicial (EstadoAlgoFormer estado){

        this.accion = new Accion();
        this.estado = estado;
    }

    public void mover(Casillero destino){

        this.accion.mover(destino, estado);
    }

    public void atacar(AlgoFormer objetivo){

        this.accion.atacar(objetivo, this.estado);
    }

}
