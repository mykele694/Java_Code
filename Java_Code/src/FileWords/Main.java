package FileWords;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Path path= Paths.get("Java_Code","src","FileWords","file.txt");
        Path path2= Paths.get("Java_Code","src","FileWords","file1.txt");
        FileWord.printWords(path);
        HashMap<String,Integer> map=FileWord.occorrenzaParole(path);
        System.out.println(map);
        map=FileWord.occorrenzaParoleTesto(path);
        System.out.println(map);
        HashMap<String, ArrayList<String>> rime=FileWord.paroleInRima(path2);
        System.out.println(rime);
    }
}
