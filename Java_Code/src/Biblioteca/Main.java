package Biblioteca;

public class Main {
    public static void main(String[] args) {
        int[] values = new int[7];
        values[0] = 123;
        values[1] = 4;
        values[2] = 98;
        values[3] = 33;
        values[4] = 76;
        values[5] = 2;
        values[6] = 235;
        Biblioteca biblioteca = new Biblioteca();
        for (int i = 0; i < values.length; i++){
            Libro libro = new Libro(values[i]);
            biblioteca.aggiungiLibro(libro);
        }
        biblioteca.showBook();
        System.out.println(biblioteca.esisteLibro(76));
        Libro[] libriOrdinati = biblioteca.getIndiciLibriOrdinati();
        System.out.println(libriOrdinati[0].idx == 2);
        System.out.println(libriOrdinati[1].idx == 4);
        System.out.println(libriOrdinati[2].idx == 33);
        System.out.println(libriOrdinati[3].idx == 76);
        System.out.println(libriOrdinati[4].idx == 98);
        System.out.println(libriOrdinati[5].idx == 123);
        System.out.println(libriOrdinati[6].idx == 235);
    }
}