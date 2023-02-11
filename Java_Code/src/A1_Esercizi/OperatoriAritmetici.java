package Esercitazione1;

import java.util.Scanner;

public class OperatoriAritmetici {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
        System.out.print("Enter b:");
        int b=sc.nextInt();
        computeValues(a, b);
    }

    private static void computeValues(int a, int b) {
        //inserite qui il vostro codice
        System.out.println("La somma è: "+(a+b));
        System.out.println("La sottrazione è: "+(a-b));
        System.out.println("La moltiplicazione è: "+(a*b));
        System.out.println("La divisione è: "+((float)a/(float)b));
    }
}
