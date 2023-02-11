package SerieA;

import java.util.Arrays;
import java.util.Comparator;

public class Classifica {
    private String nome="Serie A";
    private Squadra[] squadre;
    public Classifica(Squadra... squadra){
        this.squadre=new Squadra[squadra.length];
        for(int i=0;i<squadra.length;i++)
            this.squadre[i]=squadra[i];
    }
    public void aggiungiSquadra(Squadra squadra){
        if(this.squadre==null){
            this.squadre=new Squadra[1];
            this.squadre[0]=squadra;}
        else{
            Squadra[] new_rosa=this.squadre;
            this.squadre= Arrays.copyOf(new_rosa,new_rosa.length+1);
            this.squadre[this.squadre.length-1]=squadra;
        }

    }
    //partita
    public void esitoPartita(Squadra casa,int golCasa,Squadra ospite,int golOspite){
        //aggiornare i gol nelle squadre
        int idx;
        aggiornaRisultato(casa,golCasa,golOspite);
        aggiornaRisultato(ospite,golOspite,golCasa);
        if(golCasa>golOspite){
           //aggiornare punteggio
            idx= trovaIdxSquadra(casa);
            this.squadre[idx].setPunteggio(3);
        }
        else if(golCasa<golOspite) {
            idx=trovaIdxSquadra(ospite);
            this.squadre[idx].setPunteggio(3);
        }
        else  {
            idx= trovaIdxSquadra(casa);
            this.squadre[idx].setPunteggio(1);
            idx=trovaIdxSquadra(ospite);
            this.squadre[idx].setPunteggio(1);
        }
    }
    public void aggiornaRisultato(Squadra squadra,int golFatti,int golSubiti){
        int idx=trovaIdxSquadra(squadra);
        this.squadre[idx].setGolFatti(golFatti);
        this.squadre[idx].setGolSubiti(golSubiti);
    }
    public int trovaIdxSquadra(Squadra squadra){
        for(int i=0;i<this.squadre.length;i++)
            if(this.squadre[i].getNome().equals(squadra.getNome()))
                return i;
        return 0;
    }
    public String migliorAttacco(){
        Squadra confronto=this.squadre[0];
        for (Squadra s:this.squadre)
            if (confronto.getGolFatti()<s.getGolFatti()){
                confronto=s;
            }
        return confronto.getNome();
    }
    public String migliorDifesa(){
        Squadra confronto=this.squadre[0];
        for (Squadra s:this.squadre)
            if (confronto.getGolSubiti()>s.getGolSubiti()){
                confronto=s;
            }
        return confronto.getNome();
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Classifica{" +
                "squadre=" + Arrays.toString(squadre) +
                '}';
    }
    public void getClassifica(){
        Arrays.sort(this.squadre, Comparator.comparing(Squadra::getPunteggio));
        for(Squadra s:this.squadre)
            System.out.println(s.toString());
    }
}
