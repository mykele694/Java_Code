
public class MetodiUtili {

    public static void stampaVettore(int[] vettore) {
        for (int i=0; i<vettore.length; i++)
            System.out.println("vettore[" +i+ "] = " +vettore[i]);

        System.out.println();
    }

    public static void stampaMatrice(int[][] matrice) {
        int i;

        //Intestazione della matrice
        for (i=0; i<matrice.length; i++)
            System.out.format("Colonna %d\t\t", i);
        System.out.println();

        //Contenuto della matrice
        for (i=0; i<matrice.length; i++) {                  //Indice delle righe
            for (int j=0; j<matrice[0].length; j++)         //Indice delle colonne
                System.out.format("%9d\t\t", matrice[i][j]);
            System.out.println();
        }
    }

    public static void bubbleSort(int[] vettore) {
        int temp;

        for (int i=0; i<vettore.length-1; i++) {
            for (int j=i+1; j<vettore.length; j++) {
                if (vettore[i] > vettore[j]) {

                    temp = vettore[i];
                    vettore[i] = vettore[j];
                    vettore[j] = temp;
                }
            }
        }
    }

    /* Ordinamento per selezione: si ricerca in un vettore l'elemento più piccolo e lo si scambia con l'elemento nella prima
     * posizione del vettore, dopodiché si ripeterà l'algoritmo partendo dal sottovettore che comincia con il secondo elemento
     * del vettore (il cui indice sarà memorizzato nel parametro "low")
     */
    public static void selectionSort(int[] vettore, int low) {
        int temp;	//Variabile temporanea per effettuare gli scambi

        //Controllo se l'indice del sottovettore coincide con l'ultimo elemento del vettore --> vettore ordinato
        if (low < vettore.length-1) {

            //Ciclo nel sottovettore per trovare l'elemento più piccolo. All'inizio low = 0  --> ricerca nel vettore completo
            for (int i=low+1; i<vettore.length; i++) {
                if (vettore[i] < vettore[low]) {

                    temp = vettore[low];
                    vettore[low] = vettore[i];
                    vettore[i] = temp;
                }
            }
        }
        /* Dopo aver messo in ordine il primo elemento del vettore, prendo in considerazione il successivo (low+1) e rieseguo
         * la funzione. Questo è il passo ricorsivo
         */
        if (low+1 < vettore.length-1)
            MetodiUtili.selectionSort(vettore, low+1);
    }

    //Cerca un certo elemento di tipo intero nel vettore e ne restituisce LA POSIZIONE
    public static int ricercaLineare(int[] vettore, int elemento_da_cercare) {

        for (int i=0; i<vettore.length; i++)
            if (vettore[i] == elemento_da_cercare)
                return i;

        return -1;	//Caso in cui non lo trova
    }

    //Cerca un certo elemento di tipo intero nel vettore e ne restituisce LA POSIZIONE. Funziona solo su vettori ordinati
    public static int ricercaBinaria(int[] vettore, int low, int high, int elemento_da_cercare) {

        //Alla prima chiamata, high = size - 1. Memorizza l'estremo superiore del vettore considerato (ultima cella del vettore)
        //"low" invece memorizza l'estremo inferiore del vettore considerato.
        int middle = (high+low)/2;	//Memorizza la metà del vettore considerato ( (int) tronca la parte decimale)

        if (elemento_da_cercare == vettore[middle]) {
            return middle;
        }
        //Caso in cui l'elemento da cercare si trova nella parte dx del vettore
        else if (elemento_da_cercare > vettore[middle]) {
            low = middle + 1;
            return ricercaBinaria(vettore, low, high, elemento_da_cercare);
        }
        //Caso in cui l'elemento da cercare si trova nella parte sx del vettore
        else if (elemento_da_cercare < vettore[middle]) {
            high = middle - 1;
            return ricercaBinaria(vettore, low, high, elemento_da_cercare);
        }
        else
            return -1;	//Caso in cui non viene trovato o viene data una dimensione errata
    }
}