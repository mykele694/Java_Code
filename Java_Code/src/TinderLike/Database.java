package TinderLike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Database {
    static HashSet<Utente> users = new HashSet<>();
    static HashMap<Integer, HashSet<Interesse>> interessiUtente = new HashMap<>();
    protected static void addUser(Utente user){
        users.add(user);
    }
    protected static void removeUser(Utente user){
        for(Utente utente : users){
            if(user.getId()== utente.getId()){
                users.remove(utente);
                interessiUtente.remove(utente.getId());
            }
        }
    }
    protected static HashSet<Interesse> getInteressi(Utente user){
        return interessiUtente.get(user.getId());
    }
    protected static Utente getUtente(Utente user) {
        for (Utente utente : users) {
            if (utente.getId() == user.getId())
                return utente;
        }
        return null;
    }
    protected static HashSet<Utente> getUtente(){
        return users;
    }
    protected static void addInteresse(Utente user,Interesse interesse){
        HashSet<Interesse> oldInteressi = interessiUtente.get(user.getId());
        try {
            oldInteressi.add(interesse);
        }
        catch(Exception e){
            oldInteressi = new HashSet<>();
            oldInteressi.add(interesse);
        }
        interessiUtente.putIfAbsent(user.getId(),oldInteressi);
    }
}
