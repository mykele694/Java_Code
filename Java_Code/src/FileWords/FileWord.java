package FileWords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileWord {
    private static char[] vowels= {'a','e','i','o','u'};
    protected static void printWords(Path file){
        String line;
        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    protected static HashMap<String,Integer> occorrenzaParole(Path file){
        HashMap<String,Integer> map= new HashMap<>();
        String line;
        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null){
                for(String s:line.split(" ")){
                    if(!map.containsKey(s))
                        map.put(s,1);
                    else
                        map.put(s,map.get(s)+1);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return map;
    }
    protected static HashMap<String,Integer> occorrenzaParoleTesto(Path file){
        HashMap<String,Integer> map= new HashMap<>();
        String line;
        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null){
                if(line.equals(""))
                   continue;

                for(String s:line.split("\\W+")){
                    s=s.toLowerCase();
                    if(!map.containsKey(s))
                        map.put(s,1);
                    else
                        map.put(s,map.get(s)+1);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return map;
    }
    protected static HashMap<String, ArrayList<String>> paroleInRima(Path file){
        HashMap<String,ArrayList<String>> map= new HashMap<>();
        String line;


        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null) {
                if (line.equals(""))
                    continue;
                for (String s : line.split("\\W+")){
                    System.out.println(s);
                    s = s.toLowerCase();
                    if(s.length()>4){   //check parola ha più di 4 lettere
                        int offset=3;
                        //stiamo assumendo che il testo sia in italiano e che le parole con più
                        //di quattro lettere finiscano con sempre con (vocale-consonante-vocale) o (vocale-consonante-consonante-vocale)
                        if(Arrays.asList(vowels).contains(s.charAt(s.length()-offset)))     offset=3;//verifico che la terzultima parola sia una vocale altrimenti rientrerò nel caso  (vocale-consonante-consonante-vocale)
                        else offset=4;
                        if(map.containsKey(s.substring(s.length()-offset))){ //verifico che la desinenza Es. "ato", "ito", ecc. sia già presente
                            map.get(s.substring(s.length()-offset)).add(s);     //aggiungo ai valori già associato alla chiave
                        }
                        else{
                            ArrayList<String> arr=new ArrayList<>();  //creo nuova coppia chiave valore (desinenza,parola)
                            arr.add(s);
                            map.put(s.substring(s.length()-offset),arr);
                        }
                        }
                    }
                }
            }

        catch(IOException e){
            e.printStackTrace();
        }
        return map;
    }

}
