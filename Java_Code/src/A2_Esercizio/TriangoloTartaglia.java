import java.util.Arrays;
import java.util.Scanner;

public class TriangoloTartaglia {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
        int[] riga=tartagliaTriangle(new int[]{1},a);
        System.out.println(Arrays.toString(riga));

    }

    public static int[] tartagliaTriangle(int[] arr,int n){
        if (n==0) return arr;

        int[] new_arr = new int[arr.length + 1];
        new_arr[0] = 1;
        new_arr[new_arr.length-1]= 1;
        for (int i=1;i<new_arr.length-1;i++) {
                new_arr[i] = arr[i-1]+arr[i];
            }
        if (n+1 == new_arr.length) return new_arr;
        else return tartagliaTriangle(new_arr,n);
    }

}
