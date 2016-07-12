package fiuba.algo3.modelo.estados;

import modelo.AlgoFormer;
import modelo.Casillero;
import modelo.EstadoAlgoFormer;
import modelo.Excepciones.NoPuedeTransformarseAModoAlternoException;
import modelo.algoformers.decepticons.Megatron;
import modelo.estados.EstadoAlterno;
import modelo.estados.EstadoHumanoide;
import modelo.movimiento.MovimientoAlternoAereo;
import modelo.zonas.Nube;
import modelo.zonas.Roca;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mariano on 11/07/2016.
 */
public class EstadoAlternoTest{

    @Test
    public void transformarseAModoHumanoideCambiaAModoHumanoide(){

        EstadoAlgoFormer estadoActual = new EstadoAlterno(1,1,1,new MovimientoAlternoAereo(),false);

        estadoActual = estadoActual.transformarseAModoHumanoide(1,1,1,new MovimientoAlternoAereo());

        Assert.assertTrue(estadoActual.obtenerEstado() == "HUMANOIDE");

    }

    @Test(expected = NoPuedeTransformarseAModoAlternoException.class)
    public void transformarseAModoAlternoLanzaNoPuedeTransformarseAModoAlternoException(){

        EstadoAlgoFormer estadoActual = new EstadoAlterno(1,1,1,new MovimientoAlternoAereo(),false);

        estadoActual = estadoActual.transformarseAModoAlterno(1,1,1,new MovimientoAlternoAereo());

        Assert.assertTrue(estadoActual.obtenerEstado() == "ALTERNO");

    }
}
