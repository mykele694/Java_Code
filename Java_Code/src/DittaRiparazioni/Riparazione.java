package DittaRiparazioni;

import java.security.PublicKey;
import java.util.Scanner;

public class Riparazione {
    private String indirizzo;
    private Priority priorità;
    private String tecnico;
    private boolean eseguita=false;
    private int n_pratica;

    public enum Priority{
        BASSA,MEDIA,ALTA;
    }
    public Riparazione(String idx,Priority pr){
     this.indirizzo=idx;
     this.priorità=pr;
    }
    public Riparazione(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserisci indirizzo: ");
        String s=sc.nextLine();
        this.indirizzo=s;
        System.out.println("Definisci priorita 1=ALTA,2=MEDIA,3=BASSA");
        int pr=sc.nextInt();
        switch(pr){
            case 1:
                this.priorità=Priority.ALTA;
                break;
            case 2:
                this.priorità=Priority.MEDIA;
                break;
            case 3:
                this.priorità=Priority.BASSA;
                break;
        }
    }
    public void assegna_priorità(Priority pr){
        this.priorità=pr;
    }
    public Priority getPriority(){
        return priorità;
    }
    public String getNome(){
        return this.indirizzo;
    }
    public String getTecnico(){
        return tecnico;
    }
    public void riparazioneSvolta(){
        this.eseguita=true;
    }
    public void setTecnico(String tecnico){this.tecnico=tecnico;}
    public void setN_pratica(int num){
        this.n_pratica=num;
    }
    public int getN_pratica(){
        return this.n_pratica;
    }
}
