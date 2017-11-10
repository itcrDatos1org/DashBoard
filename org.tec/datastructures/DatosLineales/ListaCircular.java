package datastructures.DatosLineales;

/**
 * Created by HP Probook 6475b on 10/11/2017.
 */
public class ListaCircular<T>
{
    private NodeLista<T> head;
    private int capacidad;

    public ListaCircular()
    {
        this.head = null;
        this.capacidad = 0;
    }

    public void add(T data)
    {
        if (this.capacidad == 0)
        {
            NodeLista<T> aux = new NodeLista(data);
            this.head = aux;
            this.head.setNext(aux);
            this.capacidad += 1;
        }
        else
        {
            NodeLista<T> current = this.head;
            while (current.getNext() != this.head) {
                current = current.getNext();
            }
            NodeLista<T> aux = new NodeLista(data);
            aux.setNext(this.head);
            current.setNext(aux);
            this.capacidad += 1;
        }
    }

    public void remove(int posicion)
    {
        int pos_aux = posicion;
        NodeLista<T> current = this.head;
        if (pos_aux == 0)
        {
            this.head = current.getNext();
            this.capacidad -= 1;
        }
        else if (pos_aux == this.capacidad - 1)
        {
            int a = 0;
            while (a != pos_aux)
            {
                current = current.getNext();
                a++;
            }
            current.setNext(null);
            this.capacidad -= 1;
        }
        else if (pos_aux >= size())
        {
            System.out.println("No se encuentra el elemento");
        }
        else
        {
            int b = 0;
            while (pos_aux - 1 != b)
            {
                current = current.getNext();
                b++;
            }
            current.setNext(current.getNext().getNext());
            this.capacidad -= 1;
        }
    }

    public void delete(T dato)
    {
        int pos_aux = 0;
        NodeLista<T> current = this.head;
        if (current.getData() == dato)
        {
            remove(pos_aux);
        }
        else
        {
            current = current.getNext();
            pos_aux++;
            int x = 0;
            while ((current != null) && (current.getData() != dato) && (this.capacidad >= x))
            {
                current = current.getNext();
                pos_aux++;
                x++;
            }
            if (current == null) {
                System.out.println("El elemento no se encuentra en la lista");
            } else {
                remove(pos_aux);
            }
        }
    }

    public T get(int i)
    {
        NodeLista<T> aux = getHead();
        int x = 0;
        while (x != i)
        {
            aux = aux.getNext();
            x++;
        }
        if (aux == null)
        {
            System.out.println("El elemento no se encuentra en la lista");
            return null;
        }
        return (T)aux.getData();
    }

    public NodeLista<T> getHead()
    {
        return this.head;
    }

    public void setHead(NodeLista<T> head)
    {
        this.head = head;
    }

    public void clear()
    {
        this.head = null;
        this.capacidad = 0;
    }

    public int size()
    {
        return this.capacidad;
    }

    public boolean isEmpty()
    {
        if (this.capacidad == 0) {
            return true;
        }
        return false;
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
        int a = 0;
        while (a != this.capacidad)
        {
            int b = a;
            if (b++ == this.capacidad - 1)
            {
                fin = fin + aux.getData().toString();
                aux = aux.getNext();
                a++;
            }
            else
            {
                fin = fin + aux.getData().toString() + ",";
                aux = aux.getNext();
                a++;
            }
        }
        fin = fin + "]";
        return fin;
    }
}
