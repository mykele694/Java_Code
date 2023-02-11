import java.util.ArrayList;
import java.util.Scanner;

public class Copy {
    public static void main(String[] args) {
    }
    public static void EnterInt(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
    }
    public static void EnterString(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter line:");
        String a = sc.nextLine();
    }
    public static void createArrList(){
        ArrayList<Character> sc = new ArrayList<Character>();
        sc.add('a');
        sc.add('e');
        sc.add('i');
        sc.add('o');
        sc.add('u');
    }

}
