package Lampadina;

public class Lampadina {
    private int contatore=0;
    private int max_click;
    private String[] stato_s={"Spento","Acceso","Rotto"};
    private int stato_i;


    public Lampadina(int max_click){
        this.max_click=max_click;
    }

    public void click(){
        this.contatore++;
        aggiornaStato();
    }
    public void aggiornaStato(){
        if (this.contatore>=this.max_click){
            this.stato_i=2;
        }
        else
            this.stato_i=this.contatore%2;
    }
    public String getStato(){
        return this.stato_s[this.stato_i];
    }
}
