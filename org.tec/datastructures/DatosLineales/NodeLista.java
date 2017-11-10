package datastructures.DatosLineales;

/**
 * Created by HP Probook 6475b on 10/11/2017.
 */
public class NodeLista<T>
{
    private NodeLista<T> next;
    private T data;
    private NodeLista<T> prev;

    public NodeLista(T dato)
    {
        this.data = dato;
        this.next = null;
    }

    public T getData()
    {
        return (T)this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public NodeLista<T> getNext()
    {
        return this.next;
    }

    public void setNext(NodeLista<T> next)
    {
        this.next = next;
    }

    public NodeLista<T> getPrev()
    {
        return this.prev;
    }

    public void setPrev(NodeLista<T> prev)
    {
        this.prev = prev;
    }
}