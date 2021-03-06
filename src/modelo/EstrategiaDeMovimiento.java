package modelo;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.Excepciones.MovimientoInvalidoException;
import modelo.Juego;

import java.util.ArrayList;

public abstract class EstrategiaDeMovimiento {


    public abstract void ocuparCasillero(AlgoFormer algoformer, Casillero casillero);

    public abstract Casillero obtenerSiguienteCasillero(Casillero actual, Casillero destino);

    public abstract void cambiarAModoAtrapadoEnNebulosa();

    public abstract void cambiarAModoEmpantanado();

    public abstract void pasarTurno();

    public abstract void cambiarAModoNoEmpantanado();

    public abstract boolean estaEmpantanado();

    public abstract boolean recibeDaniosPorEspinas();

    public void mover(Casillero destino, AlgoFormer algoFormer) {

        Casillero casilleroActual = algoFormer.obtenerCasillero();

        int puntosDeVelocidad = algoFormer.piernas.modificarVelocidad(algoFormer.obtenerVelocidad());

        if (this.movimientoValido(casilleroActual, destino, puntosDeVelocidad)){

            int distancia = this.obtenerDistancia(casilleroActual, destino);
            int movimientosDisponibles = puntosDeVelocidad;

            while (distancia > 0 && movimientosDisponibles > 0 && algoFormer.estaVivo() ){

                Casillero casilleroAnterior = algoFormer.obtenerCasillero();
                algoFormer.desocuparCasillero();
                casilleroActual = algoFormer.estado.obtenerSiguienteCasillero(casilleroActual, destino);
                algoFormer.estado.ocuparCasillero(algoFormer, casilleroActual);
                movimientosDisponibles--;

                if (!casilleroAnterior.equals(algoFormer.obtenerCasillero())){

                    distancia--;
                }
            }

        } else { throw new MovimientoInvalidoException(); }
    }


    public Casillero calcularSiguienteCasillero(Casillero origen, Casillero destino){

        int posicionX = origen.obtenerPosicionX();
        int posicionY = origen.obtenerPosicionY();

        if(origen.obtenerPosicionX() == destino.obtenerPosicionX()){
            //posicionY++;
            if (origen.obtenerPosicionY() < destino.obtenerPosicionY()) {
                posicionY++;
            } else if (origen.obtenerPosicionY() > destino.obtenerPosicionY()){
                posicionY--;
            }

        } else {

            if (origen.obtenerPosicionY() == destino.obtenerPosicionY()) {
                if (origen.obtenerPosicionX() > destino.obtenerPosicionX()){
                    posicionX--;
                } else if (origen.obtenerPosicionX() < destino.obtenerPosicionX()){

                    posicionX++;

                }
            } else {
                if (origen.obtenerPosicionY() < destino.obtenerPosicionY()) {
                    posicionY++;
                } else if (origen.obtenerPosicionY() > destino.obtenerPosicionY()){
                    posicionY--;
                }
                if (origen.obtenerPosicionX() > destino.obtenerPosicionX()){
                    posicionX--;
                } else if (origen.obtenerPosicionX() < destino.obtenerPosicionX()){

                    posicionX++;

                }

            }
        }

        return Juego.getInstance().obtenerCasillero(posicionX, posicionY);
    }


    public boolean estaEnRango(Casillero origen, Casillero destino, int velocidad){

        int distanciaX = Math.abs(origen.obtenerPosicionX() - destino.obtenerPosicionX());
        int distanciaY = Math.abs(origen.obtenerPosicionY() - destino.obtenerPosicionY());

        return (distanciaX <= velocidad) && (distanciaY <= velocidad);
    }

    public int obtenerDistancia(Casillero origen, Casillero destino) {

        int distanciaX = Math.abs(origen.obtenerPosicionX() - destino.obtenerPosicionX());
        int distanciaY = Math.abs(origen.obtenerPosicionY() - destino.obtenerPosicionY());

        int distanciaTotal = distanciaX;

        if (distanciaX < distanciaY){

            distanciaTotal = distanciaY;
        }

        return distanciaTotal;
    }

    public boolean compararCasilleros(Casillero c1, Casillero c2){

        return (c1.obtenerPosicionX() == c2.obtenerPosicionX() && c1.obtenerPosicionY() == c2.obtenerPosicionY());

    }

    public boolean movimientoValido(Casillero origen, Casillero destino, int velocidad){

        boolean esValido = estaEnRango(origen, destino, velocidad);

        Casillero casillero = origen;

        casillero = this.calcularSiguienteCasillero(origen, destino);


        while (!this.compararCasilleros(casillero, destino) && esValido){

            esValido = (casillero.obtenerAlgoformer() == null);

            casillero = this.calcularSiguienteCasillero(casillero, destino);


        }

        return esValido;
    }

    public Casillero obtenerPrimerCasilleroDisponible(Casillero casillero){

        Casillero casilleroActual = casillero;

        while (casilleroActual.obtenerAlgoformer() != null){

            Casillero casilleroDestinoAleatorio = Juego.getInstance().obtenerCasilleroAleatorio();
            casilleroActual = calcularSiguienteCasillero(casilleroActual, casilleroDestinoAleatorio);
        }

        return casilleroActual;
    }

    public abstract boolean estaAtrapadoEnNebulosa();
}
