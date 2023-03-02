package SerieA;

/**
 * @author Andrea Pannitti
 *
 */
public class calendar {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n=20;
//Controllo sul parametro di input
        try {
            //n=Integer.parseInt(args[0]);
            if (n<1 || n>99) {
                System.out.println("Attenzione: il parametro di input deve essere un numero intero compreso tra 1 e 99!");
                return;
            }
        }
        catch (Exception e) {
            System.out.println("Attenzione: il parametro di input deve essere un numero intero compreso tra 1 e 99!");
            return;
        }

//Inizializzazione della stringa delle squadre
        String StringaSquadre = "";
        for (int i=1; i<=n; i++)
            StringaSquadre+=(" " + String.valueOf(i)).substring((" " + String.valueOf(i)).length()-2);
        System.out.println(StringaSquadre);

//Genera il calendario
        for (int i=1; i<=n-1+(n%2); i++) {
            System.out.println("Giornata " + i +":");

            if (n%2==0)
                System.out.println(StringaSquadre.substring((n - 1)* 2) + " - " + StringaSquadre.substring((n - 2) * 2, (n - 1) * 2));
            for (int j=0; j<(int)((n-1)/2); j++) {
                System.out.println(StringaSquadre.substring(j * 2, (j + 1)* 2) + " - " + StringaSquadre.substring((n - j - 3 + (n%2)) * 2, (n - j - 2 + (n%2)) * 2));
            }
            if (n%2==1)
                System.out.println("Riposa la squadra: " + StringaSquadre.substring((n - 1) * 2));

//Ruota la stringa delle squadre
            StringaSquadre = StringaSquadre.substring((n - 2 + (n%2)) * 2, (n - 1 + (n%2)) * 2) + StringaSquadre;
            StringaSquadre = StringaSquadre.substring(0, (n - 1 + (n%2)) * 2) + StringaSquadre.substring(n * 2, (n + 1 - (n%2)) * 2);
            System.out.println(StringaSquadre);
        }
    }
}
