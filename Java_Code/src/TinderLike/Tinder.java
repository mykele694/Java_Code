package TinderLike;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashSet;

class Tinder {

    protected static Utente getUtente(Utente user){
        try{
        return Database.getUtente(user);
        }
        catch(Exception e){
            System.out.println("Utente non trovato");
            return null;
        }
    }
    protected static void removeUtente(Utente user){
        Database.removeUser(user);
    }
    protected static void addUtente(Utente user){
        Database.addUser(user);
    }
    protected static HashSet<Interesse> getInteresse(Utente user){
        return Database.getInteressi(user);
    }
    protected static Utente findLove(Utente user){
        HashSet<Interesse> interessi = Database.getInteressi(user);
        int max=0;
        Utente utenteInteressante=null;
        for (Utente utente:Database.getUtente()){
            int n = interessiComuni(utente,user);
            if (n>max){
                max=n;
                utenteInteressante=utente;
            }
        }
        return utenteInteressante;
    }
    private static int interessiComuni(Utente u1,Utente u2){
        HashSet<Interesse> int_U1=Database.getInteressi(u1);
        HashSet<Interesse> int_U2=Database.getInteressi(u2);
        int n=0;
        for (Interesse interesse : int_U1) {
            if (Interesse.interesseComune(interesse, int_U2))
                n++;
        }
        return n;

    }
}
