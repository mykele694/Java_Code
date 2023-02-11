package DittaRiparazioni;

import java.util.Scanner;

public class Tecnico {
    private String nome;
    private String intervento;
    public Tecnico(String nome){
        this.nome=nome;
    }
    public Tecnico(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserisci nome tecnico: ");
        String s=sc.nextLine();
        this.nome=s;
    }
    public String getNome(){
        return nome;
    }

    public String getIntervento(){
        return intervento;
    }
    public void setIntervento(String intervento){
        this.intervento=intervento;
    }

    public void reset(){
        this.intervento=null;
    }
}
