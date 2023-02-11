import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int two=1;
        int one=1;
        int res=1;

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number:");

        int num=sc.nextInt();
        for (int i=1;i<=num;i++)
        {
            two=res;
            res=res+one;
            one=two;
            System.out.println(res);
        }
        System.out.println(res);
    }

}
