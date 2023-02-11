package Lampadina;

public class Lampadina2 {
    static boolean corrente=true;
    private Stato stato;
    int max_click;
    private int contatore=0;
    public enum Stato{
        SPENTO,ACCESO,ROTTO;
    }
    public Lampadina2(int max_click){
        this.stato=Stato.SPENTO;
        this.max_click=max_click;
    }

    public Stato getStato(){
        return this.stato;
    }

    public void click(){
        if (corrente){
        if (this.contatore>=this.max_click) this.stato=Stato.ROTTO;
        else
            if (this.stato==Stato.SPENTO) this.stato=Stato.ACCESO;
            else this.stato=Stato.SPENTO;
        //System.out.println(this.contatore);
        this.contatore++;}
    }

    public void checkcorrente(){
        if (!this.corrente)
            if(this.stato==Stato.ACCESO) this.stato=Stato.SPENTO;
    }

    public boolean getCorrente(){
        return corrente;
    }

    static void cambiaCorrente(){
        //change();
    }

    public void change(){
        this.corrente=!this.corrente;
        checkcorrente();
    }
}
