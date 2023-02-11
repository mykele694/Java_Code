import java.util.ArrayList;
import java.util.Scanner;

public class ContaLettere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word: ");
        String s = sc.nextLine();
        countvocals(s);

    }


    public static void countvocals(String s){
        ArrayList<Character> sc = new ArrayList<Character>();
        int num_v=0;
        sc.add('a');
        sc.add('e');
        sc.add('i');
        sc.add('o');
        sc.add('u');
        for (int i = 0; i < s.length(); i++) {
            if (sc.contains(s.charAt(i))) num_v+=1;
        }
        System.out.println("Ci sono: " + num_v + " vocali e: " + (s.length() - num_v) + " consonanti");

    /*public static void countvocals(String s) {
        int num_v = 0;
        String voc = "aeiou";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < voc.length(); j++) {
                if (s.charAt(i) == voc.charAt(j)) {
                    num_v += 1;
                    break;
                }
            }
        }
        System.out.println("Ci sono: " + num_v + " vocali e: " + (s.length() - num_v) + " consonanti");*/
    }
}