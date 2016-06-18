package modelo.algoformers;


import modelo.Casillero;
import modelo.Decepticon;
import modelo.EstadoAlterno;
import modelo.MovimientoAlternoTerrestre;

public class Frenzy extends Decepticon {

    public Frenzy(Casillero casillero){

        super("FRENZY", casillero);
        this.puntosDeVida = 400;
        this.estado = new EstadoAlterno(25, 2, 6, new MovimientoAlternoTerrestre());

    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(25, 2, 6);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(10, 5, 2);
    }

}
