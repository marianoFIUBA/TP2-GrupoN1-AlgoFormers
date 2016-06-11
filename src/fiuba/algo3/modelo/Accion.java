package fiuba.algo3.modelo;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;

/**
 * Created by Mariano on 11/06/2016.
 */
public class Accion {

    public void atacar(AlgoFormer objetivo, EstadoAlgoFormer estado){

        if (this.estaEnRango(objetivo.obtenerCasillero(), estado.obtenerCasillero())){
            //objetivo.recibirAtaqueDeAutobot(estado.obtenerAtaque());
            estado.atacar(objetivo);
        } else{
            //lanzar Excepcion de fuera de rango
        }
    }

    public void mover(Casillero casilleroDestino, EstadoAlgoFormer estado){

        if (this.estaEnRango(casilleroDestino, estado.obtenerCasillero())){

            Casillero casilleroActual = estado.obtenerCasillero();

            while (!estado.obtenerCasillero().equals(casilleroDestino)){

                casilleroActual = this.obtenerSiguienteCasillero(estado.obtenerCasillero(), casilleroDestino);
                estado.ocuparCasillero(casilleroActual);
            }
        } else {
            // lanzar excepcion de fuera de rango
        }
    }

    private Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destinfa){

        return new Casillero();
    }

    private boolean estaEnRango(Casillero origen, Casillero destino){

        return true;
    }
}
