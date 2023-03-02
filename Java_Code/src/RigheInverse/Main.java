package RigheInverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        String line;
        ArrayList<String> testo=new ArrayList<>();
        try(BufferedReader br= Files.newBufferedReader(Paths.get("Java_Code","src","RigheInverse","righe.txt"));){
            while((line=br.readLine())!=null)
                testo.add(line);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(testo);
        try(BufferedWriter wr = Files.newBufferedWriter(Paths.get("Java_Code", "src", "RigheInverse", "righeinverse.txt"));) {
            Collections.reverse(testo);
            for(String lines:testo)
                wr.append(lines+"\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
