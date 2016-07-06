package modelo;

import modelo.Excepciones.*;

import java.util.ArrayList;

/**
 * Created by Mariano on 12/06/2016.
 */
public abstract class Jugador {

    protected EstadoJugador estado;
    protected AlgoFormer algoformer1;
    protected AlgoFormer algoformer2;
    protected AlgoFormer algoformer3;
    protected AlgoFormer combinado;
    protected int turnosConAlgoformerCombinado;
    protected boolean leTocaJugar;
    protected AlgoFormer algoformerSeleccionado;
    protected Calculos calculos;
    protected String nombreDeEquipo;
//    private EstadoTurno estado;

    public Jugador(ArrayList<AlgoFormer> algoformers){

        this.algoformer1 = algoformers.get(0);
        this.algoformer2 = algoformers.get(1);
        this.algoformer3 = algoformers.get(2);
        this.leTocaJugar = false;
        this.algoformerSeleccionado = null;
        this.combinado = null;
        this.turnosConAlgoformerCombinado = 2;
        this.calculos = new Calculos();
    }

    public void setAlgoformer1(AlgoFormer algoFormer){

        this.algoformer1 = algoFormer;

    }



    protected void finalizarTurno(){

        if (this.quedanAlgoformers()) {


            this.algoformer1.pasarTurno();
            this.algoformer2.pasarTurno();
            this.algoformer3.pasarTurno();

            if (this.combinado != null) {

                this.turnosConAlgoformerCombinado--;

                if (this.turnosConAlgoformerCombinado == 0) {

                    this.descombinarAlgoformers();
                    this.turnosConAlgoformerCombinado = 2;

                }
            }

            Juego.getInstance().pasarTurno();
        } else {
            Juego.getInstance().finalizarJuego(this.obtenerNombreDeEquipo());
        }
    }

    public void seleccionarAlgoformer(AlgoFormer algoformer){

        this.algoformerSeleccionado = algoformer;
    }

    public void activar(){

        this.leTocaJugar = true;
    }

    public void desactivar(){

        this.leTocaJugar = false;
    }

    public AlgoFormer obtenerAlgoformer1(){

        return this.algoformer1;
    }

    public AlgoFormer obtenerAlgoformer2(){

        return this.algoformer2;
    }
    public AlgoFormer obtenerAlgoformer3(){

        return this.algoformer3;
    }

    public AlgoFormer obtenerCombinado(){

        return this.combinado;
    }

    public void atacar(AlgoFormer algoformer) {

        try {
            this.algoformerSeleccionado.atacarA(algoformer);
            this.finalizarTurno();
        } catch (NullPointerException | AutobotNoPuedeAtacarAOtroAutobot | DecepticonNoPuedeAtacarAOtroDecepticon ex) {     //| AlgoFormerFueraDeAlcanceException
        }
    }

    public void mover(Casillero casillero){

        if(this.algoformerSeleccionado.estado.obtenerMovimiento().estaEmpantanado() || this.algoformerSeleccionado.estado.obtenerMovimiento().estaAtrapadoEnNebulosa()){

            throw new AlgoFormerInhabilitadoPorEsteTurno();


        } else {try{
                    this.algoformerSeleccionado.moverA(casillero,algoformerSeleccionado);
                    this.finalizarTurno();
                } catch (NullPointerException | MovimientoInvalidoException ex) {
            //lanzar exepcion de algoformer no seleccionado
            }
        }
    }

    public void transformar(){

        try{
            if (this.algoformerSeleccionado.obtenerEstado() == "ALTERNO"){

                this.algoformerSeleccionado.transformarseAModoHumanoide();

            } else if ( this.algoformerSeleccionado.obtenerEstado() == "HUMANOIDE"){

                this.algoformerSeleccionado.transformarseAModoAlterno();
            }
            this.finalizarTurno();
        } catch (NullPointerException ex){
            //lanzar exepcion de algoformer no transformado
        }




    }

    protected boolean validarCombinacion(){

        return true;
    }

    public abstract void combinarAlgoformers();

    public void descombinarAlgoformers(){

        Casillero casilleroActual = this.combinado.obtenerCasillero();
        this.combinado.desocuparCasillero();
        //ArrayList<Casillero> casilleros = this.obtenerCasillerosParaDescombinacion(casilleroActual);

        double puntosDevida = this.combinado.obtenerPuntosDeVida() / 3;

        Casillero casillero1 = this.obtenerAlgoformerSeleccionado().estado.obtenerMovimiento().obtenerPrimerCasilleroDisponible(casilleroActual);

        this.algoformer1.estado.ocuparCasillero(algoformer1, casillero1);
        this.algoformer1.setPuntosDeVida(puntosDevida);

        Casillero casillero2 = this.obtenerAlgoformer1().estado.obtenerMovimiento().obtenerPrimerCasilleroDisponible(casillero1);

        this.algoformer2.estado.ocuparCasillero(algoformer2, casillero2);
        this.algoformer2.setPuntosDeVida(puntosDevida);

        Casillero casillero3 = this.obtenerAlgoformer1().estado.obtenerMovimiento().obtenerPrimerCasilleroDisponible(casillero2);

        this.algoformer3.estado.ocuparCasillero(algoformer3, casillero3);
        this.algoformer3.setPuntosDeVida(puntosDevida);


        this.combinado = null;
    }

   /* protected ArrayList<Casillero> obtenerCasillerosParaDescombinacion(Casillero casillero){

        ArrayList<Casillero> casilleros = new ArrayList<Casillero>();

        Casillero casillero1 = casillero;
        Casillero casillero2;
        Casillero casillero3;

        casillero1 = calculos.obtenerPrimerCasilleroDisponible(casillero1,casillero2,casillero3);
        Casillero casillero2 = calculos.obtenerPrimerCasilleroDisponible(casillero);
        Casillero casillero3 = calculos.obtenerPrimerCasilleroDisponible(casillero);

        casilleros.add(casillero1);
        casilleros.add(casillero2);
        casilleros.add(casillero3);

        return casilleros;
    }*/

    public AlgoFormer obtenerAlgoformerSeleccionado(){

        return this.algoformerSeleccionado;
    }

    public boolean poseeAlgoformer(AlgoFormer algoformer){

        boolean condicion1 = algoformer1.obtenerNombre() == algoformer.obtenerNombre();
        boolean condicion2 = algoformer2.obtenerNombre() == algoformer.obtenerNombre();
        boolean condicion3 = algoformer3.obtenerNombre() == algoformer.obtenerNombre();
        if (this.combinado != null){

            condicion1 = condicion1 || this.combinado.obtenerNombre() == algoformer.obtenerNombre();

        }

        return condicion1 || condicion2 || condicion3;
    }

    public String obtenerNombreDeEquipo(){

        return this.nombreDeEquipo;
    }

    protected boolean quedanAlgoformers(){

        boolean algoformer1Vive = !this.algoformer1.destruido;
        boolean algoformer2Vive = !this.algoformer2.destruido;
        boolean algoformer3Vive = !this.algoformer3.destruido;
        boolean combinadoVive = false ;

        if (this.combinado != null){
            combinadoVive = !this.combinado.destruido;
        }

        return algoformer1Vive || algoformer2Vive || algoformer3Vive || combinadoVive;
    }

}
