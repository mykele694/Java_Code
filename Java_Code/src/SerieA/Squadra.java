package SerieA;

import java.util.Arrays;

public class Squadra {
    private int id;
    private String nome;
    private Calciatore[] rosaCalciatori;
    private int punteggio=0;
    private int golFatti=0;
    private int golSubiti=0;

    public Squadra(String nome){
        this.nome=nome;
        this.id=nome.hashCode();
    }

    public Squadra(String nome,Calciatore[] rosa){
        this(nome);
        for(Calciatore calciatore:rosa){
            aggiungiCalciatore(calciatore);
        }
    }

    public void aggiungiCalciatore(Calciatore calciatore){
        if(this.rosaCalciatori==null){
            this.rosaCalciatori=new Calciatore[1];
            this.rosaCalciatori[0]=calciatore;}
        else{
            Calciatore[] new_rosa=this.rosaCalciatori;
            this.rosaCalciatori= Arrays.copyOf(new_rosa,new_rosa.length+1);
            this.rosaCalciatori[this.rosaCalciatori.length-1]=calciatore;
        }

    }

    public void setPunteggio(int punteggio) {
        this.punteggio += punteggio;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void setGolFatti(int golFatti) {
        this.golFatti += golFatti;
    }

    public void setGolSubiti(int golSubiti) {
        this.golSubiti += golSubiti;
    }

    public int getPunteggio(){
        return punteggio;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "nome='" + nome + '\'' +
                ", punteggio=" + punteggio +
                ", golFatti=" + golFatti +
                ", golSubiti=" + golSubiti +
                '}';
    }

    public String getNome() {
        return nome;
    }
}
