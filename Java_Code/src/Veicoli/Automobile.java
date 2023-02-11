package Veicoli;

public class Automobile extends Veicoli{
    protected int porte;

    public Automobile(String targa,int posti,int porte){
        super(targa,posti);
        this.porte=porte;
    }
    @Override
    public String toString() {
        return super.toString()+":"+porte;
    }
}
