package SerieACollection;

class Footballer {
    private int id;
    private String name;
    //private String surname;
    private char position;
    private int value;

    public Footballer(String name, char position, int value){
        this.name=name;
        this.position=position;
        this.value=value;
        //this.cogname=cogname;
        String stringa=name;//+cogname;
        this.id=stringa.hashCode();
    }

    @Override
    public String toString() {
        return "position=" + position +
                " name='" + name + "\n";
    }
}
