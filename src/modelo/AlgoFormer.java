package modelo;

public abstract class AlgoFormer {

    protected String nombre;
    protected EstadoAlgoFormer estado;
    protected Arma arma;
    protected Armadura armadura;
    protected Piernas piernas;
    protected Calculos calculo;
    protected Casillero casillero;
    protected int puntosDeVida;
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


    public int getPuntosDeVida() {
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

        } else {
            //lanzar excepcion
        }
    }

    public void atacarA(AlgoFormer algoformer) {

        int puntosDeAtaque = this.arma.modificarAtaque(this.estado.obtenerAtaque());

        if (this.modoPostPsionico){
            puntosDeAtaque = (int) (puntosDeAtaque * 0.6);
        }

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

        return this.estado.obtenerAtaque();
    }

    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }

    public String obtenerEstado(){

        return this.estado.obtenerEstado();
    }

    public abstract void transformarseAModoAlterno();

    public abstract void transformarseAModoHumanoide();


    public void  recibirDanioDeEspinas(){

        this.estado.recibirDanioDeEspinas(this);
    }

    public void cambiarAModoEmpantanado (){

        this.estado.cambiarAModoEmpantanado();
    }

    public abstract void  cambiarAModoPostPsionico();

    public void cambiarAModoAtrapadoEnNebulosa(){

        this.estado.cambiarAModoAtrapadoEnNebulosa();
    }

    public void setPuntosDeVida(int puntosDeVida){

        this.puntosDeVida = puntosDeVida;
    }

    private void desocuparCasillero(){

        this.casillero.desocupar();
    }

}
