package datastructures.DatosLineales;
import java.util.ArrayList;

public class NodeGrafo<T>
{
    protected T data;
    protected boolean visited = false;
    protected int inDegree = 0;
    protected ArrayList<NodeGrafo<T>> inNodes = new ArrayList();

    public NodeGrafo(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return (T)this.data;
    }

    public void setValue(T data)
    {
        this.data = data;
    }

    public boolean isVisited()
    {
        return this.visited;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

    public int getInDegree()
    {
        return this.inDegree;
    }

    public void setInDegree(int inDegree)
    {
        this.inDegree = inDegree;
    }

    public ArrayList<NodeGrafo<T>> getInNodes()
    {
        return this.inNodes;
    }

    public void setInNodes(ArrayList<NodeGrafo<T>> inNodes)
    {
        this.inNodes = inNodes;
    }
}

