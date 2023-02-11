import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labirinto_Dinamico {
    public static void main(String[] args) {
        /*char[][] lab={
                {'-','-','W','W','-'},
                {'-','W','-','W','-'},
                {'P','W','-','W','W'},
                {'-','-','W','-','E'},
                {'W','-','-','-','W'}};*/
        ArrayList dirDisp=new ArrayList<>();
        reset_direzione(dirDisp);
        Scanner sc = new Scanner(System.in);
        int dim= sc.nextInt();
        char [][] lab= new char[dim][dim];
        creoTable(lab);
        stampaLabirinto(lab);
        creoLab(lab,dirDisp);
        stampaLabirinto(lab);
        //sc = new Scanner(System.in);
        //String input = sc.nextLine();
        //char movement=input.toLowerCase().charAt(0);

        //stampaLabirinto(lab);
    }
public static void reset_direzione(ArrayList dir){
        boolean ans=dir.contains('w');
        if (!ans) dir.add('w');
        ans=dir.contains('a');
        if (!ans) dir.add('a');
        ans=dir.contains('s');
        if (!ans) dir.add('s');
        ans=dir.contains('d');
        if (!ans) dir.add('d');
}
    public static void creoTable(char [][] lab){
        for  (int i=0;i<lab.length;i++)
            for (int j=0;j<lab[i].length;j++)
                //if (i==0||j==0||i==lab.length-1||j==lab[i].length-1)
                    lab[i][j]='W';
                //else lab[i][j]='0';
        inizializzaLab(lab);
    }

    public static void creoLab(char[][] lab,ArrayList dirDisp){
        int[] pos=new int [2];
        char dir;
        boolean mossa=false;
        int k=0;
        for (int i=1;i<lab.length-1;i++) {

            for (int j = 1; j < lab[i].length - 1; j++) {
                k=j;
                reset_direzione(dirDisp);
                if (lab[i][j] == '-') {
                    pos[0] = i;
                    pos[1] = j;
                    mossa=false;
                    while (dirDisp.size() >= 1 && !mossa) {
                        dir = randomDirezione(dirDisp);
                        mossa=checkDir(pos,dir,lab);
                       if (mossa) stampaLabirinto(lab);
                    }
                }
            }
            if(i==lab.length-2 && k==lab[0].length-2 && lab[lab.length-2][lab[0].length-2]!='-'){
                System.out.println("ricomincio");
                stampaLabirinto(lab);
                i=1;
            }
        }
    }
    public static boolean checkDir(int[] pos,char dir,char[][]lab){
        ArrayList word= new ArrayList();
        word.add('W');
        word.add('E');
        switch (dir){
            case 'w':
                if (pos[0]-1 < 1 || lab[pos[0]-1][pos[1]] == '-' || lab[pos[0]-2][pos[1]] == '-')
                    return false;
                else if (lab[pos[0]-1][pos[1]]== 'E'){
                    System.out.println("Abbiamo trovato un path per l'uscita");
                    return false;
                }
                else if ( word.contains(lab[pos[0]-1][pos[1]-1]) && word.contains(lab[pos[0]-1][pos[1]+1]) ) {
                    lab[pos[0] - 1][pos[1]] = '-';
                    return true;
                }
                else return false;

            case 'a':
                if (pos[1]-1 < 1 || lab[pos[0]][pos[1]-1] == '-' || lab[pos[0]][pos[1]-2] == '-')
                    return false;
                else if (lab[pos[0]][pos[1]-1]== 'E'){
                    System.out.println("Abbiamo trovato un path per l'uscita");
                    return false;
                }
                else if ( word.contains(lab[pos[0]+1][pos[1]-1]) && word.contains(lab[pos[0]-1][pos[1]-1]) ) {
                    lab[pos[0]][pos[1] - 1] = '-';
                    return true;
                }
                else return false;

            case 's':
                if (pos[0]+1 > lab.length-2 || lab[pos[0]+1][pos[1]] == '-' || lab[pos[0]+2][pos[1]] == '-')
                    return false;
                else if (lab[pos[0]+1][pos[1]]== 'E'){
                    System.out.println("Abbiamo trovato un path per l'uscita");
                    return false;
                }
                else if ( word.contains(lab[pos[0]+1][pos[1]+1]) && word.contains(lab[pos[0]+1][pos[1]-1]) ) {
                    lab[pos[0] + 1][pos[1]] = '-';
                    return true;
                }
                else return false;

            case 'd':
                if (pos[1]+1 > lab[0].length-2 || lab[pos[0]][pos[1]+1] == '-' || lab[pos[0]][pos[1]+2] == '-')
                    return false;
                else if (lab[pos[0]][pos[1]+1]== 'E') {
                    System.out.println("Abbiamo trovato un path per l'uscita");
                    return false;
                }
                else if ( word.contains(lab[pos[0]+1][pos[1]+1]) && word.contains(lab[pos[0]-1][pos[1]+1]) ) {
                    lab[pos[0]][pos[1] + 1] = '-';
                    return true;
                }
                else return false;
        }
        return false;
    }
    public static char randomDirezione(ArrayList dirDisp){
        Random rand = new Random();
        char dir;
        if (dirDisp.size()==1) {
            dir = (char) dirDisp.get(0);
            dirDisp.remove(0);
            return dir;
        }
        else{
            int idx = rand.nextInt(dirDisp.size());
            dir=(char) dirDisp.get(idx);
            dirDisp.remove(idx);
            return dir;
        }

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
    private static void stampaLabirinto(char[][] labirinto) {
        for (char[] chars : labirinto)
            System.out.println(Arrays.toString(chars));
        System.out.println("");
    }
    public static void inizializzaLab(char[][] labirinto){
        labirinto[1][0]='P';
        labirinto[1][1]='-';
        labirinto[labirinto.length-2][labirinto[0].length-1]='E';
    }
}
