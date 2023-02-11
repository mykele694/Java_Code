package Esercitazione1;

import java.util.Scanner;

public class PariDispari {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number:");
        int number =sc.nextInt();
        checkEvenOdd(number);
    }

    private static void checkEvenOdd(int number) {
        //inserite qui il vostro codice
        int odd=number%2;
        if (odd==0){
        System.out.println("Il numero "+number+" è pari");}

        else if (odd==1) {
            System.out.println("Il numero "+number+" è dispari");

        }
    }
}