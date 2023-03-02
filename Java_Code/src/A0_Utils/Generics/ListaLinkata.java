package A0_Utils.Generics;


public class ListaLinkata {
    Nodo head; //
    public ListaLinkata(Nodo nodo){
        this.head=nodo;
    }
    protected void addFirst(Nodo nodo){
        nodo.setReference(this.head);
        this.head=nodo;
    }
    protected void addLast(Nodo nodo,Nodo new_nodo){
        if(nodo.getReference()==null){
            nodo.setReference(new_nodo);
        }
        else
            addLast(nodo.getReference(),new_nodo);
    }
    protected void addLast(Nodo new_nodo){
        addLast(head,new_nodo);
    }
    protected void showList(){
        showList(head);
    }
    protected void showList(Nodo nodo){
        System.out.println(nodo.getValue());
        if(nodo.getReference()!=null)
            showList(nodo.getReference());
    }
    protected Nodo removeFirst(){
        Nodo temp=head;
        head=head.getReference();
        return temp;
    }

    @Override
    public String toString() {
        return "Lista: "+head;
    }
}
