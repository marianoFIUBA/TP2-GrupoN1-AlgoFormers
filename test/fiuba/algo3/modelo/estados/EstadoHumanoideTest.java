package fiuba.algo3.modelo.estados;

import modelo.EstadoAlgoFormer;
import modelo.Excepciones.NoPuedeTransformarseAModoAlternoException;
import modelo.Excepciones.NoPuedeTransformarseAModoHumanoideException;
import modelo.estados.EstadoAlterno;
import modelo.estados.EstadoHumanoide;
import modelo.movimiento.MovimientoAlternoAereo;
import modelo.movimiento.MovimientoAlternoTerrestre;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fedek on 11/7/2016.
 */
public class EstadoHumanoideTest {



    @Test
    public void transformarseAModoHumanoideCambiaAModoHumanoide(){

        EstadoAlgoFormer estadoActual = new EstadoHumanoide(1,1,1,new MovimientoAlternoTerrestre(),false);

        estadoActual = estadoActual.transformarseAModoAlterno(1,1,1,new MovimientoAlternoTerrestre());

        Assert.assertTrue(estadoActual.obtenerEstado() == "ALTERNO");

    }

    @Test(expected = NoPuedeTransformarseAModoHumanoideException.class)
    public void transformarseAModoHumanoideLanzaNoPuedeTransformarseAModoHumanoideException(){

        EstadoAlgoFormer estadoActual = new EstadoHumanoide(1,1,1,new MovimientoAlternoTerrestre(),false);

        estadoActual = estadoActual.transformarseAModoHumanoide(1,1,1,new MovimientoAlternoTerrestre());

        Assert.assertTrue(estadoActual.obtenerEstado() == "HUMANOIDE");

    }

}
