package SerieACollection;

import java.util.*;

class Squad {

    private int id;
    private String name;
    private Set<Footballer> squadList=new HashSet<>();
    private int points=0;
    private int goalScored=0;
    private int goalConceded=0;
    private String coach;



    public Squad(String name){
        this.name=name;
        this.id=name.hashCode();
    }
    public Squad(String name, Footballer[] rosa){
        this(name);
        for(Footballer footballer :rosa){
            addFootballer(footballer);
        }
    }

    public void addFootballer(Footballer footballer){
        this.squadList.add(footballer);
    }

    public String getname() {
        return name;
    }
    public int getgoalScored() {
        return goalScored;
    }
    public int getgoalConceded() {
        return goalConceded;
    }
    public int getPoints(){
        return points;
    }
    public int getId() {
        return id;
    }
    public void setgoalScored(int goalScored) {
        this.goalScored += goalScored;
    }
    public void setgoalConceded(int goalConceded) {
        this.goalConceded += goalConceded;
    }
    public void setPoints(int points) {
        this.points += points;
    }
    @Override
    public String toString() {
        return "Squadra{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", goalScored=" + goalScored +
                ", goalConceded=" + goalConceded +
                '}';
    }
    public String toStringSquadList() {
        String s="Rosa "+this.name+"\n";
        for (Footballer c:this.squadList) {
            s+=c.toString();
        }
        return s;
    }



}
