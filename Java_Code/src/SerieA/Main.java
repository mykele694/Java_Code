package SerieA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<String[]> listone= new ArrayList<>();
        int i=0;

        String line = "";
        String splitBy = ";";
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            //BufferedReader br = new BufferedReader(new FileReader("D://Michele//Java_Developer//Java_Code//src//SerieA//listone.csv"));
            BufferedReader br = Files.newBufferedReader(Paths.get("Java_Code/src/SerieA/listone.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value //while(br.ready()) //verifica che sia possibile leggere
            {

                String[] player = line.split(splitBy);    // use comma as separator
                listone.add(new String[player.length]);
                for (int j=0;j<player.length;j++)
                    listone.get(i)[j]=player[j];
                System.out.println("Linea: "+line);
                System.out.println("Arrays: "+ Arrays.toString(player));
                System.out.println("player [Position=" + player[0] + ", Name=" + player[1] + ", Squad=" + player[2] + ", value=" + player[3] + ", fantavalore= " + player[4] + "]");
                System.out.println("List: "+Arrays.toString(listone.get(i)));
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Righe: "+listone.size()+" Colonne: "+listone.get(0).length);

        String[] nomi_squadre;
        String[] nomi_player;
        Table serieA= new Table();

        for(String[] info:listone) {
            if (!serieA.existSquad(info[2]))
                serieA.addSquad(new Squad(info[2])); //aggiungi squadra
            serieA.addPlayerToSquad(new Squad(info[2]), new Footballer(info[1], info[0].charAt(0), Integer.parseInt(info[3])));//aggiungi giocatore alla squadra
        }

        //Calciatore play1=new Calciatore("Giorgio","Chiellini");
        System.out.println(serieA.getName());
        serieA.getRanking();
        for (Squad s: serieA.getSquad())
            System.out.println(s.toStringSquadList());
        System.out.println("ATTACCO MIGLIORE: "+serieA.bestAttack());
        System.out.println("DIFESA MIGLIORE: "+serieA.bestDefence());
}
}