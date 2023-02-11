import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Tombola {
    public static void main(String[] args) {
        ArrayList estratti = new ArrayList();
        Random rand = new Random();
        int[] punteggio=new int[3];
        for (int i=1;i<=90;i++)
            estratti.add(i);
        int cartella[][] = creaCartella();
        boolean bingo=false;
        int idx;

        while(bingo==false){
            idx=rand.nextInt(estratti.size());
            punteggio=checkNum(cartella,punteggio,(int)estratti.get(idx));
            System.out.println("Numero estratto: "+(int)estratti.get(idx));
            estratti.remove(idx);
            if (punteggio[0]+punteggio[1]+punteggio[2]==15)
                bingo=true;
        }
        System.out.println("BINGOOOO");


    }

    public static int[][] creaCartella() {
        int[][] car=new int[3][5];
        int ex;
        boolean check=false;
        Random rand = new Random();

        for (int j=0;j<3;j++) {
            ArrayList number = new ArrayList();
            for (int i = 1; i < 10; i++){
                check=false;
                switch (i) {
                    case 1 -> ex = (i - 1) * 10 + 1 + rand.nextInt(10);
                    case 9 -> ex = (i - 1) * 10 + rand.nextInt(11);
                    default -> ex = (i - 1) * 10 + rand.nextInt(10);
                }
                for (int k = 0; k < j; k++)
                    for (int el: car[j])
                        if (ex == el)
                            check=true;

                if (check == false) number.add(ex);
                else i--;

            }
            for (int i = 0; i < 4; i++)
                number.remove(rand.nextInt(number.size()));
            Collections.sort(number);
            for (int i = 0; i < 5; i++)
                car[j][i] = (int) number.get(i);
            //System.out.println(number.toString());
            System.out.println(Arrays.toString(car[j]));
        }
        return car;
    }
    public static int[] checkNum(int[][] car,int[] res,int ex){
        for (int i=0;i< car.length;i++)
            for (int j=0;j< car[i].length;j++)
                if (car[i][j]==ex) res[i]++;
        return res;
    }
}

