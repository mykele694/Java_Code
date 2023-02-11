package SerieA;

public class Main {
    public static void main(String[] args) {
        /*

        ArrayList<String[]> listone= new ArrayList<>();
        int i=0;

        String line = "";
        String splitBy = ";";
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("D://Michele//Java_Developer//new_Codici//src//SerieA//listone.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {

                String[] employee = line.split(splitBy);    // use comma as separator
                listone.add(new String[employee.length]);
                for (int j=0;j<employee.length;j++)
                    listone.get(i)[j]=employee[j];
                System.out.println("Linea: "+line);
                System.out.println("Arrays: "+Arrays.toString(employee));
                System.out.println("Employee [Ruolo=" + employee[0] + ", Last Name=" + employee[1] + ", Squad=" + employee[2] + ", valore=" + employee[3] + ", fantavalore= " + employee[4] + "]");
                System.out.println("Listone: "+Arrays.toString(listone.get(i)));
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Righe: "+listone.size()+" Colonne: "+listone.get(0).length);

        String[] nomi_squadre;
        String[] nomi_player;

        for(String[] info:listone)
            if(nomi_squadre.contains(info[2]))



        */

        Classifica serieA= new Classifica();
        Calciatore play1=new Calciatore("Giorgio","Chiellini");
        System.out.println(serieA.getNome());
        Squadra squadra1= new Squadra("INTER");
        Squadra squadra2= new Squadra("MILAN");
        Squadra squadra3= new Squadra("JUVENTUS");
        System.out.println(squadra1.getId());
        System.out.println(squadra2.getId());
        System.out.println(squadra3.getId());
        serieA= new Classifica (squadra1,squadra2,squadra3);
        serieA.getClassifica();
        serieA.esitoPartita(squadra1,3,squadra2,2);
        serieA.getClassifica();
        System.out.println("ATTACCO MIGLIORE: "+serieA.migliorAttacco());
        System.out.println("DIFESA MIGLIORE: "+serieA.migliorDifesa());
}
}