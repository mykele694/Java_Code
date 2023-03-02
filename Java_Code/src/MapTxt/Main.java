package MapTxt;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args)  {
        Path path= Paths.get("Java_Code","src","MapTxt","righe.txt");
        String line;
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
        try{
            BufferedReader br= Files.newBufferedReader(path);
            while((line=br.readLine())!=null){
                String[] keyValue = line.split(":");
                ArrayList<String> arr=new ArrayList<>();
                for(String s:keyValue[1].split(","))
                    arr.add(s);
                map.put(keyValue[0],arr);
            }
            br.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(map);

    }
}
