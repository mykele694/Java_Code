package Lampadina;

import Contatore.Contatore;

public class Main {
    public static void main(String[] args) {

        provaLampadinaClass();


    }
    public static void corr(){
        boolean corrente=!Lampadina2.corrente;
    }
    public static void provaLampadinaClass(){
        Lampadina2 lamp=new Lampadina2(5);
        Lampadina2 lamp2=new Lampadina2(5);
        Interruttore int1= new Interruttore(lamp);
        Interruttore int2= new Interruttore(lamp);
        Interruttore int3=new Interruttore(lamp2);
        System.out.println(lamp.getStato());
        while(!(Lampadina2.Stato.ROTTO == lamp.getStato())){
            System.out.println("CORRENTE 1: "+lamp.getCorrente());
            System.out.println("CORRENTE 2: "+lamp2.getCorrente());
            int1.click();
            System.out.println("lamp1:"+lamp.getStato());
            int2.click();
            System.out.println("lamp1:"+lamp.getStato());
            int3.click();
            System.out.println("lamp2;"+lamp2.getStato());
            lamp.cambiaCorrente();


        }
        //System.out.println(lamp.getStato());
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
