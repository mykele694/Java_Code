import java.util.Arrays;

public class Cruciverba {
    public static void main(String[] args) {
        char [][] cruci =new char[][] {  {'H','D','G','U','P','Y','S','P','A','O'},
                                         {'T','S','A','K','O','Y','O','L','P','S'},
                                         {'R','C','M','C','N','R','I','A','A','B'},
                                         {'I','O','B','A','I','S','C','T','L','A'},
                                         {'G','R','E','L','F','A','C','E','O','L'},
                                         {'L','F','R','A','L','L','U','S','I','E'},
                                         {'I','A','E','M','E','M','L','S','L','N'},
                                         {'A','N','T','A','D','O','C','A','G','A'},
                                         {'J','O','T','R','B','N','D','G','O','D'},
                                         {'L','Y','O','O','U','E','S','M','S','M'}};

        String[] parole=new String[] {"LUCCIO","DELFINO","SALMONE","CALAMARO","GAMBERETTO","BALENA","SOGLIOLA","SCORFANO","TRIGLIA","PLATESSA"};
        for (String el:parole){
            findParole(cruci,el);
            System.out.println("Trovata "+ el);
        }
    }

    public static void findParole(char[][] mat,String word){
        for (int i=0;i<mat.length;i++)
            for (int j=0;j<mat[0].length;j++)
                if ((char)mat[i][j]!=word.charAt(0)){
                    continue;
                }
                else{
                   if(checkLetter(mat,word,i,j)==true)
                       break;
                }
    }

    public static boolean checkLetter(char[][] mat,String word,int x,int y){
        boolean OK=true;
        boolean trovata=true;
        int c=0; //idx sulla word
        int i;
        int j;
        if (mat[0].length-y>=word.length()-1) { //ho spazio a destra
            i=x;
            j=y;
            c=0;
            while (OK && c < word.length()) {
                OK=false;
                if (word.charAt(c) == mat[i][j]) {
                    OK = true;
                    c++;
                    j++;
                }
                else {
                    trovata=false;
                    break;}
            }
            if (trovata==true){
                System.out.println("X: "+x+"Y: "+y);
                return trovata;}
        }
        OK=true;
        trovata=true;
        if (y>=word.length()-1){//ho spazio a sinistra
            i=x;
            j=y;
            c=0;
            while (OK && c < word.length()) {
                OK=false;
                if (word.charAt(c) == mat[i][j]) {
                    OK = true;
                    c++;
                    j--;
                }
                else {
                    trovata=false;
                    break;}
            }
            if (trovata==true) {
                System.out.println("X: " + x + "Y: " + y);
                return trovata;
            }
        }
        OK=true;
        trovata=true;
        if (mat.length-x>=word.length()-1){//ho spazio in basso
            i=x;
            j=y;
            c=0;
            while (OK && c < word.length()) {
                OK=false;
                if (word.charAt(c) == mat[i][j]) {
                    OK = true;
                    c++;
                    i++;
                }
                else {
                    trovata=false;
                    break;}
            }
            if (trovata==true) {
                System.out.println("X: "+x+"Y: "+y);
                return trovata;
            }
        }
        OK=true;
        trovata=true;
        if (x>=word.length()-1){//ho spazio in alto
            i=x;
            j=y;
            c=0;
            while (OK && c < word.length()) {
                OK=false;
                if (word.charAt(c) == mat[i][j]) {
                    OK = true;
                    c++;
                    i--;
                }
                else {
                    trovata=false;
                    break;}
            }
            if (trovata==true){
                System.out.println("X: "+x+"Y: "+y);
                return trovata;
            }
        }
        return trovata=false;
    }
}

