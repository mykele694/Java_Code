import java.util.Arrays;
import java.util.Scanner;

/*Dato un array di interi (inseriti dall’utente, separati da virgola e senza spazi),
effettuare la conversione dei valori in interi e stampare in ordine minimo e massimo (separati da virgola).

Gli interi inseriti possono anche assumere valori negativi.
*/
public class MinMax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated):");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        System.out.println(Arrays.toString(values));
        computeMinAndMax(values);
    }

    static int[] parseNumbers(String s) {
        //inserite qui il vostro codice
        String[] arr_s=s.split(",");
        int[] arr_num= new int[arr_s.length];
        for (int i=0;i<arr_s.length;i++)
            arr_num[i]=Integer.parseInt(arr_s[i]);
        return arr_num;
    }

    static void computeMinAndMax(int[] values) {
        //inserite qui il vostro codice
        String sc="";
        int min=values[0];
        int max=values[0];
        for (int i=1;i<values.length;i++) {
            if (values[i] > max) max = values[i];
            else if (values[i] < min) min = values[i];
        }
        sc= min+","+max;
        System.out.println(sc);
        System.out.println("Min: "+min+" Max: "+max);
        }

}