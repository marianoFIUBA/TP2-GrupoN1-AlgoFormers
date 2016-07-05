package modelo;


import java.util.ArrayList;

public class Calculos {


    /*public Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destino){

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
            } else if(origen.obtenerPosicionY() != destino.obtenerPosicionY()) {
                posicionX--;
                if (origen.obtenerPosicionY() < destino.obtenerPosicionY()) {
                    posicionY++;
                } else {
                    posicionY--;
                }
        }
        return Juego.getInstance().obtenerCasillero(posicionX, posicionY);
    }*/


    public Casillero obtenerSiguienteCasillero(Casillero origen, Casillero destino){

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

        ArrayList<Casillero> trayectoria = new ArrayList<Casillero>();

        casillero = this.obtenerSiguienteCasillero(origen, destino);

        trayectoria.add(casillero);

        while (!this.compararCasilleros(casillero, destino) && esValido){

            esValido = (casillero.obtenerAlgoformer() == null);

            casillero = this.obtenerSiguienteCasillero(casillero, destino);

            trayectoria.add(casillero);

        }

        return esValido;
    }

    public Casillero obtenerPrimerCasilleroDisponible(Casillero casillero){

        Casillero casilleroActual = casillero;

        while (casilleroActual.obtenerAlgoformer() != null){

            Casillero casilleroDestinoAleatorio = Juego.getInstance().obtenerCasilleroAleatorio();
            casilleroActual = obtenerSiguienteCasillero(casilleroActual, casilleroDestinoAleatorio);

            //casilleroActual = Juego.getInstance().obtenerCasilleroAleatorio();
        }

        return casilleroActual;
    }
}
