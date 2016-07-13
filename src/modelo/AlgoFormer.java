package modelo;

public abstract class AlgoFormer {

    protected String nombre;
    protected EstadoAlgoFormer estado;
    protected Arma arma;
    protected Armadura armadura;
    protected Piernas piernas;
    protected Casillero casillero;
    protected double puntosDeVida;
    protected double puntosDeVidaIniciales;
    protected boolean modoPostPsionico;
    protected boolean destruido;
    protected String nombreDeEquipo;

    protected AlgoFormer(String nombre, Casillero casillero) {

        this.nombre = nombre;
        this.casillero = casillero;
        this.modoPostPsionico = false;
        this.armadura = new Armadura();
        this.piernas = new Piernas();
        this.destruido = false;
    }


    public double obtenerPuntosDeVida() {
        return puntosDeVida;
    }


    public void atacarA(AlgoFormer algoFormer){

        this.arma.atacar(algoFormer,this.obtenerAtaque(),this.obtenerDistanciaDeAtaque(),this.obtenerCasillero());

    }

    public int obtenerDistanciaDeAtaque() {

        return this.estado.obtenerDistanciaDeAtaque();

    }


    public abstract void atacar(AlgoFormer algoformer, int puntosDeAtaque);

    public Casillero obtenerCasillero() {

        return this.casillero;
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

        if (!this.estado.obtenerMovimiento().estaAtrapadoEnNebulosa()) {
            this.casillero.desocupar();
            this.casillero = null;
        }
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

    private void reducirPuntosDeVidaPorEspinas(){

        this.puntosDeVida = this.puntosDeVida - ( this.puntosDeVidaIniciales * 0.05);
    }

    public void verificarSiSigueConVida(){

        if (this.puntosDeVida <= 0){
            this.desocuparCasillero();
            this.casillero = null;
            this.destruido = true;
        }
    }

    public void moverA(Casillero casillero){

        this.estado.moverA(casillero,this);


    }

    public boolean estaVivo() {

        return this.puntosDeVida > 0;

    }

    public boolean tieneBonusBurbuja() {

        return this.armadura.tieneBonusBurbuja();
    }

    public boolean tieneBonusFlash(){

        return this.piernas.tieneBonusFlash();

    }

    public boolean tieneDobleCanion(){

        return this.arma.tieneBonusDobleCanion();
    }


    public boolean estaEmpantanado() {

        return this.estado.obtenerMovimiento().estaEmpantanado();
    }

    public void cambiarAModoNoEmpantanado() {

        this.estado.obtenerMovimiento().cambiarAModoNoEmpantanado();

    }

    public boolean fueDestruido(){

        return this.destruido;
    }


    public String obtenerNombreDeEquipo(){
        return this.nombreDeEquipo;
    }

    public Armadura obtenerArmadura() {

        return this.armadura;

    }

    public Arma obtenerArma(){

        return this.arma;

    }

    public Piernas obtenerPiernas(){

        return this.piernas;

    }
}
