package datastructures.DatosLineales;
public class Cola<T> {
    private NodeLista<T> head = null;
    private int capacidad = 0;

    public Cola() {
    }

    public void Enqueve(T dato) {
        NodeLista<T> nodo = new NodeLista(dato);
        if(this.capacidad == 0) {
            this.head = nodo;
            this.head.setNext((NodeLista)null);
            ++this.capacidad;
        } else {
            NodeLista current;
            for(current = this.head; current.getNext() != null; current = current.getNext()) {
                ;
            }

            current.setNext(nodo);
            current.getNext().setNext((NodeLista)null);
            ++this.capacidad;
        }

    }

    public T Peek() {
        return this.head.getData();
    }

    public void Dequeve() {
        if(this.capacidad != 0) {
            if(this.capacidad == 1) {
                this.head = null;
                --this.capacidad;
            } else {
                this.head = this.head.getNext();
                --this.capacidad;
            }
        }

    }

    public int size() {
        return this.capacidad;
    }

    public String print() {
        String fin = "[";
        NodeLista<T> aux = this.head;
        if(aux == null) {
            fin = fin + "]";
            return fin;
        } else {
            while(aux.getNext() != null) {
                if(aux.getNext() == null) {
                    fin = fin + aux.getData().toString();
                    aux = aux.getNext();
                } else {
                    fin = fin + aux.getData().toString() + ",";
                    aux = aux.getNext();
                }
            }

            fin = fin + aux.getData().toString() + "]";
            return fin;
        }
    }
}

