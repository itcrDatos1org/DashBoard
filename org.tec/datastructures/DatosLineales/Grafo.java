package datastructures.DatosLineales;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class Grafo<T> {
    private Hashtable<NodeGrafo<T>, ArrayList<NodeGrafo<T>>> adjList = new Hashtable();
    private ArrayList<NodeGrafo<T>> nodes = new ArrayList();
    private int numNodes = 0;

    public Grafo() {
    }

    public void add(NodeGrafo<T> node) {
        if(!this.adjList.contains(node)) {
            ++this.numNodes;
            this.adjList.put(node, new ArrayList());
            this.nodes.add(node);
        }
    }

    public void addCamino(NodeGrafo<T> from, NodeGrafo<T> to) {
        if(!this.adjList.containsKey(from)) {
            this.add(from);
        }

        if(!this.adjList.containsKey(to)) {
            this.add(to);
        }

        ((ArrayList)this.adjList.get(from)).add(to);
        ++to.inDegree;
        to.inNodes.add(from);
    }

    public void removeCamino(NodeGrafo<T> from, NodeGrafo<T> to) {
        ((ArrayList)this.adjList.get(from)).remove(to);
        --to.inDegree;
        to.inNodes.remove(from);
    }

    public boolean checkCamino(NodeGrafo<T> from, NodeGrafo<T> to) {
        return ((ArrayList)this.adjList.get(from)).contains(to);
    }

    public void printGraph() {
        Iterator var2 = this.nodes.iterator();

        while(var2.hasNext()) {
            NodeGrafo<T> node = (NodeGrafo)var2.next();
            System.out.print("de: " + node.getData() + " |  a: ");
            Iterator var4 = ((ArrayList)this.adjList.get(node)).iterator();

            while(var4.hasNext()) {
                NodeGrafo<T> m = (NodeGrafo)var4.next();
                System.out.print(m.getData() + " ");
            }

            System.out.println();
        }

    }

    public int getNumNodes() {
        return this.numNodes;
    }
}

