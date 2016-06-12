package fiuba.algo3.modelo;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;

/**
 * Created by Mariano on 11/06/2016.
 */
public class Accion {

    public void atacar(AlgoFormer objetivo, EstadoAlgoFormer estado){

        if (this.estaEnRango(objetivo.obtenerCasillero(), estado.obtenerCasillero(), estado.obtenerVelocidad())){
            //objetivo.recibirAtaqueDeAutobot(estado.obtenerAtaque());
            estado.atacar(objetivo);
        } else{
            //lanzar Excepcion de fuera de rango
        }
    }

    public void mover(Casillero casilleroDestino, EstadoAlgoFormer estado){

        if (this.estaEnRango(casilleroDestino, estado.obtenerCasillero(), estado.obtenerVelocidad())){

            Casillero casilleroActual = estado.obtenerCasillero();

            while (!estado.obtenerCasillero().equals(casilleroDestino)){

                casilleroActual = this.obtenerSiguienteCasillero(estado.obtenerCasillero(), casilleroDestino);
                estado.ocuparCasillero(casilleroActual);
            }
        } else {
            // lanzar excepcion de fuera de rango
        }
    }

    private Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destino){

        int posicionX = destino.obtenerPosicionX() ;
        int posicionY = destino.obtenerPosicionY();

        if(origen.obtenerPosicionX() == destino.obtenerPosicionX()){
            posicionY++;
        } else if (origen.obtenerPosicionY() == destino.obtenerPosicionY()){
            posicionX++;
        } else if (origen.obtenerPosicionX() < destino.obtenerPosicionX()){
            posicionX++;
            if (origen.obtenerPosicionY() < destino.obtenerPosicionY()){
                posicionY++;
            } else {
                posicionY--;
            }
        } else {
            posicionX--;
            if (origen.obtenerPosicionY() < destino.obtenerPosicionY()) {
                posicionY++;
            } else {
                posicionY--;
            }
        }
        return Juego.getInstance().obtenerCasillero(posicionX, posicionY);
    }

    private boolean estaEnRango(Casillero origen, Casillero destino, int velocidad){

        int distanciaX = Math.abs(origen.obtenerPosicionX() - destino.obtenerPosicionX());
        int distanciaY = Math.abs(origen.obtenerPosicionY() - destino.obtenerPosicionY());

        return (distanciaX <= velocidad) && (distanciaY <= velocidad);
    }
}
