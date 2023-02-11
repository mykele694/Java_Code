import java.util.Scanner;

public class Quadrati {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number:");
        int num=in.nextInt();
        System.out.println("Il quadrato di "+num+" è: "+square(num));

    }
    public static int square(int n){
        int sq=0;
        for (int i=1;i<=n;i++)
            sq+=(i*2)-1;
        return sq;
    }
}
