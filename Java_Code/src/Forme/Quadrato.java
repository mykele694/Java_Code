package Forme;

public class Quadrato extends Rettangolo{
    private double lato;


    public Quadrato(double lato) {
        super(lato, lato);
        super.forma="Quadrato";
    }
}
