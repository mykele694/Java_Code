package Negozio;

import java.util.Arrays;

public class Cliente {
    private String id;
    private int eta;
    private Prodotto[] carrello;

    public Cliente(String id, int eta) {
        this.id = id;
        this.eta = eta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", eta=" + eta +
                ", carrello=" + Arrays.toString(carrello) +
                '}';
    }

    public void mettiinCarrello(Prodotto prod){
        if(this.carrello==null){
            this.carrello=new Prodotto[1];
            this.carrello[0]=prod;
        }
        else {
            Prodotto[] old_lista = this.carrello;
            this.carrello = Arrays.copyOf(old_lista, old_lista.length + 1);
            this.carrello[this.carrello.length - 1] = prod;
        }
    }
    public void toglidalCarrello(Prodotto prod){
        if(this.carrello!=null)
            for(int i=0;i<this.carrello.length;i++){
                if (this.carrello[i].getNome().equals(prod.getNome()))
                    this.carrello[i].setQuantita(this.carrello[i].getQuantita()+prod.getQuantita());
                if (this.carrello[i].getQuantita()<=0)
                    togliProdotto(this.carrello[i]);
                break;
            }
    }
    public void togliProdotto(Prodotto prod){
        int i,j;
        for ( i=0;i<this.carrello.length;i++)
            if(this.carrello[i].getNome().equals(prod.getNome()))
                break;;
        Prodotto[] new_list=new Prodotto [this.carrello.length-1];
        for ( j=0;j<new_list.length;j++)
            if(j>=i)
                new_list[j]=this.carrello[j+1];
            else
                new_list[j]=this.carrello[j];
        this.carrello=new_list;
    }
    public boolean isCarrello(){
        return (this.carrello!=null)?true:false;
    }
    public Prodotto[] getCarrello(){
        return this.carrello;
    }
}
