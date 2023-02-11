import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Anagrammi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b = sc.nextLine();
        anagrams(a, b);
    }

    static void anagrams(String a, String b) {
        //inserite qui il vostro codice
        char[] A = a.toLowerCase().toCharArray();
        char[] B = b.toLowerCase().toCharArray();

        Arrays.sort(A);
        Arrays.sort(B);

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        int val1 = Arrays.toString(A).hashCode();
        int val2 = Arrays.toString(B).hashCode();
        System.out.println(val1 + " -- " + val2);
        if (val1==val2)
            System.out.println("Sono Anagrammmi");

        int res = Arrays.toString(A).compareToIgnoreCase(Arrays.toString(B));
        System.out.println(res);
    }

}