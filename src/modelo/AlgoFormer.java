package modelo;

import modelo.Excepciones.MovimientoInvalidoException;

public abstract class AlgoFormer {

    protected String nombre;
    protected EstadoAlgoFormer estado;
    protected Arma arma;
    protected Armadura armadura;
    protected Piernas piernas;
    protected Calculos calculo;
    protected Casillero casillero;
    protected double puntosDeVida;
    protected double puntosDeVidaIniciales;
    protected boolean modoPostPsionico;

    protected AlgoFormer(String nombre, Casillero casillero) {

        this.nombre = nombre;
        this.casillero = casillero;
        this.calculo = new Calculos();
        this.modoPostPsionico = false;
        this.arma = new Arma();
        this.armadura = new Armadura();
        this.piernas = new Piernas();
    }


    public double getPuntosDeVida() {
        return puntosDeVida;
    }


    public void moverA( Casillero destino){

        Casillero casilleroActual = this.casillero;

        int puntosDeVelocidad = this.piernas.modificarVelocidad(this.obtenerVelocidad());

        if (calculo.movimientoValido(casilleroActual, destino, puntosDeVelocidad)){

            int distancia = calculo.obtenerDistancia(casilleroActual, destino);
            int movimientosDisponibles = puntosDeVelocidad;

            while (distancia > 0 && movimientosDisponibles > 0){

                Casillero casilleroAnterior = this.obtenerCasillero();
                this.desocuparCasillero();
                casilleroActual = this.estado.obtenerSiguienteCasillero(casilleroActual, destino);
                this.estado.ocuparCasillero(this, casilleroActual);
                movimientosDisponibles--;

                if (!casilleroAnterior.equals(this.obtenerCasillero())){

                    distancia--;
                }
//                casilleroActual.alojarAlternoPorTierra(algoformer);
            }

        } else { throw new MovimientoInvalidoException(); }
    }

    public void atacarA(AlgoFormer algoformer) {

        int puntosDeAtaque = this.arma.modificarAtaque(this.obtenerAtaque());

        /*if (this.modoPostPsionico){
            puntosDeAtaque = (int) (puntosDeAtaque * 0.6);
        }*/

        if (this.calculo.estaEnRango(this.obtenerCasillero(), algoformer.obtenerCasillero(), puntosDeAtaque)){

            this.atacar(algoformer, puntosDeAtaque);
        }

    }

    public abstract void atacar(AlgoFormer algoformer, int puntosDeAtaque);

    public Casillero obtenerCasillero() {

        return this.casillero;
        //return this.estado.obtenerCasillero();
    }

    public void pasarTurno() {

        this.estado.pasarTurno();
        this.arma.pasarTurno();
        this.armadura.pasarTurno();
        this.piernas.pasarTurno();

    }

    public abstract void recibirAtaqueDeDecepticon(int puntosDeAtaque);

    public abstract void recibirAtaqueDeAutobot(int puntosDeAtaque);

    public String obtenerNombre() {

        return this.nombre;
    }

    public int obtenerVelocidad() {

        return this.estado.obtenerVelocidad();
    }

    public int obtenerAtaque(){

        int ataque = this.estado.obtenerAtaque();
        if (this.modoPostPsionico){
            ataque = (int) (ataque * 0.6);
        }
        return ataque;
    }

    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }

    public String obtenerEstado(){

        return this.estado.obtenerEstado();
    }

    public EstadoAlgoFormer obtenerObjetoEstado(){

        return this.estado;
    }

    public abstract void transformarseAModoAlterno();

    public abstract void transformarseAModoHumanoide();


    public void recibirDanioDeEspinas(){

        if (this.estado.obtenerMovimiento().recibeDaniosPorEspinas()){

            this.reducirPuntosDeVidaPorEspinas();

        }
    }

    public void cambiarAModoEmpantanado (){

        this.estado.cambiarAModoEmpantanado();
    }

    public abstract void  cambiarAModoPostPsionico();

    public void cambiarAModoAtrapadoEnNebulosa(){

        this.estado.cambiarAModoAtrapadoEnNebulosa();
    }

    public void setPuntosDeVida(double puntosDeVida){

        this.puntosDeVida = puntosDeVida;
    }

    public void desocuparCasillero(){

        this.casillero.desocupar();
    }

    public void cambiarAModoFlash(){

        this.piernas.cambiarAmodoFlash();
    }

    public void cambiarAModoDobleCanion(){

        this.arma.cambiarAmodoDobleCanion();
    }

    public void cambiarAModoBurbujaInmaculada(){

        this.armadura.cambiarAModoBurbujaInmaculada();
    }

    public void reducirPuntosDeVidaPorEspinas(){

        this.puntosDeVida = this.puntosDeVida - ( this.puntosDeVidaIniciales * 0.05);
    }

    public void verificarSiSigueConVida(){

        if (this.puntosDeVida <= 0){
            this.desocuparCasillero();
            this.casillero = null;
        }
    }

    public void capturarChispa(){

        Juego.getInstance().asignarChispaAAlgoformer(this);
    }

}
