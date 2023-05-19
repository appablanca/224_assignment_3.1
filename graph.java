import java.util.*;

public class graph {
    


    public class Edge implements Comparable<Edge>{
        public int v , w;
        public double weight;

        public Edge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int either() {
            return v;
        }

        public int other(int vertex) {
            if (vertex == v) return w;
            else return v;
        }

        public int compareTo(Edge that) {
            if (this.weight < that.weight) return -1;
            else if (this.weight > that.weight) return 1;
            else return 0;
        }
    }

    public class WeightedGraph{
        public int V;
        public Bag<Edge>[] adj;
        
        public WeightedGraph(int V) {
            this.V = V;
            adj = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Edge>();
            }
        }

        public void addEdge(Edge e) {
            int v = e.either();
            int w = e.other(v);
            adj[v].add(e);
            adj[w].add(e);
        }

        public void addCapacity ()
        
        public Iterable <Edge> adj(int v) {
            return adj[v];
        }
    
    }











    public class Bag<Item> implements Iterable<Item> { //bag data structure

        public Node first;
        public int N;

        public class Node { //node class
            Item item;
            Node next;
            
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return N;
        }

        public void add(Item item) {//add method
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }

        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        public class ListIterator implements Iterator<Item> {//iterator class
            public Node current = first;
            public boolean hasNext() {
                return current != null;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

        public String toString() { //toString method used while testing the algorithm 
            String s = "";
            for (Item item : this) {
                s += item + " ";
            }
            return s;
        }
    }


}
