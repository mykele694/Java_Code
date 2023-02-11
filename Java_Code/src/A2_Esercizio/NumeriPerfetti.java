import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumeriPerfetti {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
        int [] perfect=perfectNum(a);
        System.out.println(Arrays.toString(perfect));
    }

    public static int[] perfectNum(int n){
        ArrayList numeri=new ArrayList<>();
        for (int i=1;i<=n;i++){
            int sum=0;
            for (int j=1;j<=i/2;j++) {
                if (i % j == 0)
                    sum += j;
                if (sum > i) break;
            }
            if (sum==i)
                numeri.add(i);
        }
        int[] arr = numeri.stream().mapToInt(i -> (int) i).toArray();
        return arr;
    }
}
