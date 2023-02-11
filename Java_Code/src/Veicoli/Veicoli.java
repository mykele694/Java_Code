package Veicoli;

public class Veicoli {
    protected String targa;
    protected int posti;

    public Veicoli(String targa, int posti) {
        this.targa = targa;
        this.posti = posti;
    }

    @Override
    public String toString() {
        return "Targa='" + targa +"' ";
    }
}
