package Esercitazione1;

public class ComparaStringhe {
    public static void main(String[] args) {
        String a = "ciao come va ?";
        String b = "cIao come vA ?";
        String c = "ciao come va ";
        System.out.println("2".equals("" + compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIaoo come vA ?";
        c = "ciao come va a";
        System.out.println("1".equals("" + compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIao come va ?";
        c = "ciao come vA ?";
        System.out.println("3".equals("" + compareStrings(a, b, c)));
    }

    private static int compareStrings(String a, String b, String c) {
        //inserite il vostro codice qui;
        if(a.toLowerCase().equals(b.toLowerCase())){
            if (b.toLowerCase().equals(c.toLowerCase())){
                return 3;
            }
            else return 2;
        }
        else if (b.toLowerCase().equals(c.toLowerCase())) return 2;

        else return 1;
    }
}
