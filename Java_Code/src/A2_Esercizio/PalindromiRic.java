import java.util.Arrays;
import java.util.Scanner;

public class PalindromiRic {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter line:");
        String a = sc.nextLine();
        String[] s_arr=a.split(" ");
        a="";
        for (int i=0;i<s_arr.length;i++)
            a+=s_arr[i];
        if (isPalindroma_arr(a.split(""))==true)
            System.out.println("L'array è palindroma");
        else
            System.out.println("Non è palindroma");
        if (isPalindroma_str(a)==true)
            System.out.println("La stringa è palindroma");
        else
            System.out.println("Non è palindroma");
    }

    public static boolean isPalindroma_arr(String[] parola){
        switch (parola.length){
            case 1 : return true;
            case 2 : return (parola[0].equals(parola[1])) ? true:false;
            default: return (parola[0].equals(parola[parola.length-1])) ? isPalindroma_arr(Arrays.copyOfRange(parola,1,parola.length-1)):false;
        }
    }

    public static boolean isPalindroma_str(String parola)
    {
        return isPalindroma_str(parola,0,parola.length()-1);
    }

    public static boolean isPalindroma_str(String parola,int i,int j){
        if (i>= j) return true;
        if  (parola.charAt(i)!=parola.charAt(j)) return false;
        return isPalindroma_str(parola,i+1,j-1);
    }
}
