package modelo;

import modelo.Excepciones.*;

import java.util.ArrayList;


public abstract class Jugador {

    private static final String ESTADO_ALTERNO = "ALTERNO";
    private static final String ESTADO_HUMANOIDE = "HUMANOIDE";
    private static final String EQUIPO_DECEPTION = "EQUIPO DECEPTICON";
    private static final String EQUIPO_AUTOBOT = "EQUIPO AUTOBOT";


    protected EstadoJugador estado;
    protected AlgoFormer algoformer1;
    protected AlgoFormer algoformer2;
    protected AlgoFormer algoformer3;
    protected AlgoFormer combinado;
    protected int turnosConAlgoformerCombinado;
    protected boolean leTocaJugar;
    protected AlgoFormer algoformerSeleccionado;
    protected String nombreDeEquipo;

    public Jugador(ArrayList<AlgoFormer> algoformers){

        this.algoformer1 = algoformers.get(0);
        this.algoformer2 = algoformers.get(1);
        this.algoformer3 = algoformers.get(2);
        this.leTocaJugar = false;
        this.algoformerSeleccionado = null;
        this.combinado = null;
        this.turnosConAlgoformerCombinado = 2;
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

        if(this.quedanAlgoformers()){


        try {
            this.algoformerSeleccionado.atacarA(algoformer);
            this.finalizarTurno();
        } catch (NullPointerException | AutobotNoPuedeAtacarAOtroAutobot | DecepticonNoPuedeAtacarAOtroDecepticonException ex) {     //| AlgoFormerFueraDeAlcanceException
        }

        } else {

            Juego.getInstance().finalizarJuego(this.nombreDeEquipo);
        }
    }

    public void mover(Casillero casillero){

        if (this.quedanAlgoformers()){


            if(this.algoformerSeleccionado.estado.obtenerMovimiento().estaEmpantanado() || this.algoformerSeleccionado.estado.obtenerMovimiento().estaAtrapadoEnNebulosa()){

                if (this.algoformerSeleccionado.estado.obtenerMovimiento().estaAtrapadoEnNebulosa()){
                    throw new AlgoFormerAtrapadoEnNebulosaNoSePuedeMoverException();
                } else {
                    throw new HumanoideNoPuedeMoverSiEstaEnPantanoException();
                }
            } else {try{
                        this.algoformerSeleccionado.moverA(casillero,algoformerSeleccionado);
                        this.finalizarTurno();
                    } catch (NullPointerException ex) { // | MovimientoInvalidoException
                //lanzar exepcion de algoformer no seleccionado
                }
            }
        } else {
            Juego.getInstance().finalizarJuego(this.obtenerNombreEquipoEnemigo());
        }
    }

    public void transformar(){

        try{
            if (this.algoformerSeleccionado.obtenerEstado() == ESTADO_ALTERNO){

                this.algoformerSeleccionado.transformarseAModoHumanoide();

            } else if ( this.algoformerSeleccionado.obtenerEstado() == ESTADO_HUMANOIDE){

                this.algoformerSeleccionado.transformarseAModoAlterno();
            }

            this.algoformerSeleccionado.obtenerObjetoEstado().ocuparCasillero(algoformerSeleccionado, algoformerSeleccionado.obtenerCasillero());

            this.finalizarTurno();
        } catch (NullPointerException | UnidadCombinadaNoPuedeTransformarseException | NoPuedeTransformarseAModoHumanoideException | NoPuedeTransformarseAModoAlternoException ex){
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

    private String obtenerNombreEquipoEnemigo(){

        String nombreEnemigo = EQUIPO_DECEPTION;
        if (this.obtenerNombreDeEquipo() == EQUIPO_DECEPTION){
            nombreEnemigo = EQUIPO_AUTOBOT;
        }
        return nombreEnemigo;
    }

}
