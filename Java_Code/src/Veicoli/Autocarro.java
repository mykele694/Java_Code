package Veicoli;

public class Autocarro extends Veicoli{
    private int quintali;

    public Autocarro(String targa,int posti, int quintali){
        super(targa,posti);
        this.quintali =quintali;
    }

    @Override
    public String toString() {
        return super.toString()+":"+quintali;
    }
}
