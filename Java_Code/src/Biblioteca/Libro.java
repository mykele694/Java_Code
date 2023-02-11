package Biblioteca;

public class Libro {
    int idx;
    String nome;
    String autore;
    String categoria;

    public Libro(int idx){
        this.idx=idx;
    }
    public int get_idx(){
        return idx;
    }
}
