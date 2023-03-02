package SerieACollection;

import SerieACollection.Footballer;
import SerieACollection.Squad;

import java.util.*;
class Table {

    private String name="Serie A";
    private ArrayList<Squad> squads=new ArrayList<>(); //20 elementi
    private ArrayList<String[][]> calendario; //Array di giornate pari a 20-1 (*2 se si considera andata e ritorno)
    // e per ogni giornata c'è una matrice di 10*2 con l'abbinamento di squadra
    public Table(Squad... squad){
        for(Squad new_squad:squad)
            this.squads.add(new_squad);
    }
    public void addSquad(Squad squad){
        this.squads.add(squad);
        this.squads.sort(Comparator.comparing(Squad::getname));
        }
    public void addPlayerToSquad(Squad squad, Footballer footballer){
        //Iterator<Squad> squadIterator=squads.iterator();
        for(Squad squadI:this.squads)
            if(squadI.getname().equals(squad.getname())){
                squadI.addFootballer(footballer);
                return;
            }
    }
    //partita
    public void esitoPartita(Squad home, int goalHome, Squad away, int goalAway){
        //aggiornare i gol nelle squadre
        updateResult(home,goalHome,goalAway);
        updateResult(away,goalAway,goalHome);
        if(goalHome>goalAway)
            updatePoints(home,3); //aggiornare punteggio
        else if(goalHome<goalAway)
            updatePoints(away,3);
        else  {
            updatePoints(home,1);
            updatePoints(away,1);
        }
    }
    public void updateResult(Squad squad, int goalScorded, int goalConceded){
        for (Squad squadI:this.squads) {
            if(squadI.getname().equals(squad.getname())){
                squadI.setgoalScored(goalScorded);
                squadI.setgoalConceded(goalConceded);
                return;
            }
        }
    }
    public void updatePoints(Squad squad,int points){
        for (Squad squadI:this.squads) {
            if(squadI.getname().equals(squad.getname())){
                squadI.setPoints(points);
                return;
            }
        }
    }
    public String bestAttack(){
        Squad confronto=this.squads.get(0);
        for (Squad s:this.squads)
            if (confronto.getgoalScored()<s.getgoalScored()){
                confronto=s;
            }
        return confronto.getname();
    }
    public String bestDefence(){
        Squad confronto=this.squads.get(0);
        for (Squad s:this.squads)
            if (confronto.getgoalScored()>s.getgoalScored()){
                confronto=s;
            }
        return confronto.getname();
    }
    public String getName() {
        return name;
    }
    public ArrayList<Squad> getSquad() {
        return squads;
    }
    public void getRanking(){
        //Arrays.sort(this.squads, Comparator.comparing(Squad::getPoints));
        for(Squad s:this.squads)
            System.out.println(s.toString());
    }
    public boolean isInSquad(String name){
        for(Squad squad:this.squads)
            if(squad.getname().equals(name))
                return true;
        return false;
    }
  // @Override
//    public String toString() {
//        return "Classifica{" +
//                "squadre=" + Arrays.toString(squads) +
//                '}';
//    }

    public boolean existSquad(String name){
        for (Squad s:this.squads)
            if(name.equals(s.getname()))
                return true;
        return false;
    }

 /*   public void generaCalendario(){
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


    }*/
}
