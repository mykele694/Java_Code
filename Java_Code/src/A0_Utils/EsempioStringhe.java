import java.util.Arrays;

public class EsempioStringhe {

    public static void main(String[] args) {
        String s= "Java classroom";
        int lunghezza = s.length(); //il metodo ".lenght" ritorna la lunghezza della stringa
        System.out.println("la stringa \"" + s + "\" è lunga " + lunghezza + " caratteri");
        s = "Developer Java";
        lunghezza = s.length();
        System.out.println("la stringa \"" + s + "\" è lunga " + lunghezza + " caratteri");

        /*il metodo substring(a,b) ritorna sottostringa della originale compresa tra l'indice a(incluso) e l'indice b (escluso)*/

        String sub1 = s.substring(10,14);
        System.out.printf(sub1);
        String sub2 = s.substring(10); //posso dare anche solo in input la posizione del carattere iniziale della substring
        System.out.printf(sub2);

        /* il metodo equals permette di confrontare due stringhe e tornare true o false se sono uguali o meno
         */
        System.out.printf("la strina: "+sub1+"; è uguale a : "+ sub2+"? "+sub1.equals(sub2)+"\n");

        //il metodo charAt(n) ritorna il carattere in posizione n

        int n=4;
        char lettera =s.charAt(n);
        System.out.printf("La "+(n+1)+"° lettera della stringa "+s+" è : "+lettera+"\n");

        //il metodo toLowerCase() e toUpperCase() rendono la stringa minuscola o minuscola rispettivamente
        System.out.println(s.toUpperCase());
        System.out.println((s));

        //per rendere il cambiamento permanente devo sovrascrivere la variabile
        s= s.toUpperCase();

        //il metodo s.startWith(String prefix) ritorna true se prefix è un prefisso
        System.out.println("la stringa "+s+" iniza con JAVA? "+ s.startsWith("JAVA"));

        //il metodo s.endsWith(String suffix) ritorna true se suffix è un suffisso
        System.out.println("la stringa "+s+" finisce con JAVA? "+ s.endsWith("JAVA"));

        sub1= sub1.toUpperCase();
        /* il metodo s.indexOf(String substring) ritorna l'indeice (se esiste) dal quale prte substring all''interno di s*/
        System.out.println("La stringa "+ sub1+" comincia dal carattere numero "+ s.indexOf(sub1));

        /*il metodo s.replace(CharSequencec c1, Charsequence c2) e sostituisce ogni occorrenza di c1 con c2 dentro s*/
        System.out.println("Vecchia stringa: "+s);
        s = s.replace("DEVELOPER", "STUDENT");
        System.out.println("Nuova stringa: "+s);
        /* il metodo replaceAll invece prende come target i regex */

        //il metodo split permette di dividere la stringa di partenz in un array di stringe in base ad uno specifico separatore, rimuovendolo
        String[] parole = s.split(" ");
        System.out.println(Arrays.toString(parole));


            }
}
