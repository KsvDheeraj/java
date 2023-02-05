import java.io.*;
import java.util.*;

class bfs {
    private int V; // number of nodes in the ob
    private LinkedList<Integer> adj[]; // adjacency list
    private Queue<Integer> queue; // creating an integer queue

    bfs(int v) { // constructor parameter is no of vertices
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // adding an edge to the adjacency list (edges are directional in this
                       // example)
    }

    void BFS(int n) {

        boolean nodes[] = new boolean[V]; // initialize boolean array for holding the data
        int a = 0;

        nodes[n] = true;
        queue.add(n); // root node is added to the top of the queue

        while (queue.size() != 0) {
            n = queue.poll(); // remove the top element of the queue
            System.out.print(n + " "); // print the top element of the queue

            for (int i = 0; i < adj[n].size(); i++) // iterate through the linked list and push all neighbors into queue
            {
                a = adj[n].get(i);
                if (!nodes[a]) // only insert nodes into queue if they have not been explored already
                {
                    nodes[a] = true;
                    queue.add(a);
                }
            }
        }
    }

    public static void main(String args[]) {
        bfs ob = new bfs(5);

        ob.addEdge(0, 1);
        ob.addEdge(0, 2);
        ob.addEdge(1, 3);
        ob.addEdge(1, 2);
        ob.addEdge(3, 2);
        ob.addEdge(3, 4);
        ob.addEdge(4, 2);

        System.out.println("The Breadth First Traversal of the graph is as follows :");

        ob.BFS(0);
    }
}