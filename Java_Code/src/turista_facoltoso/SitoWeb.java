package turista_facoltoso;

import turista_facoltoso.utenti.Utente;
import turista_facoltoso.utenti.Host;
import java.util.HashSet;
import java.util.Iterator;

public class SitoWeb {
    private HashSet<Utente> utenti = new HashSet<>(1);
    private HashSet<Host> hosts = new HashSet<>(1);


    /**
     * Questo metodo permette di stampare le abitazioni appartenenti ad un certo host
     * @param codice_host attraverso il codice_host si può risalire alle abitazioni proprietarie dell'host
     */
    public void stampaAbitazioni(int codice_host) {
        /* Una sintassi alternativa al for-each prevede di utilizzare un iterator con la seguente sintassi:
         * Iterator<Host> iterator = host.iterator();
         * In questa maniera viene dichiarato un oggetto iterator di tipo "Host", utilizzando il metodo iterator() sulla collezione che si
         * desidera iterare.
         *
         * I metodi a disposizione con un iteratore sono 3:
         * boolean hasNext(): restituisce true se l'iteratore ha ancora elementi da restituire, false altrimenti;
         * E next(): restituisce l'elemento generico E successivo della collezione e sposta l'iteratore avanti di un'unità;
         * void remove(): rimuove l'ultimo elemento restituito dall'iteratore dalla collezione sottostante.
         *
         * Per utilizzare un iteratore, bisogna prima ottenere un'istanza di esso chiamando il metodo iterator() sulla collezione che si
         * vuole attraversare. È possibile mettere il metodo hasNext() in un ciclo while() e stampare, mediante il metodo next(), l'elemento
         * successivo della collezione. In questa maniera, finché sarà presente un elemento dopo quello "attuale", la condizione all'interno
         * del ciclo while sarà "true" e l'iterazione continuerà.
         */
        for (Host host : hosts)
            if(host.getCodiceHost() == codice_host) {
                host.mostraAbitazioni();
                break;
            }
    }

    /**
     * Questo metodo permette di registrare un host al sito web
     * @param host host da aggiungere al sito
     */
    public void aggiungiHostAlSito(Host host) {
        this.hosts.add(host);
    }

    /**
     * Questo metodo permette di registrare un utente al sito web
     * @param utente utente da registrare
     */
    public void aggiungiUtenteAlSito(Utente utente) {
        this.utenti.add(utente);
    }

    /**
     * Questo metodo permette di far prenotare un'abitazione ad un cliente
     * @param utente utente che vuole effettuare la prenotazione
     * @param prenotazione prenotazione che si vorrebbe convalidare
     */
    public void prenota(Utente utente, Prenotazione prenotazione) {
        for (Host host : hosts)
            for (Abitazione abitazione : host.getAbitazioni())
                if (abitazione.getID() == prenotazione.getIDAbitazione())

                    if (checkDate(prenotazione, abitazione)) {
                        utente.aggiungiPrenotazione(prenotazione);
                        abitazione.aggiungiPrenotazione(prenotazione);

                        if (!host.isSuperHost())
                            checkSuperHost(host);

                        System.out.println("Prenotazione effettuata con successo.");
                        return;
                    }

        System.out.println("Non è stato possibile prenotare");
    }

    /**
     * Questo metodo restituisce l'ultima prenotazione effettuata da un utente
     * @param utente utente di cui si vuole conoscere l'ultima prenotazione
     * @return restituisce la prenotazione (oggetto di tipo Prenotazione)
     */
    public Prenotazione ultimaPrenotazioneUtente(Utente utente) {
        Iterator<Prenotazione> iterator = utente.accediAllePrenotazioni().iterator();
        Prenotazione ultima_prenotazione = null;

        //Mi salvo l'ultimo elemento della collezione, ovvero l'ultima prenotazione effettuata
        while (iterator.hasNext())
            ultima_prenotazione = iterator.next();

        return ultima_prenotazione;
    }

