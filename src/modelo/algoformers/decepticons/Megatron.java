package modelo.algoformers.decepticons;


import modelo.*;
import modelo.estados.EstadoAlterno;
import modelo.movimiento.MovimientoAlternoAereo;
import modelo.movimiento.MovimientoHumanoideTerrestre;

public class Megatron extends Decepticon{


    public Megatron(Casillero casillero) {

        super("MEGATRON", casillero);
        this.puntosDeVida = 550;
        this.puntosDeVidaIniciales = 550;
        this.estado = new EstadoAlterno(55, 2, 8, new MovimientoAlternoAereo());
        this.modoPostPsionico = false;
        this.estado.ocuparCasillero(this, casillero);
    }

    public void transformarseAModoAlterno(){

        this.estado = this.estado.transformarseAModoAlterno(55, 2, 8, new MovimientoAlternoAereo(this.estado.obtenerMovimiento()));
    }

    public void transformarseAModoHumanoide(){

        this.estado = this.estado.transformarseAModoHumanoide(10, 3, 1, new MovimientoHumanoideTerrestre(this.estado.obtenerMovimiento()));
    }

    @Override
    public void  cambiarAModoPostPsionico(){

        if (!this.modoPostPsionico){
            this.modoPostPsionico = true;
        }
    }


}