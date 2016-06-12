package fiuba.algo3.modelo.subestados;

import fiuba.algo3.modelo.*;

/**
 * Created by Mariano on 11/06/2016.
 */
public class AtrapadoEnNebulosa implements SubEstadoAlgoFormer {

    private EstadoAlgoFormer estado;
    private Accion accion;
    private int turnosPendientes;

    public AtrapadoEnNebulosa (EstadoAlgoFormer estado){

        this.accion = new Accion();
        this.estado = estado;
        this.turnosPendientes = 3;
    }

    public void mover(Casillero destino){

        // this.accion.mover(destino, estado);
    }

    public void atacar(AlgoFormer objetivo){

        // this.accion.atacar(objetivo, this.estado);
    }

    public void volverAEstadoInicial(){

        this.estado.volverASubEstadoInicial();
    }

    public void pasarTurno(){

        this.turnosPendientes--;
        if (this.turnosPendientes == 0){

            this.volverASubEstadoInicial();
        }
    }

    public Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destino){

        return origen;
    }

    public void volverASubEstadoInicial(){

        this.estado.volverASubEstadoInicial();
    }


}
