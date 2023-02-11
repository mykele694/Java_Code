import java.util.Arrays;
import java.util.Scanner;

public class TrovaNumeriPrimi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        do {
            System.out.print("Enter number (min2):");
            num=sc.nextInt();
        }while(num<2);

        int[] ex= {2};
        int[] arr=trovaPrimi(ex,num);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] trovaPrimi(int[] arr,int num){
        boolean primo=true;
        for (int i=arr[arr.length-1]+1;i<=num;i++){
            primo=true;
            for (int j=0;j<arr.length;j++)
                if (i%arr[j]==0) {
                    primo = false;
                    break;
                }

            if(primo==true) {
                int[] new_arr = new int[arr.length + 1];
                for (int k = 0; k < arr.length; k++)
                    new_arr[k] = arr[k];
                new_arr[arr.length] = i;
                return trovaPrimi(new_arr, num);
            }
        }
        return arr;
    }

}
