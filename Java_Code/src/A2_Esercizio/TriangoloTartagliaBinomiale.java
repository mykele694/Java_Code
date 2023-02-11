/* Scrivere un programma (ovviamente ricorsivo) che, dato un intero n restituisce l’array corrispondente alla n riga del triangolo di
 * tartaglia.
 * https://www.andreaminini.org/matematica/il-triangolo-di-tartaglia
 */
import java.util.Arrays;

public class TriangoloTartagliaBinomiale {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(rigaTriangolo(50)));
    }

    private static int[] rigaTriangolo(int riga_triangolo) {
        int[] riga = new int[riga_triangolo+1];     //La riga n-esima contiene n+1 numeri
        riga[0] = 1;

        for (int i=0; i<riga.length; i++)
            riga[i] = coefficienteBinomiale(riga_triangolo, i);

        return riga;
    }

    /* Formula: C(n k) = n!/(k!(n-k)!)
     * Casi particolari:
     *  C(n 0) = 1
     *  C(n n) = 1
     *  C(n 1) = 1
     * Può essere scritto anche come: C(n, k) = C(n-1, k-1) + C(n-1, k)
     * https://it.wikipedia.org/wiki/Coefficiente_binomiale#Propriet%C3%A0
     */
    private static int coefficienteBinomiale(int n, int k) {
        if (k==0 || k==n)
            return 1;
        else {
            return coefficienteBinomiale(n-1, k-1) + coefficienteBinomiale(n-1, k);
        }
    }
}