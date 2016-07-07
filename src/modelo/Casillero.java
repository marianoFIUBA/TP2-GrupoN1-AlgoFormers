package modelo;

public class Casillero {

    private int posicionX;
    private int posicionY;
    private AlgoFormer algoFormer;
    private Zona aire;
    private Zona superficie;
    private Bonus bonus;

    public Casillero (int posicionX, int posicionY, Zona aire, Zona superficie, Bonus bonus){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.aire = aire;
        this.superficie = superficie;
        this.bonus = bonus;
        this.algoFormer = null;

    }
    public void alojarPorAire(AlgoFormer algoFormer){

        algoFormer.setCasillero(this);
        this.algoFormer = algoFormer;
        this.aire.interactuarCon(algoFormer);
        this.aplicarBonus(algoFormer);
        //algoFormer.verificarSiSigueConVida();
    }

    public void alojarPorTierra(AlgoFormer algoFormer){

        algoFormer.setCasillero(this);
        this.algoFormer = algoFormer;
        this.superficie.interactuarCon(algoFormer);
        this.aplicarBonus(algoFormer);
        //algoFormer.verificarSiSigueConVida();
    }


    public int obtenerPosicionX(){

        return posicionX;
    }

    public int obtenerPosicionY() {
        return posicionY;
    }


    public String obtenerSuperficie(){

        return "";
    }

    public String obtenerZonaAerea(){

        return "";
    }

    public void desocupar(){

        this.algoFormer = null;
    }

    public AlgoFormer obtenerAlgoformer(){

        return this.algoFormer;
    }

    private void aplicarBonus(AlgoFormer algoFormer){

        if (this.bonus != null){

            this.bonus.aplicarA(algoFormer,this);
        }
    }

    public void borrarBonus() {

        this.bonus = null;
    }

    public boolean tieneBonus(){

        return this.bonus != null;
    }

    public String obtenerTierra(){

        return this.superficie.obtenerNombre();
    }

    public String obtenerAire(){

        return this.aire.obtenerNombre();
    }

    public Bonus obtenerBonus() {

        return this.bonus;

    }
}
