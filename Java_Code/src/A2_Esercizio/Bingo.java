public class Bingo {
    public static void main(String[] args) {


        int[][] cartella1 = {{1, 3, 9, 21, 24}, {5, 37, 41, 60, 67}, {42, 71, 86, 87, 90}};         //Ambo e terno nelle righe 2 e 3
        int[][] cartella2 = {{42, 48, 55, 56, 4}, {72, 84, 86, 88, 90}, {60, 63, 20, 50, 89}};      //Quaterna e cinquina nelle righe 1 e 2
        int[][] cartella3 = {{1, 5, 11, 23, 24}, {30, 39, 42, 48, 55}, {56, 61, 62, 69, 70}};       //Tombola
        int[] estrazione = {1, 5, 11, 23, 24, 30, 39, 42, 48, 55, 56, 61, 62, 69, 70, 72, 84, 86, 88, 90};

        checkbingo(cartella1,estrazione);
        checkbingo(cartella2,estrazione);
        checkbingo(cartella3,estrazione);
    }

    public static void checkbingo(int[][] tabella,int[] estratti) {

        int[] result = new int[4];
        int count = 0;
        for (int i = 0; i < tabella.length; i++) {
            count = 0;
            //System.out.println(Arrays.toString(tabella[i]));
            for (int j = 0; j < tabella[0].length; j++) {
                for (int n = 0; n < estratti.length; n++) {
                    if (tabella[i][j] == estratti[n])
                        count++;
                }
            }
            switch (count){
                case 2 -> result[0]++;
                case 3 -> result[1]++;
                case 4 -> result[2]++;
                case 5 -> result[3]++;
            }
         /*   switch (count) {
                case 2 :
                    result = new int[]{result[0] + 1, result[1], result[2], result[3]};
                    break;
                case 3:
                    result = new int[]{result[0], result[1] + 1, result[2], result[3]};
                    break;
                case 4:
                    result = new int[]{result[0], result[1], result[2] + 1, result[3]};
                    break;
                case 5:
                    result = new int[]{result[0], result[1], result[2], result[3] + 1};
                    break;
                default:
                    result = new int[]{result[0], result[1], result[2], result[3]};
                }*/
                //System.out.println("Ambo: "+result[0]+" Terno: "+result[1]+" Quaterna: "+result[2]+" Cinquina: "+result[3]);

        }
        if (result[3]==3)
            System.out.println("BINGOOOO");
        else
            System.out.println("Ambo: "+result[0]+" Terno: "+result[1]+" Quaterna: "+result[2]+" Cinquina: "+result[3]);
    }



}
