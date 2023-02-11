import java.util.Scanner;

public class OddToEven {
    public static void main(String[] args) {

        int[] num = {9, 3, 8, 4, 6, 1, 0, 3, 7, 2};
        for (int i:num)
            System.out.print(i+" ");
        for (int i = 0; i < num.length; i++)
            if (num[i] % 2 != 0)
                num[i] = num[i] * 2;
        for (int i:num)
            System.out.print(i+" ");
    }

}
