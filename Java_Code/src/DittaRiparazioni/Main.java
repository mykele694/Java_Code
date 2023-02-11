package DittaRiparazioni;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ditta dambone=new Ditta();
        Tecnico tecnico1 = new Tecnico("Mario");
        dambone.aggiungi_tecnico(tecnico1);
        Tecnico tecnico2 = new Tecnico("Giovanni");
        dambone.aggiungi_tecnico(tecnico2);
        Tecnico tecnico3 = new Tecnico("Paolo");
        dambone.aggiungi_tecnico(tecnico3);
        Tecnico tecnico4 = new Tecnico("Lorenzo");
        dambone.aggiungi_tecnico(tecnico4);
        Riparazione riparazione1=new Riparazione("Via Togliatti",Riparazione.Priority.MEDIA);
        dambone.aggiungi_riparazione(riparazione1);
        Riparazione riparazione2=new Riparazione("Via Garibaldi",Riparazione.Priority.ALTA);
        dambone.aggiungi_riparazione(riparazione2);
        Riparazione riparazione3=new Riparazione("Via Mellitto",Riparazione.Priority.BASSA);
        dambone.aggiungi_riparazione(riparazione3);
        Riparazione riparazione4=new Riparazione("Via Roma",Riparazione.Priority.ALTA);
        dambone.aggiungi_riparazione(riparazione4);
        dambone.assegna_tecnici();
        dambone.ordina_perPriorita();
        dambone.show_tecnici();
        dambone.show_riparazioni();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("---- SCEGLIERE OPERAZIONE ----\n" +
                    "0: Esci\n" +
                    "1: Aggiungere riparazione\n" +
                    "2: Aggiungere tecnico\n" +
                    "3: Assegnare le riparazioni disponibili\n" +
                    "4: Assegnare qualcuno alla riparazione prioritaria\n" +
                    "5: Assegnare tecnico e riparazione\n" +
                    "6: Mostra lista tecnici\n" +
                    "7: Mostra lista riparazione\n" +
                    "8: Licenzia un tecnico\n" +
                    "9: Licenzia gruppo\n" +
                    "10: Convalida una riparazione\n" +
                    "11: Mostra Tecnici occupati\n" +
                    "12: Mostra Tecnici liberi\n" +
                    "13: Mostra Riparazioni archiviate\n");
            int scelta=sc.nextInt();
            switch(scelta){
                case 0: return;
                case 1:
                    System.out.println("Aggiungere riparazione");
                    dambone.aggiungi_riparazione();
                    break;
                case 2:
                    System.out.println("Aggiungere tecnico");
                    dambone.aggiungi_tecnico();
                    break;
                case 3:
                    System.out.println("Assegnare le riparazioni disponibili");
                    dambone.assegna_tecnici();
                    break;
                case 4:
                    System.out.println("Assegnare qualcuno alla riparazione prioritaria");
                    dambone.assegna_perPriorita();
                    break;
                case 5:
                    System.out.println("Assegnare tecnico e riparazione");
                    dambone.assegna_tecnico();
                    break;
                case 6:
                    System.out.println("Mostra lista tecnici");
                    dambone.show_tecnici();
                    break;
                case 7:
                    System.out.println("Mostra lista riparazione");
                    dambone.show_riparazioni();
                    break;
                case 8:
                    System.out.println("Licenzia un tecnico");
                    licenzia(dambone);
                    break;
                case 9:
                    System.out.println("Licenzia gruppo");
                    licenzia_gruppo(dambone);
                    break;
                case 10:
                    System.out.println("Convalida una riparazione");
                    dambone.riparazione_svolta(nome_riparazione());
                    break;
                case 11:
                    System.out.println("Mostra Tecnici occupati");
                    dambone.show_occupati();
                    break;
                case 12:
                    System.out.println("Mostra Tecnici liberi");
                    dambone.show_liberi();
                    break;
                case 13:
                    System.out.println("Mostra Riparazioni archiviate");
                    dambone.show_archivio();
                    break;
                default: break;
            }
        }
    }
    public static String nome_riparazione(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nome Riparazione");
        String nome=sc.nextLine();
        return nome;
    }
    public static void licenzia_gruppo(Ditta ditta){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nome Tecnici da licenziare (separati da una virgola)");
        String nome=sc.nextLine();
        String[] nomi=nome.split(",");
        ditta.licenzia_tecnici(nomi);
    }
    public static void licenzia(Ditta ditta){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nome Tecnico da licenziare");
        String nome=sc.nextLine();
        ditta.licenzia_tecnico(nome);
    }

}
