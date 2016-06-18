package modelo.algoformers;


import modelo.Autobot;
import modelo.Casillero;
import modelo.EstadoAlterno;
import modelo.MovimientoAlternoTerrestre;

public class Bumblebee extends Autobot {

    public Bumblebee(Casillero casillero){

        super("BUMBLEBEE", casillero);
        this.puntosDeVida = 350;
        this.estado = new EstadoAlterno(20, 3, 5, new MovimientoAlternoTerrestre());

    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(20, 3, 5);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(40, 1, 2);
    }


}
