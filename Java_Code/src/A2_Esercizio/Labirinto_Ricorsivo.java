import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labirinto_Ricorsivo {
    public static void main(String[] args) {
        ArrayList dirDisp=new ArrayList<>();
        //reset_direzione(dirDisp);
        Scanner sc = new Scanner(System.in);
        int dim= sc.nextInt();
        char [][] lab= new char[dim][dim];
        stampaLabirinto(lab);
        generoLab(lab,dim);
        stampaLabirinto(lab);

    }
    public static void creoTable(char [][] lab){
        for  (int i=0;i<lab.length;i++)
            for (int j=0;j<lab[i].length;j++)
                if (i==0||j==0||i==lab.length-1||j==lab[i].length-1)
                    lab[i][j]='W';
        stradeLab(lab);
        inizializzaLab(lab);

    }
    public static void stradeLab(char[][]lab) {
        for (int i=0;i<lab.length;i++)
            for(int j=0;j<lab[i].length;j++)
                if(lab[i][j]!='W')
                    lab[i][j]='-';
    }
    public static void inizializzaLab(char[][] labirinto){
        labirinto[1][0]='P';
        int[] pos=trovaPosizioneGiocatore(labirinto,'P');
        labirinto[pos[0]][pos[1]+1]='-';
        labirinto[labirinto.length-2][labirinto[0].length-1]='E';
        pos=trovaPosizioneGiocatore(labirinto,'E');
        labirinto[pos[0]][pos[1]-1]='-';
    }
    private static int[] trovaPosizioneGiocatore(char[][] labirinto, char carattere_da_trovare) {
        int[] posizione = new int[2];

        for (int i=0; i<labirinto.length; i++) {
            for (int j=0; j<labirinto[i].length; j++) {

                if (labirinto[i][j] == carattere_da_trovare) {      //Mi serve per trovare 'P' oppure 'E'
                    posizione[0] = i;
                    posizione[1] = j;

                    break;
                }
            }
        }
        return posizione;
    }
    public static void generoLab(char[][] lab,int dim){
        dividiLab(lab,0,0,dim,dim);
        creoTable(lab);
    }
    private static void stampaLabirinto(char[][] labirinto) {
        for (char[] chars : labirinto)
            System.out.println(Arrays.toString(chars));
        System.out.println("");
    }
    public static void dividiLab(char[][] lab,int y,int x, int h, int w) {
        if (h > 1 && w > 1) {
            if (h > w)
                dividiOrizzontalemte(lab, y, x, h, w);
            else
                dividiVerticalmente(lab, y, x, h, w);
        }

    }
    public static void dividiOrizzontalemte(char[][] lab, int y,int x,int h,int w){
        int h_wall= randomPari(h);
        int porta= randomDispari(w);
        for (int i=0;i<w-1;i++)
            if (i!=porta)
                lab[y+h_wall][x+i]='W';
        dividiLab(lab,y,x,h_wall,w);
        dividiLab(lab,y+h_wall+1,x,h-h_wall-1,w);
}
    public static void dividiVerticalmente(char[][] lab, int y,int x,int h,int w){
    int w_wall= randomPari(w);
    int porta= randomDispari(h);
    for (int i=0;i<h-1;i++)
        if (i!=porta)
            lab[y+i][x+w_wall]='W';
    dividiLab(lab,y,x,h,w_wall);
    dividiLab(lab,y,x+w_wall+1,h,w-w_wall-1);
    }
    public static int randomPari(int lim){
        Random rand = new Random();
        int val=rand.nextInt(lim-1);
        if (val%2==0)
            if(val>0)
                val=val-1;
            else
                val=val+1;
        return val;
    }
    public static int randomDispari(int lim){
        Random rand = new Random();
        int val=rand.nextInt(lim);
        if (val%2==1)
            if(val>0)
                val=val-1;
            else
                val=val+1;
        return val;
    }

}
