package Lampadina;

public class Interruttore {
    Lampadina2 lamp;

    public Interruttore(Lampadina2 lamp){
        this.lamp=lamp;
    }

    public void click(){
        lamp.click();
    }
}
