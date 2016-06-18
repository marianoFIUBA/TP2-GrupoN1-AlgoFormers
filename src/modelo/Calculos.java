package modelo;


public class Calculos {


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

    public boolean movimientoValido(Casillero origen, Casillero destino, int velocidad){

        return true;
    }
}
