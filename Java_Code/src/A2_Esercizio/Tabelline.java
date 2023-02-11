import java.util.Arrays;
import java.util.Scanner;

public class Tabelline {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number n: ");
        int n=sc.nextInt();
        System.out.print("Enter Number m: ");
        int m=sc.nextInt();
        int[] tab= new int[m];
        for (int i=0; i<m;i++)
            tab[i]=n*i;
        System.out.println(Arrays.toString(tab));
    }
}
