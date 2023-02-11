package Lampadina;

public class Corrente {
    private boolean stato=false;

    public Corrente(){
        this.stato=true;
    }

    public void on_off(){
        this.stato=!this.stato;
    }
}
