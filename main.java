import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int slots,connections,w,fee,K;

        slots = sc.nextInt();
        connections = sc.nextInt();
        fee = sc.nextInt();
        sc.nextLine();
        int[] capacity = new int[slots];
        WeightedGraph g = new WeightedGraph(slots+1);

        for (int i = 0; i < slots; i++) {
            capacity[i] = sc.nextInt();
        }

        sc.nextLine();

        for (int i :capacity) {
            System.out.println(i);
        }

        for (int i = 0; i < connections; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int weight = sc.nextInt();
            Edge e = new Edge(a,b,weight);
            g.addEdge(e);
            sc.nextLine();
        }

        
        Dijkstra dijkstra = new Dijkstra(g,1);
        
        for (int v = 0; v < slots; v++) {
            if (dijkstra.hasPathTo(v)) {
                System.out.printf("Shortest path from %d to %d: ", 1, v+1);
                for (Edge edge : dijkstra.pathTo(v+1)) {
                    System.out.print(edge + " ");
                }
                System.out.println();
            } else {
                System.out.printf("No path from %d to %d\n", 1, v+1);
            }
        }
        

       
































        sc.close();
    }
}