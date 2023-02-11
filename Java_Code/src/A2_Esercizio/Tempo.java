import java.io.Console;
import java.util.Scanner;
public class Tempo {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter seconds: ");
        int input=in.nextInt();
        System.out.println(input);
        System.out.println(calcoladata(input));

    }
    public static String calcoladata(int in){
        String result="";
        int secondi=in;
        int minuti=secondi/60;
        int ore=minuti/60;
        int giorni=ore/24;


        if (minuti!=0)
            secondi=secondi%60;
        if (ore!=0)
            minuti=minuti%60;
        if (giorni!=0)
            ore=ore%24;
        return result="Sono Giorni: "+giorni+" Ore: "+ore+" Minuti: "+minuti+" Secondi: "+secondi;
    }
}
