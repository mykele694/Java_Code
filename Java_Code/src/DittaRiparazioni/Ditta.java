package DittaRiparazioni;



import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ditta {
    private Riparazione[] lista_riparazioni;
    private Riparazione[] lista_eseguite;
    private Tecnico[] lista_tecnici;

    public void aggiungi_tecnico(Tecnico tecnico){
        boolean ok=true;
        Tecnico[] old_lista;
        if (this.lista_tecnici==null){
            this.lista_tecnici=new Tecnico[1];
            this.lista_tecnici[0]=tecnico;}
        else {
            for (int i = 0; i < this.lista_tecnici.length; i++)
                if (tecnico.getNome().equals( this.lista_tecnici[i].getNome()) ) {
                    System.out.println("Tecnico già presente ");
                    ok = false;
                }
            if(ok){
                old_lista = this.lista_tecnici;
                this.lista_tecnici = Arrays.copyOf(old_lista, old_lista.length + 1);
                this.lista_tecnici[this.lista_tecnici.length - 1] = tecnico;
            }
        }
    }
    public void aggiungi_tecnico(){
        Tecnico tec= new Tecnico();
        aggiungi_tecnico(tec);
    }
    public void aggiungi_riparazione(Riparazione intervento){
        Riparazione[] old_lista;
        codaRiparazione(intervento);
        if (this.lista_riparazioni==null){
            this.lista_riparazioni=new Riparazione[1];
            this.lista_riparazioni[0]=intervento;}
        else {
            old_lista = this.lista_riparazioni;
            this.lista_riparazioni = Arrays.copyOf(old_lista, old_lista.length + 1);
            this.lista_riparazioni[this.lista_riparazioni.length - 1] = intervento;
        }
    }
    public void aggiungi_riparazione(){
        Riparazione rip=new Riparazione();
        aggiungi_riparazione(rip);
    }
    public Riparazione codaRiparazione(Riparazione intervento){
        int coda=0;
        if(lista_riparazioni==null)
            intervento.setN_pratica(++coda);
        else {
            for (int i = 0; i < lista_riparazioni.length; i++)
                switch (intervento.getPriority()) {
                    case BASSA:
                        if (coda < lista_riparazioni[i].getN_pratica())
                            coda = lista_riparazioni[i].getN_pratica();
                    case MEDIA:
                        if (lista_riparazioni[i].getPriority() == Riparazione.Priority.MEDIA||lista_riparazioni[i].getPriority() == Riparazione.Priority.ALTA)
                            if (coda < lista_riparazioni[i].getN_pratica())
                                coda = lista_riparazioni[i].getN_pratica();
                    case ALTA:
                        if (lista_riparazioni[i].getPriority() == Riparazione.Priority.ALTA)
                            if (coda < lista_riparazioni[i].getN_pratica())
                                coda = lista_riparazioni[i].getN_pratica();
                }
            coda++;
            intervento.setN_pratica(coda);
            aggiorna_ordine(coda, true);
        }
        return intervento;
    }
    public void aggiorna_ordine(int num,boolean flag) {
        int i;
        if (flag){
            for (i = 0; i < lista_riparazioni.length; i++)
                if (lista_riparazioni[i].getN_pratica() >= num)
                    lista_riparazioni[i].setN_pratica(lista_riparazioni[i].getN_pratica() + 1);
        }
        else {
            for (i = 0; i < lista_riparazioni.length; i++)
                if (lista_riparazioni[i].getN_pratica() > num)
                    lista_riparazioni[i].setN_pratica(lista_riparazioni[i].getN_pratica() - 1);
        }
    }
    public void riparazione_svolta(String indirizzo){
        boolean ok=false;
        int i;
        for(i=0;i<this.lista_riparazioni.length;i++)
            if(this.lista_riparazioni[i].getNome().equals(indirizzo)){
                ok=true;
                break;}
        if (ok) {
            archivia_riparazione(this.lista_riparazioni[i]);
            libera_tecnico(this.lista_riparazioni[i].getTecnico());
            aggiorna_ordine(this.lista_riparazioni[i].getN_pratica(), false);
            Riparazione[] new_list = new Riparazione[this.lista_riparazioni.length - 1];
            for (int j = 0; j < new_list.length; j++)
                if (j >= i)
                    new_list[j] = this.lista_riparazioni[j + 1];
                else
                    new_list[j] = this.lista_riparazioni[j];

            this.lista_riparazioni = new_list;
        }
    }
    public void archivia_riparazione(Riparazione rip){
        Riparazione[] old_lista;
        //rip.riparazioneSvolta();
        if (this.lista_eseguite==null){
            this.lista_eseguite=new Riparazione[1];
            this.lista_eseguite[0]=rip;}
        else {
            old_lista = this.lista_eseguite;
            this.lista_eseguite = Arrays.copyOf(old_lista, old_lista.length + 1);
            this.lista_eseguite[this.lista_eseguite.length - 1] = rip;
        }
    }
    public void libera_tecnico(String nome){
        for(int i=0;i<this.lista_tecnici.length;i++)
            if (this.lista_tecnici[i].getNome().equals(nome))
                this.lista_tecnici[i].reset();
    }
    public void show_tecnici(){
        if(this.lista_tecnici==null)
            System.out.println("Non ci sono Tecnici");
        else{
        for(int i=0;i<this.lista_tecnici.length;i++)
            System.out.println(i+"°: "+this.lista_tecnici[i].getNome()
            +" Occupazione: "+this.lista_tecnici[i].getIntervento());
        }
    }
    public void show_riparazioni(){
        if(this.lista_riparazioni==null)
            System.out.println("Non ci sono Riparazioni");
        else{
            for(int i=0;i<this.lista_riparazioni.length;i++)
            {System.out.println(i+"° idx: "+this.lista_riparazioni[i].getNome()
                    +" Priorità: " + this.lista_riparazioni[i].getPriority()
                    +" Operatore: " + this.lista_riparazioni[i].getTecnico()
                    +" Pratica: "+ this.lista_riparazioni[i].getN_pratica());

                System.out.println();}

        }
    }
    public void assegna_tecnici(){
        for (int j=0;j<this.lista_riparazioni.length;j++)
            if(this.lista_riparazioni[j].getTecnico()==null)
                for(int i=0;i<this.lista_tecnici.length;i++)
                    if(this.lista_tecnici[i].getIntervento()==null) {
                        this.lista_tecnici[i].setIntervento(this.lista_riparazioni[j].getNome());
                        this.lista_riparazioni[j].setTecnico(lista_tecnici[i].getNome());
                        break;
                    }
    }
    public Void assegna_perPriorita(){
        int i,j;
        if (this.lista_riparazioni!=null){
            ordina_perPriorita();
            for ( j=0;j<this.lista_riparazioni.length;j++)
                if(this.lista_riparazioni[j].getTecnico()==null)
                    break;
            for ( i=0;i<this.lista_tecnici.length;i++)
                if (this.lista_tecnici[i].getIntervento()==null) {
                    assegna_tecnico(this.lista_riparazioni[j].getNome(), this.lista_tecnici[i].getNome());
                    return null;
                }
            System.out.println("Non ci sono tecnici liberi");
            return null;
        }
        else {
            System.out.println("Non ci sono riparazioni in coda");
            return null;
        }
    }
    public void assegna_tecnico(String rip,String nome){
        int i,j;
        for(i=0;i<this.lista_riparazioni.length;i++)
            if(this.lista_riparazioni[i].getNome().equals(rip))
                break;
        for(j=0;j<this.lista_tecnici.length;j++)
            if (this.lista_tecnici[j].getIntervento()==null)
                if(this.lista_tecnici[j].getNome().equals(nome))
                    break;
        try {
            this.lista_tecnici[j].setIntervento(this.lista_riparazioni[i].getNome());
            this.lista_riparazioni[i].setTecnico(lista_tecnici[j].getNome());
        }
        catch(Exception e)
        {
            System.out.println("Riparazione o Tecnico non presenti");
        }
    }
    public void assegna_tecnico(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nome Riparazione: ");
        String s=sc.nextLine();
        System.out.println("Nome Tecnico: ");
        String t=sc.nextLine();
        assegna_tecnico(s,t);
    }
    public void ordina_perPriorita(){
        Arrays.sort(this.lista_riparazioni, Comparator.comparing(Riparazione::getN_pratica));
    }
    public void show_occupati(){
        for(int i=0;i<this.lista_tecnici.length;i++)
             if(this.lista_tecnici[i].getIntervento()!=null)
                 System.out.println(this.lista_tecnici[i].getNome()+" lavora a "+ this.lista_tecnici[i].getIntervento());
    }
    public void show_liberi(){
        for(int i=0;i<this.lista_tecnici.length;i++)
            if(this.lista_tecnici[i].getIntervento()==null)
                System.out.println(this.lista_tecnici[i].getNome());
    }
    public void licenzia_tecnico(String nome){
        int i,j;
        for ( i=0;i<this.lista_tecnici.length;i++)
            if(this.lista_tecnici[i].getNome().equals(nome))
                break;
        if (this.lista_tecnici[i].getIntervento()!=null)
            lascia_riparazione(this.lista_tecnici[i].getIntervento());
        Tecnico[] new_list=new Tecnico [this.lista_tecnici.length-1];
        for ( j=0;j<new_list.length;j++)
            if(j>=i)
                new_list[j]=this.lista_tecnici[j+1];
            else
                new_list[j]=this.lista_tecnici[j];
        this.lista_tecnici=new_list;
}
    public void licenzia_tecnici(String[] nomi){
            for (int i=0;i<nomi.length;i++)
                licenzia_tecnico(nomi[i]);
    }
    public void lascia_riparazione(String nome){
        for(int i=0;i<this.lista_riparazioni.length;i++)
            if (this.lista_riparazioni[i].getNome().equals(nome))
                this.lista_riparazioni[i].setTecnico(null);
    }
    public void show_primointervento(){
        try{
        ordina_perPriorita();
        System.out.println("INTERVENTO PRIORITARIO\n" +
                "Indirizzo: "+this.lista_riparazioni[0].getNome()+" Operatore: "+this.lista_riparazioni[0].getTecnico());}
        catch(Exception e){
            System.out.println("Nessuna riparazione in coda");}
    }
    public void show_archivio(){
        if(this.lista_eseguite!=null)
            for(int i=0;i<this.lista_eseguite.length;i++)
                System.out.println("Riparazione: " +this.lista_eseguite[i].getNome()+" eseguita da: "+this.lista_eseguite[i].getTecnico());
    }
}
