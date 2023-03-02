package TinderLike;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Utente u1=new Utente("Michele Damone", LocalDate.of(1994,06,06));
        //Database data= new Database();
        Tinder.addUtente(u1);
        Utente u2=Tinder.getUtente(u1);
        System.out.println(u2);
        System.out.println("----------------");
        Interesse int1=new Interesse(HastagInteressi.BERE,"Mi ubriaco sempre");
        u1.addInteresse(int1);
        System.out.println(Tinder.getInteresse(u1));
        Tinder.addUtente(new Utente("Maria Nazionale",LocalDate.of(1995,05,04)));
        Tinder.findLove(u1);
    }
}
