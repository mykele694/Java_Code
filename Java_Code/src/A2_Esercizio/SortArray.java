import java.util.Arrays;
import java.util.Scanner;

/*Dato un array di interi (inseriti dall’utente, separati da virgola e senza spazi),
effettuare la conversione dei valori in interi e stampare in ordine crescente l'array (separati da virgola).

Gli interi inseriti possono anche assumere valori negativi.
*/
public class SortArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated):");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        System.out.println(Arrays.toString(values));
        sortNum(values);
    }

    static int[] parseNumbers(String s) {
        //inserite qui il vostro codice
        String[] arr_s=s.split(",");
        int[] arr_num= new int[arr_s.length];
        for (int i=0;i<arr_s.length;i++)
            arr_num[i]=Integer.parseInt(arr_s[i]);
        return arr_num;
    }

    static void sortNum(int[] values) {
        //inserite qui il vostro codice
        int temp;
        int index=0;
        int[] new_arr= new int[values.length];
        for (int i=0;i<values.length;i++) {
            index=i;
            for (int j = i+1; j < values.length; j++) {
                if (values[i] > values[j])
                    index = j;
            }
            temp=values[i];
            values[i]=values[index];
            values[index]=temp;
        }
        System.out.println(Arrays.toString(values));
    }

}