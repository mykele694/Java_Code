import java.util.Arrays;
import java.util.Scanner;

public class TriangoloTartagliaDiverso {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
        int[] riga=tartagliaTriangle2(a);
        System.out.println(Arrays.toString(riga));
    }

    public static int[] tartagliaTriangle2(int n){
        int[] riga=new int[n+1];
        if (n==0) {
            riga[n] = 1;
            return riga;
        }

        int[] riga_interna=tartagliaTriangle2(n-1);

        riga[0]=1;
        riga[n]=1;

        for(int i=1;i<n;i++)
            riga[i]=riga_interna[i-1]+riga_interna[i];
        return riga;
    }
}
