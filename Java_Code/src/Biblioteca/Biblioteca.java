package Biblioteca;

import java.util.Arrays;
import java.util.Comparator;

public class Biblioteca {
    Libro[] lista;

    public boolean esisteLibro(int code){
    for(int i=0;i<this.lista.length-1;i++)
        if(this.lista[i].idx==code)
            return true;
    return false;
    }

    public Libro[] getIndiciLibriOrdinati_old(){
        Libro temp;

        for (int i=0; i<this.lista.length-1; i++) {
            for (int j=i+1; j<this.lista.length; j++) {
                if (this.lista[i].idx > this.lista[j].idx) {
                    temp = this.lista[i];
                    this.lista[i] = this.lista[j];
                    this.lista[j] = temp;
                }
            }
        }
        return this.lista;
    }

    public Libro[] getIndiciLibriOrdinati() {
        Arrays.sort(this.lista, Comparator.comparing(Libro::get_idx));
        return this.lista;
    }

    public void aggiungiLibro(Libro libro){
        Libro[] old_lista;
        if (this.lista==null){
            this.lista=new Libro[1];
            this.lista[0]=libro;}
        else {
            old_lista = this.lista;
            this.lista = Arrays.copyOf(old_lista, old_lista.length + 1);
            this.lista[this.lista.length - 1] = libro;
        }
    }
    public void showBook(){
        for(int i=0; i<this.lista.length;i++)
            System.out.println(this.lista[i].idx);
    }
}
