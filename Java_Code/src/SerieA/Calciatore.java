package SerieA;

public class Calciatore {
    private int id;
    private String nome;
    private String cognome;

    public Calciatore(String nome,String cognome){
        this.nome=nome;
        this.cognome=cognome;
        String stringa=nome+cognome;
        this.id=stringa.hashCode();
    }

    @Override
    public String toString() {
        return "Calciatore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
