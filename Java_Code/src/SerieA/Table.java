package SerieA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Table {
    private String name="Serie A";
    private Squad[] squads; //20 elementi
    private ArrayList<String[][]> calendario; //Array di giornate pari a 20-1 (*2 se si considera andata e ritorno)
                                              // e per ogni giornata c'è una matrice di 10*2 con l'abbinamento di squadra
    public Table(Squad... squad){
        this.squads =new Squad[squad.length];
        for(int i = 0; i< squad.length; i++)
            this.squads[i]= squad[i];
    }
    public void addSquad(Squad squad){
        if(this.squads ==null){
            this.squads =new Squad[1];
            this.squads[0]= squad;}
        else{
            Squad[] new_rosa=this.squads;
            this.squads = Arrays.copyOf(new_rosa,new_rosa.length+1);
            this.squads[this.squads.length-1]= squad;
        }

    }
    //partita
    public void esitoPartita(Squad home, int goalHome, Squad away, int goalAway){
        //aggiornare i gol nelle squadre
        int idx;
        updateResult(home,goalHome,goalAway);
        updateResult(away,goalAway,goalHome);
        if(goalHome>goalAway){
           //aggiornare punteggio
            idx= findIdxSquad(home);
            this.squads[idx].setPoints(3);
        }
        else if(goalHome<goalAway) {
            idx=findIdxSquad(away);
            this.squads[idx].setPoints(3);
        }
        else  {
            idx= findIdxSquad(home);
            this.squads[idx].setPoints(1);
            idx=findIdxSquad(away);
            this.squads[idx].setPoints(1);
        }
    }
    public void updateResult(Squad squad, int goalScorded, int goalConceded){
        int idx=findIdxSquad(squad);
        this.squads[idx].setgoalScored(goalScorded);
        this.squads[idx].setgoalConceded(goalConceded);
    }
    public int findIdxSquad(Squad squad){
        for(int i = 0; i<this.squads.length; i++)
            if(this.squads[i].getname().equals(squad.getname()))
                return i;
        return 0;
    }
    public String bestAttack(){
        Squad confronto=this.squads[0];
        for (Squad s:this.squads)
            if (confronto.getgoalScored()<s.getgoalScored()){
                confronto=s;
            }
        return confronto.getname();
    }
    public String bestDefence(){
        Squad confronto=this.squads[0];
        for (Squad s:this.squads)
            if (confronto.getgoalScored()>s.getgoalScored()){
                confronto=s;
            }
        return confronto.getname();
    }
    public String getName() {
        return name;
    }

    public Squad[] getSquad() {
        return squads;
    }

    @Override
    public String toString() {
        return "Classifica{" +
                "squadre=" + Arrays.toString(squads) +
                '}';
    }
    public void getRanking(){
        Arrays.sort(this.squads, Comparator.comparing(Squad::getPoints));
        for(Squad s:this.squads)
            System.out.println(s.toString());
    }
    public boolean existSquad(String name){
        for (Squad s:this.squads)
            if(name.equals(s.getname()))
                return true;
        return false;
    }
    public void addPlayerToSquad(Squad squad, Footballer footballer){
        int idx=findIdxSquad(squad);
        this.squads[idx].aggiungiCalciatore(footballer);
    }
    public void generaCalendario(){
        String[][] giornata;
        int j,i,n;
        for (int num=0;num<19;num++){
            giornata=new String[10][2];//1. crea giornata
            this.calendario.add(giornata);
            for (i =0; i<this.squads.length/2; i++)
                j=i+10;
                this.calendario.get(num)[i][0]=this.squads[i].getname();
                this.calendario.get(num)[i][1]=this.squads[i].getname();
        }

        //   abbino due squadre non selezionate
        //1.1 seleziono una squadre
        //1.2 abbino la squadra ad un'altra non selezionata
        //1.3 controllo che l'abbinamento non si stato fatto


    }
}
