package datastructures.DatosLineales;

public class Cola<T>
{
    private NodeLista<T> head;
    private int capacidad;

    public Cola()
    {
        this.head = null;
        this.capacidad = 0;
    }

    public void Enqueve(T dato)
    {
        NodeLista<T> nodo = new NodeLista(dato);
        if (this.capacidad == 0)
        {
            this.head = nodo;
            this.head.setNext(null);
            this.capacidad += 1;
        }
        else
        {
            NodeLista<T> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(nodo);
            current.getNext().setNext(null);
            this.capacidad += 1;
        }
    }

    public T Peek()
    {
        return (T)this.head.getData();
    }

    public void Dequeve()
    {
        if (this.capacidad != 0) {
            if (this.capacidad == 1)
            {
                this.head = null;
                this.capacidad -= 1;
            }
            else
            {
                this.head = this.head.getNext();
                this.capacidad -= 1;
            }
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
