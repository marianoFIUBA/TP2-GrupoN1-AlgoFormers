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
            int movimientosPendientes = estado.obtenerVelocidad();

            for (int i = 0; i < movimientosPendientes; i++){

                casilleroActual = estado.obtenerSubEstado().obtenerSiguienteCasillero(estado.obtenerCasillero(), casilleroDestino);
                estado.ocuparCasillero(casilleroActual);
                i++;
            }
          /*  while (!estado.obtenerCasillero().equals(casilleroDestino)){

                casilleroActual = this.obtenerSiguienteCasillero(estado.obtenerCasillero(), casilleroDestino);
                estado.ocuparCasillero(casilleroActual);
            }*/
        } else {
            // lanzar excepcion de fuera de rango
        }
    }

    public Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destino){

        int posicionX = origen.obtenerPosicionX();
        int posicionY = origen.obtenerPosicionY();

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

    private Casillero obtenerCasilleroAnterior(Casillero destino, Casillero origen){

        int posicionX = destino.obtenerPosicionX();
        int posicionY = destino.obtenerPosicionY();

        int distanciaX = Math.abs(origen.obtenerPosicionX() - destino.obtenerPosicionX());
        int distanciaY = Math.abs(origen.obtenerPosicionY() - destino.obtenerPosicionY());

        if (distanciaX > distanciaY){
            if(posicionX > origen.obtenerPosicionX()){
                posicionX--;
            } else{
                posicionX++;
            }
        } else if(distanciaY > distanciaX){
            if(posicionY > origen.obtenerPosicionY()){
                posicionY--;
            } else{
                posicionY++;
            }
        } else {
            if(posicionY > origen.obtenerPosicionY()){
                posicionY--;
                if(posicionX > origen.obtenerPosicionX()){
                    posicionX--;
                } else{
                    posicionX++;
                }
            } else{
                posicionY++;
                if(posicionX > origen.obtenerPosicionX()){
                    posicionX--;
                } else{
                    posicionX++;
                }
            }
        }
        return Juego.getInstance().obtenerCasillero(posicionX, posicionY);
    }
}
