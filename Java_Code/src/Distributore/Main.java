package Distributore;

public class Main {
    public static void main(String[] args) {
        Caffe caffe=new Caffe();
        Cappuccino capp=new Cappuccino();
        DistributoreBevande macchinetta=new DistributoreBevande(5);
        macchinetta.caricaProdotto(caffe);
        macchinetta.caricaProdotto(caffe);
        macchinetta.caricaProdotto(capp);
        macchinetta.caricaProdotto(caffe);
        macchinetta.caricaProdotto(capp);
        macchinetta.caricaProdotto(caffe);
        System.out.println(caffe.toString());
        System.out.println(capp.toString());
        System.out.println(macchinetta.toString());
        macchinetta.inserisciImporto(0.1);
        macchinetta.scegliProdotto(caffe);
        macchinetta.inserisciImporto(0.5);
        System.out.println("Saldo: "+macchinetta.saldoAttuale());
        macchinetta.scegliProdotto(caffe);
        System.out.println("Resto: "+macchinetta.getResto());
        System.out.println("Saldo: "+macchinetta.saldoAttuale());
    }
}
