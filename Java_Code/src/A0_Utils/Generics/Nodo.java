package A0_Utils.Generics;

class Nodo <T> {
    private T value;
    private Nodo nextNode=null;

    protected Nodo(T value){
        this.value=value;
    }
    protected void setReference(Nodo nodo){
        this.nextNode=nodo;
    }
    protected Nodo getReference(){
            return this.nextNode;
    }
    protected T getValue(){
        return value;
    }

    @Override
    public String toString() {
        return  value + ((nextNode!=null)? ","+ nextNode:"");
    }
}
