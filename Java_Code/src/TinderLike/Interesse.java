package TinderLike;

import java.util.HashSet;

class Interesse{
    HastagInteressi hastag;
    String descrizione;

    protected Interesse(HastagInteressi tipo,String bio){
        hastag=tipo;
        descrizione=bio;
    }

    public HastagInteressi getHastag() {
        return hastag;
    }

    protected static boolean interesseComune(Interesse interesse, HashSet<Interesse> interessi){
        for(Interesse new_interesse:interessi){
            if(interesse.getHastag().equals(new_interesse.getHastag()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Interesse{" +
                "hastag=" + hastag +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}