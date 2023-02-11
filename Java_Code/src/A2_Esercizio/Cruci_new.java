public class Cruci_new {
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

        String[] parole=new String[] {"LUCCIO","DELFINO","SALMONE","CALAMARO","GAMBERETTO","BALENA","SOGLIOLA","SCORFANO","TRIGLIA","PLATESSA","ORCE","PACA","BOLSO","URTA"};
        for (String el:parole){
            findParole(cruci,el);
            System.out.println("Trovata "+ el);
        }
    }

    public static void findParole(char[][] mat,String word){
        for (int i=0;i<mat.length;i++)
            for (int j=0;j<mat[0].length;j++)
                if (mat[i][j]==word.charAt(0))
                    if(checkLetter(mat,word,i,j))
                        break;

    }

    public static boolean checkLetter(char[][] mat,String word,int x,int y){
        int c; //idx sulla word
        if (mat[0].length-y>=word.length()-1) { //ho spazio a destra
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x][y+c]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }
        if (y>=word.length()-1){//ho spazio a sinistra
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x][y-c]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }
        if (mat.length-x>=word.length()-1){//ho spazio in basso
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x+c][y]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }
        if (x>=word.length()-1){//ho spazio in alto
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x-c][y]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }

        if (x>=word.length()-1 && (mat[0].length-y>=word.length()-1)){//ho spazio in alto-destra
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x-c][y+c]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }
        if (x>=word.length()-1 && y>=word.length()-1){//ho spazio in alto-sinistra
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x-c][y-c]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }
        if (mat.length-x>=word.length()-1 && (mat[0].length-y>=word.length()-1)){//ho spazio in basso-destra
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x+c][y+c]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }
        if (mat.length-x>=word.length()-1 && y>=word.length()-1){//ho spazio in basso-sinistra
            c=0;
            while (c < word.length()) {
                if (word.charAt(c) == mat[x+c][y-c]) c++;
                else break;
            }
            if (c==word.length()) {
                System.out.println("X: " + x + "Y: " + y);
                return true;
            }
        }
        return false;
    }
}

