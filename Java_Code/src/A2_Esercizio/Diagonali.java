import java.util.Scanner;

public class Diagonali {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean choose = true;
        int[][] mat = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {8, 5, 6, 7}};
        System.out.println("La somma della diagonale da sx-dx: " + sumdiag(mat, choose));
        System.out.print("Enter L for left-diag-sx or R for right-diag: ");
        String a = sc.nextLine();
        if (a.equals("L")){
            choose = true;
            System.out.println("La somma della diagonale da sx-dx: " + sumdiag(mat, choose));
         }
         else if(a.equals("R"))
        {
            choose=false;
            System.out.println("La somma della diagonale da dx-sx: " + sumdiag(mat, choose));
        }

    }

    public static int sumdiag(int[][] mat,boolean x){
        int res=0;
        if (x==true)
            for(int i=0;i<mat[0].length;i++)
                res+=mat[i][i];
        else
            for(int i=mat[0].length-1;i>=0;i--)
                res+=mat[i][mat[0].length-1-i];

        return res;
    }
}
