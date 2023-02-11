import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated):");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        int[] merged = mergeSortArr(values);
        System.out.println(Arrays.toString(merged));
    }
    public static int[] parseNumbers(String s) {
        //inserite qui il vostro codice
        String[] arr_s=s.split(",");
        int[] arr_num= new int[arr_s.length];
        for (int i=0;i<arr_s.length;i++)
            arr_num[i]=Integer.parseInt(arr_s[i]);
        return arr_num;
    }

    public static int[] mergeSortArr(int[] val) {
        if (val.length == 0)
            return val;
        else if (val.length == 1)
            return val;
        else if (val.length == 2)
            return sort(val);
        else {
            int mid = val.length / 2;
            return mergeSortArr(Arrays.copyOf(val, mid), Arrays.copyOfRange(val, mid, val.length));
        }
    }

    public static int[] mergeSortArr(int[]arr1,int[]arr2){
        int[] new_arr1=mergeSortArr(arr1);
        int[] new_arr2=mergeSortArr(arr2);
        return merge(new_arr1,new_arr2);
    }
    public static int[]merge(int[] arr1,int[]arr2){
        int i=0;
        int j=0;
        int k=0;
        int[] arr_merg=new int[arr1.length+arr2.length];
        while(i < arr1.length && j<arr2.length){
            if (arr1[i]<arr2[j]) {
                arr_merg[k]=arr1[i];
                i++;
            }
            else {
                arr_merg[k]=arr2[j];
                j++;
            }
            k++;
        }
        if (i==arr1.length)
            for(j=j;j<arr2.length;j++) {
                arr_merg[k] = arr2[j];
                k++;
            }
        else
            for(i=i;i<arr1.length;i++) {
                arr_merg[k] = arr1[i];
                k++;
            }
        return arr_merg;
    }
    public static int[] sort(int[] arr1){
        int temp;
        if (arr1[0]<arr1[1])
            return arr1;
        else {
            temp = arr1[0];
            arr1[0] = arr1[1];
            arr1[1] = temp;
            return arr1;
        }
    }
}
