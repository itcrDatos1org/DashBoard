package datastructures.DatosLineales;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class Grafo<T>
{
    private Hashtable<NodeGrafo<T>, ArrayList<NodeGrafo<T>>> adjList = new Hashtable();
    private ArrayList<NodeGrafo<T>> nodes = new ArrayList();
    private int numNodes = 0;

    public void add(NodeGrafo<T> node)
    {
        if (this.adjList.contains(node)) {
            return;
        }
        this.numNodes += 1;
        this.adjList.put(node, new ArrayList());
        this.nodes.add(node);
    }

    public void addCamino(NodeGrafo<T> from, NodeGrafo<T> to)
    {
        if (!this.adjList.containsKey(from)) {
            add(from);
        }
        if (!this.adjList.containsKey(to)) {
            add(to);
        }
        ((ArrayList)this.adjList.get(from)).add(to);
        to.inDegree += 1;
        to.inNodes.add(from);
    }

    public void removeCamino(NodeGrafo<T> from, NodeGrafo<T> to)
    {
        ((ArrayList)this.adjList.get(from)).remove(to);
        to.inDegree -= 1;
        to.inNodes.remove(from);
    }

    public boolean checkCamino(NodeGrafo<T> from, NodeGrafo<T> to)
    {
        return ((ArrayList)this.adjList.get(from)).contains(to);
    }

    public void printGraph()
    {
        for (NodeGrafo<T> node : this.nodes)
        {
            System.out.print("de: " + node.getData() + " |  a: ");
            for (NodeGrafo m : (ArrayList)this.adjList.get(node)) {
                System.out.print(m.getData() + " ");
            }
            System.out.println();
        }
    }

    public int getNumNodes()
    {
        return this.numNodes;
    }
}
