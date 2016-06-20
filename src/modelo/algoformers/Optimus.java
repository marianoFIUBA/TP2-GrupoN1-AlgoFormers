package modelo.algoformers;


import modelo.*;

public class Optimus extends Autobot{

    public Optimus(Casillero casillero){

        super("OPTIMUS", casillero);
        this.puntosDeVida = 500;
        this.estado = new EstadoAlterno(15, 4, 5, new MovimientoAlternoTerrestre());
    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(15, 4, 5);
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(50, 2, 2);
    }

    @Override
    public  void  cambiarAModoPostPsionico(){
        //lanzar excepcion
    }

}