    /**
     * Questo metodo restituisce l'abitazione più prenotata nel mese passato come parametro
     * @param mese mese di cui si vuole conoscere l'abitazione più gettonata (numero intero)
     * @return restituisce l'abitazione
     */
    public Abitazione abitazionePiuGettonata(int mese) {
        int contatore, temp=0;
        Abitazione abitazione_temp = null;

        //Scorro tutti gli host, dai quali accedo alle abitazioni da loro messe a disposizione
        for (Host host : hosts)
            for (Abitazione abitazione : host.getAbitazioni()) {
                contatore=0;

                //Tramite un contatore, memorizzo l'abitazione con più prenotazione in quel mese
                for (Prenotazione prenotazione : abitazione.getPrenotazioni())
                    if (mese >= prenotazione.getDataInizio().getMonth().getValue() && mese <= prenotazione.getDataFine().getMonth().getValue())
                        contatore++;

                if (contatore > temp) {
                    abitazione_temp = abitazione;
                    temp = contatore;
                }
            }

        return abitazione_temp;
    }

    /**
     * Questo metodo restituisce l'host che ha "subito" più prenotazioni nel mese passato come parametro
     * @param mese mese di cui si vuole conoscere questa informazione
     * @return restituisce l'host in questione
     */
    public Host hostPiuPrenotazionioMese(int mese) {
        int contatore, temp=0;
        Host host_temp = null;

        for (Host host : hosts) {
            contatore=0;

            for (Abitazione abitazione : host.getAbitazioni()) {
                for (Prenotazione prenotazione : abitazione.getPrenotazioni()) {
                    if (mese == prenotazione.getDataInizio().getMonth().getValue() || mese == prenotazione.getDataFine().getMonth().getValue())
                        contatore++;
                }
            }

            if (contatore > temp) {
                host_temp = host;
                temp = contatore;
            }
        }

        return host_temp;
    }

    /**
     * Stampa la lista dei superhost
     */
    public void stampaSuperHosts() {
        for (Host host : hosts)
            if (host.isSuperHost())
                System.out.println(host+ "\n");
    }

    /**
     * Restituisce il numero di posti letto di tutte le abitazioni presenti nel sito
     * @return restituisce il numero di posti letto
     */
    public int numeroMedioPostiLetto() {
        int numero_posti=0;
        int numero_abitazioni=0;

        for (Host host : hosts)
            for (Abitazione abitazione : host.getAbitazioni()) {
                numero_posti += abitazione.getPosti_letto();
                numero_abitazioni++;
            }

        return numero_posti/numero_abitazioni;
    }

    /**
     * Questo metodo controlla se è possibile effettuare una prenotazione, controllando le date disponibili e tenendo conto di altre
     * eventuali prenotazioni dell'abitazione
     * @param prenotazione prenotazione che si vorrebbe effettuare
     * @param abitazione abitazione che si vorrebbe prenotare
     * @return restituisce vero o falso, rispettivamente, se è possibile o meno prenotare
     */
    private boolean checkDate(Prenotazione prenotazione, Abitazione abitazione) {
        //Controllo se la prenotazione avviene prima o dopo del periodo di disponibilità dell'abitazione
        if (prenotazione.getDataInizio().isBefore(abitazione.getInizioDisponibilita()) || prenotazione.getDataFine().isAfter(abitazione.getFineDisponibilita()))
            return false;

        for (Prenotazione prenotazione1 : abitazione.getPrenotazioni()) {
            if (prenotazione.getDataInizio().isBefore(prenotazione1.getDataFine()) && prenotazione.getDataInizio().isAfter(prenotazione1.getDataInizio()))
                return false;
            if (prenotazione.getDataFine().isBefore(prenotazione1.getDataFine()) && prenotazione.getDataFine().isAfter(prenotazione1.getDataInizio()))
                return false;
            if (prenotazione.getDataInizio().isEqual(prenotazione1.getDataInizio()) || prenotazione.getDataInizio().isEqual(prenotazione1.getDataFine()))
                return false;
            if (prenotazione.getDataFine().isEqual(prenotazione1.getDataInizio()) || prenotazione.getDataFine().isEqual(prenotazione1.getDataFine()))
                return false;
        }

        return true;
    }

    /**
     * Questo metodo permette di controllare (ed eventualmente settare) se l'host passato come parametro supera le 10 prenotazioni
     * @param host host che si vuole controllare
     */
    private void checkSuperHost(Host host) {
        int contatore=0;

        for (Abitazione abitazione : host.getAbitazioni())
            contatore += abitazione.getPrenotazioni().size();

        if (contatore >= 10)
            host.setSuperHost(true);
    }
}