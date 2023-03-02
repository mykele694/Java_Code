package SerieACollection;

import SerieACollection.Footballer;
import SerieACollection.Squad;
import SerieACollection.Table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        ArrayList<String[]> listone= new ArrayList<>();
        ArrayList<String[][]> calendario = new ArrayList<>();
        ArrayList<String> nomi_squadre=new ArrayList<>();
        String[] nomi_player;
        Table serieA= new Table();

        int i=0;

        String line = "";
        String splitBy = ";";
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("D://Michele//Java_Developer//Java_Code//src//SerieA//listone.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value
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



        for(String[] info:listone) {
            if(!serieA.isInSquad(info[2])){
                serieA.addSquad(new Squad(info[2])); //aggiungi squadra
                nomi_squadre.add(info[2]);
            }
            serieA.addPlayerToSquad(new Squad(info[2]), new Footballer(info[1], info[0].charAt(0), Integer.parseInt(info[3])));//aggiungi giocatore alla squadra
        }

        //Calciatore play1=new Calciatore("Giorgio","Chiellini");
        System.out.println(serieA.getName());
        serieA.getRanking();
        for (Squad s: serieA.getSquad())
            System.out.println(s.toStringSquadList());
        System.out.println("BEST ATTACK: "+serieA.bestAttack());
        System.out.println("BEST DEFENCE: "+serieA.bestDefence());
        generaCalendario(nomi_squadre,calendario);
        i=0;
        for(String[][] giornata:calendario){
            System.out.println("\nGIORNATA "+ ++i);
            for(String[] partita :giornata)
                System.out.println(partita[0]+" - "+partita[1]);
        }
    }
    public static void generaCalendario(ArrayList squadre,ArrayList<String[][]> calendario){
        ArrayList<String> meta1=new ArrayList<>();
        ArrayList<String> meta2=new ArrayList<>();

        for(int i=0;i<squadre.size()/2;i++)
            meta1.add(squadre.get(i).toString());
        for(int i=squadre.size()/2;i<squadre.size();i++)
            meta2.add(squadre.get(i).toString());
        System.out.println(meta1 +"\n"+meta2);

        for(int j=0;j<squadre.size()-1;j++) {
            calendario.add(new String[squadre.size() / 2][2]);
            for (int i = 0; i < meta1.size(); i++) {
                calendario.get(j)[i][0] = meta1.get(i);
                calendario.get(j)[i][1] = meta2.get(i);
            }
            ArrayList<String> new_meta1=new ArrayList<>();
            new_meta1.add(meta1.get(0));
            new_meta1.add(meta2.get(0));
            for(int i=2;i<meta1.size();i++)
                new_meta1.add(meta1.get(i-1));
            meta2.add(meta1.get(meta1.size()-1));
            meta1=new_meta1;
            meta2.remove(0);
            System.out.println(meta1 +"\n"+meta2);

        }
    }
}



