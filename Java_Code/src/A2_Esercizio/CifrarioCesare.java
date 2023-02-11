import java.util.Scanner;

public class CifrarioCesare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter line: ");
        String origin = sc.nextLine();
        System.out.print("Enter key: ");
        int key=sc.nextInt();
        String cripted=cript(origin,key);
        System.out.println(cripted);
        String decripted=decript(cripted,key);
        System.out.println(decripted);
    }

    public static String cript(String word,int key){
        String new_word="";
        word=word.toLowerCase();
        for (int i=0; i<word.length();i++) {
            int ascii=(int) word.charAt(i)+key;
   /*         if (key>0)
                ascii= (ascii>(int) 'z' ) ? ascii%((int)'z'+1)+(int)'a' : ascii;//%((int)'z'+1
            else
                ascii= (ascii<(int)'a') ? (ascii+(int)'z'+1)%((int)'a')+(int)'a' : ascii;//%((int)'a'-1)+(int)'a'  */
            ascii= (key>0)? (ascii-96)%26+96 : (ascii+26-97)%26+97;
            new_word+=(char)ascii;
        }
        return new_word;
    }
    public static String decript(String word,int key) {
       return cript(word, -key);
    }
}
