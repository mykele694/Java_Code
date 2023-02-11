package Negozio;

public class Main {
    public static void main(String[] args) {
        Prodotto prodotto1= new Prodotto("mela",2.00,30,true);
        Prodotto prodotto2= new Prodotto("pera",1.00,50,true);
        Prodotto prodotto3= new Prodotto("camicia",20.00,10,false);
        Prodotto prodotto4= new Prodotto("pasta",1.75,200,true);
        Prodotto prodotto5= new Prodotto("passata",2.50,15,true);
        Prodotto prodotto6= new Prodotto("maglietta",35.00,12,false);
        Prodotto prodotto7= new Prodotto("felpa",35.00,14,false);
        Negozio negozio= new Negozio("IPERCOOP");
//        negozio.aggiungiProdotto(prodotto1);
//        prodotto1= new Prodotto("mela",2.00,30,true);
//        negozio.aggiungiProdotto(prodotto2);
//        negozio.aggiungiProdotto(prodotto3);
//        negozio.aggiungiProdotto(prodotto4);
//        negozio.aggiungiProdotto(prodotto5);
//        negozio.aggiungiProdotto(prodotto6);
        negozio.aggiungiProdotto(prodotto1);
        prodotto1= new Prodotto("mela",2.00,30,true);
        negozio.mostraProdotti();
        negozio.aggiungiProdotto(prodotto1);
        prodotto1= new Prodotto("mela",2.00,30,true);
        negozio.mostraProdotti();
        negozio.aggiungiCliente(new Cliente("Mario",25));
        negozio.aggiungiCliente(new Cliente("Giorgio",70));
        negozio.riempiCarrello(new Cliente("Mario",25),new Prodotto("mela",2.00,20,true));
        prodotto1= new Prodotto("mela",2.00,30,true);
        negozio.riempiCarrello(new Cliente ("Giorgio",70),new Prodotto("mela",2.00,50,true));
        negozio.mostraProdotti();
        negozio.mostraClienti();
        negozio.paga(new Cliente ("Giorgio",70));
        negozio.paga(new Cliente("Mario",25));
        negozio.mostraProdotti();
        negozio.mostraClienti();
        negozio.registratoreCassa();
    }


}
