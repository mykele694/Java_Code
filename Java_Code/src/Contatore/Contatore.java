package Contatore;

public class Contatore {
    private int contatore;

    public  Contatore(){
        this.contatore=0;
    }
    public  Contatore(int contatore){
        this.contatore=contatore;
    }
    public void update(){
        this.contatore++;
    }
    public void update(int x){
        this.contatore+=x;
    }
    public void reset(){
        this.contatore=0;
    }
    public void reset(int contatore){
        this.contatore=contatore;
    }
    public int get(){
        int contatore=this.contatore;
        return contatore;
    }
}
