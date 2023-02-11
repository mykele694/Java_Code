package Negozio;

import java.util.Arrays;

public class Negozio {
    String nome;
    Prodotto[] prodotti;
    Cliente[] clienti;
    Giorni giorno=Giorni.LUN;
    double cassa;

    public Negozio(String nome){
        this.nome=nome;
    }
    public void aggiungiProdotto(Prodotto prod){
        if(this.prodotti==null){
            this.prodotti=new Prodotto[1];
            this.prodotti[0]=prod;}
        else{
            if(productPresent(prod))
            {
                System.out.println(prod.getNome()+" presenti");
                modificaQuantita(prod,true);}
            else
                if(this.prodotti.length>=100)
                    System.out.println("Negozio pieno");
                else
                    add_prodotto(prod);
        }
    }
    public boolean productPresent(Prodotto prod){
        for(Prodotto p:this.prodotti)
            if (p.getNome().equals(prod.getNome()))
                return true;
        return false;
    }
    public void modificaQuantita(Prodotto prod,boolean in_out){
        int quantita;
        if(in_out)
            quantita=prod.getQuantita();
        else
            quantita=-prod.getQuantita();
        for(int i=0;i<this.prodotti.length;i++){
            if (this.prodotti[i].getNome().equals(prod.getNome()))
            {
                System.out.println("Aggiungo "+prod.getQuantita()+" "+prod.getNome());
                quantita+=this.prodotti[i].getQuantita();
                this.prodotti[i].setQuantita(quantita);}
            if (this.prodotti[i].getQuantita()<=0)
                removeProdotto(this.prodotti[i]);
            break;
        }
    }
    public void removeProdotto(Prodotto prod){
        int i,j;
        for ( i=0;i<this.prodotti.length;i++)
            if(this.prodotti[i].getNome().equals(prod.getNome()))
                break;;
        Prodotto[] new_list=new Prodotto [this.prodotti.length-1];
        for ( j=0;j<new_list.length;j++)
            if(j>=i)
                new_list[j]=this.prodotti[j+1];
            else
                new_list[j]=this.prodotti[j];
        this.prodotti=new_list;
    }
    public void add_prodotto(Prodotto prod){
        Prodotto[] old_lista = this.prodotti;
        this.prodotti = Arrays.copyOf(old_lista, old_lista.length + 1);
        this.prodotti[this.prodotti.length - 1] = prod;
    }
    public void aggiungiCliente(Cliente client){
        if(this.clienti==null){
            this.clienti=new Cliente[1];
            this.clienti[0]=client;}
        else {
            if (clientPresent(client))
                System.out.println("Cliente già iscritto");
            else {
                Cliente[] old_lista = this.clienti;
                this.clienti = Arrays.copyOf(old_lista, old_lista.length + 1);
                this.clienti[this.clienti.length - 1] = client;
            }
        }
    }
    public boolean clientPresent(Cliente client){
        for(Cliente c:this.clienti)
            if (c.getId().equals(client.getId()))
                return true;
        return false;
    }
    public void mostraProdotti(){
        if(this.prodotti!=null)
            for(Prodotto p:this.prodotti)
                System.out.println(p.toString());
        else
            System.out.println("Negozio vuoto");
    }
    public void riempiCarrello(Cliente cliente,Prodotto prod){
        if(this.prodotti!=null){
            if(clientPresent(cliente)) {
                for (Prodotto p : this.prodotti) {
                    if (prod.getNome().equals(p.getNome()))
                        if (prod.getQuantita() <= p.getQuantita())
                            for (Cliente c : this.clienti) {
                                if(c.getId().equals(cliente.getId())) {
                                    c.mettiinCarrello(prod);
                                    modificaQuantita(prod, false);
                                    break;
                                }
                            }
                        else
                            System.out.println("Disponibilita limitata: " + p.getQuantita());
                }
                //System.out.println("Non c'è il prodotto "+prod.getNome());
            }
            else
                System.out.println("Cliente non registrato");
        }
        else System.out.println("Negozio vuoto");
    }
    public void svuotaCarrello(Cliente cliente,Prodotto prod){
        if(clientPresent((cliente)))
            for(int i=0;i<this.clienti.length;i++)
                if(this.clienti[i].getId().equals(cliente.getId()))
                    if(this.clienti[i].isCarrello())
                        for (int j=0;j<this.clienti[i].getCarrello().length;j++)
                            if(this.clienti[i].getCarrello()[j].getNome().equals(prod.getNome())){
                                this.clienti[i].toglidalCarrello(prod);
                                aggiungiProdotto(prod);
                            }
        else System.out.println("Cliente non presente in negozio");
    }
    public void paga(Cliente cliente){
        double totale=0;
        System.out.print(cliente.getId()+" ha pagato ");
        if(clientPresent(cliente))
            for(Cliente c:this.clienti)
                if(c.getId().equals(cliente.getId())){
                    if (c.isCarrello())
                        for(Prodotto p:c.getCarrello()){
                            totale+=calcolaPrezzo(p,c);
                            c.togliProdotto(p);
                        }
                    this.cassa+=totale;
                    System.out.println(totale);
                }
    }
    public double calcolaPrezzo(Prodotto prod,Cliente cliente){
        double totale=0;
        switch(this.giorno){
            case LUN:
                if(prod.isAlimentare())
                    if(cliente.getEta()>=60)
                        totale=(prod.getPrezzo()-prod.getPrezzo()*0.2)*prod.getQuantita();
                    else
                        totale=prod.getPrezzo()*prod.getQuantita();
                else
                    totale=prod.getPrezzo()*prod.getQuantita();
                break;
            case MAR:
                totale=prod.getPrezzo()*prod.getQuantita();
                break;
            case MER:
                if(prod.isAlimentare())
                    if(cliente.getEta()>=60)
                        totale=(prod.getPrezzo()-prod.getPrezzo()*0.2)*prod.getQuantita();
                    else
                        totale=prod.getPrezzo()*prod.getQuantita();
                else
                    totale=prod.getPrezzo()*prod.getQuantita();
                break;
            case GIO:
                totale=prod.getPrezzo()*prod.getQuantita();
                break;
            case VEN:
                totale=prod.getPrezzo()*prod.getQuantita();
                break;
            case SAB:
                totale=prod.getPrezzo()*prod.getQuantita();
                break;
            case DOM:
                totale=prod.getPrezzo()*prod.getQuantita();
                break;
            default:
                break;
        }
        return totale;
    }
    public void mostraClienti(){
        if(this.clienti!=null)
            for(Cliente p:this.clienti)
                System.out.println(p.toString());
    }
    public void registratoreCassa(){
        System.out.println("Incasso alla chiusura: "+this.cassa);

    }
}
