package Distributore;

public class Prodotto {
    protected String codice;
    protected double prezzo;

    public Prodotto(String codice,double prezzo){
        this.codice=codice;
        this.prezzo=prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codice='" + codice + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
