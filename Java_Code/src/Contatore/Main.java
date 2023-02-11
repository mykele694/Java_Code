package Contatore;

public class Main {
    public static void main(String[] args) {

        provaContatoreClass();


    }

    public static void provaContatoreClass() {
        Contatore cont1 = new Contatore();
        Contatore cont2 = new Contatore(10);
        System.out.println("1° contatore: "+cont1.get());
        System.out.println("2° contatore: "+cont2.get());
        cont1.update(4);
        cont2.update();
        System.out.println("1° contatore: "+cont1.get());
        System.out.println("2° contatore: "+cont2.get());
        cont2.reset(cont1.get());
        cont1.reset();
        System.out.println("1° contatore: "+cont1.get());
        System.out.println("2° contatore: "+cont2.get());



    }
}
