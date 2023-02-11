package SerieAExcel;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Csvreader {
    public static void main(String[] args) throws Exception
    {
        ArrayList<ArrayList> listone= new ArrayList<>();

        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("D://Michele//Java_Developer//new_Codici//src//SerieA//listone.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        int i=0;
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.println("Iterazione: "+i);
            listone.add(new ArrayList());
            ArrayList riga=new ArrayList();
            System.out.println(sc.next());
            String[] split= sc.next().split(";");
            riga.add(split);
            listone.get(i).add(riga);
            System.out.print(split[1]);  //find and returns the next complete token from this scanner
            i++;
        }
        System.out.println(listone.get(0).get(0));
        System.out.println("righe: "+listone.size()+" colonne: "+ listone.get(0).size());
        sc.close();  //closes the scanner
    }

}