package modelo;

public class ChispaSuprema {

    private Casillero casillero;
    private AlgoFormer portador;

    public ChispaSuprema(Casillero casillero){

        this.casillero = casillero;
    }

    public void setAlgoformer(AlgoFormer portador){

        this.portador = portador;
        this.casillero = this.portador.obtenerCasillero();
    }

    public Casillero getCasillero(){

        return this.casillero;
    }

}
