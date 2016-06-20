package modelo.algoformers;


import modelo.*;

public class Megatron extends Decepticon{

    private boolean modoPostPsionico;

    public Megatron(Casillero casillero) {

        super("MEGATRON", casillero);
        this.puntosDeVida = 550;
        this.estado = new EstadoAlterno(55, 2, 8, new MovimientoAlternoAereo());
        this.modoPostPsionico = false;

    }

    public void transformarseAModoAlterno() {

        this.estado = this.estado.transformarseAModoAlterno(55, 2, 8);
    }

    public void transformarseAModoHumanoide() {

        this.estado = this.estado.transformarseAModoHumanoide(10, 3, 1);
    }

    @Override
    public void  cambiarAModoPostPsionico(){

        if (!this.modoPostPsionico){
            this.estado.cambiarAModoPostPsionico(this);
        }
    }

}