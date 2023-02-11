package Distributore;

public class DistributoreBevande {
    private Prodotto[] lista;
    private int cont=0;
    private double saldo=0;
    public DistributoreBevande(int lunghezzaLista){
        this.lista= new Prodotto[lunghezzaLista];
    }
    public void caricaProdotto(Prodotto p){
        if (cont<lista.length){
            this.lista[this.cont]=p;
            cont++;}
        else
            System.out.println("Macchinetta piena");
    }
    public void inserisciImporto(double soldi){
        this.saldo+=soldi;
    }
    public boolean scegliProdotto(Prodotto p){
        if(this.saldo> p.getPrezzo()){
            System.out.println("Erogazione "+p.getCodice());
            this.saldo=this.saldo - p.getPrezzo();
            return true;
        }
        else {
            System.out.println("Importo: " + this.saldo + " insufficiente.\n" + p.toString());
            return false;
        }
    }
    public double getResto(){
        double resto=this.saldo;
        this.saldo=0;
        return resto;
    }
    public double saldoAttuale() {
        return saldo;
    }
    @Override
    public String toString() {
        String s="Prodotti Disponibili:\n";
        for (Prodotto p:lista)
            s+=p.getCodice()+"\n";
        return s;
    }
}
