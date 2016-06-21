package modelo.algoformers;


import modelo.*;

public class Frenzy extends Decepticon{

    public Frenzy(Casillero casillero){

        super("FRENZY", casillero);
        this.puntosDeVida = 400;
        this.estado = new EstadoAlterno(25, 2, 6, new MovimientoAlternoTerrestre());
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(25, 2, 6);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(10, 5, 2);
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
