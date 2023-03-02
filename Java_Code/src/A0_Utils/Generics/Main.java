package A0_Utils.Generics;

public class Main {
    public static void main(String[] args) {
        Nodo nodo1=new Nodo("1");
        Nodo nodo2=new Nodo("2");
        Nodo nodo3=new Nodo("3");
        Nodo nodo4=new Nodo("4");
        ListaLinkata nodi=new ListaLinkata(nodo1);
        nodi.addFirst(nodo2);
        nodi.addFirst(nodo3);
        nodi.addFirst(nodo4);
        nodi.addFirst(new Nodo("5"));
        nodi.addFirst(new Nodo("6"));
        nodi.addFirst(new Nodo("7"));
        nodi.addLast(new Nodo("0"));
        nodi.showList();
        System.out.println("Rimosso: "+nodi.removeFirst().getValue());
        nodi.showList();
        System.out.println(nodi);
    }
}
