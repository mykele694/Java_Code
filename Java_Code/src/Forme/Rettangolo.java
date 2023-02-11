package Forme;

public class Rettangolo {
    protected double area;
    protected double perimetro;
    protected String forma="Rettangolo";

    protected double latoMin;
    protected double latoMax;

    public Rettangolo(double latoMin,double latoMax){
        area=latoMax*latoMin;
        perimetro=2*latoMax+2*latoMin;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public String getForma() {
        return forma;
    }

    public double getLatoMin() {
        return latoMin;
    }

    public double getLatoMax() {
        return latoMax;
    }

    @Override
    public String toString() {
        return "Rettangolo{" +
                "forma='" + forma + '\'' +
                '}';
    }
}
