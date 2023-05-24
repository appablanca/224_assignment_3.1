import java.util.*;

public class Dijkstra {
    private double[] distTo;
    private Edge[] edgeTo;
    private PriorityQueue<Node> pq;

    public Dijkstra(WeightedGraph graph, int source) {
        int V = graph.V;
        distTo = new double[V];
        edgeTo = new Edge[V];
        pq = new PriorityQueue<>(V, Comparator.comparingDouble(node -> node.dist));

        for (int v = 0; v < V; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0.0;

        pq.add(new Node(source, 0.0));

        while (!pq.isEmpty()) {
            int v = pq.poll().vertex;

            for (Edge edge : graph.adj(v)) {
                relax(edge);
            }
        }
    }

    private void relax(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        double weight = edge.weight;

        if (distTo[w] > distTo[v] + weight) {
            distTo[w] = distTo[v] + weight;
            edgeTo[w] = edge;

            Node node = new Node(w, distTo[w]);
            pq.remove(node); // Remove the old node (if exists)
            pq.add(node);    // Add the updated node
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Edge> path = new Stack<>();
        for (Edge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.either()]) {
            path.push(edge);
        }
        return path;
    }

    private class Node {
        private int vertex;
        private double dist;

        public Node(int vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }
}
