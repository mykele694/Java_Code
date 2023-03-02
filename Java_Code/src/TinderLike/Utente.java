package TinderLike;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

class Utente {
    private static Integer ID=0;
    private String nomeUtente;
    private LocalDate dataNascita;
    private Integer idUtente;
    private Integer etaUtente;
    //interessi

    protected Utente(String nome,LocalDate dataNascita){
        this.nomeUtente=nome;
        this.dataNascita=dataNascita;
        this.etaUtente= Period.between(dataNascita,LocalDate.now()).getYears();
        idUtente=ID++;
    }
    protected Utente getUtente(){
        return this;
    }
    protected int getId(){
        return idUtente;
    }
    protected void addInteresse(Interesse interesse){
        Database.addInteresse(this,interesse);
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nomeUtente='" + nomeUtente + '\'' +
                ", etaUtente=" + etaUtente +
                '}';
    }

    public Integer getEtaUtente() {
        return etaUtente;
    }

    public static Integer getID() {
        return ID;
    }
}
