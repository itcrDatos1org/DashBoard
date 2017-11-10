package datastructures.DatosLineales;
public class Pila<T>
{
    private NodeLista<T> tail;
    private NodeLista<T> head;
    private int capacidad;

    public Pila()
    {
        this.tail = null;
        this.head = null;
        this.capacidad = 0;
    }

    public void Push(T dato)
    {
        NodeLista<T> nodo = new NodeLista(dato);
        if (this.capacidad == 0)
        {
            this.head = nodo;
            this.tail = nodo;
            this.capacidad += 1;
        }
        else
        {
            NodeLista<T> current = this.tail;
            nodo.setPrev(current);
            current.setNext(nodo);
            this.tail = nodo;
            this.tail.setNext(null);
            this.capacidad += 1;
        }
    }

    public T Peek()
    {
        return (T)this.tail.getData();
    }

    public void Pop()
    {
        if (this.capacidad == 1)
        {
            this.tail = null;
            this.head = null;
            this.capacidad -= 1;
        }
        else
        {
            this.capacidad -= 1;
            NodeLista<T> a = this.tail.getPrev();
            this.tail = this.tail.getPrev();
            a.setNext(null);
        }
    }

    public int size()
    {
        return this.capacidad;
    }

    public String print()
    {
        String fin = "[";
        NodeLista<T> aux = this.head;
        if (aux == null)
        {
            fin = fin + "]";
            return fin;
        }
        while (aux.getNext() != null) {
            if (aux.getNext() == null)
            {
                fin = fin + aux.getData().toString();
                aux = aux.getNext();
            }
            else
            {
                fin = fin + aux.getData().toString() + ",";
                aux = aux.getNext();
            }
        }
        fin = fin + aux.getData().toString() + "]";
        return fin;
    }
}
