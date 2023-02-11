package Esercitazione1;

import java.util.Scanner;

public class Intrusi {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string: ");
        String a=sc.nextLine();
        System.out.print("Enter string: ");
        String b=sc.nextLine();
        System.out.print("Enter string (with two space): ");
        String c=sc.nextLine();
        replaceIntruder(a, b, c);
    }

    private static void replaceIntruder(String a, String b , String c) {
        //inserite qui il vostro codice
        String[] arr=c.split(" ");
        arr[1] = arr[1].replace(a, b);
        String new_c = arr[0]+" "+arr[1]+" "+arr[2];
        String result = String.join(" ",arr);
        System.out.println(new_c);
        System.out.println(result);

    }

}