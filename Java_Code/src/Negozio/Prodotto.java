package Negozio;

public class Prodotto {
    private String nome;
    private boolean alimentare;
    private int quantita;
    private double prezzo;

    public Prodotto(String nome,double prezzo,int quantita,boolean alimentare){
        this.nome=nome;
        this.alimentare=alimentare;
        this.quantita=quantita;
        this.prezzo=prezzo;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAlimentare() {
        return alimentare;
    }

    public int getQuantita() {
        return quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlimentare(boolean alimentare) {
        this.alimentare = alimentare;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", alimentare=" + alimentare +
                ", quantita=" + quantita +
                ", prezzo=" + prezzo +
                '}';
    }
}
