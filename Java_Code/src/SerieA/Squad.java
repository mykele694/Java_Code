package SerieA;

import java.util.Arrays;

class Squad {
    private int id;
    private String name;
    private Footballer[] squadList;
    private int points=0;
    private int goalScored=0;
    private int goalConceded=0;



    public Squad(String name){
        this.name=name;
        this.id=name.hashCode();
    }

    public Squad(String name, Footballer[] rosa){
        this(name);
        for(Footballer footballer :rosa){
            aggiungiCalciatore(footballer);
        }
    }

    public void aggiungiCalciatore(Footballer footballer){
        if(this.squadList==null){
            this.squadList=new Footballer[1];
            this.squadList[0]= footballer;}
        else{
            Footballer[] new_rosa=this.squadList;
            this.squadList= Arrays.copyOf(new_rosa,new_rosa.length+1);
            this.squadList[this.squadList.length-1]= footballer;
        }

    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getgoalScored() {
        return goalScored;
    }

    public int getgoalConceded() {
        return goalConceded;
    }

    public void setgoalScored(int goalScored) {
        this.goalScored += goalScored;
    }

    public void setgoalConceded(int goalConceded) {
        this.goalConceded += goalConceded;
    }

    public int getPoints(){
        return points;
    }

    public int getId() {
        return id;
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

    public String getname() {
        return name;
    }

    public String toStringSquadList() {
        String s="Rosa "+this.name+"\n";
        for (Footballer c:this.squadList) {
            s+=c.toString();
        }
        return s;
    }
}
